package mf.service;

import MF_Utils.Result;
import mf.pojo.WalletInstructionExample;

public interface WalletInstructionService {
    public Result selectByExample(WalletInstructionExample example);
}
