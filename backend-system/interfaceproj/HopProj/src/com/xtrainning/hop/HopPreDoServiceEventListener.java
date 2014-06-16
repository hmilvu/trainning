/**
 * 版权声明：中国电信号百信息服务有限公司 版权所有 违者必究 2013 
 * 日    期：137-17
 */
package com.xtrainning.hop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rop.MessageFormat;
import com.rop.RopRequest;
import com.rop.RopRequestContext;
import com.rop.event.PreDoServiceEvent;
import com.rop.event.RopEventListener;
import com.rop.marshaller.MessageMarshallerUtils;
import com.xtrainning.hop.resolver.AccessLogResolver;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 张志鹏
 * @version 1.0
 */
public class HopPreDoServiceEventListener implements RopEventListener<PreDoServiceEvent> {
	private static final Logger log = LoggerFactory.getLogger(HopPreDoServiceEventListener.class);
	@Autowired
	private AccessLogResolver logResolver;
    @Override
    public void onRopEvent(PreDoServiceEvent ropEvent) {
        RopRequestContext ropRequestContext = ropEvent.getRopRequestContext();
        if(ropRequestContext != null && ropRequestContext.getRopRequest() != null){
            RopRequest ropRequest = ropRequestContext.getRopRequest();
            String message = MessageMarshallerUtils.getMessage(ropRequest, MessageFormat.json);
            log.info("request:" + message);
           /* AccessLog accessLog = new AccessLog();
            accessLog.setAppkey(ropRequestContext.getAppKey());
            accessLog.setIp(ropRequestContext.getIp());
            accessLog.setMethod(ropRequestContext.getMethod());
            if (message != null && message.length() > 1900) {
            	message = message.substring(0,1900);
            }
            accessLog.setMessage(message);
            accessLog.setType(ACCESS_LOG_TYPE.REQUEST.getValue());
            accessLog.setCreateTime(new Timestamp(ropEvent.getServiceBeginTime()));
            logResolver.save(accessLog);*/
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

