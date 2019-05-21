package com.ruoyi.partTime.service;

import com.ruoyi.partTime.domain.PtpWorkExperience;
import java.util.List;

/**
 * 工作经历 服务层
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
public interface IPtpWorkExperienceService {
	/**
     * 查询工作经历信息
     * 
     * @param id 工作经历ID
     * @return 工作经历信息
     */
	PtpWorkExperience selectPtpWorkExperienceById(Integer id);
	
	/**
     * 查询工作经历列表
     * 
     * @param ptpWorkExperience 工作经历信息
     * @return 工作经历集合
     */
	List<PtpWorkExperience> selectPtpWorkExperienceList(PtpWorkExperience ptpWorkExperience);
	
	/**
     * 新增工作经历
     * 
     * @param ptpWorkExperience 工作经历信息
     * @return 结果
     */
	int insertPtpWorkExperience(PtpWorkExperience ptpWorkExperience);
	
	/**
     * 修改工作经历
     * 
     * @param ptpWorkExperience 工作经历信息
     * @return 结果
     */
	int updatePtpWorkExperience(PtpWorkExperience ptpWorkExperience);
		
	/**
     * 删除工作经历信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deletePtpWorkExperienceByIds(String ids);
	
}
