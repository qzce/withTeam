package com.qzce.withteam.user;

import com.qzce.withteam.user.dto.UserSignDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    // 회원가입
    @Transactional
    public User signIn(UserSignDto userSignDto) {
//        loginRepository.findByEmail(userSignDto.getEmail())
//                .orElseThrow(IllegalArgumentException::new);

        return userRepository.save(userSignDto.toEntity());
    }

    // 회원탈퇴
    public void signOut() {}

    // 로그인
    public User findUser(String pid, String password) {
        return userRepository.findByPidAndPassword(pid, password);
    }

    // 전체 유저 찾기
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
    


}
