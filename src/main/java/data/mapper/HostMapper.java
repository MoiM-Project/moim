package data.mapper;


import data.dto.HostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface HostMapper {
//    public void HostHome();

    List<HostDto> getHostList();
}
