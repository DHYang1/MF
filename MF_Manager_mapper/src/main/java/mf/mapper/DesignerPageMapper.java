package mf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import mf.pojo.Designwork;

public interface DesignerPageMapper {
    //分页根据设计师查询作品
    List<Designwork> selectBypageDesigner(@Param("page")Integer page,@Param("designerId")long designerId);
}
