package org.study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.study.demo.controller.vo.homepage.HomePageSearchVo;
import org.study.demo.entity.po.Lesson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity org.study.demo.entity.po.Lesson
 */

@Repository
@Mapper
public interface LessonMapper extends BaseMapper<Lesson> {

    /**
     * select: 根据`lessonName`课程名称搜索`lesson`课程和`section`模块及`completed`完成进度
     *
     * @param lessonName 课程名称
     * @return 课程和门模块及未完成进度
     */
    HomePageSearchVo homePageSearch(@Param("lessonName") String lessonName);
}




