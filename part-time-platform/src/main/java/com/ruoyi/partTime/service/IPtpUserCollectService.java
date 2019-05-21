package com.ruoyi.partTime.service;

import com.ruoyi.partTime.domain.PtpUserCollect;
import java.util.List;

/**
 * 用户收藏 服务层
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
public interface IPtpUserCollectService {
	/**
     * 查询用户收藏信息
     * 
     * @param companyUserId 用户收藏ID
     * @return 用户收藏信息
     */
	PtpUserCollect selectPtpUserCollectById(Integer companyUserId);
	
	/**
     * 查询用户收藏列表
     * 
     * @param ptpUserCollect 用户收藏信息
     * @return 用户收藏集合
     */
	List<PtpUserCollect> selectPtpUserCollectList(PtpUserCollect ptpUserCollect);
	
	/**
     * 新增用户收藏
     * 
     * @param ptpUserCollect 用户收藏信息
     * @return 结果
     */
	int insertPtpUserCollect(PtpUserCollect ptpUserCollect);
	
	/**
     * 修改用户收藏
     * 
     * @param ptpUserCollect 用户收藏信息
     * @return 结果
     */
	int updatePtpUserCollect(PtpUserCollect ptpUserCollect);
		
	/**
     * 删除用户收藏信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deletePtpUserCollectByIds(String ids);
	
}
