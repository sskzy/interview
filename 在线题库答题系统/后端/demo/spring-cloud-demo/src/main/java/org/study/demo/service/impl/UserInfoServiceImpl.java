package org.study.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.demo.controller.vo.login.LoginVo;
import org.study.demo.controller.vo.login.RegisterVo;
import org.study.demo.entity.po.UserInfo;
import org.study.demo.service.UserInfoService;
import org.study.demo.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

    private UserInfoMapper userInfoMapper;

    @Autowired
    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfo completionUserInfo(UserInfo userInfo) {
        return userInfoMapper.completionUserInfo(userInfo);
    }

    @Override
    public Integer insertUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }
}




