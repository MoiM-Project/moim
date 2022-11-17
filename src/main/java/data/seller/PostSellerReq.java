package data.seller;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostSellerReq {
    private String email;
    private String password;
    private String brandname;
    private String phoneNum;
    private String gender;
    private String birthday;
    private String notification;

}


