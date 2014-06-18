/**
 * 版权声明：中国电信号百信息服务有限公司 版权所有 违者必究 2013 
 * 日    期：136-2
 */
package com.xtrainning.hop;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rop.MessageFormat;
import com.rop.RopRequestContext;
import com.rop.event.AfterDoServiceEvent;
import com.rop.event.RopEventListener;
import com.rop.marshaller.MessageMarshallerUtils;
import com.xtrainning.hop.common.Constants.ACCESS_LOG_TYPE;
import com.xtrainning.hop.entity.AccessLog;
import com.xtrainning.hop.resolver.AccessLogResolver;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 张志鹏
 * @version 1.0
 */
public class HopAfterDoServiceEventListener implements RopEventListener<AfterDoServiceEvent> {
	private static final Logger log = LoggerFactory.getLogger(HopAfterDoServiceEventListener.class);
	@Autowired
	private AccessLogResolver logResolver;
    @Override
    public void onRopEvent(AfterDoServiceEvent ropEvent) {
        RopRequestContext ropRequestContext = ropEvent.getRopRequestContext();
        if(ropRequestContext != null && ropRequestContext.getRopRequest() != null){
            String message = MessageMarshallerUtils.getMessage(ropRequestContext.getRopResponse(), MessageFormat.json);
            log.info("response:" + message);
            AccessLog accessLog = new AccessLog();
            accessLog.setAppkey(ropRequestContext.getAppKey());
            accessLog.setIp(ropRequestContext.getIp());
            accessLog.setMethod(ropRequestContext.getMethod());
            if (message != null && message.length() > 2000) {
            	message = message.substring(0,2000);
            }
            accessLog.setMessage(message);
            accessLog.setType(ACCESS_LOG_TYPE.RESPONSE.getValue());
            accessLog.setCreateTime(new Timestamp(ropEvent.getServiceBeginTime()));
            logResolver.save(accessLog);
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

