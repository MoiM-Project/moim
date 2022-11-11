package data.mapper;

import data.dto.RoomDto;
import data.dto.RoomImageDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {

    public RoomDto getRoomData(int num);
    //booking detail page
    public List<RoomDto> getCategoryData(int num);
    public List<RoomDto> getFacilityList(int num);
    public List<RoomDto> getOptionList(int num);
    List<RoomImageDto> selectRoomImageList(int num);
    //mainpage suggestRoom
    List<RoomDto> getRoomList();
}
