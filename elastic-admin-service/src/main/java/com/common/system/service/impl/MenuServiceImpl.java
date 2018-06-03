package com.common.system.service.impl;

import com.biantech.elastic.admin.entity.ElasticMenu;
import com.biantech.elastic.admin.entity.ElasticMenuExample;
import com.biantech.elastic.admin.mapper.ElasticMenuMapper;
import com.common.system.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.biantech on 2017/8/2.
 * Time:14:01
 * ProjectName:elastic-admin
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private ElasticMenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ElasticMenu record) throws Exception{
        return menuMapper.insert(record);
    }

    @Override
    public ElasticMenu selectByPrimaryKey(String id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(ElasticMenu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int updatePcode(String oldPcode,String newPcode) {
        return menuMapper.updatePcode(oldPcode,newPcode);
    }
    @Override
    public PageInfo<ElasticMenu> listForPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ElasticMenuExample example = new ElasticMenuExample();
        ElasticMenuExample.Criteria criteria = example.createCriteria();
//        criteria.andPIdEqualTo("000000000000000000");
//        example.setOrderByClause("p_id");
        List<ElasticMenu> list = menuMapper.selectByExample(example);
//        List<ElasticMenu> finalList = new ArrayList<>();
//        if (list !=null && list.size()>0){
//            for (ElasticMenu m:list
//                 ) {
//                List<ElasticMenu> childs = getByParentId(m.getId());
//                finalList.add(m);
//                finalList.addAll(childs);
//                m.setChild(childs);
//            }
//        }
        PageInfo<ElasticMenu> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<ElasticMenu> getMenu() {
        List<ElasticMenu> list = menuMapper.selectByExample(new ElasticMenuExample());
        return list;
    }

    @Override
    public ElasticMenu selectCode(String code) {
        ElasticMenuExample example = new ElasticMenuExample();
        ElasticMenuExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<ElasticMenu> menus = menuMapper.selectByExample(example);
        if (menus != null && menus.size() > 0){
            return menus.get(0);
        }
        return null;
    }

    @Override
    public List<ElasticMenu> selectInIds(List<String> ids,List<Integer> wantLevel) {
        ElasticMenuExample example = new ElasticMenuExample();
        ElasticMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        if (wantLevel != null){
            criteria.andLevelIn(wantLevel);
        }
        example.setOrderByClause("sort desc");
        return menuMapper.selectByExample(example);
    }

    @Override
    public List<ElasticMenu> getByParentId(String pId) {
        ElasticMenuExample example = new ElasticMenuExample();
        ElasticMenuExample.Criteria criteria = example.createCriteria();
        criteria.andPIdEqualTo(pId);
        return menuMapper.selectByExample(example);
    }
}
