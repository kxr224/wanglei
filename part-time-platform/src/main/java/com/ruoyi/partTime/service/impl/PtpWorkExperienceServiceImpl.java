package com.ruoyi.partTime.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.partTime.mapper.PtpWorkExperienceMapper;
import com.ruoyi.partTime.domain.PtpWorkExperience;
import com.ruoyi.partTime.service.IPtpWorkExperienceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 工作经历 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Service
@AllArgsConstructor
public class PtpWorkExperienceServiceImpl implements IPtpWorkExperienceService {
	private final PtpWorkExperienceMapper ptpWorkExperienceMapper;

	/**
     * 查询工作经历信息
     * 
     * @param id 工作经历ID
     * @return 工作经历信息
     */
    @Override
	public PtpWorkExperience selectPtpWorkExperienceById(Integer id){
	    return ptpWorkExperienceMapper.selectPtpWorkExperienceById(id);
	}
	
	/**
     * 查询工作经历列表
     * 
     * @param ptpWorkExperience 工作经历信息
     * @return 工作经历集合
     */
	@Override
	public List<PtpWorkExperience> selectPtpWorkExperienceList(PtpWorkExperience ptpWorkExperience){
	    return ptpWorkExperienceMapper.selectPtpWorkExperienceList(ptpWorkExperience);
	}
	
    /**
     * 新增工作经历
     * 
     * @param ptpWorkExperience 工作经历信息
     * @return 结果
     */
	@Override
	public int insertPtpWorkExperience(PtpWorkExperience ptpWorkExperience){
	    return ptpWorkExperienceMapper.insertPtpWorkExperience(ptpWorkExperience);
	}
	
	/**
     * 修改工作经历
     * 
     * @param ptpWorkExperience 工作经历信息
     * @return 结果
     */
	@Override
	public int updatePtpWorkExperience(PtpWorkExperience ptpWorkExperience){
	    return ptpWorkExperienceMapper.updatePtpWorkExperience(ptpWorkExperience);
	}

	/**
     * 删除工作经历对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePtpWorkExperienceByIds(String ids){
		return ptpWorkExperienceMapper.deletePtpWorkExperienceByIds(Convert.toStrArray(ids));
	}
	
}
