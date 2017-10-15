package mf.service;

import MF_Utils.Result;
import mf.pojo.RegistrationProtocolExample;

public interface RegistrationProtocolService {
    public Result selectByExample(RegistrationProtocolExample example);
}
