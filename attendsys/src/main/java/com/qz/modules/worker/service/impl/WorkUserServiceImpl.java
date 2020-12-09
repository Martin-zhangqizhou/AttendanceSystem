package com.qz.modules.worker.service.impl;

import com.qz.modules.worker.entity.WorkerEntity;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qz.utils.PageUtils;
import com.qz.utils.Query;

import com.qz.modules.worker.dao.WorkUserDao;
import com.qz.modules.worker.entity.WorkUserEntity;
import com.qz.modules.worker.service.WorkUserService;


@Service("workUserService")
public class WorkUserServiceImpl extends ServiceImpl<WorkUserDao, WorkUserEntity> implements WorkUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WorkUserEntity> page = this.page(
                new Query<WorkUserEntity>().getPage(params),
                new QueryWrapper<WorkUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public WorkUserEntity queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }

    @Override
    public void saveUser(WorkUserEntity workUser) {
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        workUser.setPassword(new Sha256Hash(workUser.getPassword(), salt).toHex());
        workUser.setSalt(salt);
        this.save(workUser);
    }

}