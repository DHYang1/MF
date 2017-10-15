package mf.mapper;

import java.util.List;
import mf.pojo.ShopImage;
import mf.pojo.ShopImageExample;
import org.apache.ibatis.annotations.Param;

public interface ShopImageMapper {
    int countByExample(ShopImageExample example);

    int deleteByExample(ShopImageExample example);

    int deleteByPrimaryKey(Long imageId);

    int insert(ShopImage record);

    int insertSelective(ShopImage record);

    List<ShopImage> selectByExample(ShopImageExample example);

    ShopImage selectByPrimaryKey(Long imageId);

    int updateByExampleSelective(@Param("record") ShopImage record, @Param("example") ShopImageExample example);

    int updateByExample(@Param("record") ShopImage record, @Param("example") ShopImageExample example);

    int updateByPrimaryKeySelective(ShopImage record);

    int updateByPrimaryKey(ShopImage record);
}