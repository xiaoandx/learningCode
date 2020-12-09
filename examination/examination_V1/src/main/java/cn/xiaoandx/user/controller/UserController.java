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
package cn.xiaoandx.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xiaoandx.user.entity.User;
import cn.xiaoandx.user.service.UserService;
import cn.xiaoandx.user.vo.OneValueVO;
import cn.xiaoandx.user.vo.UserImage;
import cn.xiaoandx.user.vo.WUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**  
 * <p> 
 *	用户登录注册答题系统操作类
 * </p> 
 * @ClassName:UserController   
 * @author: WEI.ZHOU
 * @date: 2020-12-07 20:14
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@RequestMapping("/v1/open/user")
@RestController
@Api(tags = "微信用户登录注册相关操作API")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
 	 *<p>用户登录注册</p> 
	 * @Title: get    
	 * @version:V1.0     
	 * @param wuser		包含code与用户信息的对象
	 * @return:OneValueVO	返回userid与token（前端根据token判断是否注册）
	 */
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "POST", value = "根据微信code，获取微信userId,向数据库插入该用户", notes = "根据微信code（还需要传入用户信息），获取微信userId（前端将userid缓存起来）"
    		+ "<br>过程中会进行微信个人信息录入<br><b>@author zhen.pan</b>")
    public OneValueVO get(@ApiParam(value = "用户信息（头像地址，昵称，城市，国家参考右边对象）+临时code *必填",required = true)@RequestBody WUser wuser) {
    	OneValueVO vo = null;
        String openid = userService.getWeixinOpenInfo(wuser.getCode());
        String token = userService.findUser(openid,wuser);
        User user = userService.findByOpenId(openid);
        vo = new OneValueVO(user.getId(),token);
        return vo;
    }
    
    /**
     *<p>人脸注册</p> 
     * @Title: registrationFace    
     * @version:V1.0     
     * @param userimage		用户人脸注册的Base64人像数据
     * @throws Exception    
     * @return:String		返回注册结果(json对象)
     */
    @PostMapping(value = "/faceRe",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "POST",value = "首次人脸注册，获取tock",notes = "根据拍照，获取本人的tock然后返回给用户（前端缓存起来）<br><br><b>@author 周巍</b>")
    public String registrationFace(@ApiParam(value = "人脸Base64字符串对象*必填",required = true)@RequestBody UserImage userimage) throws Exception {
    	return userService.faceRe(userimage.getImageBase());
    }
    
    /**
     *<p>写入token</p> 
     * @Title: registr    
     * @version:V1.0     
     * @param oneValueVO	包含token，userid的对象
     * @return:OneValueVO	包含token，userid的对象
     */
    @PostMapping(value = "/setToken",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "POST",value = "将用户token写入数据库",notes = "用户点击确定注册后将人脸的tock保存在数据库<br>（将刚刚缓存的token+与用户id一起传给后端）<br><br><b>@author 周巍</b>")
    public void registr(@ApiParam(value = "userId+token数据对象*必填",required = true) @RequestBody OneValueVO oneValueVO) {
    	userService.addToken(oneValueVO);
    	//return oneValueVO;
    }
    
    /**
     *<p>检测</p> 
     * @Title: searchFace    
     * @version:V1.0     
     * @param userimage	检测人脸数据
     * @return:String	返回检测数据
     */
    @PostMapping(value = "/searchFace",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "POST",value = "人脸检测登录，更具相似度来判断",notes = "需要传入人脸Base64数据<br>返回给前端带有相似度的json数据<br><b>@author 周巍</b>")
    public String searchFace(@ApiParam(value = "Base64字符串对象*必填",required = true) @RequestBody UserImage userimage) {
    	return userService.searchFace(userimage.getImageBase());
    }
}
