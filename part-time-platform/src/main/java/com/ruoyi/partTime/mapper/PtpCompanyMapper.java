package com.ruoyi.partTime.mapper;

import com.ruoyi.partTime.domain.PtpCompany;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**
 * 企业 数据层
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Mapper
@Component
public interface PtpCompanyMapper {
	/**
     * 查询企业信息
     * 
     * @param id 企业ID
     * @return 企业信息
     */
	PtpCompany selectPtpCompanyById(Integer id);
	
	/**
     * 查询企业列表
     * 
     * @param ptpCompany 企业信息
     * @return 企业集合
     */
	List<PtpCompany> selectPtpCompanyList(PtpCompany ptpCompany);
	
	/**
     * 新增企业
     * 
     * @param ptpCompany 企业信息
     * @return 结果
     */
	int insertPtpCompany(PtpCompany ptpCompany);
	
	/**
     * 修改企业
     * 
     * @param ptpCompany 企业信息
     * @return 结果
     */
	int updatePtpCompany(PtpCompany ptpCompany);
	
	/**
     * 删除企业
     * 
     * @param id 企业ID
     * @return 结果
     */
	int deletePtpCompanyById(Integer id);
	
	/**
     * 批量删除企业
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deletePtpCompanyByIds(String[] ids);
	
}