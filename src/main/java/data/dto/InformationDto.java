package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("InformationDto")
public class InformationDto {
    private int num;
    private String content;
    private int roomNum;
}
