package com.mall.oss.module.dao;

import com.mall.oss.module.entity.EsUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsUserDao extends ElasticsearchRepository<EsUser, String> {
}
