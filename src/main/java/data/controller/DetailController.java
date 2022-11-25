package data.controller;

import data.dto.LikeDto;
import data.dto.QnADto;
import data.dto.ReviewDto;
import data.dto.RoomDto;
import data.mapper.DetailMapper;
import data.mapper.LikeMapper;
import data.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DetailController {

    @Autowired
    DetailMapper detailMapper;

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    LikeMapper likeMapper;


//    detail.js(태그,룸이미지,룸정보)
    @GetMapping("/detailroom")
    public Map<String,Object> detailroom(@RequestParam int num){

        //조회수 증가
        //detailMapper.updateReadCount(num);

        Map<String, Object> map=new HashMap<>();
        map.put("roomData",detailMapper.getRoomData(num));
        map.put("tag",detailMapper.getTagName(num));
        map.put("roomImg",detailMapper.getImg(num));

        return map;
    }

//    DetailInfo.js(룸에 대한 정보)
    @GetMapping("/detailInfo")
    public Map<String,Object> detailInfo(@RequestParam int num ){

        Map<String, Object> map=new HashMap<>();
        map.put("roomData",detailMapper.getRoomData(num));
        map.put("roomInfo",detailMapper.getInformation(num));
        map.put("pre",detailMapper.getPrecaution(num));
        map.put("category",detailMapper.getCategoryData(num));
        map.put("facility",detailMapper.getFacilityList(num));

        return map;
    }
//    찜_조건 리스트
    @GetMapping("/detailLike")
    public LikeDto selectLike(@RequestParam int num, @RequestParam int userNum){
        Map<String, Integer> smap=new HashMap<>();
        smap.put("num",num);
        smap.put("userNum",userNum);


        return likeMapper.selectLike(smap);
    }


//    찜 삭제
    @PostMapping("/detail/deleteLike")
    public void deleteLike(@RequestBody LikeDto dto){

        likeMapper.deleteLike(dto);
    }

//    찜 추가
    @PostMapping("/detail/insertLike")
    public void insertLike(@RequestBody LikeDto dto){

        likeMapper.insertLike(dto);
    }

//    예약된 시간 가져오기
    @GetMapping("detailBookingTime")
    public String getBookingTime(@RequestParam int num,@RequestParam String selectDay){
        Map<String, Object> smap=new HashMap<>();
        smap.put("num",num);
        smap.put("selectDay",selectDay);

        return detailMapper.getBookingTime(smap);
    }

//    Qna 리스트 가져오기
    @GetMapping("/detailQna")
    public List<QnADto> detailQna(@RequestParam int num){
       return detailMapper.getQnaList(num);
    }

//    Qna 추가
    @PostMapping("/detail/insertQna")
    public void insertQna(@RequestBody QnADto dto){
        dto.setStatus("답변대기중");
        detailMapper.insertQna(dto);
    }

//    리뷰+호스트(로고이미지,호스트명) 정보 가져오기
    @GetMapping("/detailReview")
    public Map<String,Object> detailReview(@RequestParam int num){
        Map<String, Object> map=new HashMap<>();
        map.put("count",reviewMapper.selectReviewCount(num));
        map.put("avg",reviewMapper.getReviewAvg(num));
        map.put("review",detailMapper.getReviewList(num));
        map.put("reviewPhoto",detailMapper.getReviewPhoto(num));
        map.put("host",detailMapper.getHostByNum(num));
        map.put("roomData",detailMapper.getRoomData(num));


        return map;
    }

//    호스트 공간+정렬

    @GetMapping("/host/placelist")
    public List<RoomDto> detailHost(@RequestParam int hostNum,  @RequestParam(defaultValue = "readCount desc") String sort){
        System.out.println(sort);

        Map<String, Object> map=new HashMap<>();

        map.put("hostNum",hostNum);
        map.put("sort",sort);

        return detailMapper.getRoomByHostNum(map);
    }
    @GetMapping("/reviewQna/qnaList")
    public List<QnADto> getQnaByUserNum(@RequestParam int userNum, @RequestParam String sort){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userNum",userNum);
        map.put("sort",sort);

        System.out.println(map);

        return detailMapper.getQnaByUserNum(map);
    }
}
