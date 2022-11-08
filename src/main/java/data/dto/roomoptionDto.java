package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("roomoptionDto")
public class roomoptionDto {
    private int num;
    private int roomNum;
    private int roptionNum;
}
