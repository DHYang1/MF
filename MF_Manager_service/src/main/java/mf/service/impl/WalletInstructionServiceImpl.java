package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.WalletInstructionMapper;
import mf.pojo.WalletInstruction;
import mf.pojo.WalletInstructionExample;
import mf.service.WalletInstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WalletInstructionServiceImpl implements WalletInstructionService{
    @Autowired
    WalletInstructionMapper walletInstructionMapper;
    @Override
    public Result selectByExample(WalletInstructionExample example) {
        List<WalletInstruction> walletInstructions=walletInstructionMapper.selectByExample(example);
        return Result.ok(walletInstructions.get(0));
    }
}
