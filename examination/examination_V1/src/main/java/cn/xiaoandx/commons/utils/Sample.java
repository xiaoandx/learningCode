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

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.baidu.aip.face.AipFace;

/**  
 * <p> 
 *	人脸识别
 * </p> 
 * @ClassName:Sample   
 * @author: WEI.ZHOU
 * @date: 2020-12-08 13:31
 * @since: JDK1.8
 * @version V1.0
 * @Copyright: Note: This prohibition leaks and for other commercial projects
 */
@Service
public class Sample {

    //client  AipFace对象
    private static AipFace client = null;
    //APPID
    public static final String APP_ID = "16217652";
    //API_KEY
    public static final String API_KEY = "MPN1dX5pOdxby9Gfaq5z7Ofb";
    //SECRET_KEY
    public static final String SECRET_KEY = "jCF9pHZLnhPRNPnwwDxGR32mEBbrxZh3";
	//GROUP_ID
    public static final String GROUP_ID = "xiaox_exam";

    
    static {
    	getAipFace();
    }
    
    /**
     *<p>获取 AipFace对象</p> 
     * @Title: getAipFace    
     * @version:V2.0     
     * @return:AipFace	aip对象aipface
     */
    public static AipFace getAipFace() {
    	client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    	client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    	return client;
    }
    
    
    /**
     *<p>人脸注册</p> 
     * @Title: faceRe    
     * @version:V2.0     
     * @param imageBase64	传入base64照片数据
     * @return:String	返回openId
     */
    public static String faceRe(String imageBase64) {
    	// 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        
        String imageType = "BASE64";
        String groupId = GROUP_ID;
        String userId = IdAndTimeUtil.getQuestionId();
        
        // 人脸注册
        JSONObject res = client.addUser(imageBase64, imageType, groupId, userId, options);
        /**
         	* 直接获取的值face_token
         */
        System.out.println(res.toString(2));
        JSONObject result = res.getJSONObject("result");
        String[]  opedId = JSONObject.getNames(result);
        
        return (String) result.get(opedId[0]);

    }
    
    
    /**
     *<p>人脸检测</p> 
     * @Title: searchFace    
     * @version:V2.0     
     * @param imageBase64	传入base64照片数据
     * @return:String		对比检测数据字符串
     */
    public static String searchFace(String imageBase64) {
    	// 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "NONE");
        
        String image = imageBase64;
        String imageType = "BASE64";
        String groupIdList = GROUP_ID;
        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);
        return res.toString(2);
    }
    
}
