package mf.mapper;

import java.util.List;
import mf.pojo.PayVendor;
import mf.pojo.PayVendorExample;
import org.apache.ibatis.annotations.Param;

public interface PayVendorMapper {
    int countByExample(PayVendorExample example);

    int deleteByExample(PayVendorExample example);

    int deleteByPrimaryKey(Long payVendorId);

    int insert(PayVendor record);

    int insertSelective(PayVendor record);

    List<PayVendor> selectByExample(PayVendorExample example);

    PayVendor selectByPrimaryKey(Long payVendorId);

    int updateByExampleSelective(@Param("record") PayVendor record, @Param("example") PayVendorExample example);

    int updateByExample(@Param("record") PayVendor record, @Param("example") PayVendorExample example);

    int updateByPrimaryKeySelective(PayVendor record);

    int updateByPrimaryKey(PayVendor record);
}