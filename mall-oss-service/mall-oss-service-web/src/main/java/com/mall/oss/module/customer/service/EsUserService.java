package com.mall.oss.module.customer.service;

import com.mall.oss.module.dao.EsLogDao;
import com.mall.oss.module.dao.EsUserDao;
import com.mall.oss.module.entity.EsLog;
import com.mall.oss.module.entity.EsUser;
import org.apache.curator.shaded.com.google.common.collect.Lists;
import org.elasticsearch.common.util.iterable.Iterables;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsUserService {
    @Autowired
    private EsUserDao esUserDao;

    public EsUser saveOrUpdate(EsUser esUser) {
        return esUserDao.save(esUser);
    }

    public List<EsUser> saveOrUpdateList(List<EsUser> esUserList) {
        return Lists.newArrayList(esUserDao.saveAll(esUserList));
    }

    public Page<EsUser> getList(EsUser esUser) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery(); // DSL

        if(esUser.getUsername() != null) {
            QueryBuilder queryBuilderUserName = QueryBuilders.matchQuery("username",esUser.getUsername());
            queryBuilder.must(queryBuilderUserName);
        }

        NativeSearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        return esUserDao.search(searchQuery);
    }
}
