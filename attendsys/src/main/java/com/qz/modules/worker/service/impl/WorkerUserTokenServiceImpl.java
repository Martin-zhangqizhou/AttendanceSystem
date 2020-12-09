package com.qz.modules.worker.service.impl;

import com.qz.modules.system.oauth2.TokenGenerator;
import com.qz.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.qz.modules.worker.dao.WorkerUserTokenDao;
import com.qz.modules.worker.entity.WorkerUserTokenEntity;
import com.qz.modules.worker.service.WorkerUserTokenService;


@Service("workerUserTokenService")
public class WorkerUserTokenServiceImpl extends ServiceImpl<WorkerUserTokenDao, WorkerUserTokenEntity> implements WorkerUserTokenService {

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    public R createToken(long workerId) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@"+workerId);
        //生成一个token
        String token = TokenGenerator.generateValue();
        System.out.println("*****************"+token);

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        WorkerUserTokenEntity tokenEntity = this.getById(workerId);

        if(tokenEntity == null){
            //System.out.println("---------------------------");
            tokenEntity = new WorkerUserTokenEntity();
            tokenEntity.setWorkerId(workerId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&"+tokenEntity.getWorkerId());
            System.out.println(this);
            System.out.println(tokenEntity.toString());
            //保存token
            this.save(tokenEntity);
        }else{
            //tokenEntity.setWorkerId(workerId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        R r = R.ok().put("token", token).put("expire", EXPIRE).put("workerId",tokenEntity.getWorkerId());

        return r;
    }

    @Override
    public void logout(long workerId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        WorkerUserTokenEntity tokenEntity = new WorkerUserTokenEntity();
        tokenEntity.setWorkerId(workerId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }

}