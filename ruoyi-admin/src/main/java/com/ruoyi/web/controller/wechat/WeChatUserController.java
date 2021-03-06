package com.ruoyi.web.controller.wechat;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.partTime.domain.PtpCompany;
import com.ruoyi.partTime.domain.PtpCompanyCollect;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.service.IPtpCompanyCollectService;
import com.ruoyi.partTime.service.IPtpCompanyService;
import com.ruoyi.partTime.service.IPtpUserService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("weChat/user")
@AllArgsConstructor
//学生登录控制
public class WeChatUserController extends BaseController {
    private final IPtpCompanyService companyService;
    private final IPtpUserService userService;
    private final IPtpCompanyCollectService companyCollectService;
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
//查看公司是否收藏人才
    @PostMapping("/selectCompanyCollection")
    public AjaxResult selectCompanyCollection(@RequestBody PtpCompanyCollect ptpCompanyCollect) {
        AjaxResult res = AjaxResult.success();
        ptpCompanyCollect.setCompanyUserId(ShiroUtils.getWeChatUser().getUserId());
        List<PtpCompanyCollect> companyCollects = companyCollectService.selectPtpCompanyCollectList(ptpCompanyCollect);
        // 没收藏
        if (companyCollects == null || companyCollects.size() == 0) {
            res.put("isCollection", false);
        } else {
            res.put("isCollection", true);
        }
        return res;
    }
    //收藏人才
    @PostMapping("/insertCollectList")
    public AjaxResult  insertCollectList(@RequestBody PtpCompanyCollect ptpCompanyCollect){
        AjaxResult res = AjaxResult.success();
        ptpCompanyCollect.setCompanyUserId(ShiroUtils.getWeChatUser().getUserId());
        return toAjax(companyCollectService.insertPtpCompanyCollect(ptpCompanyCollect));
    }
    //取消收藏人才
    @PostMapping("deleteCollectList")
    public AjaxResult deleteCollectList(@RequestBody PtpCompanyCollect ptpCompanyCollect){
        ptpCompanyCollect.setCompanyUserId(ShiroUtils.getWeChatUser().getUserId());
        return toAjax(companyCollectService.deleteCompanyCollect(ptpCompanyCollect));
    }
    //查看公司收藏的人才列表
    @GetMapping("list/collectUser")
    public AjaxResult listCollectUser() {
        Integer companyUserId = ShiroUtils.getWeChatUser().getUserId();//这个公司的userd
        List<PtpUser> users = companyCollectService.selectCollectUserList(companyUserId);
        AjaxResult res = AjaxResult.success();
        res.put("data", users);
        return res;
    }
}
