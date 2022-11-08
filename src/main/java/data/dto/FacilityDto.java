package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("FacilityDto")
public class FacilityDto {
    private int num;
    private String name;
    private String imageUrl;
}
