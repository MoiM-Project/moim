package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CategoryDto")
public class CategoryDto {
    private int num;
    private String cname;
    private int mainCategoryNum;
}
