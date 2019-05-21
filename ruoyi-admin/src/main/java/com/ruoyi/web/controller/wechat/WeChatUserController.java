package com.ruoyi.web.controller.wechat;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.service.IPtpUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weChat/user")
@AllArgsConstructor
public class WeChatUserController extends BaseController {
    private final IPtpUserService userService;

    @PostMapping("/register")
    public AjaxResult saveUserInfo(@RequestBody PtpUser ptpUser) {
        // 用户注册
        userService.insertPtpUser(ptpUser);
        AjaxResult res = AjaxResult.success();
        res.put("data",ptpUser);
        return res;
    }
}
