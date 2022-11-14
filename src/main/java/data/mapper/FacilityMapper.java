package data.mapper;

import data.dto.CategoryDto;
import data.dto.FacilityDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FacilityMapper {

    public List<FacilityDto> selectFacility();
}
