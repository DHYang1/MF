package mf.controller;

import MF_Utils.IDUtils;
import MF_Utils.Result;
import mf.pojo.Feedback;
import mf.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    /**
     * 新增用户反馈
     * @param feedback
     * @return
     */

    @RequestMapping("/feedback")
    @ResponseBody
    public Result creat(Feedback feedback){
        feedback.setFeedbackId(IDUtils.getUserId());
        feedbackService.insertSelective(feedback);
        return Result.ok();
    }
}
