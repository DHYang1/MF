package mf.controller;

import MF_Utils.Result;
import mf.pojo.UserKnowExample;
import mf.service.UserKnowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class UserKnowController {
    @Autowired
    UserKnowService userKnowService;

    /**
     * 根据状态查询用户须知(0.未使用1.已使用)
     * @param state
     * @return
     */
    @RequestMapping("/userknow")
    @ResponseBody
    public Result select(){
        UserKnowExample userKnowExample=new UserKnowExample();
        userKnowExample.or().andStateEqualTo(1);
        Result result=userKnowService.selectByExample(userKnowExample);
        return result;
    }
}
