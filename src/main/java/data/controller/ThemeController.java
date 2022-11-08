package data.controller;

import data.dto.ThemeDto;
import data.mapper.ThemeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ThemeController {

    @Autowired
    ThemeMapper themeMapper;

    @GetMapping("/main/theme")
    public List<ThemeDto> selectThemeList() {

        return themeMapper.selectThemeList();
    }
}
