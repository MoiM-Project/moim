package data.mapper;

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

}
