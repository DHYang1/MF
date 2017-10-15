package mf.mapper;

import java.util.List;
import mf.pojo.Instruction;
import mf.pojo.InstructionExample;
import org.apache.ibatis.annotations.Param;

public interface InstructionMapper {
    int countByExample(InstructionExample example);

    int deleteByExample(InstructionExample example);

    int deleteByPrimaryKey(Integer instructionId);

    int insert(Instruction record);

    int insertSelective(Instruction record);

    List<Instruction> selectByExampleWithBLOBs(InstructionExample example);

    List<Instruction> selectByExample(InstructionExample example);

    Instruction selectByPrimaryKey(Integer instructionId);

    int updateByExampleSelective(@Param("record") Instruction record, @Param("example") InstructionExample example);

    int updateByExampleWithBLOBs(@Param("record") Instruction record, @Param("example") InstructionExample example);

    int updateByExample(@Param("record") Instruction record, @Param("example") InstructionExample example);

    int updateByPrimaryKeySelective(Instruction record);

    int updateByPrimaryKeyWithBLOBs(Instruction record);

    int updateByPrimaryKey(Instruction record);
}