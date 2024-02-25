package com.rgd.mychat;

import com.rgd.mychat.domain.model.User;
import com.rgd.mychat.domain.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ModelData {


    public static final UUID CHAT1_ID = UUID.fromString("700ff923-c0d3-458b-84d9-6413a942b799");
    public static final UUID USER1_ID = UUID.fromString("a8b8b070-7fd3-45e6-97c9-5bd8b4acccc4");
    public static final UUID USER2_ID = UUID.fromString("f8180e3c-71ca-4c17-bbfb-32b5892e7f87");
    public static final UUID MESSAGE1_ID = UUID.fromString("4219ec18-88c6-4d69-bc27-fb7fe7e1b029");


    private final UserRepository userRepository;

    public void givenThereIsAnUser(String userName, UUID userId) {
        userRepository.save(new User(userId, userName, "surname",
                "description", LocalDateTime.now())).block();
    }
}
