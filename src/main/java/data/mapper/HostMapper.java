package data.mapper;



import data.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

import data.dto.HostDto;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface HostMapper {

    //    public void HostHome();
    public List<RoomDto> getRoomList(); // 룸 리스트
    public List<MainCategoryDto> getMainCategoryList(); // 메인카테고리 리스트
    public List<CategoryDto> getCategoryList(); // 카테고리 리스트
    public void insertRoom(RoomDto dto); // 번호 생성 인서트
    public void insertUpdateRoom(RoomDto dto); // 번호 생성 후 (업데이트)인서트
    public RoomDto getData(int num); //num값 가져오기
    public void deleteRoom(int num); //삭제
    public void insertRoomOption(HashMap<String,Object> map);
    public void insertInformation(InformationDto dto);
    public void insertPrecaution(PrecautionDto dto);
    public void insertRoomImage(RoomImageDto dto);


//    public void HostHome();

    List<HostDto> getHostList();

}
