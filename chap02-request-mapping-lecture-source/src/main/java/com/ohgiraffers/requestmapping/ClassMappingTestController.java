package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/* 클래스 레벨에 @RequestMapping 어노테이션 사용이 가능하다.
*  클래스 레벨에 URL 을 공통 부분을 이용해 설정하고 나면 매번 해들러 메소드에 URL 의 중복 되는 내용을 작성하지 않아도 된다.
* */
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    /* 1. Class 레벨 매핑 */
    @GetMapping("/regist")
    public String registOrder(Model model) {

        model.addAttribute("message", "GET 방식의 주문 등록용 메소드 호출함...");

        return "mappingResult";
    }

    /* 2. 여러 개의 패턴 매핑 */
    /* value 속성에 중괄호를 이용해 매핑할 URL 을 나열한다. */
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDeleteOrder(Model model) {

        model.addAttribute("message", "POST 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 호출함...");

        return "mappingResult";
    }

    /* path variable */
    /* @PathVariable 어노테이션을 이용해 요청 path 로부터 변수를 받아올 수 있다.
    *  @PathVariable 로 전달되는 {변수명} 값은 반드시 매개변수명과 동일해야 한다.
    *  만약 동일하지 않으면 @PathVariable("이름") 을 설정해 주어야 한다.
    *  이는 REST 형 웹 서비스를 설계할 때 유용하게 사용된다.
    * */

    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable int orderNo){

        model.addAttribute("message",orderNo+"번 주문 상세 내용 조회 핸들러 메소드 호출함...");
        
        return "mappingResult";
    }
}

