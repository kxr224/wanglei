package com.ruoyi.partTime.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.partTime.mapper.PtpUserDeliverMapper;
import com.ruoyi.partTime.domain.PtpUserDeliver;
import com.ruoyi.partTime.service.IPtpUserDeliverService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户投递 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Service
@AllArgsConstructor
public class PtpUserDeliverServiceImpl implements IPtpUserDeliverService {
	private final PtpUserDeliverMapper ptpUserDeliverMapper;

	/**
     * 查询用户投递信息
     * 
     * @param companyUserId 用户投递ID
     * @return 用户投递信息
     */
    @Override
	public PtpUserDeliver selectPtpUserDeliverById(Integer companyUserId){
	    return ptpUserDeliverMapper.selectPtpUserDeliverById(companyUserId);
	}
	
	/**
     * 查询用户投递列表
     * 
     * @param ptpUserDeliver 用户投递信息
     * @return 用户投递集合
     */
	@Override
	public List<PtpUserDeliver> selectPtpUserDeliverList(PtpUserDeliver ptpUserDeliver){
	    return ptpUserDeliverMapper.selectPtpUserDeliverList(ptpUserDeliver);
	}
	
    /**
     * 新增用户投递
     * 
     * @param ptpUserDeliver 用户投递信息
     * @return 结果
     */
	@Override
	public int insertPtpUserDeliver(PtpUserDeliver ptpUserDeliver){
	    return ptpUserDeliverMapper.insertPtpUserDeliver(ptpUserDeliver);
	}
	
	/**
     * 修改用户投递
     * 
     * @param ptpUserDeliver 用户投递信息
     * @return 结果
     */
	@Override
	public int updatePtpUserDeliver(PtpUserDeliver ptpUserDeliver){
	    return ptpUserDeliverMapper.updatePtpUserDeliver(ptpUserDeliver);
	}

	/**
     * 删除用户投递对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePtpUserDeliverByIds(String ids){
		return ptpUserDeliverMapper.deletePtpUserDeliverByIds(Convert.toStrArray(ids));
	}
	@Override
	public int deletePtpUserDeliver(PtpUserDeliver ptpUserDeliver){
		return ptpUserDeliverMapper.deletePtpUserDeliver(ptpUserDeliver);
	}
	
}
