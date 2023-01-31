package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.entity.po.Lesson;
import com.example.demo1.service.LessonService;
import com.example.demo1.mapper.LessonMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class LessonServiceImpl extends ServiceImpl<LessonMapper, Lesson>
    implements LessonService{

}




