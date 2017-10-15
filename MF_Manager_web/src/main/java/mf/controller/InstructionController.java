package mf.controller;

import MF_Utils.Result;
import mf.pojo.InstructionExample;
import mf.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class InstructionController {
    @Autowired
    InstructionService instructionService;

    /**
     * 根据状态查询使用说明(0.未使用1.已使用)
     * @param state
     * @return
     */
    @RequestMapping("/instruction")
    @ResponseBody
    public Result select(){
        InstructionExample instructionExample=new InstructionExample();
        instructionExample.or().andStateEqualTo(1);
        Result result=instructionService.selectByExample(instructionExample);
        return result;
    }
}
