package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.AdvertisementMapper;
import mf.pojo.Advertisement;
import mf.pojo.AdvertisementExample;
import mf.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdvertisementServiceImpl implements AdvertisementService{
    @Autowired
    AdvertisementMapper advertisementMapper;
    @Override
    public Result selectByExample(AdvertisementExample example) {
        List<Advertisement> advertisements=advertisementMapper.selectByExample(example);
        return Result.ok(advertisements);
    }
}
