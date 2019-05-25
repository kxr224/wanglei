package com.ruoyi.web.controller.wechat;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.partTime.domain.PtpCompany;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.domain.PtpUserCollect;
import com.ruoyi.partTime.domain.PtpUserDeliver;
import com.ruoyi.partTime.service.IPtpCompanyService;
import com.ruoyi.partTime.service.IPtpUserCollectService;
import com.ruoyi.partTime.service.IPtpUserDeliverService;
import com.ruoyi.partTime.service.IPtpUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("weChat/com")
@AllArgsConstructor
//企业登录控制
public class WeChatComController extends BaseController {
    private final IPtpCompanyService companyService;
    private final IPtpUserService userService;
    private final IPtpUserCollectService userCollectService;
    private final IPtpUserDeliverService userDeliverService;

    //将修改的个人信息保存
    @PostMapping("/save/comInfo")
    public AjaxResult updateComInfo(@RequestBody PtpCompany ptpCompany) {
        AjaxResult res = AjaxResult.success();
        PtpUser user = ShiroUtils.getWeChatUser();
        ptpCompany.setUserId(user.getUserId());
        ptpCompany = companyService.saveCompany(ptpCompany);
        res.put("data", ptpCompany);
        return res;
    }

    @GetMapping("/detail/{userId}")
    @Log(title = "查询企业信息")
    public AjaxResult selectCompanyByUserId(@PathVariable Integer userId) {
        AjaxResult res = AjaxResult.success();
        PtpCompany ptpCompany = companyService.selectCompanyByUserId(userId);
        res.put("data", ptpCompany);
        return res;
    }
    //公司列表
    @PostMapping("/companyList")
    public AjaxResult selectCompanyList(@RequestBody PtpCompany ptpCompany) {
        AjaxResult res = AjaxResult.success();
        List<PtpCompany> companyList = companyService.selectPtpCompanyList(ptpCompany);
        res.put("data", companyList);
        return res;
    }
    //人才的列表
    @PostMapping("/userList")
    public AjaxResult selectUserList(@RequestBody PtpUser ptpUser) {
        AjaxResult res = AjaxResult.success();
        List<PtpUser> userList = userService.selectPtpUserList(ptpUser);
        res.put("data", userList);
        return res;
    }
    //查看收藏列表
    @PostMapping("/selectCollection")
    public AjaxResult selectCollection(@RequestBody PtpUserCollect ptpUserCollect) {
        AjaxResult res = AjaxResult.success();
        ptpUserCollect.setUserId(ShiroUtils.getWeChatUser().getUserId());
        List<PtpUserCollect> userCollects = userCollectService.selectPtpUserCollectList(ptpUserCollect);
        // 没收藏
        if (userCollects == null || userCollects.size() == 0) {
            res.put("isCollection", false);
        } else {
            res.put("isCollection", true);
        }
        return res;
    }
    //收藏公司
    @PostMapping("/insertCollectList")
    public AjaxResult insertCollectList(@RequestBody PtpUserCollect ptpUserCollect) {
        ptpUserCollect.setUserId(ShiroUtils.getWeChatUser().getUserId());
        return toAjax(userCollectService.insertPtpUserCollect(ptpUserCollect));
    }
    //取消收藏
    @PostMapping("/deleteCollectList")
    public AjaxResult deleteCollectList(@RequestBody PtpUserCollect ptpUserCollect) {
        if (ptpUserCollect.getCompanyUserId() == null) {
            return AjaxResult.error("请传入companyUserId");
        }
        ptpUserCollect.setUserId(ShiroUtils.getWeChatUser().getUserId());
        return toAjax(userCollectService.deleteUserCollect(ptpUserCollect));
    }
    //投递简历
    @PostMapping("/insertDeliverList")
    public AjaxResult insertDeliverList(@RequestBody PtpUserDeliver ptpUserDeliver){
        ptpUserDeliver.setUserId(ShiroUtils.getWeChatUser().getUserId());
        return toAjax(userDeliverService.insertPtpUserDeliver(ptpUserDeliver));
    }
    //取消投递
    @PostMapping("deleteDelivertList")
    public AjaxResult  deleteDelivertList(@RequestBody PtpUserDeliver ptpUserDeliver){
        ptpUserDeliver.setUserId(ShiroUtils.getWeChatUser().getUserId());
        return toAjax(userDeliverService.deletePtpUserDeliver(ptpUserDeliver));
    }
    //搜索框根据名字搜索公司
    @PostMapping("/selectCompanyByName")
    public AjaxResult selectCompanyByName(@RequestBody PtpCompany ptpCompany) {
        AjaxResult res = AjaxResult.success();
        List<PtpCompany> company=companyService.selectCompanyByName(ptpCompany.getName());
        res.put("data",company);
        return res;
    }
    //点击收藏列表 查看已经收藏的公司列表
    @GetMapping("/list/collectCompany")
    public AjaxResult listCollectCompany() {
        Integer userId = ShiroUtils.getWeChatUser().getUserId();
        List<PtpCompany> companies = companyService.selectCollectCompanyList(userId);
        AjaxResult res = AjaxResult.success();
        res.put("data", companies);
        return res;
    }
    //点击投递列表 查看已经投递的公司列表
    @GetMapping("/list/deliverCompany")
    public AjaxResult listCompany() {
        Integer userId = ShiroUtils.getWeChatUser().getUserId();
        List<PtpCompany> companies = companyService.selectDeliverCompanyList(userId);
        AjaxResult res = AjaxResult.success();
        res.put("data", companies);
        return res;
    }
    //查看是否投递
    @PostMapping("/selectDeliver")
    public AjaxResult selectDeliver(@RequestBody PtpUserDeliver ptpUserDeliver) {
        AjaxResult res = AjaxResult.success();
        ptpUserDeliver.setUserId(ShiroUtils.getWeChatUser().getUserId());
        List<PtpUserDeliver> userDelivers = userDeliverService.selectPtpUserDeliverList(ptpUserDeliver);
        // 没收藏
        if (userDelivers == null || userDelivers.size() == 0) {
            res.put("isDeliver", false);
        } else {
            res.put("isDeliver", true);
        }
        return res;
    }


}
