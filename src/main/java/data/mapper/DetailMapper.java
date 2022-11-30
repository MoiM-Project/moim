package data.mapper;

import data.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DetailMapper {
    public RoomDto getRoomData(int num);
    public void updateReadCount(int num);
    public List<TagDto> getTagName(int num);
    public List<TagDto> getImg(int num);
    public List<TagDto> getInformation(int num);
    public List<TagDto> getPrecaution(int num);
    public List<RoomDto> getCategoryData(int num);
    public List<RoomDto> getFacilityList(int num);
    public List<QnADto> getQnaList(int num);
    public void insertQna(QnADto dto);
    public  List<ReviewDto> getReviewList(int num);
    public  List<ReviewDto> getReviewPhoto(int num);
    public String getBookingTime(Map<String,Object> map);
    public RoomDto getHostByNum(int num);
    public List<RoomDto> getRoomByHostNum(Map<String,Object> map);
    List<QnADto> getQnaByUserNum(HashMap<String,Object> map);
    public List<RoomDto> selectRandomRooms(int num);
}
