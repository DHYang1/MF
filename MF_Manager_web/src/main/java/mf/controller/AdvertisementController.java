package mf.controller;

import MF_Utils.Result;
import mf.pojo.AdvertisementExample;
import mf.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class AdvertisementController {
    @Autowired
    AdvertisementService advertisementService;

    /**
     * 根据状态查询广告(0.未使用1.已使用)
     */
    @RequestMapping("/ad")
    @ResponseBody
    public Result select(){
        AdvertisementExample advertisementExample=new AdvertisementExample();
        advertisementExample.or().andStateEqualTo(1);
        Result result=advertisementService.selectByExample(advertisementExample);
        return result;
    }
}
