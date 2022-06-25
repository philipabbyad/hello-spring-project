package org.laucnhcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // path now /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring! See ya later!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        if (name == null || name == "") {
            name = "World";
        }
        return createMessage(name, language);
    }

    // Method that takes in name and language input to return String message

    public static String createMessage(String name, String language) {
        String greeting = "";
        switch (language) {
            case "english":
                greeting = "Hello,";
                break;
            case "spanish":
                greeting = "Hola,";
                break;
            case "french":
                greeting = "Bonjour,";
                break;
            case "german":
                greeting = "Hallo,";
                break;
            case "italian":
                greeting = "Ciao,";
                break;
        }
        return greeting + " " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // path /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='/hello' method='post'>" + // submit a request to /hello
                            "<input type='text' name='name'>" +
                            "<select name='language' id='language-select'>" +
                                "<option value ='english'>English</option>" +
                                "<option value ='spanish'>Spanish</option>" +
                                "<option value ='french'>French</option>" +
                                "<option value ='german'>German</option>" +
                                "<option value ='italian'>Italian</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
