package mf.mapper;

import java.util.List;
import mf.pojo.DesignerWallet;
import mf.pojo.DesignerWalletExample;
import org.apache.ibatis.annotations.Param;

public interface DesignerWalletMapper {
    int countByExample(DesignerWalletExample example);

    int deleteByExample(DesignerWalletExample example);

    int deleteByPrimaryKey(Long designerId);

    int insert(DesignerWallet record);

    int insertSelective(DesignerWallet record);

    List<DesignerWallet> selectByExample(DesignerWalletExample example);

    DesignerWallet selectByPrimaryKey(Long designerId);

    int updateByExampleSelective(@Param("record") DesignerWallet record, @Param("example") DesignerWalletExample example);

    int updateByExample(@Param("record") DesignerWallet record, @Param("example") DesignerWalletExample example);

    int updateByPrimaryKeySelective(DesignerWallet record);

    int updateByPrimaryKey(DesignerWallet record);
}