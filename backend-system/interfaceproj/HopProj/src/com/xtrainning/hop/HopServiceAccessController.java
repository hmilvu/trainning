/**
 * 版权声明：中国电信号百信息服务有限公司 版权所有 违者必究 2013 
 * 日    期：135-25
 */
package com.xtrainning.hop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.rop.security.ServiceAccessController;
import com.rop.session.Session;
import com.xtrainning.hop.resolver.AccessPrivilegeResolver;
import com.xtrainning.hop.resolver.ClientAppkeyResolver;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 张志鹏
 * @version 1.0
 */
public class HopServiceAccessController implements ServiceAccessController {

	private static final Map<String, List<String>> aclMap = new HashMap<String, List<String>>();
    @Autowired
	private AccessPrivilegeResolver accessPrivilegeResolver;
    
    @Autowired
    private ClientAppkeyResolver clientAppkeyResolver;

    @Override
    public boolean isAppGranted(String appKey, String method, String version) {
    	return true;
    	/*if(aclMap.isEmpty()){
    		loadPrivilege();
    	}
        if(aclMap.containsKey(appKey)){
            List<String> serviceMethods = aclMap.get(appKey);
            boolean access = serviceMethods.contains(method);
            return access;
        }else{
            return false;
        }*/
    }

    private void loadPrivilege() {
    	/*List<ClientAppkey> list = clientAppkeyResolver.findAllClientAppkey();
		for(ClientAppkey appkey : list){
			if(appkey.getStatus().intValue() == CLIENT_APPKEY_STATUS.ACTIVE.getValue()){
				List<AccessPrivilege> privilegeList = accessPrivilegeResolver.findClientPrivilege(appkey.getAppkey());
				List<String> serviceMethods = new ArrayList<String>();
				for(AccessPrivilege privilege : privilegeList){		
					serviceMethods.add(privilege.getMethod());
				}
				aclMap.put(appkey.getAppkey(), serviceMethods);
			}
		}	*/	
	}

	@Override
    public boolean isUserGranted(Session session, String method, String version) {
        return true;
    }
}

