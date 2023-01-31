package com.example.demo1;

import com.example.demo1.entity.po.Check;
import com.example.demo1.entity.po.Lesson;
import com.example.demo1.entity.po.Module;
import com.example.demo1.entity.po.Question;
import com.example.demo1.mapper.CheckMapper;
import com.example.demo1.mapper.LessonMapper;
import com.example.demo1.mapper.ModuleMapper;
import com.example.demo1.mapper.QuestionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class Demo1ApplicationTests {

    private LessonMapper lessonMapper;

    @Autowired
    public void setLessonMapper(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }

    private ModuleMapper moduleMapper;

    @Autowired
    public void setModuleMapper(ModuleMapper moduleMapper) {
        this.moduleMapper = moduleMapper;
    }

    private QuestionMapper questionMapper;

    @Autowired
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    private CheckMapper checkMapper;

    @Autowired
    public void setCheckMapper(CheckMapper checkMapper) {
        this.checkMapper = checkMapper;
    }

    @Test
    void contextLoads() {
        //user
        //System.out.println(getUUID());

        // lesson
//        for (int i = 1; i <= 6; i++) {
//            lessonMapper.insertAll(new Lesson(
//                    getUUID(),
//                    "广义相对论" + i,
//                    "@/assets/lesson/abc.jpg",
//                    i + ".描写物质间引力相互作用的理论"));
//        }

        // module
//        List<Lesson> lessonList = lessonMapper.selectLessonId();
//        for (int i = 0; i < 36; i++) {
//            moduleMapper.insertAll(new Module(getUUID(),
//                    lessonList.get(i / 6).getLessonId(),
//                    "广义相对论模块" + (i + 1),
//                    "@/assets/module/abc.mp4",
//                    (i + 1) + ".广义相对论将经典的牛顿万有引力定律与狭义相对论加以推广"
//            ));
//        }

        // question
//        List<Module> moduleList = moduleMapper.selectModuleId();
//        for (int i = 0; i < 36 * 6; i++) {
//            questionMapper.insertAll(new Question(
//                    getUUID(),
//                    moduleList.get(i / 6).getModuleId(),
//                    "我们每个人都有一系列的个体经验。这些个体经验以事件序列的形式呈现在我们面前?"
//            ));
//        }

        // check
//        List<Question> questionList = questionMapper.selectQuestionId();
//        for (int i = 0; i < 36 * 6; i++) {
//            checkMapper.insertAll(new Check(getUUID(), questionList.get(i / 6).getQuestionId(), "不同个体在一定程度上能比较各自的经验", false));
//            checkMapper.insertAll(new Check(getUUID(), questionList.get(i / 6).getQuestionId(), "物理学客体就是这一类感觉的一种相对恒定的复合", true));
//            checkMapper.insertAll(new Check(getUUID(), questionList.get(i / 6).getQuestionId(), "过程对时间与空间的概念尤为正确", false));
//            checkMapper.insertAll(new Check(getUUID(), questionList.get(i / 6).getQuestionId(), "物理学就是研究这样一个共同的感觉", true));
//        }
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
