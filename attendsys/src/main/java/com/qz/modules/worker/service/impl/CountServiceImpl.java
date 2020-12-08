package com.qz.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.CountDao;
import com.qz.modules.worker.entity.CountEntity;
import com.qz.modules.worker.service.CountService;


@Service("countService")
public class CountServiceImpl extends ServiceImpl<CountDao, CountEntity> implements CountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CountEntity> page = this.page(
                new Query<CountEntity>().getPage(params),
                new QueryWrapper<CountEntity>()
        );

        return new PageUtils(page);
    }

}