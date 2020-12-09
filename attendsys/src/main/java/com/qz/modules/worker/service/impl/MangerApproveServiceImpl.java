package com.qz.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.MangerApproveDao;
import com.qz.modules.worker.entity.MangerApproveEntity;
import com.qz.modules.worker.service.MangerApproveService;


@Service("mangerApproveService")
public class MangerApproveServiceImpl extends ServiceImpl<MangerApproveDao, MangerApproveEntity> implements MangerApproveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MangerApproveEntity> page = this.page(
                new Query<MangerApproveEntity>().getPage(params),
                new QueryWrapper<MangerApproveEntity>()
        );
        System.out.println(page.getRecords());
        return new PageUtils(page);
    }

}