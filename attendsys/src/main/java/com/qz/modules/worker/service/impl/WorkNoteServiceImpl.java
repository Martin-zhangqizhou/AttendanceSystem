package com.qz.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.WorkNoteDao;
import com.qz.modules.worker.entity.WorkNoteEntity;
import com.qz.modules.worker.service.WorkNoteService;


@Service("workNoteService")
public class WorkNoteServiceImpl extends ServiceImpl<WorkNoteDao, WorkNoteEntity> implements WorkNoteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WorkNoteEntity> page = this.page(
                new Query<WorkNoteEntity>().getPage(params),
                new QueryWrapper<WorkNoteEntity>()
        );

        return new PageUtils(page);
    }

}