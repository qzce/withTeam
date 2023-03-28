package com.qzce.withteam.user;

import com.qzce.withteam.domain.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class UserController {

    @GetMapping("/kakao")
    public BaseResponse kakaoCallback(@RequestParam String code) {
        String message = "Get api successfully.";
        return new BaseResponse(message);
    }

}
