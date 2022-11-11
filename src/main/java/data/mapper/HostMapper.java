package data.mapper;


import data.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface HostMapper {
    //    public void HostHome();
    public List<RoomDto> getRoomList(); // 룸 리스트
    public List<MainCategoryDto> getMainCategoryList(); // 메인카테고리 리스트
    public List<CategoryDto> getCategoryList(); // 카테고리 리스트
    public void insertRoom(RoomDto dto); // 인서트
    public RoomDto getData(int num); //num값 가져오기
    public void deleteRoom(int num); //삭제
    public void insertInformation(InformationDto dto);
    public void insertPrecaution(PrecautionDto dto);
    public void insertRoomImage(RoomImageDto dto);
    public void insertRoomOption(RoptionDto dto);
}
