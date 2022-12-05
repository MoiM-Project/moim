package data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("ReviewDto")
public class ReviewDto {
    private int num;
    private String content;
    private String answerContent;
    private int rating;
    private String reviewImageUrl;
    private int userNum;
    private int roomNum;
    private int bookingDetailNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp writeday;

    //member
    private String nickname;
    private String profile_image;
    private String name;

    //room - 메인페이지 리뷰가져오기
    private String roomName; //리뷰 클릭 시 공간 상세보기 이동을 위한 num
    private int weekAmPrice; //리뷰에 가격 표시
    
}
