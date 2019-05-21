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
import com.ruoyi.partTime.domain.PtpEducationExperience;
import com.ruoyi.partTime.service.IPtpEducationExperienceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 教育经历 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Controller
@RequestMapping("/partTime/ptpEducationExperience")
public class PtpEducationExperienceController extends BaseController{
    private String prefix = "partTime/ptpEducationExperience";
	
	@Autowired
	private IPtpEducationExperienceService ptpEducationExperienceService;
	
	@RequiresPermissions("partTime:ptpEducationExperience:view")
	@GetMapping()
	public String ptpEducationExperience(){
	    return prefix + "/ptpEducationExperience";
	}
	
	/**
	 * 查询教育经历列表
	 */
	@RequiresPermissions("partTime:ptpEducationExperience:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PtpEducationExperience ptpEducationExperience){
		startPage();
        List<PtpEducationExperience> list = ptpEducationExperienceService.selectPtpEducationExperienceList(ptpEducationExperience);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教育经历列表
	 */
	@RequiresPermissions("partTime:ptpEducationExperience:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtpEducationExperience ptpEducationExperience){
    	List<PtpEducationExperience> list = ptpEducationExperienceService.selectPtpEducationExperienceList(ptpEducationExperience);
        ExcelUtil<PtpEducationExperience> util = new ExcelUtil<PtpEducationExperience>(PtpEducationExperience.class);
        return util.exportExcel(list, "ptpEducationExperience");
    }
	
	/**
	 * 新增教育经历
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教育经历
	 */
	@RequiresPermissions("partTime:ptpEducationExperience:add")
	@Log(title = "教育经历", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PtpEducationExperience ptpEducationExperience){
		return toAjax(ptpEducationExperienceService.insertPtpEducationExperience(ptpEducationExperience));
	}

	/**
	 * 修改教育经历
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap){
		PtpEducationExperience ptpEducationExperience = ptpEducationExperienceService.selectPtpEducationExperienceById(id);
		mmap.put("ptpEducationExperience", ptpEducationExperience);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教育经历
	 */
	@RequiresPermissions("partTime:ptpEducationExperience:edit")
	@Log(title = "教育经历", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PtpEducationExperience ptpEducationExperience){
		return toAjax(ptpEducationExperienceService.updatePtpEducationExperience(ptpEducationExperience));
	}
	
	/**
	 * 删除教育经历
	 */
	@RequiresPermissions("partTime:ptpEducationExperience:remove")
	@Log(title = "教育经历", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		return toAjax(ptpEducationExperienceService.deletePtpEducationExperienceByIds(ids));
	}
	
}
