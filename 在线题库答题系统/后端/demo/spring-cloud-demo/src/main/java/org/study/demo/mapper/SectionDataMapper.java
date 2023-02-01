package org.study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.study.demo.entity.po.SectionData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity org.study.demo.entity.po.SectionData
 */

@Repository
@Mapper
public interface SectionDataMapper extends BaseMapper<SectionData> {

    /**
     * select: 根据`sectionId`模块ID查询`sectionData`模块数据
     *
     * @param sectionId 模块ID
     * @return 模块数据
     */
    List<SectionData> selectAllBySectionId(@Param("sectionId") String sectionId);

}




