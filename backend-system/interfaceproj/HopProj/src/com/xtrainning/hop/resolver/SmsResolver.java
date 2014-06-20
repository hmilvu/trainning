package com.xtrainning.hop.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.common.Constants.SMS_STATUS;
import com.xtrainning.hop.dao.MemberSmsHistoryDAO;
import com.xtrainning.hop.entity.MemberSmsHistory;
@Service
public class SmsResolver {
	private static final Logger log = LoggerFactory.getLogger(SmsResolver.class);
	@Autowired private MemberSmsHistoryDAO memberSmsHistoryDao;
	public void sendVcode(MemberSmsHistory msg) {
		msg.setStatus(SMS_STATUS.SENT_SUCCESS.getValue());
		memberSmsHistoryDao.update(msg);
		
//		SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor("sms");
//		executor.setConcurrencyLimit(-1);
//	    executor.execute(new SendMessageThread(msg), 40000L);		
	}

	class SendMessageThread implements Runnable {
		private MemberSmsHistory msg;
		public SendMessageThread(MemberSmsHistory msg){
			this.msg = msg;
		}
        public void run() {
        	try {
				Thread.sleep(2 * 1000L);
			} catch (InterruptedException e) {
				log.error("SendMessageThread sleep error");
			}
        	//TODO: 发送短信
        }
	}
}
