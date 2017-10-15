package mf.service;

import MF_Utils.Result;
import mf.pojo.InstructionExample;

public interface InstructionService {
    public Result selectByExample(InstructionExample example);
}
