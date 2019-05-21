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
import com.ruoyi.partTime.domain.PtpCompany;
import com.ruoyi.partTime.service.IPtpCompanyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 企业 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Controller
@RequestMapping("/partTime/ptpCompany")
public class PtpCompanyController extends BaseController{
    private String prefix = "partTime/ptpCompany";
	
	@Autowired
	private IPtpCompanyService ptpCompanyService;
	
	@RequiresPermissions("partTime:ptpCompany:view")
	@GetMapping()
	public String ptpCompany(){
	    return prefix + "/ptpCompany";
	}
	
	/**
	 * 查询企业列表
	 */
	@RequiresPermissions("partTime:ptpCompany:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PtpCompany ptpCompany){
		startPage();
        List<PtpCompany> list = ptpCompanyService.selectPtpCompanyList(ptpCompany);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业列表
	 */
	@RequiresPermissions("partTime:ptpCompany:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtpCompany ptpCompany){
    	List<PtpCompany> list = ptpCompanyService.selectPtpCompanyList(ptpCompany);
        ExcelUtil<PtpCompany> util = new ExcelUtil<PtpCompany>(PtpCompany.class);
        return util.exportExcel(list, "ptpCompany");
    }
	
	/**
	 * 新增企业
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业
	 */
	@RequiresPermissions("partTime:ptpCompany:add")
	@Log(title = "企业", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PtpCompany ptpCompany){
		return toAjax(ptpCompanyService.insertPtpCompany(ptpCompany));
	}

	/**
	 * 修改企业
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap){
		PtpCompany ptpCompany = ptpCompanyService.selectPtpCompanyById(id);
		mmap.put("ptpCompany", ptpCompany);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业
	 */
	@RequiresPermissions("partTime:ptpCompany:edit")
	@Log(title = "企业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PtpCompany ptpCompany){
		return toAjax(ptpCompanyService.updatePtpCompany(ptpCompany));
	}
	
	/**
	 * 删除企业
	 */
	@RequiresPermissions("partTime:ptpCompany:remove")
	@Log(title = "企业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		return toAjax(ptpCompanyService.deletePtpCompanyByIds(ids));
	}
	
}
