package org.study.demo.controller.vo.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.study.demo.controller.vo.Status;
import org.study.demo.entity.po.SectionData;

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
public class HomePageSearchDataVo {

    private Status status;
    private List<SectionData> sectionDataList;

}
