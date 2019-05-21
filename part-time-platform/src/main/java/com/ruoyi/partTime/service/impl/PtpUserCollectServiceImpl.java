package com.ruoyi.partTime.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.partTime.mapper.PtpUserCollectMapper;
import com.ruoyi.partTime.domain.PtpUserCollect;
import com.ruoyi.partTime.service.IPtpUserCollectService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户收藏 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Service
@AllArgsConstructor
public class PtpUserCollectServiceImpl implements IPtpUserCollectService {
	private final PtpUserCollectMapper ptpUserCollectMapper;

	/**
     * 查询用户收藏信息
     * 
     * @param companyUserId 用户收藏ID
     * @return 用户收藏信息
     */
    @Override
	public PtpUserCollect selectPtpUserCollectById(Integer companyUserId){
	    return ptpUserCollectMapper.selectPtpUserCollectById(companyUserId);
	}
	
	/**
     * 查询用户收藏列表
     * 
     * @param ptpUserCollect 用户收藏信息
     * @return 用户收藏集合
     */
	@Override
	public List<PtpUserCollect> selectPtpUserCollectList(PtpUserCollect ptpUserCollect){
	    return ptpUserCollectMapper.selectPtpUserCollectList(ptpUserCollect);
	}
	
    /**
     * 新增用户收藏
     * 
     * @param ptpUserCollect 用户收藏信息
     * @return 结果
     */
	@Override
	public int insertPtpUserCollect(PtpUserCollect ptpUserCollect){
	    return ptpUserCollectMapper.insertPtpUserCollect(ptpUserCollect);
	}
	
	/**
     * 修改用户收藏
     * 
     * @param ptpUserCollect 用户收藏信息
     * @return 结果
     */
	@Override
	public int updatePtpUserCollect(PtpUserCollect ptpUserCollect){
	    return ptpUserCollectMapper.updatePtpUserCollect(ptpUserCollect);
	}

	/**
     * 删除用户收藏对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePtpUserCollectByIds(String ids){
		return ptpUserCollectMapper.deletePtpUserCollectByIds(Convert.toStrArray(ids));
	}
	
}
