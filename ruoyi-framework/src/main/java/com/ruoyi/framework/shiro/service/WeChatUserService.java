package com.ruoyi.framework.shiro.service;

import com.ruoyi.common.exception.user.UserNotExistsException;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.service.IPtpUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @program: online-course
 * @description: 微信登陆服务
 * @author: Mr.Kong
 * @create: 2019-04-10 23:49
 **/
@Component
@AllArgsConstructor
public class WeChatUserService {
    private final IPtpUserService userService;

    /**
     *
     * 功能描述: 通过微信openId进行登陆
     *
     * @param openId 微信openId，通过微信openId即可进行登陆
     * @return com.ruoyi.course.domain.User
     * @auther Cyrus.kong
     * @date 2019-04-10
     */
    public PtpUser login(String openId) {
        PtpUser user = userService.getUserByOpenId(openId);
        if (user == null){
            throw new UserNotExistsException();
        }
        return user;
    }
}
