package com.example.testparagonsoftware.unit;

import com.example.testparagonsoftware.exceptions.UserNotFoundException;
import com.example.testparagonsoftware.model.User;
import com.example.testparagonsoftware.model.UserStatusEnum;
import com.example.testparagonsoftware.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class ChangeStatusUnit {

    private final UserRepository userRepository;

    public Runnable changeOnline(Integer id, UserStatusEnum userStatus) {
        return () -> {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(id));
            UserStatusEnum currentStatus = user.getStatus();
            user.setStatus(UserStatusEnum.AWAY);
//            if (currentStatus != null && currentStatus.getChangeTime().isEqual(userStatus.getChangeTime())) {
//                user.setStatus(UserStatusEnum.AWAY);
//            }
        };
    }
}
