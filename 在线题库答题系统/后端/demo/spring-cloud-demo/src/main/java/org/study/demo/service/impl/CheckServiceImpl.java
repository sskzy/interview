package org.study.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.study.demo.entity.po.Check;
import org.study.demo.service.CheckService;
import org.study.demo.mapper.CheckMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CheckServiceImpl extends ServiceImpl<CheckMapper, Check>
    implements CheckService{

}




