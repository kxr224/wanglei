package com.ruoyi.service.impl;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.config.WeChatAppletProperties;
import com.ruoyi.entity.Code2SessionResultEntity;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.service.IPtpUserService;
import com.ruoyi.service.WeChatAuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: ruoyi
 * @description: 微信鉴权服务
 * @author: Mr.Kong
 * @create: 2019-04-01 11:08
 **/
@Slf4j
@Service
@AllArgsConstructor
public class WeChatAuthServiceImpl implements WeChatAuthService {
    /**
     * 微信配置文件注入
     */
    private final WeChatAppletProperties weChatAppletProperties;
    /**
     * 用户服务注入用于微信登陆
     */
    private final IPtpUserService userService;

    @Override
    public Code2SessionResultEntity code2Session(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BusinessException("缺少code是参数");
        }
        String url = weChatAppletProperties.getCode2SessionUrl();
        url = url.replace("{appId}", weChatAppletProperties.getAppId())
                .replace("{appSecret}", weChatAppletProperties.getAppSecret()).replace("{JSCODE}", code);
        // 发送请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity res = restTemplate.getForEntity(url, String.class);
        Code2SessionResultEntity code2SessionResultEntity = JSON.parseObject(String.valueOf(res.getBody()), Code2SessionResultEntity.class);
        //返回数据
        if (StringUtils.isNotBlank(code2SessionResultEntity.getOpenid())) {
            // 如果该用户未注册，则进行注册
            PtpUser user = userService.getUserByOpenId(code2SessionResultEntity.getOpenid());
            // 未注册
            if (user == null) {
                code2SessionResultEntity.setIsRegister(false);
            } else {
                code2SessionResultEntity.setIsRegister(true);
            }
        }
        return code2SessionResultEntity;
    }

}
