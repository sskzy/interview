package org.study.demo.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.study.demo.controller.vo.question.QuestionDataVo;
import org.study.demo.entity.po.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity org.study.demo.entity.po.Question
 */

@Repository
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * select: 根据`sectionId`模块ID查询问题内容列表
     *
     * @param sectionId 模块ID
     * @return 问题内容列表
     */
    QuestionDataVo selectAllBySectionId(@Param("sectionId") String sectionId);

}




