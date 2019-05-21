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
import com.ruoyi.partTime.domain.PtpCompanyCollect;
import com.ruoyi.partTime.service.IPtpCompanyCollectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 企业收藏 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Controller
@RequestMapping("/partTime/ptpCompanyCollect")
public class PtpCompanyCollectController extends BaseController{
    private String prefix = "partTime/ptpCompanyCollect";
	
	@Autowired
	private IPtpCompanyCollectService ptpCompanyCollectService;
	
	@RequiresPermissions("partTime:ptpCompanyCollect:view")
	@GetMapping()
	public String ptpCompanyCollect(){
	    return prefix + "/ptpCompanyCollect";
	}
	
	/**
	 * 查询企业收藏列表
	 */
	@RequiresPermissions("partTime:ptpCompanyCollect:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PtpCompanyCollect ptpCompanyCollect){
		startPage();
        List<PtpCompanyCollect> list = ptpCompanyCollectService.selectPtpCompanyCollectList(ptpCompanyCollect);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业收藏列表
	 */
	@RequiresPermissions("partTime:ptpCompanyCollect:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtpCompanyCollect ptpCompanyCollect){
    	List<PtpCompanyCollect> list = ptpCompanyCollectService.selectPtpCompanyCollectList(ptpCompanyCollect);
        ExcelUtil<PtpCompanyCollect> util = new ExcelUtil<PtpCompanyCollect>(PtpCompanyCollect.class);
        return util.exportExcel(list, "ptpCompanyCollect");
    }
	
	/**
	 * 新增企业收藏
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业收藏
	 */
	@RequiresPermissions("partTime:ptpCompanyCollect:add")
	@Log(title = "企业收藏", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PtpCompanyCollect ptpCompanyCollect){
		return toAjax(ptpCompanyCollectService.insertPtpCompanyCollect(ptpCompanyCollect));
	}

	/**
	 * 修改企业收藏
	 */
	@GetMapping("/edit/{companyUserId}")
	public String edit(@PathVariable("companyUserId") Integer companyUserId, ModelMap mmap){
		PtpCompanyCollect ptpCompanyCollect = ptpCompanyCollectService.selectPtpCompanyCollectById(companyUserId);
		mmap.put("ptpCompanyCollect", ptpCompanyCollect);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业收藏
	 */
	@RequiresPermissions("partTime:ptpCompanyCollect:edit")
	@Log(title = "企业收藏", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PtpCompanyCollect ptpCompanyCollect){
		return toAjax(ptpCompanyCollectService.updatePtpCompanyCollect(ptpCompanyCollect));
	}
	
	/**
	 * 删除企业收藏
	 */
	@RequiresPermissions("partTime:ptpCompanyCollect:remove")
	@Log(title = "企业收藏", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		return toAjax(ptpCompanyCollectService.deletePtpCompanyCollectByIds(ids));
	}
	
}
