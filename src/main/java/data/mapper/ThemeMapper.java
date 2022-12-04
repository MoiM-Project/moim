package data.mapper;

import data.dto.RoomDto;
import data.dto.ThemeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ThemeMapper {
    List<ThemeDto> selectThemeList();
    ThemeDto selectTheme(int themeNum);
    List<RoomDto> selectThemeRoomList(HashMap<String,Object> map);
    void deleteTheme(int themeNum);
    int selectThemeCount(int themeNum);
    void deleteThemeRoom(HashMap<String,Object> map);
    void insertTheme(HashMap<String,Object> map);
    void insertThemeRoom(HashMap<String,Object> map);
    void updateTheme(HashMap<String,Object> map);
}
