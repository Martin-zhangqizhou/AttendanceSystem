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

import com.qz.modules.worker.entity.OverNoteEntity;
import com.qz.modules.worker.service.OverNoteService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 加班表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@RestController
@RequestMapping("worker/overnote")
public class OverNoteController {
    @Autowired
    private OverNoteService overNoteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:overnote:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = overNoteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{overNum}")
    @RequiresPermissions("worker:overnote:info")
    public R info(@PathVariable("overNum") Integer overNum){
		OverNoteEntity overNote = overNoteService.getById(overNum);

        return R.ok().put("overNote", overNote);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:overnote:save")
    public R save(@RequestBody OverNoteEntity overNote){
		overNoteService.save(overNote);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:overnote:update")
    public R update(@RequestBody OverNoteEntity overNote){
		overNoteService.updateById(overNote);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:overnote:delete")
    public R delete(@RequestBody Integer[] overNums){
		overNoteService.removeByIds(Arrays.asList(overNums));

        return R.ok();
    }

}
