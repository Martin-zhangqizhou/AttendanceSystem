package com.qz.modules.worker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("worker/mangerapprove")
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

    @PostMapping("/list")
    @RequiresPermissions("worker:mangerapprove:list")
    public R testlist(@RequestBody Map<String, Object> params){
        PageUtils page = mangerApproveService.queryPage(params);
        String s = (String)params.get("z");
        String[] res = s.split(",");
        System.out.println(Integer.parseInt(res[1]));
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

    /**
     * 批请假条
     */
    @RequestMapping("/ratify")
    public Object ratify(@RequestParam Map<String, Object> params){
        PageUtils page = mangerApproveService.queryPage(params);
        List<MangerApproveEntity> list= (List<MangerApproveEntity>) page.getList();
        return list;
    }


    /**
     * 处理批请假条
     */
//    @RequestMapping("/ratify")
//    public Object ratifyPro(@RequestParam Map<String, Object> params){
//        PageUtils page = mangerApproveService.queryPage(params);
//        List<MangerApproveEntity> list= new ArrayList<>();
//        list = mangerApproveService.list();
//        System.out.println(list);
////        for (MangerApproveEntity item:list){
////            item.
////        }
////        return null;
//    }
}
