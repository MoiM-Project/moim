package data.mapper;

import data.dto.RoomDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    public RoomDto getRoomData(int num);
}
