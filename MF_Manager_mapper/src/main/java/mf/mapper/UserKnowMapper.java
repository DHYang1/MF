package mf.mapper;

import java.util.List;
import mf.pojo.UserKnow;
import mf.pojo.UserKnowExample;
import org.apache.ibatis.annotations.Param;

public interface UserKnowMapper {
    int countByExample(UserKnowExample example);

    int deleteByExample(UserKnowExample example);

    int deleteByPrimaryKey(Integer userknowId);

    int insert(UserKnow record);

    int insertSelective(UserKnow record);

    List<UserKnow> selectByExampleWithBLOBs(UserKnowExample example);

    List<UserKnow> selectByExample(UserKnowExample example);

    UserKnow selectByPrimaryKey(Integer userknowId);

    int updateByExampleSelective(@Param("record") UserKnow record, @Param("example") UserKnowExample example);

    int updateByExampleWithBLOBs(@Param("record") UserKnow record, @Param("example") UserKnowExample example);

    int updateByExample(@Param("record") UserKnow record, @Param("example") UserKnowExample example);

    int updateByPrimaryKeySelective(UserKnow record);

    int updateByPrimaryKeyWithBLOBs(UserKnow record);

    int updateByPrimaryKey(UserKnow record);
}