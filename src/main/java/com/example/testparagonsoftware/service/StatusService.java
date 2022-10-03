package com.example.testparagonsoftware.service;

import com.example.testparagonsoftware.dto.ResponseStatusDTO;
import com.example.testparagonsoftware.exceptions.UserNotFoundException;
import com.example.testparagonsoftware.model.User;
import com.example.testparagonsoftware.model.UserStatusEnum;
import com.example.testparagonsoftware.repository.UserRepository;
import com.example.testparagonsoftware.unit.ChangeStatusUnit;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@AllArgsConstructor
@EnableScheduling
public class StatusService {
    private final UserRepository userRepository;

    private final ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private final ChangeStatusUnit changeStatusUnit;

    public ResponseStatusDTO setUserStatus(Integer id, UserStatusEnum newUserStatus) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        UserStatusEnum oldUserStatus = user.getStatus();
        user.setStatus(newUserStatus);
        changeDelay(id, newUserStatus);
        return new ResponseStatusDTO(id, newUserStatus, oldUserStatus);
    }

    public void changeDelay(Integer id, UserStatusEnum userStatus) {
        if (userStatus.equals(UserStatusEnum.ONLINE)) {
//            Date initDelayDate = new Date(System.currentTimeMillis() + UserStatusEnum.ONLINE.getDurationSeconds() * 1000);
            Date initDelayDate = new Date(System.currentTimeMillis() + 5000);
            threadPoolTaskScheduler.schedule(changeStatusUnit.changeOnline(id, userStatus), initDelayDate);
        }
    }

//     public Runnable changeOnline(Integer id, UserStatusEnum userStatus) {
//        return () -> {
//            User user = userRepository.findById(id)
//                    .orElseThrow(() -> new UserNotFoundException(id));
//            UserStatusEnum currentStatus = user.getStatus();
//            user.setStatus(UserStatusEnum.AWAY);
//            if (currentStatus != null && currentStatus.getChangeTime().isEqual(userStatus.getChangeTime())) {
//                user.setStatus(UserStatusEnum.AWAY);
//            }
//        };
//    }

}
