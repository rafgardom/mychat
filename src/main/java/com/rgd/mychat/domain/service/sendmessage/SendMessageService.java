package com.rgd.mychat.domain.service.sendmessage;

import com.rgd.mychat.domain.service.sendmessage.command.SendMessageCommand;
import com.rgd.mychat.domain.service.sendmessage.command.SendMessageCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SendMessageService {

    private final SendMessageCommandHandler sendMessageCommandHandler;

    public Mono<Void> send(UUID user1Id, UUID user2Id, String messageBodyText) {
        return sendMessageCommandHandler.handle(new SendMessageCommand(user1Id, user2Id, messageBodyText));
    }
}
