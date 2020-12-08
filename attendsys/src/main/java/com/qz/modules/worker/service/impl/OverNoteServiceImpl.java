package com.qz.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.OverNoteDao;
import com.qz.modules.worker.entity.OverNoteEntity;
import com.qz.modules.worker.service.OverNoteService;


@Service("overNoteService")
public class OverNoteServiceImpl extends ServiceImpl<OverNoteDao, OverNoteEntity> implements OverNoteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OverNoteEntity> page = this.page(
                new Query<OverNoteEntity>().getPage(params),
                new QueryWrapper<OverNoteEntity>()
        );

        return new PageUtils(page);
    }

}