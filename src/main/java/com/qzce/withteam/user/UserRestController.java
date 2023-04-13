package com.qzce.withteam.user;

import com.qzce.withteam.domain.response.BaseResponse;
import com.qzce.withteam.user.dto.UserLoginDto;
import com.qzce.withteam.user.dto.UserSignDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api")
public class UserRestController {

    private final UserService userService;

    @GetMapping("/login/kakao")
    public BaseResponse kakaoCallback(@RequestParam String code) {
        String message = "Get api successfully.";
        return new BaseResponse(message);
    }

    // 회원가입
    @PostMapping("/sign")
    public ResponseEntity signIn(@RequestBody UserSignDto userSignDto) {
        userService.signIn(userSignDto);
        return ResponseEntity.ok().body(userSignDto);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String pid,
                                @RequestParam String password) {
        User user = userService.findUser(pid, password);
        return ResponseEntity.ok().body(user);
    }


}
