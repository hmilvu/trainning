/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-6-7
 */
package com.xtrainning.hop.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rop.request.RopConverter;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@Component
public class DateConverter implements RopConverter<String, Date> {
	private static final String YYYY_MM_DD_HH24_MI_SS = "yyyy-MM-dd HH:mm:ss";
	private static final Logger log = LoggerFactory.getLogger(DateConverter.class);
    @Override
    public Date convert(String source) {
        if (StringUtils.hasText(source)) {
            SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH24_MI_SS);
            Date date = null;
			try {
				date = format.parse(source);
			} catch (ParseException e) {
				log.error("日期格式非法 source date = " + source, e);
			}
            return date;
        } else {
            return null;
        }
    }

    @Override
    public String unconvert(Date target) {
    	if(target == null) {
    		return "";
    	}
    	SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH24_MI_SS);
    	String dateStr = format.format(target);
        return dateStr;
    }

    @Override
    public Class<String> getSourceClass() {
        return String.class;
    }

    @Override
    public Class<Date> getTargetClass() {
        return Date.class;
    }
}

