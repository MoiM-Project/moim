package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("roptionDto")
public class roptionDto {
    private int num;
    private String name;
    private int price;
    private String imageUrl;
}
