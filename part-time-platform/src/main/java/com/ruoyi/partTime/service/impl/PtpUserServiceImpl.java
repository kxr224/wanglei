package com.ruoyi.partTime.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.date.DateUtil;
import com.ruoyi.partTime.domain.PtpWorkExperience;
import com.ruoyi.partTime.mapper.PtpEducationExperienceMapper;
import com.ruoyi.partTime.mapper.PtpWorkExperienceMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.partTime.mapper.PtpUserMapper;
import com.ruoyi.partTime.domain.PtpUser;
import com.ruoyi.partTime.service.IPtpUserService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

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
    private final PtpEducationExperienceMapper educationExperienceMapper;
    private final PtpWorkExperienceMapper workExperienceMapper;

    /**
     * 查询课程用户信息
     *
     * @param userId 课程用户ID
     * @return 课程用户信息
     */
    @Override
    public PtpUser selectPtpUserById(Integer userId) {
        return ptpUserMapper.selectPtpUserById(userId);
    }

    /**
     * 查询课程用户列表
     *
     * @param ptpUser 课程用户信息
     * @return 课程用户集合
     */
    @Override
    public List<PtpUser> selectPtpUserList(PtpUser ptpUser) {
        return ptpUserMapper.selectPtpUserList(ptpUser);
    }

    /**
     * 新增课程用户
     *
     * @param ptpUser 课程用户信息
     * @return 结果
     */
    @Override
    public int insertPtpUser(PtpUser ptpUser) {
        return ptpUserMapper.insertPtpUser(ptpUser);
    }

    /**
     * 修改课程用户
     *
     * @param ptpUser 课程用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePtpUser(PtpUser ptpUser) {
        int i = ptpUserMapper.updatePtpUser(ptpUser);
        if (ptpUser.getParams() == null) {
            return i;
        }
        if (ptpUser.getWorkList() != null) {
            workExperienceMapper.deleteByUserId(ptpUser.getUserId());
            if (ptpUser.getWorkList().size() != 0) {
                workExperienceMapper.batchInsert(ptpUser.getWorkList(), ptpUser.getUserId());
            }
        }
        if (ptpUser.getEducationList() != null) {
            educationExperienceMapper.deleteByUserId(ptpUser.getUserId());
            if (ptpUser.getEducationList().size() != 0) {
                educationExperienceMapper.batchInsert(ptpUser.getEducationList(), ptpUser.getUserId());
            }
        }
        return i;
    }

    /**
     * 删除课程用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePtpUserByIds(String ids) {
        return ptpUserMapper.deletePtpUserByIds(Convert.toStrArray(ids));
    }

    @Override
    public List<PtpUser> selectUserByName(String nickname){
        return ptpUserMapper.selectUserByName(nickname);
    }
    @Override
    public PtpUser getUserByOpenId(String openId) {
        PtpUser user = ptpUserMapper.getUserByOpenId(openId);
        if (user != null && user.getBirthday() != null) {
            user.setAge(DateUtil.ageOfNow(user.getBirthday()));
        }
        return user;
    }


}
