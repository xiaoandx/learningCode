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
package cn.xiaoandx.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.xiaoandx.commons.utils.IdAndTimeUtil;
import cn.xiaoandx.user.entity.User;
import cn.xiaoandx.user.vo.OneValueVO;
import cn.xiaoandx.user.vo.WUser;
import lombok.extern.slf4j.Slf4j;

/**  
 * <p> 
 *	用户数据操作控制
 * </p> 
 * @ClassName:UserDao   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:14
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Component
@Slf4j
public class UserDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/**  
	 *<p>根据opengid查询是否该微信用户注册过</p> 
	 * @Title: findUser    
	 * @version:V1.0     
	 * @param openid	用户的openid
	 * @return:List<User>	xx用户的数据集合
	 */
	public List<User> findUser(String openid) {
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		String sql = "SELECT u.`id`,u.`open_id`,u.`head_portrait`,u.`nickname`,u.`country`,u.`province`,u.`city`,u.`creation_time`,u.`token` "
				+ "FROM`user` AS u "
				+ "WHERE u.`open_id` = ?";
		return jdbcTemplate.query(sql, rowMapper, openid);
	}

	/**  
	 *<p>注册用户</p> 
	 * @Title: reUser    
	 * @version:V1.0     
	 * @param user	包含code与用户信息的对象
	 * @param openid	用户的openid
	 * @return:int	操作结果
	 */
	public int reUser(WUser user, String openid) {
		String sql = "INSERT INTO  `user` "
				+ "(`open_id`,`head_portrait`,`nickname`,`country`,`province`,`city`,`creation_time`) "
				+ "VALUES (?,?,?,?,?,?,?)";
		int number = jdbcTemplate.update(sql,openid,user.getHeadPortrait(),user.getNickname(),user.getCountry(),user.getProvince(),user.getCity(),IdAndTimeUtil.getNewDate());
		log.info("==========注册用户========"+String.valueOf(number));
		return number;
	}

	/**  
	 *<p>获取用户数据</p> 
	 * @Title: findByOpenId    
	 * @version:V1.0     
	 * @param openid	用户的openId
	 * @return:User		用户信息对象
	 */
	public User findByOpenId(String openid) {
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		String sql = "SELECT u.`id`,u.`open_id`,u.`head_portrait`,u.`nickname`,u.`country`,u.`province`,u.`city`,u.`creation_time`,u.`token`,u.`jurisdiction` "
				+ "FROM`user` AS u "
				+ "WHERE u.`open_id` = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, openid);
	}
	public User findByUsersId(int openid) {
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
		String sql = "SELECT u.`id`,u.`head_portrait`,u.`nickname`,u.`jurisdiction` "
				+ "FROM`user` AS u "
				+ "WHERE u.`id` = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, openid);
	}

	/**  
	 *<p>用户注册人脸获得token写入数据库</p> 
	 * @Title: addToken    
	 * @version:V1.0     
	 * @param oneValueVO	userId+token对象
	 * @return:int			操作结果
	 */
	public int addToken(OneValueVO oneValueVO) {
		String sql = "UPDATE  `user` SET `token` = ? WHERE `id` = ?";
		int number = jdbcTemplate.update(sql,oneValueVO.getToken(),oneValueVO.getUserId());
		log.info("==========写入token成功========"+String.valueOf(number));
		return number;
	}
	
}
