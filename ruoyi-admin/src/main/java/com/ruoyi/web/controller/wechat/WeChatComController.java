package com.ruoyi.web.controller.wechat;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.partTime.domain.PtpCompany;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.domain.PtpUserCollect;
import com.ruoyi.partTime.service.IPtpCompanyService;
import com.ruoyi.partTime.service.IPtpUserCollectService;
import com.ruoyi.partTime.service.IPtpUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("weChat/com")
@AllArgsConstructor
public class WeChatComController extends BaseController {
    private final IPtpCompanyService companyService;
    private final IPtpUserService userService;
    private final IPtpUserCollectService userCollectService;



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

    @PostMapping("/companyList")
    public AjaxResult selectCompanyList(@RequestBody PtpCompany ptpCompany) {
        AjaxResult res = AjaxResult.success();
        List<PtpCompany> companyList = companyService.selectPtpCompanyList(ptpCompany);
        res.put("data", companyList);
        return res;
    }
    @PostMapping("/userList")
    public AjaxResult selectUserList(@RequestBody  PtpUser ptpUser) {
        AjaxResult res = AjaxResult.success();
        List<PtpUser> userList = userService.selectPtpUserList(ptpUser);
        res.put("data", userList);
        return res;
    }
    @PostMapping("/selectCollection")
    public AjaxResult selectCollection(@RequestBody PtpUserCollect ptpUserCollect) {
        AjaxResult res = AjaxResult.success();
        ptpUserCollect.setUserId(ShiroUtils.getWeChatUser().getUserId());
        List<PtpUserCollect> userCollects = userCollectService.selectPtpUserCollectList(ptpUserCollect);
        res.put("data",userCollects);
        return res;
    }
    @PostMapping("/insertCollectList")
    public AjaxResult insertCollectList(@RequestBody PtpUserCollect ptpUserCollect) {
        AjaxResult res = AjaxResult.success();
        ptpUserCollect.setUserId(ShiroUtils.getWeChatUser().getUserId());
        userCollectService.insertPtpUserCollect(ptpUserCollect);
        res.setCode(0);
        return res;
    }
    @PostMapping("/deleteCollectList")
    public AjaxResult deleteCollectList(@RequestBody PtpUserCollect ptpUserCollect) {
        AjaxResult res = AjaxResult.success();
        int del=userCollectService.deletePtpUserCollectByIds(ptpUserCollect.getCompanyUserId().toString());
        if(del!=0){
            res.setCode(0);
        }
        else{
            res.setCode(1);
        }
        return res;
    }
    @PostMapping("/selectUserByUserName")
    public AjaxResult selectUserByUserName(@RequestBody PtpUser ptpUser) {
        AjaxResult res=AjaxResult.success();
        return res;
    }
    @PostMapping("/selectCompanyByName")
    public AjaxResult selectCompanyByName(@RequestBody PtpCompany ptpCompany){
        AjaxResult res=AjaxResult.success();
        return res;
    }





}
