package com.ruoyi.partTime.service;

import com.ruoyi.partTime.domain.PtpCompanyCollect;
import com.ruoyi.partTime.domain.PtpUser;

import java.util.List;

/**
 * 企业收藏 服务层
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
public interface IPtpCompanyCollectService {
	/**
     * 查询企业收藏信息
     * 
     * @param companyUserId 企业收藏ID
     * @return 企业收藏信息
     */
	PtpCompanyCollect selectPtpCompanyCollectById(Integer companyUserId);
	
	/**
     * 查询企业收藏列表
     * 
     * @param ptpCompanyCollect 企业收藏信息
     * @return 企业收藏集合
     */
	List<PtpCompanyCollect> selectPtpCompanyCollectList(PtpCompanyCollect ptpCompanyCollect);
	
	/**
     * 新增企业收藏
     * 
     * @param ptpCompanyCollect 企业收藏信息
     * @return 结果
     */
	int insertPtpCompanyCollect(PtpCompanyCollect ptpCompanyCollect);
	
	/**
     * 修改企业收藏
     * 
     * @param ptpCompanyCollect 企业收藏信息
     * @return 结果
     */
	int updatePtpCompanyCollect(PtpCompanyCollect ptpCompanyCollect);
		
	/**
     * 删除企业收藏信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deletePtpCompanyCollectByIds(String ids);
	int deleteCompanyCollect(PtpCompanyCollect ptpCompanyCollect);
	List<PtpUser> selectCollectUserList(Integer companyUserId);
}
