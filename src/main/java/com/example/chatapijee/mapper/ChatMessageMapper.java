package com.example.chatapijee.mapper;

import com.example.chatapijee.dto.PrivateMessageDto;
import com.example.chatapijee.dto.PublicMessageDto;
import com.example.chatapijee.model.Message;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ChatMessageMapper {
    ChatMessageMapper INSTANCE = Mappers.getMapper(ChatMessageMapper.class);

    @Mapping(source = "sender", target = "sender.name")
    Message mapPublicToEntity (PublicMessageDto publicMessageDto);


    @Mapping(source = "sender", target = "sender.name")
    @Mapping(source = "receiver", target = "receiver.name")
    Message mapPrivateToEntity (PrivateMessageDto privateMessageDto);
//
//    @Mapping(source = "sender", target = "sender.name")
//    @Mapping(source = "channel", target = "channel.name")
//    ChatMessage mapChannelToEntity (ChannelMessageDto channelMessageDto);
//
//    @Mapping(target = "sender", source = "sender.name")
//    @Mapping(target = "channel", source = "channel.name")
//    ChannelHistoryDto mapEntityToHistory(Message message);
}
