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
package cn.xiaoandx.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xiaoandx.commons.core.DaoCode;
import cn.xiaoandx.commons.core.Parameter;
import cn.xiaoandx.commons.core.PublicErrorCode;
import cn.xiaoandx.commons.exception.CommonException;
import cn.xiaoandx.commons.utils.GetWeChatOpenId;
import cn.xiaoandx.commons.utils.Sample;
import cn.xiaoandx.exam.dao.TotalCollcetDao;
import cn.xiaoandx.user.dao.UserDao;
import cn.xiaoandx.user.entity.User;
import cn.xiaoandx.user.vo.OneValueVO;
import cn.xiaoandx.user.vo.WUser;
import lombok.extern.slf4j.Slf4j;

/**  
 * <p> 
 *	微信登录注册操作逻辑service控制层
 * </p> 
 * @ClassName:UserService   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:12
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Service
@Transactional
@Slf4j
public class UserService implements DaoCode,Parameter{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private TotalCollcetDao totalCollcetDao;
	
	// 微信开发者APPID
	@Value("${weixings.appId}")
	private String  appId;
	// 微信开发者APPSecurity
	@Value("${weixings.appSecurity}")
	private  String appSecurity ;
	
	/**  
	 *<p>获取openid</p> 
	 * @Title: getWeixinOpenInfo    
	 * @version:V1.0     
	 * @param code		传入code
	 * @return:String	传出openid
	 */
	public String getWeixinOpenInfo(String code) {

		GetWeChatOpenId getWeChatOpenId = new GetWeChatOpenId();
		return getWeChatOpenId.getWeixinOpenInfo(code, appId, appSecurity);
	}
	
	/**  
	 *<p>先根据code查询是否已经注册，若注册跳转检测界面，若未注册就进行注册</p> 
	 * @Title: findUser    
	 * @version:V1.0     
	 * @param openid	用户的微信openid
	 * @return:User		用户对象
	 */
	public String findUser(String openid,WUser user) {
		if(null != openid) {
			List<User> listuserservice = userDao.findUser(openid);
			if(ENTER_NUMBER == listuserservice.size()) {
				int number = userDao.reUser(user,openid);
				if(ADD_ERROR != number) {
					log.info("注册用户成功");
				}
			}else {
				for(User u : listuserservice) {
					if(null != u.getToken()) {
						return u.getToken();
					}
				}
			}
		}
		 return null;
	}
	
	/**  
	 *<p>人脸注册</p> 
	 * @Title: faceRe    
	 * @version:V1.0     
	 * @param imageBase	注册人脸的base64字符串
	 * @return:String	返回人脸token
	 */
	public String faceRe(String imageBase) {
		if(null != imageBase) {
			return Sample.faceRe(imageBase);
		}
		new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(),"照片异常");
		return null;
	}

	/**  
	 *<p>人脸注册的时候将人脸的token写入数据库</p> 
	 * @Title: addToken    
	 * @version:V1.0     
	 * @param oneValueVO    userId+token对象
	 */
	public void addToken(OneValueVO oneValueVO) {
		if(oneValueVO.getUserId() != ENTER_NUMBER) {
			int numbers = ADD_ERROR;
			if(totalCollcetDao.findByUserId(oneValueVO.getUserId()).size() == 0) {
				// 初始化答题汇总表
				numbers = totalCollcetDao.addDefulent(oneValueVO);
			}else {
				new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "初始化数据表失败");
			}
			if(ADD_ERROR == numbers) {
				new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "初始化数据表失败");
			}
			int number = userDao.addToken(oneValueVO);
			if (ADD_ERROR == number) {
				new CommonException(PublicErrorCode.SAVE_EXCEPTION.getIntValue(), "更新token失败");
			}
		}else {
			new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(),"用户id为空");
		}
		
	}

	/**  
	 *<p>人脸检测</p> 
	 * @Title: searchFace    
	 * @version:V1.0     
	 * @param imageBase	检测人脸base64字符串
	 * @return:String	检测数据字符串
	 */
	public String searchFace(String imageBase) {
		if(null != imageBase) {
			return Sample.searchFace(imageBase);
		}
		new CommonException(PublicErrorCode.PARAM_EXCEPTION.getIntValue(),"照片异常");
		return null;
	}

	/**  
	 *<p>根据openid获得微信用户的userid</p> 
	 * @Title: findByOpenId    
	 * @version:V1.0     
	 * @param openid code换取的openid
	 * @return:User	返回的user对象
	 */
	public User findByOpenId(String openid) {
		return userDao.findByOpenId(openid);
	}

}
