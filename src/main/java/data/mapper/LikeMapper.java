package data.mapper;

import data.dto.LikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LikeMapper {
    int selectLikeCount(int num);
    void insertLike(LikeDto dto);
    void deleteLike(LikeDto dto);
    LikeDto selectLike(Map<String,Integer> map);
}
