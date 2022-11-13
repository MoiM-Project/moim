package data.mapper;


import data.dto.HostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface HostMapper {
    public void HostHome();

    // booking detail page host info
    public HostDto getHostInfoList(int num);
}
