package org.study.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.study.demo.controller.ro.login.LoginRo;
import org.study.demo.controller.ro.login.RegisterRo;
import org.study.demo.controller.vo.Status;
import org.study.demo.controller.vo.login.LoginVo;
import org.study.demo.controller.vo.login.RegisterVo;
import org.study.demo.entity.po.UserInfo;
import org.study.demo.service.impl.UserInfoServiceImpl;
import org.study.demo.util.metaData;

import java.util.UUID;

/**
 * @Author: SongTC
 * @Since: 2022/11/12
 * @E-mail: 690259811@qq.com
 * @Details;
 */

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginPageController {

    private UserInfoServiceImpl userInfoService;

    @Autowired
    public void setUserInfoService(UserInfoServiceImpl userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping("/login")
    public LoginVo login(@RequestBody LoginRo loginRo) {
        // 创建对象并写入`username`和`password`
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(loginRo.getUsername());
        userInfo.setPassword(loginRo.getPassword());

        LoginVo loginVo = new LoginVo();
        loginVo.setToken(userInfoService.completionUserInfo(userInfo).getToken());
        loginVo.setStatus(new Status(metaData.SUCCESS.CODE, metaData.SUCCESS.MSG));
        return loginVo;
    }

    /* ============================================================================================================== */

    @PostMapping("/register")
    public RegisterVo register(@RequestBody RegisterRo registerRo) {
        // 创建待插入的实例
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UUID.randomUUID().toString().replace("-", ""))
                .setUserAccount(registerRo.getUserAccount())
                .setPassword(registerRo.getPassword())
                .setUsername(UUID.randomUUID().toString().replace("-", ""))
                .setToken(UUID.randomUUID().toString().replace("-", ""));

        // 判断检查插入数据的情况
        Integer i = userInfoService.insertUserInfo(userInfo);
        if (i == 1) {
            return new RegisterVo(new Status(metaData.SUCCESS.CODE, metaData.SUCCESS.MSG));
        }
        return new RegisterVo(new Status(metaData.DEFEAT.CODE, metaData.DEFEAT.MSG));
    }

}
