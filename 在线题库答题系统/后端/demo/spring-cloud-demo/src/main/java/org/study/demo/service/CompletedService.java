package org.study.demo.service;

import org.apache.ibatis.annotations.Param;
import org.study.demo.controller.ro.homepage.LessonAddRo;
import org.study.demo.controller.ro.question.UpdateCompletedRo;
import org.study.demo.controller.vo.homepage.HomePageDataVo;
import org.study.demo.entity.po.Completed;
import com.baomidou.mybatisplus.extension.service.IService;
import org.study.demo.entity.po.UserInfo;

import java.util.List;

/**
 *
 */
public interface CompletedService extends IService<Completed> {

    HomePageDataVo HomePageData(@Param("userInfo") UserInfo userInfo);

    int insertLessonAndSection(@Param("completed") Completed completed, @Param("token") String token);

    int updateIsCompleted(@Param("updateCompletedRo") UpdateCompletedRo updateCompletedRo);
}
