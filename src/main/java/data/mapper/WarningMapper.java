package data.mapper;

import data.dto.WarningDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface WarningMapper {

    //admin > report 신고관리
//    List<WarningDto> getReportList(HashMap<String, Object> map);   //신고하기 전체 리스트 가져오기 (sort값 필요)
    List<WarningDto> getReportList(String sort);   //신고하기 전체 리스트 가져오기 (sort값 필요)

    void reportInsert(HashMap<String, Object> map);  //신고하기 Insert (방 상세 / 리뷰 / QnA 에서 각각 활용)

    WarningDto getReportInfo(int num);  //관리자 > 신고하기

}
