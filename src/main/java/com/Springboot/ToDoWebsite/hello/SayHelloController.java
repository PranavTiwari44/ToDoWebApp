package com.Springboot.ToDoWebsite.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! What's Up?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
       StringBuffer sb = new StringBuffer();
       sb.append("<HTML>");
       sb.append("<head>");
       sb.append("<title>Testing Html Webpage</title>");
       sb.append("</head>");
       sb.append("<body>");
       sb.append("Testing My HTML Webpage");
       sb.append("</body>");
       sb.append("</HTML>");

        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }


}
