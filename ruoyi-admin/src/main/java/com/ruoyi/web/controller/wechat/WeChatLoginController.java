package com.ruoyi.web.controller.wechat;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.constants.WechatErrCodeConstant;
import com.ruoyi.entity.Code2SessionResultEntity;
import com.ruoyi.partTime.service.IPtpUserService;
import com.ruoyi.service.WeChatAuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ruoyi
 * @description: 微信登陆的控制器
 * @author: Mr.Kong
 * @create: 2019-04-01 16:37
 **/
@RestController()
@RequestMapping("/weChat/applet/login")
@AllArgsConstructor
public class WeChatLoginController extends BaseController {

    private final WeChatAuthService weChatAuthService;
    private final IPtpUserService userService;


    @Log(title = "code2session", businessType = BusinessType.OTHER)
    @GetMapping("/code2session/{code}")
    public AjaxResult code2session(@PathVariable String code) {
        Code2SessionResultEntity code2SessionResultEntity = weChatAuthService.code2Session(code);
        // 判断是否请求成功
        AjaxResult ajaxResult;
        if (WechatErrCodeConstant.CODE2SESSION_SYSTEMBUSY.equals(code2SessionResultEntity.getErrcode())) {
            throw new BusinessException("微信服务繁忙，请稍后重试");
        } else if (WechatErrCodeConstant.CODE2SESSION_INVALID.equals(code2SessionResultEntity.getErrcode())) {
            throw new BusinessException("code无效");
        } else if (WechatErrCodeConstant.CODE2SESSION_LIMITEDNUM.equals(code2SessionResultEntity.getErrcode())) {
            throw new BusinessException("接口今日调用已达上限");
        } else {
            ajaxResult = success();
        }
        ajaxResult.put("data", code2SessionResultEntity);
        return ajaxResult;
    }

//    @Log(title = "wechat login", businessType = BusinessType.OTHER)
//    @GetMapping("/byOpenId/{openId}")
//    public AjaxResult loginByOpenId(@PathVariable String openId, HttpSession session) {
//        WeChatUserToken weChatUserToken = new WeChatUserToken(openId);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(weChatUserToken);
//            AjaxResult res = success();
//            res.put("data", ShiroUtils.getWeChatUser());
//            res.put("sessionId", session.getId());
//            return res;
//        } catch (AuthenticationException e) {
//            String msg = "用户不存在";
//            if (StringUtils.isNotEmpty(e.getMessage())) {
//                msg = e.getMessage();
//            }
//            return error(msg);
//        }
//    }

}
