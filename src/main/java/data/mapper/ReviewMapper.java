package data.mapper;

import data.dto.QnADto;
import data.dto.ReviewDto;
import data.dto.TagDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper {
    int selectReviewCount(int num);
    List<ReviewDto> getReviewList();
    int getReviewAvg(int num);
    List<ReviewDto> getReviewByUserNum(HashMap<String,Object> map);

    // review insert ( booking detail page)
    void reviewInsert(HashMap<String, Object> map);
    void reviewDelete(int num);
    ReviewDto getReviewByNum(int num);
    void updateReview(HashMap<String,Object> map);
    // review 작성 했는지 안했는지 체크
    ReviewDto reviewCheck(int bookingDetailNum);
    List<ReviewDto> getReviewByHostNum(HashMap<String,Object> map);
}
