/**
 * 版权声明：中国电信号百信息服务有限公司 版权所有 违者必究 2013 
 * 日    期：136-2
 */
package com.xtrainning.hop;

import com.rop.event.AfterStartedRopEvent;
import com.rop.event.RopEventListener;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 张志鹏
 * @version 1.0
 */
public class HopPostInitializeEventListener implements RopEventListener<AfterStartedRopEvent> {

    @Override
    public void onRopEvent(AfterStartedRopEvent ropRopEvent) {
//        System.out.println("execute BopPostInitializeEventListener!");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

