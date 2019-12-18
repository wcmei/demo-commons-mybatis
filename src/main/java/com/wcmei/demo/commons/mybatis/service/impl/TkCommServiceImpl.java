package com.wcmei.demo.commons.mybatis.service.impl;

import com.wcmei.demo.commons.domain.AbstractBaseDomain;
import com.wcmei.demo.commons.service.BaseCommService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wcmei
 * @date 2019-12-16
 * @description
 */
public class TkCommServiceImpl<T extends AbstractBaseDomain, M extends tk.mybatis.mapper.common.Mapper<T> & tk.mybatis.mapper.common.MySqlMapper<T>> implements BaseCommService<T> {

    @Autowired
    protected M mapper;

//    private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public void insertDomain(T domain) {
        mapper.insert(domain);
    }

    @Override
    public void updateDomain(T domain) {
        mapper.updateByPrimaryKeySelective(domain);
    }

    @Override
    public void deleteDomainById(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T selectDomainById(Long id) {
        T domain = mapper.selectByPrimaryKey(id);
        return domain;
    }
}
