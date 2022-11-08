package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("RoptionDto")
public class RoptionDto {
    private int num;
    private String oname;
    private int price;
    private String oimageUrl;
}
