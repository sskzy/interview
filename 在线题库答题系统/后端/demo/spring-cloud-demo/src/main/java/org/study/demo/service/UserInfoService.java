package org.study.demo.service;

import org.apache.ibatis.annotations.Param;
import org.study.demo.controller.vo.login.LoginVo;
import org.study.demo.controller.vo.login.RegisterVo;
import org.study.demo.entity.po.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo completionUserInfo(@Param("userInfo") UserInfo userInfo);

    Integer insertUserInfo(@Param("userInfo") UserInfo userInfo);
}
