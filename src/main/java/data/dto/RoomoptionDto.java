package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("RoomoptionDto")
public class RoomoptionDto {
    private int num;
    private int roomNum;
    private int roptionNum;
}
