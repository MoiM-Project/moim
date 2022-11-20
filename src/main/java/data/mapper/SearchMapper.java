package data.mapper;

import data.dto.RoomDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface SearchMapper {
    List<RoomDto> getSearchRoom(HashMap<String, Object> map);
}
