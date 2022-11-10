package data.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    int selectLikeCount(int num);
}
