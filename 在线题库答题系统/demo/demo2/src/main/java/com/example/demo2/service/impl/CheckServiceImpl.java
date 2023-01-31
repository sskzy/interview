package com.example.demo2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo2.entity.po.Check;
import com.example.demo2.service.CheckService;
import com.example.demo2.mapper.CheckMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CheckServiceImpl extends ServiceImpl<CheckMapper, Check>
    implements CheckService{

}




