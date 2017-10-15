package mf.mapper;

import java.util.List;
import mf.pojo.WalletInstruction;
import mf.pojo.WalletInstructionExample;
import org.apache.ibatis.annotations.Param;

public interface WalletInstructionMapper {
    int countByExample(WalletInstructionExample example);

    int deleteByExample(WalletInstructionExample example);

    int deleteByPrimaryKey(Integer walletId);

    int insert(WalletInstruction record);

    int insertSelective(WalletInstruction record);

    List<WalletInstruction> selectByExampleWithBLOBs(WalletInstructionExample example);

    List<WalletInstruction> selectByExample(WalletInstructionExample example);

    WalletInstruction selectByPrimaryKey(Integer walletId);

    int updateByExampleSelective(@Param("record") WalletInstruction record, @Param("example") WalletInstructionExample example);

    int updateByExampleWithBLOBs(@Param("record") WalletInstruction record, @Param("example") WalletInstructionExample example);

    int updateByExample(@Param("record") WalletInstruction record, @Param("example") WalletInstructionExample example);

    int updateByPrimaryKeySelective(WalletInstruction record);

    int updateByPrimaryKeyWithBLOBs(WalletInstruction record);

    int updateByPrimaryKey(WalletInstruction record);
}