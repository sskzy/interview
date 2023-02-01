package org.study.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.study.demo.controller.ro.question.UpdateCompletedRo;
import org.study.demo.controller.vo.Status;
import org.study.demo.controller.vo.question.QuestionDataVo;
import org.study.demo.service.impl.CompletedServiceImpl;
import org.study.demo.service.impl.QuestionServiceImpl;
import org.study.demo.util.metaData;

/**
 * @Author: SongTC
 * @Since: 2022/11/13
 * @E-mail: 690259811@qq.com
 * @Details;
 */

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionPageController {

    private QuestionServiceImpl questionService;

    @Autowired
    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/data")
    public QuestionDataVo.QuestionDataTempVo questionData(String sectionId) {
        QuestionDataVo questionDataVo = questionService.selectAllBySectionId(sectionId);

        // 使用模板对象重新构架对象并返回
        QuestionDataVo.QuestionDataTempVo questionDataTempVo = new QuestionDataVo.QuestionDataTempVo();
        questionDataTempVo.setStatus(new Status(metaData.SUCCESS.CODE, metaData.SUCCESS.MSG));
        questionDataTempVo.setQuestionItemList(questionDataVo.getQuestionItemList());
        return questionDataTempVo;
    }

    /* ============================================================================================================== */

    private CompletedServiceImpl completedService;

    @Autowired
    public void setCompletedService(CompletedServiceImpl completedService) {
        this.completedService = completedService;
    }

    @PostMapping("/updateCompleted")
    public Status updateCompleted(@RequestBody UpdateCompletedRo updateCompletedRo) {
        // 判断检查更新情况
        int i = completedService.updateIsCompleted(updateCompletedRo);
        if (i == 1) {
            return new Status(metaData.SUCCESS.CODE, metaData.SUCCESS.MSG);
        }
        return new Status(metaData.DEFEAT.CODE, metaData.DEFEAT.MSG);
    }


}
