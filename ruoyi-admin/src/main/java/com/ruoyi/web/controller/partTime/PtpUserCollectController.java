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
import com.ruoyi.partTime.domain.PtpUserCollect;
import com.ruoyi.partTime.service.IPtpUserCollectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 用户收藏 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Controller
@RequestMapping("/partTime/ptpUserCollect")
public class PtpUserCollectController extends BaseController{
    private String prefix = "partTime/ptpUserCollect";
	
	@Autowired
	private IPtpUserCollectService ptpUserCollectService;
	
	@RequiresPermissions("partTime:ptpUserCollect:view")
	@GetMapping()
	public String ptpUserCollect(){
	    return prefix + "/ptpUserCollect";
	}
	
	/**
	 * 查询用户收藏列表
	 */
	@RequiresPermissions("partTime:ptpUserCollect:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PtpUserCollect ptpUserCollect){
		startPage();
        List<PtpUserCollect> list = ptpUserCollectService.selectPtpUserCollectList(ptpUserCollect);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户收藏列表
	 */
	@RequiresPermissions("partTime:ptpUserCollect:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtpUserCollect ptpUserCollect){
    	List<PtpUserCollect> list = ptpUserCollectService.selectPtpUserCollectList(ptpUserCollect);
        ExcelUtil<PtpUserCollect> util = new ExcelUtil<PtpUserCollect>(PtpUserCollect.class);
        return util.exportExcel(list, "ptpUserCollect");
    }
	
	/**
	 * 新增用户收藏
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户收藏
	 */
	@RequiresPermissions("partTime:ptpUserCollect:add")
	@Log(title = "用户收藏", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PtpUserCollect ptpUserCollect){
		return toAjax(ptpUserCollectService.insertPtpUserCollect(ptpUserCollect));
	}

	/**
	 * 修改用户收藏
	 */
	@GetMapping("/edit/{companyUserId}")
	public String edit(@PathVariable("companyUserId") Integer companyUserId, ModelMap mmap){
		PtpUserCollect ptpUserCollect = ptpUserCollectService.selectPtpUserCollectById(companyUserId);
		mmap.put("ptpUserCollect", ptpUserCollect);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户收藏
	 */
	@RequiresPermissions("partTime:ptpUserCollect:edit")
	@Log(title = "用户收藏", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PtpUserCollect ptpUserCollect){
		return toAjax(ptpUserCollectService.updatePtpUserCollect(ptpUserCollect));
	}
	
	/**
	 * 删除用户收藏
	 */
	@RequiresPermissions("partTime:ptpUserCollect:remove")
	@Log(title = "用户收藏", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		return toAjax(ptpUserCollectService.deletePtpUserCollectByIds(ids));
	}
	
}
