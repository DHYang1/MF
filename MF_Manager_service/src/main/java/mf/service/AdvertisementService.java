package mf.service;

import MF_Utils.Result;
import mf.pojo.AdvertisementExample;

public interface AdvertisementService {
    public Result selectByExample(AdvertisementExample example);
}
