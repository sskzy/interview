package org.study.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.demo.entity.po.SectionData;
import org.study.demo.service.SectionDataService;
import org.study.demo.mapper.SectionDataMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SectionDataServiceImpl extends ServiceImpl<SectionDataMapper, SectionData>
        implements SectionDataService {

    private SectionDataMapper sectionDataMapper;

    @Autowired
    public void setSectionDataMapper(SectionDataMapper sectionDataMapper) {
        this.sectionDataMapper = sectionDataMapper;
    }

    @Override
    public List<SectionData> selectAllBySectionId(String sectionId) {
        return sectionDataMapper.selectAllBySectionId(sectionId);
    }
}




