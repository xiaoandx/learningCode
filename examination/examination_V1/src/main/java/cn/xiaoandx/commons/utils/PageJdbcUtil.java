/*
 * Copyright 2019-2020 the original WEI.ZHOU.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.xiaoandx.commons.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.xiaoandx.commons.core.ApiReturnConstants;
import cn.xiaoandx.commons.core.PaginationCore;
import cn.xiaoandx.exam.vo.PageData;
import cn.xiaoandx.exam.vo.PageDomain;
import lombok.extern.slf4j.Slf4j;

/**  
 * <p> 
 *	分页操作
 * </p> 
 * @ClassName:PageJdbcUtil   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:30
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Repository
@Slf4j
public class PageJdbcUtil {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public <T> Map<String, Object> getPageInfor(Integer pageSize, Integer offset,RowMapper<T> rowMapper,String querySql,String countSql) {
		Map<String, Object> r = new HashMap<String, Object>();
		
		if (pageSize == null || pageSize <= 0)
			pageSize = PaginationCore.DEFAULT_LIMIT;
		if (offset == null || offset <= 0)
			offset = PaginationCore.DEFAULT_OFFSET;

		Long totalCount = jdbcTemplate.queryForObject(
				countSql, Long.class);
		String orderBy = "";
	
		querySql = querySql + orderBy;
		int start = (offset - 1) * pageSize;
		querySql += " limit " + start + " , " + pageSize;
		log.debug("find page = {} " + querySql);
		List<T> data = jdbcTemplate.query(querySql, rowMapper);
		log.debug("data size : {} ", data.size());

		int pageCount = totalCount == 0 ? 1 : (int) Math
				.ceil((double) totalCount / (double) pageSize);
		PageDomain p = new PageDomain();
		p.setPageNumber(offset);
		p.setPageSize(pageSize);
		p.setTotalElements(totalCount);
		p.setTotalPages(pageCount);
		r.put(ApiReturnConstants.PAGE, p);
		r.put(ApiReturnConstants.DATA, data);
		return r;
	}
	
	
	public <T> PageData<T> getPageData(Integer pageSize, Integer offset,RowMapper<T> rowMapper,
		String querySql,String countSql) {
		/**
		 * 
		 */
		PageData<T> page = new PageData<T>();
		
		if (pageSize == null || pageSize <= 0)
			pageSize = PaginationCore.DEFAULT_LIMIT;
		if (offset == null || offset <= 0)
			offset = PaginationCore.DEFAULT_OFFSET;

		Long totalCount = jdbcTemplate.queryForObject(
				countSql, Long.class);
		
		int start = (offset - 1) * pageSize;
		querySql += " limit " + start + " , " + pageSize;
		log.debug("find page = {} " + querySql);
		List<T> data = jdbcTemplate.query(querySql, rowMapper);
		log.debug("data size : {} ", data.size());

		int pageCount = totalCount == 0 ? 1 : (int) Math
				.ceil((double) totalCount / (double) pageSize);
		PageDomain p = new PageDomain();
		p.setPageNumber(offset);
		p.setPageSize(pageSize);
		p.setTotalElements(totalCount);
		p.setTotalPages(pageCount);
		page.setData(data);
		page.setPage(p);
		return page;
	}
	
	public <T> List<T> getInfo(String sql, RowMapper<T> rowMapper){

		log.debug("getInfo sql = {} " + sql);
		List<T> data = jdbcTemplate.query(sql, rowMapper);
		log.debug("getInfo data size : {} ", data.size());

		return data;
	}
	
	public Long getCount(String sql){
		Long totalCount = jdbcTemplate.queryForObject(
				sql, Long.class);
		return totalCount;
	}
}
