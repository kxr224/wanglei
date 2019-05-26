package com.ruoyi.partTime.service.impl;

import java.util.List;

import com.ruoyi.partTime.domain.PtpUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.partTime.mapper.PtpCompanyCollectMapper;
import com.ruoyi.partTime.domain.PtpCompanyCollect;
import com.ruoyi.partTime.service.IPtpCompanyCollectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 企业收藏 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Service
@AllArgsConstructor
public class PtpCompanyCollectServiceImpl implements IPtpCompanyCollectService {
	private final PtpCompanyCollectMapper ptpCompanyCollectMapper;

	/**
     * 查询企业收藏信息
     * 
     * @param companyUserId 企业收藏ID
     * @return 企业收藏信息
     */
    @Override
	public PtpCompanyCollect selectPtpCompanyCollectById(Integer companyUserId){
	    return ptpCompanyCollectMapper.selectPtpCompanyCollectById(companyUserId);
	}
	
	/**
     * 查询企业收藏列表
     * 
     * @param ptpCompanyCollect 企业收藏信息
     * @return 企业收藏集合
     */
	@Override
	public List<PtpCompanyCollect> selectPtpCompanyCollectList(PtpCompanyCollect ptpCompanyCollect){
	    return ptpCompanyCollectMapper.selectPtpCompanyCollectList(ptpCompanyCollect);
	}
	
    /**
     * 新增企业收藏
     * 
     * @param ptpCompanyCollect 企业收藏信息
     * @return 结果
     */
	@Override
	public int insertPtpCompanyCollect(PtpCompanyCollect ptpCompanyCollect){
	    return ptpCompanyCollectMapper.insertPtpCompanyCollect(ptpCompanyCollect);
	}
	
	/**
     * 修改企业收藏
     * 
     * @param ptpCompanyCollect 企业收藏信息
     * @return 结果
     */
	@Override
	public int updatePtpCompanyCollect(PtpCompanyCollect ptpCompanyCollect){
	    return ptpCompanyCollectMapper.updatePtpCompanyCollect(ptpCompanyCollect);
	}

	/**
     * 删除企业收藏对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePtpCompanyCollectByIds(String ids){
		return ptpCompanyCollectMapper.deletePtpCompanyCollectByIds(Convert.toStrArray(ids));
	}
	@Override
	public int deleteCompanyCollect(PtpCompanyCollect ptpCompanyCollect){
		return ptpCompanyCollectMapper.deleteCompanyCollect(ptpCompanyCollect);
	}
	@Override
	public List<PtpUser> selectCollectUserList(Integer companyUserId){
		return ptpCompanyCollectMapper.selectCollectUserList(companyUserId) ;
	}
}
