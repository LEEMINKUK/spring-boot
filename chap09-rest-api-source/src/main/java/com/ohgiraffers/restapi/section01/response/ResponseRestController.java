package com.ohgiraffers.restapi.section01.response;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Tag(name = "Spring Boot Response 연동 (USER) ")
@RestController // 데이터로 직접 반환?
@RequestMapping("/response")
public class ResponseRestController {

    /* 1. 문자열 응답 */
    @GetMapping("/hello")
    public String helloworld(){

        return "hello world";
    }

    /* 2. 기본자료형 응답 */
    @GetMapping("/random")
    public int getRandomNumber(){

        return (int)(Math.random() * 10) + 1;
    }

    /* 3. Object 응답 */
    @GetMapping("/message")
    public Message getMessage(){

        return new Message(200,"응답 하라");
    }

    /* 4.List 응답*/
    @GetMapping("/list")
    public List<String> getList(){

        return List.of(new String[]{"사과","바나나","복숭아"});
    }

    /* 5. Map 응답 */
    @GetMapping("/map")
    public Map<Integer,String> getMap(){
        Map<Integer,String> messageMap= new HashMap<>();

        messageMap.put(200, "정상 응답");
        messageMap.put(404, "페이지를 못찾음");
        messageMap.put(500, "개발자 이슈");

        return messageMap;
    }

    /* 6. ImageFile 응답
    *
    * produces 설정을 해주지 않으면 text/plain 응답하므로 이미지가 텍스트 형태로 전송된다.
    * produces 는 response header 의 content-type 설정이다.
    * */

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {

        return getClass().getResourceAsStream("/images/sample.PNG").readAllBytes();
    }

    /* 7. ResponseEntity 를 이용한 응답 */
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity(){

        return ResponseEntity.ok(new Message(123,"hello Rest!"));
    }

}
