package org.study.demo.service;

import org.apache.ibatis.annotations.Param;
import org.study.demo.entity.po.SectionData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SectionDataService extends IService<SectionData> {

    List<SectionData> selectAllBySectionId(@Param("sectionId") String sectionId);
}
