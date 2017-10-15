package mf.mapper;

import java.util.List;
import mf.pojo.Subscribe;
import mf.pojo.SubscribeExample;
import org.apache.ibatis.annotations.Param;

public interface SubscribeMapper {
    int countByExample(SubscribeExample example);

    int deleteByExample(SubscribeExample example);

    int deleteByPrimaryKey(Long subscribeId);

    int insert(Subscribe record);

    int insertSelective(Subscribe record);

    List<Subscribe> selectByExample(SubscribeExample example);

    Subscribe selectByPrimaryKey(Long subscribeId);

    int updateByExampleSelective(@Param("record") Subscribe record, @Param("example") SubscribeExample example);

    int updateByExample(@Param("record") Subscribe record, @Param("example") SubscribeExample example);

    int updateByPrimaryKeySelective(Subscribe record);

    int updateByPrimaryKey(Subscribe record);
}