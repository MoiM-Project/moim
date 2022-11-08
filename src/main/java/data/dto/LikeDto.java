package data.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("LikeDto")
public class LikeDto {
    private int num;
    private int userNum;
    private int roomNum;
}
