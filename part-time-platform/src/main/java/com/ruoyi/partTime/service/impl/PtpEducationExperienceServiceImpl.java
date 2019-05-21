package com.ruoyi.partTime.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.partTime.mapper.PtpEducationExperienceMapper;
import com.ruoyi.partTime.domain.PtpEducationExperience;
import com.ruoyi.partTime.service.IPtpEducationExperienceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 教育经历 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Service
@AllArgsConstructor
public class PtpEducationExperienceServiceImpl implements IPtpEducationExperienceService {
	private final PtpEducationExperienceMapper ptpEducationExperienceMapper;

	/**
     * 查询教育经历信息
     * 
     * @param id 教育经历ID
     * @return 教育经历信息
     */
    @Override
	public PtpEducationExperience selectPtpEducationExperienceById(Integer id){
	    return ptpEducationExperienceMapper.selectPtpEducationExperienceById(id);
	}
	
	/**
     * 查询教育经历列表
     * 
     * @param ptpEducationExperience 教育经历信息
     * @return 教育经历集合
     */
	@Override
	public List<PtpEducationExperience> selectPtpEducationExperienceList(PtpEducationExperience ptpEducationExperience){
	    return ptpEducationExperienceMapper.selectPtpEducationExperienceList(ptpEducationExperience);
	}
	
    /**
     * 新增教育经历
     * 
     * @param ptpEducationExperience 教育经历信息
     * @return 结果
     */
	@Override
	public int insertPtpEducationExperience(PtpEducationExperience ptpEducationExperience){
	    return ptpEducationExperienceMapper.insertPtpEducationExperience(ptpEducationExperience);
	}
	
	/**
     * 修改教育经历
     * 
     * @param ptpEducationExperience 教育经历信息
     * @return 结果
     */
	@Override
	public int updatePtpEducationExperience(PtpEducationExperience ptpEducationExperience){
	    return ptpEducationExperienceMapper.updatePtpEducationExperience(ptpEducationExperience);
	}

	/**
     * 删除教育经历对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePtpEducationExperienceByIds(String ids){
		return ptpEducationExperienceMapper.deletePtpEducationExperienceByIds(Convert.toStrArray(ids));
	}
	
}
