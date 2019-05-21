package com.ruoyi.service;


import com.ruoyi.entity.Code2SessionResultEntity;

/**
 * @program: ruoyi
 * @description: 微信鉴权服务
 * @author: Mr.Kong
 * @create: 2019-04-01 10:59
 **/
public interface WeChatAuthService {

    /**
     *
     * 功能描述: 登录凭证校验。
     * 通过 wx.login() 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。
     *
     * @param code 通过 wx.login() 接口获得临时登录凭证 code
     * @return com.ruoyi.entity.Code2SessionResult
     * @auther Cyrus.kong
     * @date 2019-04-01
     */
    Code2SessionResultEntity code2Session(String code);
}
