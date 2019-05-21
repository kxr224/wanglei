package com.ruoyi.partTime.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.partTime.mapper.PtpCompanyMapper;
import com.ruoyi.partTime.domain.PtpCompany;
import com.ruoyi.partTime.service.IPtpCompanyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 企业 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Service
@AllArgsConstructor
public class PtpCompanyServiceImpl implements IPtpCompanyService {
	private final PtpCompanyMapper ptpCompanyMapper;

	/**
     * 查询企业信息
     * 
     * @param id 企业ID
     * @return 企业信息
     */
    @Override
	public PtpCompany selectPtpCompanyById(Integer id){
	    return ptpCompanyMapper.selectPtpCompanyById(id);
	}
	
	/**
     * 查询企业列表
     * 
     * @param ptpCompany 企业信息
     * @return 企业集合
     */
	@Override
	public List<PtpCompany> selectPtpCompanyList(PtpCompany ptpCompany){
	    return ptpCompanyMapper.selectPtpCompanyList(ptpCompany);
	}
	
    /**
     * 新增企业
     * 
     * @param ptpCompany 企业信息
     * @return 结果
     */
	@Override
	public int insertPtpCompany(PtpCompany ptpCompany){
	    return ptpCompanyMapper.insertPtpCompany(ptpCompany);
	}
	
	/**
     * 修改企业
     * 
     * @param ptpCompany 企业信息
     * @return 结果
     */
	@Override
	public int updatePtpCompany(PtpCompany ptpCompany){
	    return ptpCompanyMapper.updatePtpCompany(ptpCompany);
	}

	/**
     * 删除企业对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePtpCompanyByIds(String ids){
		return ptpCompanyMapper.deletePtpCompanyByIds(Convert.toStrArray(ids));
	}
	
}
