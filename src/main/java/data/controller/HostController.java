package data.controller;

import data.dto.HostDto;
import data.mapper.HostMapper;
import data.util.S3UploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import data.dto.*;
import data.mapper.CategoryMapper;
import data.mapper.TagMapper;
import data.util.ChangeName;
import data.util.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/host")
public class HostController {

    String uploadFileName;

    ArrayList<String> uploadFileNames = new ArrayList<>();

    List<String> roomList = new ArrayList<>();

    private final S3UploadUtil s3UploadUtil;

    @Autowired
    HostMapper hostMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    CategoryMapper categoryMapper;

    //전체 리스트
    @GetMapping("/list")
    public List<RoomDto> roomList(int hostNum) {
//        System.out.println(hostMapper.getRoomList().size());
        return hostMapper.getRoomList(hostNum);
    }


    //메인 카테고리 리스트
    @GetMapping("/maincategoryList")
    public List<MainCategoryDto> mainCategoryList() {
//        System.out.println("hostMapper.getMainCategoryList().size()" + hostMapper.getMainCategoryList().size());
        return hostMapper.getMainCategoryList();
    }

    //카테고리 리스트
    @GetMapping("/categoryList")
    public List<CategoryDto> categoryList() {
//        System.out.println("hostMapper.getCategoryList().size()" + hostMapper.getCategoryList().size());
        return hostMapper.getCategoryList();
    }

    //기본 인서트
    @PostMapping("/insert")
    public int insertRoom(@RequestBody RoomDto dto) {
        //업로드한 파일 이름 넣기
        dto.setThumbnailImage(uploadFileName);

        hostMapper.insertRoom(dto);

        uploadFileName = null; //비워줘야 다음에 먼저 첨부했떤 파일이 들어가있지 않음

//        System.out.println(dto.getNum());
        return dto.getNum();
    }

    @PostMapping("/insert2")
    public int insert2(@RequestBody Map<String, Object> params, RoomCategoryDto cdto, TagDto tdto,
                       InformationDto idto, PrecautionDto pdto) {

        List<String> TagList = (List<String>) params.get("tname");
        List<String> IContentList = (List<String>) params.get("icontent");
        List<String> PContentList = (List<String>) params.get("pcontent");
        List<Integer> CateList = (List<Integer>) params.get("categoryNum");
        int roomNum = Integer.parseInt((String) params.get("roomNum"));

        for (Integer s : CateList) {
            cdto.setCategoryNum(s);
            cdto.setRoomNum(roomNum);
            categoryMapper.insertCategory(cdto);
        }
        for (String s : TagList) {
            tdto.setTname(s);
            tdto.setRoomNum(roomNum);
            tagMapper.insertTag(tdto);
        }
        for (String s : IContentList) {
            idto.setIcontent(s);
            idto.setRoomNum(roomNum);
            hostMapper.insertInformation(idto);
        }
        for (String s : PContentList) {
            pdto.setPcontent(s);
            pdto.setRoomNum(roomNum);
            hostMapper.insertPrecaution(pdto);
        }
        return roomNum;
    }

    //옵션 인서트
    @PostMapping("/optioninsert")
    public void insertOption(@RequestBody Map<String, Object> params) {
//        System.out.println("호출이라도되나용");

        System.out.println(params);

        HashMap<String, Object> map = new HashMap<>();

        List<Map<String, Object>> OptionList = (List<Map<String, Object>>) params.get("roptionList");

        if (OptionList.size() != 0) {
            map.put("OptionList", OptionList);
            hostMapper.insertRoomOption(map);
        }
    }

    //인서트 업데이트
    @PostMapping("/insertupdate")
    public void insertupdate(@RequestBody RoomDto dto) {
        hostMapper.insertUpdateRoom(dto);
    }

    //썸네일 업로드
    @PostMapping("/photoupload")
    public String fileUploadlist(@RequestParam MultipartFile uploadFile) throws IOException {
        System.out.println("React로부터 썸네일 이미지 업로드");
        return s3UploadUtil.upload(uploadFile, "host");
    }

    //옵션 사진 업로드
    @PostMapping("/optionimage")
    public String OptionImage(@RequestParam MultipartFile uploadFile) throws IOException {
        System.out.println("React로부터 옵션 이미지 업로드");
        return s3UploadUtil.upload(uploadFile, "host");
    }

    //사진 리스트 업로드
    //업로드끝난 파일명을 반환해줄거임 -> List<String>
    @PostMapping("/photolistupload")
    public List<String> photoUpload(@RequestParam List<MultipartFile> uploadFile) throws IOException {
        System.out.println(uploadFile.size() + "개 업로드");
        // foodList 의 기존 사진명 지우기
        roomList.clear();

        for (MultipartFile multi : uploadFile) {
            roomList.add(s3UploadUtil.upload(multi,"host"));
        }
        return roomList;
    }

    // 방 이미지들 인서트
    @PostMapping("/roomimages")
    public void roomimagesInsert(@RequestBody RoomImageDto dto) {

        for (String s : uploadFileNames) {
            dto.setRimageUrl(s);
            hostMapper.insertRoomImage(dto);
        }
        uploadFileNames.clear();
    }

    // 방이미지들 삭제
    @GetMapping("/delphoto")
    public void deletePhoto(@RequestParam int idx) {
//        System.out.println(idx + "번 삭제");
        roomList.remove(idx);
    }

    //인서트 캔슬
    @DeleteMapping("/cancel")
    public void deleteRoom(@RequestParam int num) {
        System.out.println(num);
        hostMapper.deleteRoom(num);   //DB 데이터 삭제
    }


    //방 리스트에서 삭제
    @DeleteMapping("/delete")
    public void deleteRoom(@RequestParam int num, HttpServletRequest request) {
        System.out.println(num);

        //경로 구하기
        String path = request.getSession().getServletContext().getRealPath("/image");

        //삭제할 기존 파일명
        String oldFileName = hostMapper.getData(num).getThumbnailImage();
        FileUtil.deletePhoto(path, oldFileName);

        System.out.println(oldFileName + "삭제");
        System.out.println(num);
        hostMapper.deleteRoom(num);
    }

    //방 공개 비공개 이벤트
    @PatchMapping("/status")
    public void hideStatus(@RequestParam int num, @RequestParam boolean hideStatus) {
        System.out.println(num);
        System.out.println(hideStatus);
        RoomDto dto = hostMapper.getData(num);

//        dto=hostMapper.getData(num);
        dto.setHideStatus(hideStatus);
        hostMapper.updateStatus(dto);
    }

    @PatchMapping("/update")
    public void firstUpdateForm(@RequestBody RoomDto dto) {
        System.out.println(dto.getNum());
        hostMapper.updateForm1(dto);
    }


    // booking detail page - host info
    @GetMapping("/info")
    public HostDto getHostInfoList(int num) {
        HostDto dto = hostMapper.getHostInfoList(num);
//        System.out.println(dto);
        return dto;
    }

    //num에 해당하는 데이터 호출
    @GetMapping("/select")
    public RoomDto getData(@RequestParam int num) {
//        System.out.println(num);
        return hostMapper.getData(num);
    }

    //roomNum에 해당하는 데이터 호출
    @GetMapping("/updateform2")
    public Map<String, Object> updateform2(@RequestParam int roomNum) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryData", hostMapper.getCategoryData(roomNum));
        map.put("roptionData", hostMapper.getOptionData(roomNum));
        map.put("imageData", hostMapper.getImageData(roomNum));
        map.put("tagData", hostMapper.getTagData(roomNum));
        map.put("infoData", hostMapper.getInfoData(roomNum));
        map.put("preData", hostMapper.getPreData(roomNum));
        return map;
    }

    //수정폼에서 옵션삭제
    @DeleteMapping("/roptindel")
    public void roptindel(@RequestParam int num, HttpServletRequest request) {
        System.out.println(num);
        if(hostMapper.getOptionNum(num).getOimageUrl()!=null){
            String path = (hostMapper.getOptionNum(num).getOimageUrl().split("/",4)[3]);
            s3UploadUtil.delete(path);
        }
        System.out.println("roption삭제");
        hostMapper.deleteoption(num);
        System.out.println("roption삭제");
    }

    //수정폼에서 이미지들 삭제
    @DeleteMapping("/imagesdel")
    public void roomImagedel(@RequestParam int num, HttpServletRequest request) {
        System.out.println(num);
        if(hostMapper.getImagesNum(num).getRimageUrl()!=null){
            String path = hostMapper.getImagesNum(num).getRimageUrl().split("/",4)[3];
            s3UploadUtil.delete(path);
        }
        System.out.println("rimage삭제");
        hostMapper.deleteimages(num);
        System.out.println("rimage삭제");
    }

    //수정폼에서 태그,인포,주의사항 삭제
    @DeleteMapping("/updatedel")
    public void updatedel(@RequestParam int num) {
        hostMapper.deltag(num);
        hostMapper.delinfo(num);
        hostMapper.delpre(num);
    }

    //예약리스트 출력
    @GetMapping("/bookinglist")
    public List<BookingDetailDto> getBookingList(int hostNum, @RequestParam(defaultValue = "-1") String bookingStatus, @RequestParam(defaultValue = "num desc") String sort, @RequestParam(defaultValue = "") String search) {
        System.out.println(bookingStatus);
        HashMap<String, Object> map = new HashMap<>();
        map.put("hostNum", hostNum);
        map.put("bookingStatus", bookingStatus);
        map.put("sort", sort);
        if (bookingStatus.equals("-1"))
            return hostMapper.getBookingList2(hostNum);

        return hostMapper.getBookingList(map);
    }

    //예약리스트 디테일페이지
    @GetMapping("/bookingdetail")
    public BookingDetailDto getBookingDetailHost(int bookingDetailNum) {
        System.out.println(bookingDetailNum);
        BookingDetailDto dto = hostMapper.getBookingDetailHost(bookingDetailNum);
        return dto;
    }

    //대기중인거 승인으로 바꿔주기
    @PatchMapping("/bookingStatusUpdate")
    public void updateCancel(@RequestBody HashMap<String, Object> data) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("num", data.get("num"));

        System.out.println(map);
        hostMapper.bookingStatusUpdate(map);
    }

    //정산리스트
    @GetMapping("/acount")
    public List<BookingDto> getBookinglist(int hostNum) {
        return hostMapper.bookingGet(hostNum);
    }

    //정산 검색
    @GetMapping("/bsearch")
    public List<BookingDto> getSearchBooking(int hostNum, String sdate, String edate, String roomName, int payStatus) {
        System.out.println(hostNum);

        HashMap<String, Object> map = new HashMap<>();
        map.put("payStatus", payStatus);
        map.put("hostNum", hostNum);
        map.put("sdate", sdate);
        map.put("edate", edate);
        map.put("roomName", roomName);

        System.out.println(map);
        System.out.println(hostMapper.searchBooking(map));
        return hostMapper.searchBooking(map);
    }
}
