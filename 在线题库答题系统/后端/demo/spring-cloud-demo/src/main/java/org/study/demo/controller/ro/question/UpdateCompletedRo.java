package org.study.demo.controller.ro.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: SongTC
 * @Since: 2022/11/13
 * @E-mail: 690259811@qq.com
 * @Details;
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompletedRo {

    private String token;
    private String lessonId;
    private String sectionId;
}
