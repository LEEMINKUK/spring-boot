package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/" , "/main"}) //두개의 경로를 지정할 수 있다.
    public String main(){

        return "main";
    }
}
