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
import com.ruoyi.partTime.domain.PtpWorkExperience;
import com.ruoyi.partTime.service.IPtpWorkExperienceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 工作经历 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Controller
@RequestMapping("/partTime/ptpWorkExperience")
public class PtpWorkExperienceController extends BaseController{
    private String prefix = "partTime/ptpWorkExperience";
	
	@Autowired
	private IPtpWorkExperienceService ptpWorkExperienceService;
	
	@RequiresPermissions("partTime:ptpWorkExperience:view")
	@GetMapping()
	public String ptpWorkExperience(){
	    return prefix + "/ptpWorkExperience";
	}
	
	/**
	 * 查询工作经历列表
	 */
	@RequiresPermissions("partTime:ptpWorkExperience:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PtpWorkExperience ptpWorkExperience){
		startPage();
        List<PtpWorkExperience> list = ptpWorkExperienceService.selectPtpWorkExperienceList(ptpWorkExperience);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工作经历列表
	 */
	@RequiresPermissions("partTime:ptpWorkExperience:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtpWorkExperience ptpWorkExperience){
    	List<PtpWorkExperience> list = ptpWorkExperienceService.selectPtpWorkExperienceList(ptpWorkExperience);
        ExcelUtil<PtpWorkExperience> util = new ExcelUtil<PtpWorkExperience>(PtpWorkExperience.class);
        return util.exportExcel(list, "ptpWorkExperience");
    }
	
	/**
	 * 新增工作经历
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工作经历
	 */
	@RequiresPermissions("partTime:ptpWorkExperience:add")
	@Log(title = "工作经历", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PtpWorkExperience ptpWorkExperience){
		return toAjax(ptpWorkExperienceService.insertPtpWorkExperience(ptpWorkExperience));
	}

	/**
	 * 修改工作经历
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap){
		PtpWorkExperience ptpWorkExperience = ptpWorkExperienceService.selectPtpWorkExperienceById(id);
		mmap.put("ptpWorkExperience", ptpWorkExperience);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工作经历
	 */
	@RequiresPermissions("partTime:ptpWorkExperience:edit")
	@Log(title = "工作经历", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PtpWorkExperience ptpWorkExperience){
		return toAjax(ptpWorkExperienceService.updatePtpWorkExperience(ptpWorkExperience));
	}
	
	/**
	 * 删除工作经历
	 */
	@RequiresPermissions("partTime:ptpWorkExperience:remove")
	@Log(title = "工作经历", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		return toAjax(ptpWorkExperienceService.deletePtpWorkExperienceByIds(ids));
	}
	
}
