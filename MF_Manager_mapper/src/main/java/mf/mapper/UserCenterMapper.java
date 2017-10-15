package mf.mapper;

import java.util.List;
import mf.pojo.UserCenter;
import mf.pojo.UserCenterExample;
import org.apache.ibatis.annotations.Param;

public interface UserCenterMapper {
    int countByExample(UserCenterExample example);

    int deleteByExample(UserCenterExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserCenter record);

    int insertSelective(UserCenter record);

    List<UserCenter> selectByExample(UserCenterExample example);

    UserCenter selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserCenter record, @Param("example") UserCenterExample example);

    int updateByExample(@Param("record") UserCenter record, @Param("example") UserCenterExample example);

    int updateByPrimaryKeySelective(UserCenter record);

    int updateByPrimaryKey(UserCenter record);
}