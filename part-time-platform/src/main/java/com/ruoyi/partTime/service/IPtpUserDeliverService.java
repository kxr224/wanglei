package com.ruoyi.partTime.service;

import com.ruoyi.partTime.domain.PtpUserDeliver;
import java.util.List;

/**
 * 用户投递 服务层
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
public interface IPtpUserDeliverService {
	/**
     * 查询用户投递信息
     * 
     * @param companyUserId 用户投递ID
     * @return 用户投递信息
     */
	PtpUserDeliver selectPtpUserDeliverById(Integer companyUserId);
	
	/**
     * 查询用户投递列表
     * 
     * @param ptpUserDeliver 用户投递信息
     * @return 用户投递集合
     */
	List<PtpUserDeliver> selectPtpUserDeliverList(PtpUserDeliver ptpUserDeliver);
	
	/**
     * 新增用户投递
     * 
     * @param ptpUserDeliver 用户投递信息
     * @return 结果
     */
	int insertPtpUserDeliver(PtpUserDeliver ptpUserDeliver);
	
	/**
     * 修改用户投递
     * 
     * @param ptpUserDeliver 用户投递信息
     * @return 结果
     */
	int updatePtpUserDeliver(PtpUserDeliver ptpUserDeliver);
		
	/**
     * 删除用户投递信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deletePtpUserDeliverByIds(String ids);
	int deletePtpUserDeliver(PtpUserDeliver ptpUserDeliver);
}
