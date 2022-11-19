package data.mapper;

import data.dto.HostDto;
import org.apache.ibatis.annotations.Mapper;
import data.dto.*;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface HostMapper {

    // booking detail page host info
    public HostDto getHostInfoList(int num);

    //    public void HostHome();
    public List<RoomDto> getRoomList(); // 룸 리스트
    public List<MainCategoryDto> getMainCategoryList(); // 메인카테고리 리스트
    public List<CategoryDto> getCategoryList(); // 카테고리 리스트
    public void insertRoom(RoomDto dto); // 번호 생성 인서트
    public void insertUpdateRoom(RoomDto dto); // 번호 생성 후 (업데이트)인서트
    public RoomDto getData(int num); //num값 가져오기
    public void deleteRoom(int num); //삭제
    public void insertRoomOption(HashMap<String,Object> map); //룸 옵션 인서트
    public void insertInformation(InformationDto dto); // 룸 인포 인서트
    public void insertPrecaution(PrecautionDto dto); // 룸 주의사항 인서트
    public void insertRoomImage(RoomImageDto dto); // 룸 이미지들 인서트
    public void updateStatus(RoomDto dto); // 방 공개 비공개
    public void updateForm1(RoomDto dto); // 첫번째업데이트폼
    public List<RoomCategoryDto> getCategoryData (int roomNum); // 카테고리에서 룸 넘버
    public List<RoptionDto> getOptionData (int roomNum); // roption에서 룸넘버 가져오기
    public List<RoomImageDto> getImageData (int roomNum); // roomImage에서 룸 넘버 가져오기
    public List<TagDto> getTagData (int roomNum); // 태그에서 룸 넘버
    public List<InformationDto> getInfoData (int roomNum); //인포에서 룸 넘버
    public List<PrecautionDto> getPreData (int roomNum); //주의사항에서 룸 넘버




//    List<HostDto> getHostList();
    List<HostDto> getHostSearchList(HashMap<String,Object> map);    // 호스트 리스트 출력
}
