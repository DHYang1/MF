package mf.controller;

import MF_Utils.Result;
import mf.pojo.RegistrationProtocolExample;
import mf.service.RegistrationProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class RegistrationProtocolController {
    @Autowired
    RegistrationProtocolService registrationProtocolService;

    /**
     * 根据状态查询注册协议(0.未使用1.已使用)
     * @param state
     * @return
     */
    @RequestMapping("/registration")
    @ResponseBody
    public Result select(){
        RegistrationProtocolExample registrationProtocolExample=new RegistrationProtocolExample();
        registrationProtocolExample.or().andStateEqualTo(1);
        Result result=registrationProtocolService.selectByExample(registrationProtocolExample);
        return result;
    }
}
