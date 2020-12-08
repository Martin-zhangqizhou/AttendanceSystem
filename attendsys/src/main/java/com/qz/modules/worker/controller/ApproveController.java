package com.qz.modules.worker.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qz.modules.worker.entity.ApproveEntity;
import com.qz.modules.worker.service.ApproveService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 批文表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 11:42:05
 */
@RestController
@RequestMapping("worker/approve")
public class ApproveController {
    @Autowired
    private ApproveService approveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:approve:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = approveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("worker:approve:info")
    public R info(@PathVariable("id") Integer id){
		ApproveEntity approve = approveService.getById(id);

        return R.ok().put("approve", approve);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:approve:save")
    public R save(@RequestBody ApproveEntity approve){
		approveService.save(approve);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:approve:update")
    public R update(@RequestBody ApproveEntity approve){
		approveService.updateById(approve);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:approve:delete")
    public R delete(@RequestBody Integer[] ids){
		approveService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
