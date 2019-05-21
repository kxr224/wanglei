package com.ruoyi.partTime.service;

import com.ruoyi.partTime.domain.PtpEducationExperience;
import java.util.List;

/**
 * 教育经历 服务层
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
public interface IPtpEducationExperienceService {
	/**
     * 查询教育经历信息
     * 
     * @param id 教育经历ID
     * @return 教育经历信息
     */
	PtpEducationExperience selectPtpEducationExperienceById(Integer id);
	
	/**
     * 查询教育经历列表
     * 
     * @param ptpEducationExperience 教育经历信息
     * @return 教育经历集合
     */
	List<PtpEducationExperience> selectPtpEducationExperienceList(PtpEducationExperience ptpEducationExperience);
	
	/**
     * 新增教育经历
     * 
     * @param ptpEducationExperience 教育经历信息
     * @return 结果
     */
	int insertPtpEducationExperience(PtpEducationExperience ptpEducationExperience);
	
	/**
     * 修改教育经历
     * 
     * @param ptpEducationExperience 教育经历信息
     * @return 结果
     */
	int updatePtpEducationExperience(PtpEducationExperience ptpEducationExperience);
		
	/**
     * 删除教育经历信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deletePtpEducationExperienceByIds(String ids);
	
}
