package org.study.demo.controller.vo.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.study.demo.controller.vo.Status;

import java.util.List;

/**
 * @Author: SongTC
 * @Since: 2022/11/13
 * @E-mail: 690259811@qq.com
 * @Details;
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDataVo {

    private Integer code;
    private List<QuestionItem> questionItemList;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionDataTempVo {

        private Status status;
        private List<QuestionItem> questionItemList;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionItem {

        private String questionId;
        private String questionDetail;
        private List<CheckItem> checkItemList;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class CheckItem {

            public String checkChoose;
            public Integer checkFlag;
        }
    }
}



