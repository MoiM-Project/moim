package data.mapper;

import data.dto.ChatDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {
    void insertChat(ChatDto dto);
}
