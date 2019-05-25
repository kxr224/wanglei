package com.ruoyi.web.controller.wechat;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.service.IPtpCompanyService;
import com.ruoyi.partTime.service.IPtpUserService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("weChat/user")
@AllArgsConstructor
//学生登录控制
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
    @PostMapping("/save/userInfo")
    public AjaxResult updateUserInfo(@RequestBody PtpUser ptpUser){
        AjaxResult res = AjaxResult.success();
        userService.updatePtpUser(ptpUser);
        ShiroUtils.setWeChatUser(ptpUser);
        return res;
    }
    @PostMapping("/selectUserByName")
    public AjaxResult selectUserByName(@RequestBody PtpUser ptpUser){
        AjaxResult res = AjaxResult.success();
        List<PtpUser> users=userService.selectUserByName(ptpUser.getNickname());
        res.put("data",users);
        return res;
    }

}
