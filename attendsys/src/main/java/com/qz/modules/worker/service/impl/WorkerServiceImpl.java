package com.qz.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.WorkerDao;
import com.qz.modules.worker.entity.WorkerEntity;
import com.qz.modules.worker.service.WorkerService;


@Service("workerService")
public class WorkerServiceImpl extends ServiceImpl<WorkerDao, WorkerEntity> implements WorkerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WorkerEntity> page = this.page(
                new Query<WorkerEntity>().getPage(params),
                new QueryWrapper<WorkerEntity>()
        );
        System.out.println(page.getRecords());
        return new PageUtils(page);
    }

}