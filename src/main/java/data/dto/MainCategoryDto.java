package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("MainCategoryDto")
public class MainCategoryDto {
    private int num;
    private String mcname;
}
