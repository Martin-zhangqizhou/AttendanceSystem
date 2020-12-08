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

import com.qz.modules.worker.entity.CountEntity;
import com.qz.modules.worker.service.CountService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 月统计表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@RestController
@RequestMapping("worker/count")
public class CountController {
    @Autowired
    private CountService countService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:count:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = countService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{countId}")
    @RequiresPermissions("worker:count:info")
    public R info(@PathVariable("countId") Integer countId){
		CountEntity count = countService.getById(countId);

        return R.ok().put("count", count);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:count:save")
    public R save(@RequestBody CountEntity count){
		countService.save(count);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:count:update")
    public R update(@RequestBody CountEntity count){
		countService.updateById(count);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:count:delete")
    public R delete(@RequestBody Integer[] countIds){
		countService.removeByIds(Arrays.asList(countIds));

        return R.ok();
    }

}
