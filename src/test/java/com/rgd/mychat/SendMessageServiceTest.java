package com.rgd.mychat;

import com.rgd.mychat.domain.model.Chat;
import com.rgd.mychat.domain.model.ChatRepository;
import com.rgd.mychat.domain.model.Message;
import com.rgd.mychat.domain.model.MessageRepository;
import com.rgd.mychat.domain.service.sendmessage.SendMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SendMessageServiceTest {

    private static final String MESSAGE_BODY_TEXT = "Message text test";

    @Autowired
    private ModelData modelData;
    @Autowired
    private SendMessageService sendMessageService;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    void sendMessageFromAnUserToAnUser(){
        modelData.givenThereIsAnUser("User1", ModelData.USER1_ID);
        modelData.givenThereIsAnUser("User2", ModelData.USER2_ID);

        sendMessageService.send(ModelData.USER1_ID, ModelData.USER2_ID, MESSAGE_BODY_TEXT);

        assertThatChatIsValid();
        assertThatMessageIsValid();
    }

    private void assertThatChatIsValid() {
        Chat chat = chatRepository.findAll().blockFirst();
        assertEquals(ModelData.CHAT1_ID, chat.getId());
        assertEquals(ModelData.USER1_ID, chat.getCreatorUserId());
        assertEquals(ModelData.USER2_ID, chat.getReceiverUserId());
    }

    private void assertThatMessageIsValid() {
        Message message = messageRepository.findById(ModelData.MESSAGE1_ID).block();

        assertEquals(MESSAGE_BODY_TEXT, message.getBody());
        assertEquals(ModelData.USER1_ID, message.getUserId());
        assertEquals(ModelData.CHAT1_ID, message.getChatId());
    }
}
