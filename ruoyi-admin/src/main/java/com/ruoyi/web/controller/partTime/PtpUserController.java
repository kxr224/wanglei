package com.ruoyi.web.controller.partTime;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.service.IPtpUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 课程用户 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Controller
@RequestMapping("/partTime/ptpUser")
public class PtpUserController extends BaseController{
    private String prefix = "partTime/ptpUser";
	
	@Autowired
	private IPtpUserService ptpUserService;
	
	@RequiresPermissions("partTime:ptpUser:view")
	@GetMapping()
	public String ptpUser(){
	    return prefix + "/ptpUser";
	}
	
	/**
	 * 查询课程用户列表
	 */
	@RequiresPermissions("partTime:ptpUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PtpUser ptpUser){
		startPage();
        List<PtpUser> list = ptpUserService.selectPtpUserList(ptpUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出课程用户列表
	 */
	@RequiresPermissions("partTime:ptpUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtpUser ptpUser){
    	List<PtpUser> list = ptpUserService.selectPtpUserList(ptpUser);
        ExcelUtil<PtpUser> util = new ExcelUtil<PtpUser>(PtpUser.class);
        return util.exportExcel(list, "ptpUser");
    }
	
	/**
	 * 新增课程用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存课程用户
	 */
	@RequiresPermissions("partTime:ptpUser:add")
	@Log(title = "课程用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PtpUser ptpUser){
		return toAjax(ptpUserService.insertPtpUser(ptpUser));
	}

	/**
	 * 修改课程用户
	 */
	@GetMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") Integer userId, ModelMap mmap){
		PtpUser ptpUser = ptpUserService.selectPtpUserById(userId);
		mmap.put("ptpUser", ptpUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存课程用户
	 */
	@RequiresPermissions("partTime:ptpUser:edit")
	@Log(title = "课程用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PtpUser ptpUser){
		return toAjax(ptpUserService.updatePtpUser(ptpUser));
	}
	
	/**
	 * 删除课程用户
	 */
	@RequiresPermissions("partTime:ptpUser:remove")
	@Log(title = "课程用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		return toAjax(ptpUserService.deletePtpUserByIds(ids));
	}
	
}
