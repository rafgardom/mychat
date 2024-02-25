package com.rgd.mychat.domain.service.sendmessage.command;

import java.util.UUID;

public record SendMessageCommand(UUID senderUserId, UUID receiverUserId, String messageBodyText) {
}
