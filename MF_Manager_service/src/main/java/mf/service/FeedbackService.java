package mf.service;

import MF_Utils.Result;
import mf.pojo.Feedback;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * FeedbackService接口
 * created by 程建达 on 2017/9/11.
 */
public interface FeedbackService {
    /**
     * 新建意见反馈
     * @param record
     * @return
     */
    public Result insertSelective(Feedback record);
}
