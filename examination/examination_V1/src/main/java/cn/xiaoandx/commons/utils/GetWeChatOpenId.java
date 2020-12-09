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

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**  
 * <p> 
 *	获取微信opendId
 * </p> 
 * @ClassName:GetWeChatOpenId   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:29
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Service
@Slf4j
public class GetWeChatOpenId {
	//获取openid请求
	private  String weixinUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=";
    
    
    /**
     *<p>获取微信唯一标识openId</p> 
     * @Title: getWeixinOpenInfo    
     * @version:V2.0     
     * @param code		微信code（前台获取传入）
     * @return:String	返回openId
     */
    public String getWeixinOpenInfo(String code, String appId, String appSecurity) {
        RestTemplate rest = new RestTemplate();
        StringBuilder sb = new StringBuilder(weixinUrl);
        sb.append(appId).append("&secret=").append(appSecurity);
        sb.append("&js_code=").append(code).append("&grant_type=authorization_code");
        //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        String json = rest.getForObject(sb.toString(), String.class);
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(json);
            if (root.has("errcode")) {
                log.warn("获取OpenId失败，code:{},errcode:{}, errmsg:{}", code, root.get("errcode").intValue(), root.get("errmsg").textValue());
            } else {
                JsonNode node = root.get("openid");
                if (null != node) {
                    return node.textValue();
                }
            }
        } catch (Exception e) {
            log.warn("调用微信小程序获取openid失败：{}", e);
        }
        return null;
    }
}
