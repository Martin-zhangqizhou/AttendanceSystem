package com.qz.modules.worker.controller;

import java.util.Arrays;
import java.util.Map;

import com.qz.modules.worker.entity.WorkUserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qz.modules.worker.entity.WorkerEntity;
import com.qz.modules.worker.service.WorkerService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:15:30
 */
@RestController
@RequestMapping("worker/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:worker:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = workerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{workerId}")
    @RequiresPermissions("worker:worker:info")
    public R info(@PathVariable("workerId") Integer workerId){
		WorkerEntity worker = workerService.getById(workerId);

        return R.ok().put("worker", worker);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:worker:save")
    public R save(@RequestBody WorkerEntity worker){
        WorkerEntity wue = workerService.getById(worker.getWorkerId());
        if (wue != null){
            workerService.save(worker);
            return R.ok();
        }
        return R.error("已存在" + worker.getName() + "该用户！！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:worker:update")
    public R update(@RequestBody WorkerEntity worker){
		workerService.updateById(worker);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:worker:delete")
    public R delete(@RequestBody Integer[] workerIds){
		workerService.removeByIds(Arrays.asList(workerIds));

        return R.ok();
    }

}
