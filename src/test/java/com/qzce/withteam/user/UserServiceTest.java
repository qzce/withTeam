package com.qzce.withteam.user;

import com.qzce.withteam.user.dto.UserSignDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("회원가입_정상")
    public void signInSuccess() {

        // given
        String pid = "adminTestPid";
        String password = "qweasdsda";
        String email = "asd@naver.com";

        UserSignDto userSignDto = new UserSignDto();
        userSignDto.setPid(pid);
        userSignDto.setPassword(password);
        userSignDto.setEmail(email);

        List<User> users = new ArrayList<>();
        users.add(userSignDto.toEntity());

        given(userRepository.findAll()).willReturn(users);

        // when
        List<User> findUsers = userService.findAllUser();

        Assertions.assertThat(userSignDto.getPid())
                .isEqualTo(findUsers.get(0).getPid());

    }
    @Test
    @DisplayName("회원가입_실패")
    public void signInFail() {

        // given
        String pid = "adminTestㅁㄴㅇㅁㄴㅇPid";
        String password = "qweasdsda";
        String email = "asd@naver.com";

        UserSignDto userSignDto = new UserSignDto();
        userSignDto.setPid(pid);
        userSignDto.setPassword(password);
        userSignDto.setEmail(email);

        List<User> users = new ArrayList<>();
        users.add(userSignDto.toEntity());

        given(userRepository.findAll()).willReturn(users);

        // when
        List<User> findUsers = userService.findAllUser();

        Assertions.assertThat(userSignDto.getPid())
                .isEqualTo(findUsers.get(0).getPid());

    }


}
