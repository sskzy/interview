package org.study.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.study.demo.controller.ro.homepage.LessonAddRo;
import org.study.demo.controller.vo.Status;
import org.study.demo.controller.vo.homepage.HomePageDataVo;
import org.study.demo.controller.vo.homepage.HomePageSearchDataVo;
import org.study.demo.controller.vo.homepage.HomePageSearchVo;
import org.study.demo.entity.po.Completed;
import org.study.demo.entity.po.SectionData;
import org.study.demo.entity.po.UserInfo;
import org.study.demo.service.impl.CompletedServiceImpl;
import org.study.demo.service.impl.LessonServiceImpl;
import org.study.demo.service.impl.SectionDataServiceImpl;
import org.study.demo.util.metaData;

import java.util.List;

/**
 * @Author: SongTC
 * @Since: 2022/11/12
 * @E-mail: 690259811@qq.com
 * @Details;
 */

@CrossOrigin
@RestController
@RequestMapping("/homepage")
public class HomePageController {

    private CompletedServiceImpl completedService;

    @Autowired
    public void setCompletedService(CompletedServiceImpl completedService) {
        this.completedService = completedService;
    }

    @PostMapping("/data")
    public HomePageDataVo homePageData(@RequestBody UserInfo userInfo) {
        HomePageDataVo homePageDataVo = completedService.HomePageData(userInfo);
        homePageDataVo.setStatus(new Status(metaData.SUCCESS.CODE, metaData.SUCCESS.MSG));
        return homePageDataVo;
    }

    /* ============================================================================================================== */
    private LessonServiceImpl lessonService;

    @Autowired
    public void setLessonService(LessonServiceImpl lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/search")
    public HomePageSearchVo.HomePageSearchTempVo search(String lessonName) {
        System.out.println(lessonName);
        HomePageSearchVo homePageSearchVo;
        HomePageSearchVo.HomePageSearchTempVo homePageSearchTempVo;

        // ????????????`lessonName`????????????
        if (lessonName.isEmpty()) {
            // ??????????????????????????????????????????
            homePageSearchTempVo = new HomePageSearchVo.HomePageSearchTempVo();
            homePageSearchTempVo.setLessonList(null);
            homePageSearchTempVo.setStatus(new Status(metaData.DEFEAT.CODE, metaData.DEFEAT.MSG));
            return homePageSearchTempVo;
        }
        homePageSearchVo = lessonService.homePageSearch(lessonName);
        homePageSearchTempVo = new HomePageSearchVo.HomePageSearchTempVo();

        // ??????????????????????????????????????????
        homePageSearchTempVo.setLessonList(homePageSearchVo.getLessonList());
        homePageSearchTempVo.setStatus(new Status(metaData.SUCCESS.CODE, metaData.SUCCESS.MSG));
        return homePageSearchTempVo;
    }

    /* ============================================================================================================== */
    private SectionDataServiceImpl sectionDataService;

    @Autowired
    public void setSectionDataService(SectionDataServiceImpl sectionDataService) {
        this.sectionDataService = sectionDataService;
    }

    @GetMapping("/videoData")
    public HomePageSearchDataVo videoData(String sectionId) {
        List<SectionData> sectionData = sectionDataService.selectAllBySectionId(sectionId);
        HomePageSearchDataVo homePageSearchDataVo = new HomePageSearchDataVo();

        // ??????`sectionData`????????????????????????
        // true: ?????????????????????
        // false: ?????????????????????
        if (sectionData.isEmpty()) {
            homePageSearchDataVo.setStatus(new Status(metaData.DEFEAT.CODE, metaData.DEFEAT.MSG));
        } else {
            homePageSearchDataVo.setStatus(new Status(metaData.SUCCESS.CODE, metaData.SUCCESS.MSG));
        }
        homePageSearchDataVo.setSectionDataList(sectionData);
        return homePageSearchDataVo;

    }

    /* ============================================================================================================== */
    @PostMapping("lessonAdd")
    public Status lessonAdd(@RequestBody LessonAddRo lessonAddRo) {
        Completed completed = new Completed();
        completed.setLessonId(lessonAddRo.getLessonId());

        // ?????????????????????????????????
        int i = completedService.insertLessonAndSection(completed, lessonAddRo.getToken());
        if (i == 1) {
            return new Status(metaData.SUCCESS.CODE, metaData.SUCCESS.MSG);
        }
        return new Status(metaData.DEFEAT.CODE, metaData.DEFEAT.MSG);
    }


}
