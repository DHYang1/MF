package mf.service.impl;

import MF_Utils.Result;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import mf.mapper.FeedbackMapper;
import mf.pojo.Feedback;
import mf.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    FeedbackMapper feedbackMapper;
    @Override
    public Result insertSelective(Feedback record) {
        feedbackMapper.insertSelective(record);
        return Result.ok();
    }
}
