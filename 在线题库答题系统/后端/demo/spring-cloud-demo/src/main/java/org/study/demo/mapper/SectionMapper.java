package org.study.demo.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.study.demo.entity.po.Section;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity org.study.demo.entity.po.Section
 */

@Repository
@Mapper
public interface SectionMapper extends BaseMapper<Section> {

    /**
     * select: 根据`lessonId`课程ID查询`sectionId`模块ID列表
     *
     * @param lessonId 课程ID
     * @return 模块ID列表
     */
    List<Section> selectSectionIdByLessonId(@Param("lessonId") String lessonId);
}




