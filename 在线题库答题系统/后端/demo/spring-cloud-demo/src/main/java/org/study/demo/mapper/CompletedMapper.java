package org.study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.study.demo.controller.ro.homepage.LessonAddRo;
import org.study.demo.controller.ro.question.UpdateCompletedRo;
import org.study.demo.controller.vo.homepage.HomePageDataVo;
import org.study.demo.entity.po.Completed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.study.demo.entity.po.UserInfo;

import java.util.List;

/**
 * @Entity org.study.demo.entity.po.Completed
 */

@Repository
@Mapper
public interface CompletedMapper extends BaseMapper<Completed> {

    /**
     * select: 根据用户`token`令牌 获取用户信息{`account`,`avatarUrl`}和`lesson`课程及`section`模块
     *
     * @param userInfo 令牌
     * @return 用户信息和课程
     */
    HomePageDataVo HomePageData(@Param("userInfo") UserInfo userInfo);

    /**
     * insert: 将`lessonId`课程和`sectionId`课程的模块加入用户进度表
     *
     * @param completed 课程和模块
     * @return 1 成功状态(1:成功)
     */
    int insertLessonAndSection(@Param("completed") Completed completed);

    /**
     * select: 根据`lessonId`课程ID查询进度表是否存在课程
     *
     * @param lessonId 课程
     * @return 进度表
     */
    Completed selectAllByLessonId(@Param("lessonId") String lessonId);

    /**
     * update: 根据`userId`用户ID配合`lessonId`课程ID和`sectionId`模块ID修改`isCompleted`进度
     *
     * @param updateCompletedRo updateCompletedRo对象
     * @return 1 (1:成功状态)
     */
    int updateIsCompleted(@Param("updateCompletedRo") UpdateCompletedRo updateCompletedRo);
}




