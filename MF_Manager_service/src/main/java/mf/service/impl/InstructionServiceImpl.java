package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.InstructionMapper;
import mf.pojo.Instruction;
import mf.pojo.InstructionExample;
import mf.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructionServiceImpl implements InstructionService{
    @Autowired
    InstructionMapper instructionMapper;
    @Override
    public Result selectByExample(InstructionExample example) {
        List<Instruction> instructionList=instructionMapper.selectByExample(example);
        return Result.ok(instructionList.get(0));
    }
}
