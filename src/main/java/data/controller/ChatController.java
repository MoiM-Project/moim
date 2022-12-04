package data.controller;

import data.dto.ChatDto;
import data.mapper.ChatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate template;
    @Autowired
    ChatMapper mapper;


    @MessageMapping("/chat")
    public void sendMessage(ChatDto chatDto, SimpMessageHeaderAccessor accessor){
        System.out.println(chatDto);
        template.convertAndSend("/sub/chat/"+chatDto.getRoomNum(), chatDto);
        mapper.insertChat(chatDto);
    }
}
