package com.ruoyi.framework.shiro.realm;

import com.ruoyi.common.constant.ShiroConstants;
import com.ruoyi.common.exception.user.UserBlockedException;
import com.ruoyi.framework.shiro.service.WeChatUserService;
import com.ruoyi.framework.shiro.token.WeChatUserToken;
import com.ruoyi.partTime.domain.PtpUser;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: online-course
 * @description: 微信shiro realm
 * @author: Mr.Kong
 * @create: 2019-04-10 15:53
 **/
@Slf4j
public class WeChatRealm extends AuthorizingRealm {
    @Getter
    private final String loginType = ShiroConstants.WECHAT_LOGIN_TYPE;

    @Autowired
    private WeChatUserService weChatUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 权限判断,这里只用于微信小程序登陆，权限一样
        Set<String> perms = new HashSet<>();
        perms.add("weChat:customer:view");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;
    }

    /**
     * 登陆认证
     *
     * @param token token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        WeChatUserToken weChatUserToken = (WeChatUserToken) token;
        String openId = weChatUserToken.getOpenId();
        PtpUser user = null;
        try {
            user = weChatUserService.login(openId);
        } catch (UserBlockedException e) {
            throw new LockedAccountException(e.getMessage(), e);
        } catch (Exception e) {
            log.info("对用户[" + openId + "]进行登录验证..验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        return new SimpleAuthenticationInfo(user, weChatUserToken.getOpenId(), getName());
    }


}
