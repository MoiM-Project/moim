package data.mapper;

import data.dto.RoomImageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<RoomImageDto> selectRoomImageList(int num);
}
