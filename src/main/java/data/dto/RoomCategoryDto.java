package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("RoomCategoryDto")
public class RoomCategoryDto {
    private int num;
    private int roomNum;
    private int categoryNum;
}
