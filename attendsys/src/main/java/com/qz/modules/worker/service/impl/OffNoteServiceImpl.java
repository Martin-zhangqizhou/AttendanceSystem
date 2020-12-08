package com.qz.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.OffNoteDao;
import com.qz.modules.worker.entity.OffNoteEntity;
import com.qz.modules.worker.service.OffNoteService;


@Service("offNoteService")
public class OffNoteServiceImpl extends ServiceImpl<OffNoteDao, OffNoteEntity> implements OffNoteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OffNoteEntity> page = this.page(
                new Query<OffNoteEntity>().getPage(params),
                new QueryWrapper<OffNoteEntity>()
        );

        return new PageUtils(page);
    }

}