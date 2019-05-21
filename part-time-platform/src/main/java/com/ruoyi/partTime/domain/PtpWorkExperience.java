package com.ruoyi.partTime.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 工作经历表 ptp_work_experience
 * 
 * @author ruoyi
 * @date 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PtpWorkExperience extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 用户主键 */
	private Integer userId;
	/** 工作经历 */
	private String workExperience;

}
