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

import com.qz.modules.worker.entity.WorkNoteEntity;
import com.qz.modules.worker.service.WorkNoteService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 出勤记录表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:24:15
 */
@RestController
@RequestMapping("worker/worknote")
public class WorkNoteController {
    @Autowired
    private WorkNoteService workNoteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:worknote:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = workNoteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{workerId}")
    @RequiresPermissions("worker:worknote:info")
    public R info(@PathVariable("workerId") Integer workerId){
		WorkNoteEntity workNote = workNoteService.getById(workerId);

        return R.ok().put("workNote", workNote);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:worknote:save")
    public R save(@RequestBody WorkNoteEntity workNote){
		workNoteService.save(workNote);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:worknote:update")
    public R update(@RequestBody WorkNoteEntity workNote){
		workNoteService.updateById(workNote);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:worknote:delete")
    public R delete(@RequestBody Integer[] workerIds){
		workNoteService.removeByIds(Arrays.asList(workerIds));

        return R.ok();
    }

}
