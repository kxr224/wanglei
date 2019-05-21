package com.ruoyi.framework.shiro.config;

import cn.hutool.core.util.ReflectUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;


/**
 * 当配置了多个Realm时，我们通常使用的认证器是shiro自带的org.apache.shiro.authc.pam.ModularRealmAuthenticator，其中决定使用的Realm的是doAuthenticate()方法
 * <p>
 * 自定义Authenticator
 * 注意，当需要分别定义处理学生和教师和管理员验证的Realm时，对应Realm的全类名应该包含字符串“Student”“Teacher”，或者“Admin”。
 * 并且，他们不能相互包含，例如，处理学生验证的Realm的全类名中不应该包含字符串"Admin"。
 */
public class MultiModularRealmAuthenticator extends ModularRealmAuthenticator {

    private static final Logger logger = LoggerFactory.getLogger(MultiModularRealmAuthenticator.class);


    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken token)
            throws AuthenticationException {
        logger.info("UserModularRealmAuthenticator:method doAuthenticate() execute ");
        // 判断getRealms()是否返回为空
        assertRealmsConfigured();
        // 利用反射机制获取loginType的值
        String loginType = (String) ReflectUtil.getFieldValue(token,
                ReflectUtil.getField(token.getClass(), "loginType"));
        // 所有Realm
        Collection<Realm> realms = getRealms();
        // 登录类型对应的所有Realm
        ArrayList<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().contains(loginType)) {
                typeRealms.add(realm);
            }
        }

        // 判断是单Realm还是多Realm
        if (typeRealms.size() == 1) {
            logger.info("doSingleRealmAuthentication() execute ");
            return doSingleRealmAuthentication(typeRealms.get(0), token);
        } else {
            logger.info("doMultiRealmAuthentication() execute ");
            return doMultiRealmAuthentication(typeRealms, token);
        }
    }
}
