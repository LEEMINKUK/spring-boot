package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lecture") // 상위 경로를 표현해준다.
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression (ModelAndView mv){

        mv.addObject("member",new MemberDTO("홍길동",20,'남',"서울시 서초구"));

        mv.addObject("hello","hello!<h3>Thymeleaf</h3>");

//        mv.setViewName("/lecture/expression"); // 위에 경로가 다 지정되어 있어서 현재는 불필요한 코드.
        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){

        mv.addObject("num",1);
        mv.addObject("str","바나나");

//        mv.setViewName("/lecture/conditional"); // 위에 경로가 다 지정되어 있어서 현재는 불필요한 코드.

        return mv;
    }
}
