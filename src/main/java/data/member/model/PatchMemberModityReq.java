package data.member.model;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatchMemberModityReq {
    private String nickname;
    private String phoneNum;
    private String gender;
    private String birthday;
    private String notification;
}
