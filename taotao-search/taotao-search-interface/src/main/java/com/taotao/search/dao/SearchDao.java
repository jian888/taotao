package com.taotao.search.dao;

import com.taotao.common.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Created by lenovo on 2018-04-25.
 */
public interface SearchDao {

    SearchResult search(SolrQuery query) throws Exception;
}
