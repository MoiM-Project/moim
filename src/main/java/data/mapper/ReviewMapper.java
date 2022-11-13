package data.mapper;

import data.dto.ReviewDto;
import data.dto.TagDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    int selectReviewCount(int num);
    List<ReviewDto> getReviewList();

}
