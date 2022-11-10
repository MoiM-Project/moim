package data.mapper;

<<<<<<< HEAD
import data.dto.RoomDto;
=======
import data.dto.RoomImageDto;
>>>>>>> 3c4590ae2fca5b23a5d55a49db6777b4d4068765
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

}
