package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.RegistrationProtocolMapper;
import mf.pojo.RegistrationProtocol;
import mf.pojo.RegistrationProtocolExample;
import mf.service.RegistrationProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegistrationProtocolServiceImpl implements RegistrationProtocolService{
    @Autowired
    RegistrationProtocolMapper registrationProtocolMapper;
    @Override
    public Result selectByExample(RegistrationProtocolExample example) {
        List<RegistrationProtocol> registrationProtocols=registrationProtocolMapper.selectByExample(example);
        return Result.ok(registrationProtocols.get(0));
    }
}
