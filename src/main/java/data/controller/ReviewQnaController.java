package data.controller;

import data.dto.QnADto;
import data.dto.ReviewDto;
import data.mapper.QnAMapper;
import data.mapper.ReviewMapper;
import data.util.ChangeName;
import data.util.FileUtil;
import data.util.S3UploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ReviewQnaController {

    String uploadFileName;

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    QnAMapper qnaMapper;

    private final S3UploadUtil s3UploadUtil;

//    일반회원 기준 리뷰
    @GetMapping("/reviewQna/reviewList")
    public List<ReviewDto> getReviewByUserNum(@RequestParam int userNum,@RequestParam String sort){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userNum",userNum);
        map.put("sort",sort);

        return reviewMapper.getReviewByUserNum(map);
    }
//  호스트 기준 리뷰
    @GetMapping("/reviewQna/reviewHostList")
    public List<ReviewDto> getReviewByHostNum(@RequestParam int hostNum,@RequestParam String sort){
        HashMap<String, Object> map = new HashMap<>();
        map.put("hostNum",hostNum);
        map.put("sort",sort);

        return reviewMapper.getReviewByHostNum(map);
    }

    @DeleteMapping("/reviewDelete")
    public void reviewDelete(@RequestParam int num){
        // db에 이미지가 있는 경우 s3 이미지 파일 삭제
        if(reviewMapper.getReviewByNum(num).getReviewImageUrl()!=null){
            String path = reviewMapper.getReviewByNum(num).getReviewImageUrl().split("/",4)[3];
            s3UploadUtil.delete(path);
        }

        reviewMapper.reviewDelete(num);
    }

    @GetMapping("/reviewMember")
    public ReviewDto reviewMember(@RequestParam int num){
        return reviewMapper.getReviewByNum(num);
    }

    @PostMapping("/reviewUpdate")
    public void updateReview (@RequestParam(value="uploadFile", required = false) MultipartFile uploadFile,
                              String content,
                              int rating,
                              int num

    ) throws IOException{

        //DB에 Insert하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        //uploadFile을 제외하고 map에 담기
        map.put("content",content);
        map.put("rating",rating);
        map.put("num",num);


        // 이미지파일 첨부 여부 체크
        if(uploadFile!=null){
            // 이미지파일 첨부시
            if(reviewMapper.getReviewByNum(num).getReviewImageUrl()!=null){
                // db에 이미지 url이 있는 경우
                // 기존 데이터의 이미지url을 가져온 후 s3파일 삭제
                String path = reviewMapper.getReviewByNum(num).getReviewImageUrl().split("/",4)[3];
                s3UploadUtil.delete(path);
            }
            // 새로운 이미지 s3에 업로드 후 map에 추가
            map.put("uploadFile",s3UploadUtil.upload(uploadFile,"review"));
        } else {
            // 이미지파일 미첨부시
            // db의 이미지 url 가져와서 map에 추가
            map.put("uploadFile",null);
        }
        // insert sql 에 map 전달
        reviewMapper.updateReview(map);
        System.out.println(map);
    }

    @GetMapping("/qnaCotent")
    public QnADto getQnaByNum(@RequestParam int num){
        return qnaMapper.getQnaByNum(num);
    }
    @DeleteMapping("/qnaDelete")
    public void qnaDelete(@RequestParam int num){
        qnaMapper.qnaDelete(num);
    }

    @PostMapping("/qnaUpdate")
    public void updateQna (
                              @RequestParam String title,
                              String question,
                              int num
    ){

        //DB에 Insert하기위해 map 선언
        HashMap<String, Object> map = new HashMap<>();

        //uploadFile을 제외하고 map에 담기
        map.put("title",title);
        map.put("question",question);
        map.put("num",num);


        // insert sql 에 map 전달
        qnaMapper.updateQna(map);

    }

    @GetMapping("/hostQna")
    public List<QnADto> getQnaByHostNum(@RequestParam int hostNum,@RequestParam String sort){
        HashMap<String, Object> map = new HashMap<>();
        map.put("hostNum",hostNum);
        map.put("sort",sort);

        return qnaMapper.getQnaByHostNum(map);
    }

    @PostMapping("/hostQnaAnswer")
    public void insertQnaAnswer(@RequestParam String answer,int num){
        HashMap<String, Object> map = new HashMap<>();
        map.put("answer",answer);
        map.put("num",num);
        qnaMapper.insertQnaAnswer(map);
    }
}
