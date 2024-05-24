package com.ohgiraffers.restapi.section03.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(UserNotFoundException e) {

        String code = "ERROR_CODE_0001";
        String description = "회원 정보 조회 실패...";
        String detail = e.getMessage();

        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e) {

        String code = "";
        String description = "";
        String detail = "";

        /* 에러가 있다면 */
        if (e.getBindingResult().hasErrors()) {

            detail = e.getBindingResult().getFieldError().getDefaultMessage();  // e.getMessage() 랑 같은 의미

            String bindResultCode = e.getBindingResult().getFieldError().getCode(); // NotNull, Size ,NotBlank. ...

            switch (bindResultCode) {
                case "NotBlank":
                    code = "ERROR_CODE_0002";
                    description = "필수 값 누락";
                    break;
                case "Size":
                    code = "ERROR_CODE_00003";
                    description = "글자 수 확인 바람";
                    break;
            }
        }
        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.BAD_REQUEST);
    }
}

