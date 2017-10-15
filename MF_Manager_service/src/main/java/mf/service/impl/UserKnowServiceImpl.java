package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.UserKnowMapper;
import mf.pojo.UserKnow;
import mf.pojo.UserKnowExample;
import mf.service.UserKnowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserKnowServiceImpl implements UserKnowService{
    @Autowired
    UserKnowMapper userKnowMapper;
    @Override
    public Result selectByExample(UserKnowExample example) {
        List<UserKnow> userKnows=userKnowMapper.selectByExample(example);
        return Result.ok(userKnows.get(0));
    }
}
