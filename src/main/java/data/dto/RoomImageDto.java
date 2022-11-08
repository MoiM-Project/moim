package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("RoomImageDto")
public class RoomImageDto {
    private int num;
    private String imageUrl;
    private int roomNum;
}
