package com.ruoyi.partTime.domain;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 课程用户表 ptp_user
 *
 * @author ruoyi
 * @date 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PtpUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键 主键，自增
     */
    private Integer userId;
    /**
     * 微信的open_id 微信的openid
     */
    private String wechatOpenId;
    /**
     * 微信昵称 昵称
     */
    private String nickname;
    /**
     * 微信头像 用户头像
     */
    private String wechatAvatar;
    /**
     * 用户自己上传的头像 用户自己上传的头像
     */
    private Integer avatar;
    /**
     * 手机号 手机号
     */
    private String mobile;
    /**
     * 性别1男2女
     */
    private String gender;
    /**
     * 学历
     */
    private String education;
    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 城市
     */
    private String city;
    /**
     * l联系邮箱
     */
    private String email;
    /**
     * 类型0学生1企业
     */
    private String type;
    /**
     * 用户状态 用户状态
     */
    private String status;
    /**
     * 备注 备注说明
     */
    private String remark;
    /**
     * 删除标志 删除标志
     */
    private String delFlag;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

    private List<String> workList;

    private List<String> educationList;
}
