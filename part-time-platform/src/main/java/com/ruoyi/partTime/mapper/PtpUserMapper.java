package com.ruoyi.partTime.mapper;

import com.ruoyi.partTime.domain.PtpUser;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 课程用户 数据层
 *
 * @author ruoyi
 * @date 2019-05-20
 */
@Mapper
@Component
public interface PtpUserMapper {
    /**
     * 查询课程用户信息
     *
     * @param userId 课程用户ID
     * @return 课程用户信息
     */
    PtpUser selectPtpUserById(Integer userId);

    /**
     * 查询课程用户列表
     *
     * @param ptpUser 课程用户信息
     * @return 课程用户集合
     */
    List<PtpUser> selectPtpUserList(PtpUser ptpUser);

    /**
     * 新增课程用户
     *
     * @param ptpUser 课程用户信息
     * @return 结果
     */
    int insertPtpUser(PtpUser ptpUser);

    /**
     * 修改课程用户
     *
     * @param ptpUser 课程用户信息
     * @return 结果
     */
    int updatePtpUser(PtpUser ptpUser);

    /**
     * 删除课程用户
     *
     * @param userId 课程用户ID
     * @return 结果
     */
    int deletePtpUserById(Integer userId);

    /**
     * 批量删除课程用户
     *
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    int deletePtpUserByIds(String[] userIds);

    /**
     * 功能描述:  通过openId获取用户信息
     *
     * @param openId wechat openId
     * @return com.ruoyi.partTime.domain.PtpUser
     * @auther Cyrus.kong
     * @date 2019-05-20
     */
    PtpUser getUserByOpenId(@Param("openId") String openId);
    List<PtpUser> selectUserByName(@Param("nickname") String nickname);
}