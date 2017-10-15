package mf.service;

import MF_Utils.Result;
import mf.pojo.UserKnowExample;

public interface UserKnowService {
    public Result selectByExample(UserKnowExample example);
}
