package mf.controller;

import MF_Utils.Result;
import mf.pojo.WalletInstructionExample;
import mf.service.WalletInstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class WalletInstructionController {
    @Autowired
    WalletInstructionService walletInstructionService;

    /**
     * 根据状态查询钱包说明(0.未使用1.已使用)
     * @param state
     * @return
     */
    @RequestMapping("/walletInstruction")
    @ResponseBody
    public Result select(){
        WalletInstructionExample walletInstructionExample=new WalletInstructionExample();
        walletInstructionExample.or().andStateEqualTo(1);
        Result result=walletInstructionService.selectByExample(walletInstructionExample);
        return result;
    }
}
