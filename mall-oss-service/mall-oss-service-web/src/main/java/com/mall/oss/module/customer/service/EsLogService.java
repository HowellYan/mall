package com.mall.oss.module.customer.service;

import com.mall.oss.module.dao.EsLogDao;
import com.mall.oss.module.entity.EsLog;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

@Service
public class EsLogService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private EsLogDao esLogDao;

    public Page<EsLog> getLog() {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery();
        NativeSearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        return esLogDao.search(searchQuery);
    }

    public EsLog addOrUpdate(EsLog esLog) {
        return esLogDao.save(esLog);
    }

    public void delete(EsLog esLog) {
        esLogDao.delete(esLog);
    }


}
