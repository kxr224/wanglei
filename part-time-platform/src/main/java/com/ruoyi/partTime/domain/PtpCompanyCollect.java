package com.ruoyi.partTime.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业收藏表 ptp_company_collect
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PtpCompanyCollect extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	/** 企业用户id */
	private Integer companyUserId;
	/** 用户id */
	private Integer userId;

}
