package mf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mf.mapper.UserCenterMapper;
import mf.pojo.UserCenter;
import mf.service.DemoService;
@Service
public class DemoServiceImpl implements DemoService {
@Autowired UserCenterMapper upmsUserMapper;
	@Override
	public UserCenter getUserById(long userId) {
		UserCenter user = upmsUserMapper.selectByPrimaryKey(userId);
		return user;
		
	}

}
