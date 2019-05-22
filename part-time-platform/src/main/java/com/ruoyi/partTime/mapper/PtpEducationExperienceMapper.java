package com.ruoyi.partTime.mapper;

import com.ruoyi.partTime.domain.PtpEducationExperience;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 教育经历 数据层
 *
 * @author ruoyi
 * @date 2019-05-20
 */
@Mapper
@Component
public interface PtpEducationExperienceMapper {
    /**
     * 查询教育经历信息
     *
     * @param id 教育经历ID
     * @return 教育经历信息
     */
    PtpEducationExperience selectPtpEducationExperienceById(Integer id);

    /**
     * 查询教育经历列表
     *
     * @param ptpEducationExperience 教育经历信息
     * @return 教育经历集合
     */
    List<PtpEducationExperience> selectPtpEducationExperienceList(PtpEducationExperience ptpEducationExperience);

    /**
     * 新增教育经历
     *
     * @param ptpEducationExperience 教育经历信息
     * @return 结果
     */
    int insertPtpEducationExperience(PtpEducationExperience ptpEducationExperience);

    /**
     * 修改教育经历
     *
     * @param ptpEducationExperience 教育经历信息
     * @return 结果
     */
    int updatePtpEducationExperience(PtpEducationExperience ptpEducationExperience);

    /**
     * 删除教育经历
     *
     * @param id 教育经历ID
     * @return 结果
     */
    int deletePtpEducationExperienceById(Integer id);

    /**
     * 批量删除教育经历
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deletePtpEducationExperienceByIds(String[] ids);

    /**
     * 批量插入
     *
     * @param list   列表
     * @param userId user id
     * @return 插入个数
     */
    int batchInsert(@Param("list") List<String> list, @Param("userId") Integer userId);

    /**
     * 批量删除
     *
     * @param userId user id
     * @return 删除个数
     */
    int deleteByUserId(@Param("userId") Integer userId);
}