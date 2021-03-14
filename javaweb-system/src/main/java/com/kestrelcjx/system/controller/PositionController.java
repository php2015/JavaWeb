package com.kestrelcjx.system.controller;

import com.kestrelcjx.common.annotation.Log;
import com.kestrelcjx.common.common.BaseController;
import com.kestrelcjx.common.enums.BusinessType;
import com.kestrelcjx.common.utils.JsonResult;
import com.kestrelcjx.system.entity.Position;
import com.kestrelcjx.system.query.PositionQuery;
import com.kestrelcjx.system.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 岗位控制器
 */
@Controller
@RequestMapping("/position")
public class PositionController extends BaseController {
    @Autowired
    private IPositionService positionService;

    /**
     * 获取数据列表
     *
     * @param query 查询条件
     * @return
     */
//    @RequiresPermissions("sys:position:list")
    @ResponseBody
    @PostMapping("/list")
    public JsonResult list(PositionQuery query) {
        return positionService.getList(query);
    }

    /**
     * 添加记录
     *
     * @param entity 实体对象
     * @return
     */
//    @RequiresPermissions("sys:position:add")
    @Log(title = "岗位", businessType = BusinessType.INSERT)
    @ResponseBody
    @PostMapping("/add")
    public JsonResult add(@RequestBody Position entity) {
        return positionService.edit(entity);
    }

    /**
     * 修改记录
     *
     * @param entity 实体对象
     * @return
     */
//    @RequiresPermissions("sys:position:update")
    @Log(title = "岗位", businessType = BusinessType.UPDATE)
    @ResponseBody
    @PostMapping("/update")
    public JsonResult update(@RequestBody Position entity) {
        return positionService.edit(entity);
    }

    /**
     * 获取记录详情
     *
     * @param id    记录ID
     * @param model 模型
     * @return
     */
    @Override
    public String edit(Integer id, Model model) {
        Map<String, Object> info = new HashMap<>();
        if (id != null && id > 0) {
            info = positionService.info(id);
        }
        model.addAttribute("info", info);
        return super.edit(id, model);
    }

    /**
     * 删除记录
     *
     * @param id 记录ID
     * @return
     */
//    @RequiresPermissions("sys:position:delete")
    @Log(title = "岗位", businessType = BusinessType.DELETE)
    @ResponseBody
    @GetMapping("/delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        return positionService.deleteById(id);
    }

    /**
     * 批量删除
     *
     * @param ids 记录ID(多个使用逗号","分隔)
     * @return
     */
//    @RequiresPermissions("sys:position:batchDelete")
    @Log(title = "岗位", businessType = BusinessType.BATCH_DELETE)
    @ResponseBody
    @GetMapping("/batchDelete/{ids}")
    public JsonResult batchDelete(@PathVariable("ids") String ids) {
        return positionService.deleteByIds(ids);
    }

    /**
     * 设置状态
     *
     * @param entity 实体对象
     * @return
     */
//    @RequiresPermissions("sys:position:status")
    @Log(title = "岗位", businessType = BusinessType.STATUS)
    @ResponseBody
    @PostMapping("/setStatus")
    public JsonResult setStatus(@RequestBody Position entity) {
        return positionService.setStatus(entity);
    }
}

