package org.study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.study.demo.entity.po.Check;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity org.study.demo.entity.po.Check
 */

@Repository
@Mapper
public interface CheckMapper extends BaseMapper<Check> {

}




