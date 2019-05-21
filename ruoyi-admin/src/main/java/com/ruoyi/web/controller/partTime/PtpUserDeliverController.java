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
import com.ruoyi.partTime.domain.PtpUserDeliver;
import com.ruoyi.partTime.service.IPtpUserDeliverService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户投递 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Controller
@RequestMapping("/partTime/ptpUserDeliver")
public class PtpUserDeliverController extends BaseController{
    private String prefix = "partTime/ptpUserDeliver";
	
	@Autowired
	private IPtpUserDeliverService ptpUserDeliverService;
	
	@RequiresPermissions("partTime:ptpUserDeliver:view")
	@GetMapping()
	public String ptpUserDeliver(){
	    return prefix + "/ptpUserDeliver";
	}
	
	/**
	 * 查询用户投递列表
	 */
	@RequiresPermissions("partTime:ptpUserDeliver:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PtpUserDeliver ptpUserDeliver){
		startPage();
        List<PtpUserDeliver> list = ptpUserDeliverService.selectPtpUserDeliverList(ptpUserDeliver);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户投递列表
	 */
	@RequiresPermissions("partTime:ptpUserDeliver:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtpUserDeliver ptpUserDeliver){
    	List<PtpUserDeliver> list = ptpUserDeliverService.selectPtpUserDeliverList(ptpUserDeliver);
        ExcelUtil<PtpUserDeliver> util = new ExcelUtil<PtpUserDeliver>(PtpUserDeliver.class);
        return util.exportExcel(list, "ptpUserDeliver");
    }
	
	/**
	 * 新增用户投递
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户投递
	 */
	@RequiresPermissions("partTime:ptpUserDeliver:add")
	@Log(title = "用户投递", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PtpUserDeliver ptpUserDeliver){
		return toAjax(ptpUserDeliverService.insertPtpUserDeliver(ptpUserDeliver));
	}

	/**
	 * 修改用户投递
	 */
	@GetMapping("/edit/{companyUserId}")
	public String edit(@PathVariable("companyUserId") Integer companyUserId, ModelMap mmap){
		PtpUserDeliver ptpUserDeliver = ptpUserDeliverService.selectPtpUserDeliverById(companyUserId);
		mmap.put("ptpUserDeliver", ptpUserDeliver);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户投递
	 */
	@RequiresPermissions("partTime:ptpUserDeliver:edit")
	@Log(title = "用户投递", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PtpUserDeliver ptpUserDeliver){
		return toAjax(ptpUserDeliverService.updatePtpUserDeliver(ptpUserDeliver));
	}
	
	/**
	 * 删除用户投递
	 */
	@RequiresPermissions("partTime:ptpUserDeliver:remove")
	@Log(title = "用户投递", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		return toAjax(ptpUserDeliverService.deletePtpUserDeliverByIds(ids));
	}
	
}
