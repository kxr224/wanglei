package com.ruoyi.framework.shiro.token;

import com.ruoyi.common.constant.ShiroConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @program: online-course
 * @description: 微信自定义的token，用于判断登陆类型
 * @author: Mr.Kong
 * @create: 2019-04-10 15:53
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class WeChatUserToken extends UsernamePasswordToken {
    /**
     * 登陆类型,该类型需要和realm的类名相同，通过该属性确认访问哪一个realm
     */
    private final String loginType = ShiroConstants.WECHAT_LOGIN_TYPE;
    /**
     * openId,通过openId判断该用户是否注册，如果注册，
     * todo 可能存在风险，如果该openId，被别人知道了就可以进行调用了，可以加上通过sessionId进行判定
     */
    private String openId;

    public WeChatUserToken(String openId) {
        // 默认是记住我防止鉴权失效，未来改为认证失败返回json后就可以去掉了
        super(openId, openId, true);
        this.openId = openId;
    }

}
