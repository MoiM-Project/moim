package data.member;

import data.member.model.GetEmailCertRes;
import data.member.model.GetEmailConfirmReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailCertService {

    private final
    JavaMailSender javaMailSender;

    @Autowired
    private EmailCertDao emailCertDao;

    @Async
    public String createEmailConfirmationToken(String token, String receiverEmail, String jwt) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(receiverEmail);
        mailMessage.setSubject("회원가입 이메일 인증 메일!");
        mailMessage.setText("http://localhost:9000/member/confirm?email="+receiverEmail+"&token="+token+"&jwt="+jwt );
        javaMailSender.send(mailMessage);

        return "test";
    }

    public GetEmailCertRes signupConfirm(GetEmailConfirmReq getEmailConfirmReq) {
        if (emailCertDao.tokenCheck(getEmailConfirmReq)) {
            GetEmailCertRes getEmailCertRes = emailCertDao.signupConfirm(getEmailConfirmReq.getEmail());
            return getEmailCertRes;
        }
        else {
            GetEmailCertRes getEmailCertRes = new  GetEmailCertRes(0);
            return getEmailCertRes;
        }

    }
}