package data.mapper;

import data.dto.CategoryDto;
import data.dto.RoomCategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    public List<CategoryDto> getAllCategory();

    public void insertCategory(RoomCategoryDto dto);


}
