package data.mapper;

import data.dto.CategoryDto;
import data.dto.RoomDto;
import data.dto.RoomCategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryDto> getAllCategory();
    List<RoomDto> getCategoryRoom(HashMap<String,Object> map);
    CategoryDto selectCategory(int categoryNum);
    public void insertCategory(RoomCategoryDto map);


}
