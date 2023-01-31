package com.example.demo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo1.entity.po.Check;
import com.example.demo1.service.CheckService;
import com.example.demo1.mapper.CheckMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CheckServiceImpl extends ServiceImpl<CheckMapper, Check>
    implements CheckService{

}




