package com.kestrelcjx.system.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kestrelcjx.common.common.BaseQuery;
import com.kestrelcjx.common.utils.JsonResult;
import com.kestrelcjx.common.utils.StringUtils;
import com.kestrelcjx.system.common.BaseServiceImpl;
import com.kestrelcjx.system.entity.Item;
import com.kestrelcjx.system.entity.LayoutDesc;
import com.kestrelcjx.system.mapper.ItemMapper;
import com.kestrelcjx.system.mapper.LayoutDescMapper;
import com.kestrelcjx.system.query.LayoutDescQuery;
import com.kestrelcjx.system.service.ILayoutDescService;
import com.kestrelcjx.system.utils.AdminUtils;
import com.kestrelcjx.system.vo.LayoutDescListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 布局描述服务实现类
 */
@Service
public class LayoutDescServiceImpl extends BaseServiceImpl<LayoutDescMapper, LayoutDesc> implements ILayoutDescService {
    @Autowired
    private LayoutDescMapper layoutDescMapper;
    @Autowired
    private ItemMapper itemMapper;

    /**
     * 获取数据列表
     *
     * @param query 查询条件
     * @return
     */
    @Override
    public JsonResult getList(BaseQuery query) {
        LayoutDescQuery layoutDescQuery = (LayoutDescQuery) query;
        // 查询条件
        QueryWrapper<LayoutDesc> queryWrapper = new QueryWrapper<>();
        // 推荐位名称
        if (!StringUtils.isEmpty(layoutDescQuery.getName())) {
            queryWrapper.like("name", layoutDescQuery.getName());
        }
        queryWrapper.eq("mark", 1);
        queryWrapper.orderByDesc("id");
        // 查询数据
        IPage<LayoutDesc> page = new Page<>(layoutDescQuery.getPage(), layoutDescQuery.getLimit());
        IPage<LayoutDesc> data = layoutDescMapper.selectPage(page, queryWrapper);
        List<LayoutDesc> layoutDescList = data.getRecords();
        List<LayoutDescListVo> layoutDescListVoList = new ArrayList<>();
        if (!layoutDescList.isEmpty()) {
            layoutDescList.forEach(item -> {
                LayoutDescListVo layoutDescListVo = new LayoutDescListVo();
                // 拷贝属性
                BeanUtils.copyProperties(item, layoutDescListVo);
                // 所属站点
                if (layoutDescListVo.getItemId() != null && layoutDescListVo.getItemId() > 0) {
                    Item itemInfo = itemMapper.selectById(layoutDescListVo.getItemId());
                    if (itemInfo != null) {
                        layoutDescListVo.setItemName(itemInfo.getName());
                    }
                }
                // 添加人名称
                if (layoutDescListVo.getCreateUser() > 0) {
                    layoutDescListVo.setCreateUserName(AdminUtils.getName((layoutDescListVo.getCreateUser())));
                }
                // 更新人名称
                if (layoutDescListVo.getUpdateUser() > 0) {
                    layoutDescListVo.setUpdateUserName(AdminUtils.getName((layoutDescListVo.getUpdateUser())));
                }
                layoutDescListVoList.add(layoutDescListVo);
            });
        }
        return JsonResult.success("操作成功", layoutDescListVoList, data.getTotal());
    }

    /**
     * 获取记录详情
     *
     * @param id 记录ID
     * @return
     */
    @Override
    public Object getInfo(Serializable id) {
        LayoutDesc entity = (LayoutDesc) super.getInfo(id);
        return entity;
    }

    /**
     * 添加或编辑记录
     *
     * @param entity 实体对象
     * @return
     */
    @Override
    public JsonResult edit(LayoutDesc entity) {
        return super.edit(entity);
    }

    /**
     * 删除记录
     *
     * @param id 记录ID
     * @return
     */
    @Override
    public JsonResult deleteById(Integer id) {
        if (id == null || id == 0) {
            return JsonResult.error("记录ID不能为空");
        }
        LayoutDesc entity = this.getById(id);
        if (entity == null) {
            return JsonResult.error("记录不存在");
        }
        return super.delete(entity);
    }

    /**
     * 根据ID获取页面位置描述
     *
     * @param itemId 页面位置ID
     * @param locId  位置ID
     * @return
     */
    @Override
    public LayoutDesc getLocDescById(Integer itemId, Integer locId) {
        // 查询条件
        QueryWrapper<LayoutDesc> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.eq("loc_id", locId);
        queryWrapper.eq("mark", 1);
        LayoutDesc layoutDescInfo = layoutDescMapper.selectOne(queryWrapper);
        return layoutDescInfo;
    }
}
