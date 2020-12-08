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

import com.qz.modules.worker.entity.MangerApproveEntity;
import com.qz.modules.worker.service.MangerApproveService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 19:13:05
 */
@RestController
@RequestMapping("l")
public class MangerApproveController {
    @Autowired
    private MangerApproveService mangerApproveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:mangerapprove:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mangerApproveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("worker:mangerapprove:info")
    public R info(@PathVariable("id") Integer id){
		MangerApproveEntity mangerApprove = mangerApproveService.getById(id);

        return R.ok().put("mangerApprove", mangerApprove);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:mangerapprove:save")
    public R save(@RequestBody MangerApproveEntity mangerApprove){
		mangerApproveService.save(mangerApprove);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:mangerapprove:update")
    public R update(@RequestBody MangerApproveEntity mangerApprove){
		mangerApproveService.updateById(mangerApprove);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:mangerapprove:delete")
    public R delete(@RequestBody Integer[] ids){
		mangerApproveService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
