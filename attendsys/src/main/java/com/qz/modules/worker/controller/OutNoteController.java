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

import com.qz.modules.worker.entity.OutNoteEntity;
import com.qz.modules.worker.service.OutNoteService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 出差记录表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@RestController
@RequestMapping("worker/outnote")
public class OutNoteController {
    @Autowired
    private OutNoteService outNoteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:outnote:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = outNoteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{outNum}")
    @RequiresPermissions("worker:outnote:info")
    public R info(@PathVariable("outNum") Integer outNum){
		OutNoteEntity outNote = outNoteService.getById(outNum);

        return R.ok().put("outNote", outNote);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:outnote:save")
    public R save(@RequestBody OutNoteEntity outNote){
		outNoteService.save(outNote);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:outnote:update")
    public R update(@RequestBody OutNoteEntity outNote){
		outNoteService.updateById(outNote);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:outnote:delete")
    public R delete(@RequestBody Integer[] outNums){
		outNoteService.removeByIds(Arrays.asList(outNums));

        return R.ok();
    }

}
