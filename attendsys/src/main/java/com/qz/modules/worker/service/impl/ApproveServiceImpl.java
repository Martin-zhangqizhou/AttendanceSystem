package com.qz.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.ApproveDao;
import com.qz.modules.worker.entity.ApproveEntity;
import com.qz.modules.worker.service.ApproveService;


@Service("approveService")
public class ApproveServiceImpl extends ServiceImpl<ApproveDao, ApproveEntity> implements ApproveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ApproveEntity> page = this.page(
                new Query<ApproveEntity>().getPage(params),
                new QueryWrapper<ApproveEntity>()
        );

        return new PageUtils(page);
    }

}