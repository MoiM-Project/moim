package data.mapper;

import data.dto.RoomDto;
import data.dto.ThemeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThemeMapper {
    void insertTheme(ThemeDto dto);
    List<ThemeDto> selectThemeList();
    List<RoomDto> selectThemeRoomList(int themeNum);
    void updateTheme(ThemeDto dto);
    void deleteTheme(int num);
    int selectThemeCount(int num);
}
