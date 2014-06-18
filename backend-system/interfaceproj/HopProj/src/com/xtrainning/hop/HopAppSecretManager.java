package com.xtrainning.hop; /**
 * 版权声明：中国电信号百信息服务有限公司 版权所有 违者必究 2013 
 * 日    期：135-25
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.rop.security.AppSecretManager;
import com.xtrainning.hop.common.Constants.CLIENT_APPKEY_STATUS;
import com.xtrainning.hop.entity.ClientAppkey;
import com.xtrainning.hop.resolver.ClientAppkeyResolver;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 张志鹏
 * @version 1.0
 */
public class HopAppSecretManager implements AppSecretManager {
	@Autowired
    private ClientAppkeyResolver clientAppkeyResolver;
    
    private static Map<String, String> appKeySecretMap = new HashMap<String, String>();

	@Override
    public boolean isValidAppKey(String appKey) {
        return getSecret(appKey) != null;
    }
	
    @Override
    public String getSecret(String appKey) {
    	if(appKeySecretMap.isEmpty()){
    		loadAppKey();
    	}
        return appKeySecretMap.get(appKey);
    }
	
    private void loadAppKey() {
		List<ClientAppkey> list = clientAppkeyResolver.findAllClientAppkey();
		for(ClientAppkey client : list){
			if(StringUtils.isNotBlank(client.getSecretKey()) && client.getStatus().intValue() == CLIENT_APPKEY_STATUS.ACTIVE.getValue()){
				appKeySecretMap.put(client.getAppKey(), client.getSecretKey());
			}
		}		
	}
}

