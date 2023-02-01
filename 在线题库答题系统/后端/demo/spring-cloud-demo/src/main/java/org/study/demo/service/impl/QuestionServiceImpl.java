package org.study.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.demo.controller.vo.Status;
import org.study.demo.controller.vo.question.QuestionDataVo;
import org.study.demo.entity.po.Question;
import org.study.demo.service.QuestionService;
import org.study.demo.mapper.QuestionMapper;
import org.springframework.stereotype.Service;
import org.study.demo.util.metaData;

/**
 *
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
        implements QuestionService {

    private QuestionMapper questionMapper;

    @Autowired
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public QuestionDataVo selectAllBySectionId(String sectionId) {
        return questionMapper.selectAllBySectionId(sectionId);
    }
}




