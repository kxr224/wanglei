package com.ruoyi.config;

import com.ruoyi.common.utils.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: ruoyi
 * @description: 微信小程序的配置文件
 * @author: Mr.Kong
 * @create: 2019-04-01 14:45
 **/
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatAppletProperties {

    /**
     * 小程序appId
     **/
    private String appId;
    /**
     * 小程序的appSecret
     **/
    private String appSecret;
    /**
     * code2session 请求的url
     */
    private String code2SessionUrl;

    @PostConstruct
    public void verifyProperties() {
        if (StringUtils.isBlank(this.appId)){
            log.error("请配置微信小程序的appId");
            throw new RuntimeException("请配置微信小程序的appId");
        }else if (StringUtils.isBlank(this.appSecret)){
            log.error("请配置微信小程序的appSecret");
            throw new RuntimeException("请配置微信小程序的appSecret");
        }else if (StringUtils.isBlank(this.code2SessionUrl)){
            log.error("请配置微信小程序的code2SessionUrl");
            throw new RuntimeException("请配置微信小程序的code2SessionUrl");
        }
    }
}
