package data.controller;

import data.member.CertificationService;
import data.member.email.RegisterMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class MailController {
    @Autowired
    RegisterMail registerMail;

    @Autowired
    CertificationService certificationService;

    // 이메일 인증
    @PostMapping("login/mailConfirm")
    @ResponseBody
    String mailConfirm(@RequestParam String email) throws Exception {

        String code = registerMail.sendSimpleMessage(email);
        System.out.println("인증코드 : " + code);
        return code;
    }
    // 휴대폰 인증
    @GetMapping("/check/sendSMS")
    public @ResponseBody
    String sendSMS(String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
//        certificationService.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }
}
