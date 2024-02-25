package com.rgd.mychat.domain.service.sendmessage.command;

import com.rgd.mychat.domain.model.Chat;
import com.rgd.mychat.domain.model.ChatRepository;
import com.rgd.mychat.domain.model.Message;
import com.rgd.mychat.domain.model.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SendMessageCommandHandler {

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    public Mono<Void> handle(SendMessageCommand sendMessageCommand) {
        return chatRepository.findByChatByUsers(sendMessageCommand.senderUserId(), sendMessageCommand.receiverUserId())
                .doOnNext(chat -> {
                    if (chat != null) {
                        saveMessage(sendMessageCommand, chat);
                    } else {
                        createChat(sendMessageCommand.senderUserId(), sendMessageCommand.receiverUserId())
                                .doOnNext(newChat -> saveMessage(sendMessageCommand, newChat));
                    }

                }).then();
    }

    private Mono<Chat> createChat(UUID senderUserId, UUID receiverUserId) {
        return chatRepository.save(new Chat(UUID.randomUUID(), senderUserId, receiverUserId, LocalDateTime.now()));
    }

    private void saveMessage(SendMessageCommand sendMessageCommand, Chat chat) {
        messageRepository.save(new Message(UUID.randomUUID(),
                sendMessageCommand.messageBodyText(),
                sendMessageCommand.senderUserId(),
                chat.getId()
        ));
    }
}
