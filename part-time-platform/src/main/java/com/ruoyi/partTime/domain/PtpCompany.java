package com.ruoyi.partTime.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业表 ptp_company
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PtpCompany extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 企业用户 */
	private Integer userId;
	/** 名称 */
	private String name;
	/** 地点 */
	private String place;
	/** 联系方式 */
	private String mobile;
	/** 在招岗位 */
	private String jobs;
	/** 封面 */
	private String coverImg;
	/** 公司介绍 */
	private String intro;

}
