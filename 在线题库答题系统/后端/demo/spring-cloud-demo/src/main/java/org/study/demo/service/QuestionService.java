package org.study.demo.service;

import org.apache.ibatis.annotations.Param;
import org.study.demo.controller.vo.question.QuestionDataVo;
import org.study.demo.entity.po.Question;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface QuestionService extends IService<Question> {

    QuestionDataVo selectAllBySectionId(@Param("sectionId") String sectionId);

}
