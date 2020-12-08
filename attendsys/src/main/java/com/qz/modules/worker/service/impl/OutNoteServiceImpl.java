package com.qz.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.OutNoteDao;
import com.qz.modules.worker.entity.OutNoteEntity;
import com.qz.modules.worker.service.OutNoteService;


@Service("outNoteService")
public class OutNoteServiceImpl extends ServiceImpl<OutNoteDao, OutNoteEntity> implements OutNoteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OutNoteEntity> page = this.page(
                new Query<OutNoteEntity>().getPage(params),
                new QueryWrapper<OutNoteEntity>()
        );

        return new PageUtils(page);
    }

}