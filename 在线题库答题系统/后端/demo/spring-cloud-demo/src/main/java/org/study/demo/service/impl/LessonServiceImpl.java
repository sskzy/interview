package org.study.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.demo.controller.vo.homepage.HomePageSearchVo;
import org.study.demo.entity.po.Lesson;
import org.study.demo.service.LessonService;
import org.study.demo.mapper.LessonMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class LessonServiceImpl extends ServiceImpl<LessonMapper, Lesson>
    implements LessonService{

    private LessonMapper lessonMapper;

    @Autowired
    public void setLessonMapper(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }

    @Override
    public HomePageSearchVo homePageSearch(String lessonName) {
        return lessonMapper.homePageSearch(lessonName);
    }
}




