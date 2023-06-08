package board.service;

import board.domain.User;
import board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원 가입
     */
    public Long join(User user) {
        userRepository.save(user);
        return user.getUserId();
    }

    /**
     * 모든 회원 조회
     */

    @Transactional(readOnly = true)
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    /**
     * ID로 회원 정보 조회
     */
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * 개인정보변경
     * 현재는 이름만 변경 가능
     */

    public void updateName(Long id, String name) {
        User findUser = userRepository.findById(id);
        findUser.setUserName(name);
    }

    /**
     * 회원 탈퇴
     */
    public void withdraw(Long id) {
        userRepository.deleteById(id);
    }
}
