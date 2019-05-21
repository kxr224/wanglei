package com.ruoyi.framework.shiro.token;

import com.ruoyi.common.constant.ShiroConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @program: online-course
 * @description: 用户的token对象
 * @author: Mr.Kong
 * @create: 2019-04-10 17:20
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class UserToken extends UsernamePasswordToken {

    /**
     * 登陆类型,该类型需要和realm的类名相同，通过该属性确认访问哪一个realm
     */
    private final String loginType = ShiroConstants.ADMIN_LOGIN_TYPE;

    public UserToken(String username, String password, boolean rememberMe) {
        super(username, password, rememberMe);
    }
}
