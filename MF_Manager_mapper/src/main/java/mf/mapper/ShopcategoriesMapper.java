package mf.mapper;

import java.util.List;
import mf.pojo.Shopcategories;
import mf.pojo.ShopcategoriesExample;
import org.apache.ibatis.annotations.Param;

public interface ShopcategoriesMapper {
    int countByExample(ShopcategoriesExample example);

    int deleteByExample(ShopcategoriesExample example);

    int deleteByPrimaryKey(Long categoriesId);

    int insert(Shopcategories record);

    int insertSelective(Shopcategories record);

    List<Shopcategories> selectByExample(ShopcategoriesExample example);

    Shopcategories selectByPrimaryKey(Long categoriesId);

    int updateByExampleSelective(@Param("record") Shopcategories record, @Param("example") ShopcategoriesExample example);

    int updateByExample(@Param("record") Shopcategories record, @Param("example") ShopcategoriesExample example);

    int updateByPrimaryKeySelective(Shopcategories record);

    int updateByPrimaryKey(Shopcategories record);
}