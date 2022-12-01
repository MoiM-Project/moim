package data.mapper;

import data.dto.RoomDto;
import data.dto.RoomImageDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface RoomMapper {

    public RoomDto getRoomData(int num);
    //booking detail page
    public List<RoomDto> getCategoryData(int num);
    public List<RoomDto> getFacilityList(int num);
    public List<RoomDto> getOptionList(int num);
    List<RoomImageDto> selectRoomImageList(int num);

    //mainPage suggestRoom
    List<RoomDto> getRoomList();

    //adminPage (search) space = room
    List<RoomDto> getSpaceSearchList(HashMap<String,Object> map);
    void approveSpace(int roomNum); //공간 승인을 위한 방 번호 넘기기
    void rejectSpace(int roomNum); //공간 거부를 위한 방 번호 넘기기


}
