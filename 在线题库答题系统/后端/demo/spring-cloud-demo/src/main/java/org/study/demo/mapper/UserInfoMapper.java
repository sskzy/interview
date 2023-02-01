package org.study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.study.demo.controller.vo.login.LoginVo;
import org.study.demo.controller.vo.login.RegisterVo;
import org.study.demo.entity.po.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity org.study.demo.entity.po.UserInfo
 */

@Repository
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * select: 根据用户对象`username`学号和`password`密码获取`token`令牌
     *
     * @param userInfo 用户对象
     * @return 令牌
     */
    UserInfo completionUserInfo(@Param("userInfo") UserInfo userInfo);

    /**
     * insert: 根据对象参数新郑用户信息
     *
     * @param userInfo 用户对象
     * @return 1 成功状态(1:成功)
     */
    Integer insertUserInfo(@Param("userInfo") UserInfo userInfo);

    /**
     * select: 根据`token`令牌查询用户ID
     *
     * @param token 令牌
     * @return 用户ID
     */
    UserInfo selectUserIdByToken(@Param("token") String token);

}




