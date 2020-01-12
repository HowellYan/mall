package com.mall.oss.module.dao;

import com.mall.oss.module.entity.EsLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Howell.Yang
 */
@Repository
public interface EsLogDao extends ElasticsearchRepository<EsLog, String> {

}
