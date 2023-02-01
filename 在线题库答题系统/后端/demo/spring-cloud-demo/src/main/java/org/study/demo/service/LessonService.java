package org.study.demo.service;

import org.apache.ibatis.annotations.Param;
import org.study.demo.controller.vo.homepage.HomePageSearchVo;
import org.study.demo.entity.po.Lesson;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface LessonService extends IService<Lesson> {

    HomePageSearchVo homePageSearch(@Param("lesson") String lessonName);
}
