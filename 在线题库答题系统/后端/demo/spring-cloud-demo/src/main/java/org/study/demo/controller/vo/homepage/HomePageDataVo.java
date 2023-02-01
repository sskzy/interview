package org.study.demo.controller.vo.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.study.demo.controller.vo.Status;

import java.util.List;

/**
 * @Author: SongTC
 * @Since: 2022/11/12
 * @E-mail: 690259811@qq.com
 * @Details;
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomePageDataVo {

    private Status status;
    private String account;
    private String avatarUrl;
    private List<LessonItem> lessonList;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LessonItem {

        private String lessonId;
        private String lessonName;
        private List<SectionItem> sectionList;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class SectionItem {

            private String sectionId;
            private String sectionName;
            private boolean isCompleted;
        }
    }
}



