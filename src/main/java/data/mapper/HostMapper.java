package data.mapper;


import data.dto.CategoryDto;
import data.dto.MainCategoryDto;
import data.dto.RoomDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface HostMapper {
    //    public void HostHome();
    public List<RoomDto> getRoomList(); // 룸 리스트

    public List<MainCategoryDto> getMainCategoryList(); // 메인카테고리 리스트

    public List<CategoryDto> getCategoryList(); // 카테고리 리스트

    public void insertRoom(RoomDto dto); // 인서트
}
