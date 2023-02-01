package org.study.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.demo.controller.ro.question.UpdateCompletedRo;
import org.study.demo.controller.vo.homepage.HomePageDataVo;
import org.study.demo.entity.po.Completed;
import org.study.demo.entity.po.Section;
import org.study.demo.entity.po.UserInfo;
import org.study.demo.mapper.SectionMapper;
import org.study.demo.mapper.UserInfoMapper;
import org.study.demo.service.CompletedService;
import org.study.demo.mapper.CompletedMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service
public class CompletedServiceImpl extends ServiceImpl<CompletedMapper, Completed>
        implements CompletedService {

    private CompletedMapper completedMapper;

    @Autowired
    public void setCompletedMapper(CompletedMapper completedMapper) {
        this.completedMapper = completedMapper;
    }

    @Override
    public HomePageDataVo HomePageData(UserInfo userInfo) {
        return completedMapper.HomePageData(userInfo);
    }

    /* ============================================================================================================== */
    private SectionMapper sectionMapper;
    private UserInfoMapper userInfoMapper;

    @Autowired
    public void setSectionMapper(SectionMapper sectionMapper) {
        this.sectionMapper = sectionMapper;
    }

    @Autowired
    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public int insertLessonAndSection(Completed completed, String token) {
        UserInfo userInfo = userInfoMapper.selectUserIdByToken(token);
        List<Section> sectionList = sectionMapper.selectSectionIdByLessonId(completed.getLessonId());

        try {
            // 判断将加入的课程是否已存在
            Completed completedTemp = completedMapper.selectAllByLessonId(completed.getLessonId());
            if (completedTemp != null) {
                return 0;
            }
        } catch (NullPointerException e) {
            return 0;
        }

        // 判断课程有无对应模块
        if (sectionList.isEmpty()) {
            return 0;
        }

        int j = 0;
        for (Section section : sectionList) {
            Completed completedInstance;
            try {
                completedInstance = new Completed(UUID.randomUUID().toString(),
                        userInfo.getUserId(),
                        completed.getLessonId(),
                        section.getSectionId(),
                        false);
            } catch (NullPointerException e) {
                //
                return 0;
            }

            j += completedMapper.insertLessonAndSection(completedInstance);
        }
        return j == sectionList.size() ? 1 : 0;
    }

    /* ============================================================================================================== */
    @Override
    public int updateIsCompleted(UpdateCompletedRo updateCompletedRo) {
        return completedMapper.updateIsCompleted(updateCompletedRo);
    }
}




