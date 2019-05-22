package com.ruoyi.partTime.mapper;

import com.ruoyi.partTime.domain.PtpWorkExperience;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 工作经历 数据层
 *
 * @author ruoyi
 * @date 2019-05-20
 */
@Mapper
@Component
public interface PtpWorkExperienceMapper {
    /**
     * 查询工作经历信息
     *
     * @param id 工作经历ID
     * @return 工作经历信息
     */
    PtpWorkExperience selectPtpWorkExperienceById(Integer id);

    /**
     * 查询工作经历列表
     *
     * @param ptpWorkExperience 工作经历信息
     * @return 工作经历集合
     */
    List<PtpWorkExperience> selectPtpWorkExperienceList(PtpWorkExperience ptpWorkExperience);

    /**
     * 新增工作经历
     *
     * @param ptpWorkExperience 工作经历信息
     * @return 结果
     */
    int insertPtpWorkExperience(PtpWorkExperience ptpWorkExperience);

    /**
     * 修改工作经历
     *
     * @param ptpWorkExperience 工作经历信息
     * @return 结果
     */
    int updatePtpWorkExperience(PtpWorkExperience ptpWorkExperience);

    /**
     * 删除工作经历
     *
     * @param id 工作经历ID
     * @return 结果
     */
    int deletePtpWorkExperienceById(Integer id);

    /**
     * 批量删除工作经历
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deletePtpWorkExperienceByIds(String[] ids);

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