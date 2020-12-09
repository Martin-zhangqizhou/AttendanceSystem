package com.qz.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.utils.PageUtils;
import com.qz.modules.worker.entity.WorkerUserTokenEntity;
import com.qz.utils.R;

import java.util.Map;

/**
 * 普通用户Token
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-09 10:23:17
 */
public interface WorkerUserTokenService extends IService<WorkerUserTokenEntity> {

    /**
     * 生成token
     * @param workerId  用户ID
     */
    R createToken(long workerId);

    /**
     * 退出，修改token值
     * @param workerId  用户ID
     */
    void logout(long workerId);
}

