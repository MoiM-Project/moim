package data.controller;

import data.dto.NoticeDto;
import data.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class NoticeEventController {

    @Autowired
    NoticeMapper noticeMapper;

    //관리자 페이지에서 멤버정보 가져오기
    @GetMapping("/notice/noticeList")
    public List<NoticeDto> getNoticeSearchList(
            @RequestParam String searchWord)
    {
        //saerchWord 넘어오는지 테스트
        System.out.println("Notice searchWord = "+searchWord);

        HashMap<String, Object> map = new HashMap<>();
        map.put("searchWord",searchWord);

        //map 출력 테스트
        System.out.println("NoticeList map = "+ map);

        return noticeMapper.getNoticeSearchList(map);
    }
}
