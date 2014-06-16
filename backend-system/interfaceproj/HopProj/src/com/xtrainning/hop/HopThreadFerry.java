/**
 * 版权声明：中国电信号百信息服务有限公司 版权所有 违者必究 2013 
 * 日    期：137-20
 */
package com.xtrainning.hop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rop.ThreadFerry;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 张志鹏
 * @version 1.0
 */
public class HopThreadFerry implements ThreadFerry{
	private static final Logger log = LoggerFactory.getLogger(HopThreadFerry.class);
	
    @Override
    public void doInSrcThread() {
    	log.info("doInSrcThread:"+Thread.currentThread().getId());
    }

    @Override
    public void doInDestThread() {
    	log.info("doInSrcThread:"+Thread.currentThread().getId());
    }
}

