package com.ruoyi.partTime.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.partTime.mapper.PtpUserMapper;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.service.IPtpUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 课程用户 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Service
@AllArgsConstructor
public class PtpUserServiceImpl implements IPtpUserService {
	private final PtpUserMapper ptpUserMapper;

	/**
     * 查询课程用户信息
     * 
     * @param userId 课程用户ID
     * @return 课程用户信息
     */
    @Override
	public PtpUser selectPtpUserById(Integer userId){
	    return ptpUserMapper.selectPtpUserById(userId);
	}
	
	/**
     * 查询课程用户列表
     * 
     * @param ptpUser 课程用户信息
     * @return 课程用户集合
     */
	@Override
	public List<PtpUser> selectPtpUserList(PtpUser ptpUser){
	    return ptpUserMapper.selectPtpUserList(ptpUser);
	}
	
    /**
     * 新增课程用户
     * 
     * @param ptpUser 课程用户信息
     * @return 结果
     */
	@Override
	public int insertPtpUser(PtpUser ptpUser){
	    return ptpUserMapper.insertPtpUser(ptpUser);
	}
	
	/**
     * 修改课程用户
     * 
     * @param ptpUser 课程用户信息
     * @return 结果
     */
	@Override
	public int updatePtpUser(PtpUser ptpUser){
	    return ptpUserMapper.updatePtpUser(ptpUser);
	}

	/**
     * 删除课程用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePtpUserByIds(String ids){
		return ptpUserMapper.deletePtpUserByIds(Convert.toStrArray(ids));
	}

	@Override
	public PtpUser getUserByOpenId(String openId) {
		return ptpUserMapper.getUserByOpenId(openId);
	}

}
