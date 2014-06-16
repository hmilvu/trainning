package com.xtrainning.hop.service.mobile;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import org.junit.Test;

import com.rop.MessageFormat;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.xtrainning.hop.common.Constants.METHOD;
import com.xtrainning.hop.request.mobile.GetMemberIdRequest;
import com.xtrainning.hop.request.mobile.GetNewsListRequest;
import com.xtrainning.hop.response.mobile.MemberIdResponse;
import com.xtrainning.hop.response.mobile.NewsListResponse;

public class NewsServiceTest extends TestCase{
    public static final String SERVER_URL = "http://localhost:8080/hop/service";
    public static final String APP_KEY = "iphone_user";
    public static final String APP_VERSION = "V0.5.0.0";
    public static final String APP_SECRET = "b3rl8DPBrc0ka4wxhisVrT4nMUL2Crtk";
    private static DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET);
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testGetNewsList() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	GetNewsListRequest ropRequest = new GetNewsListRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setMemberId(1L);
        ropRequest.setPageNumber(1);
        ropRequest.setPageSize(10);
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, NewsListResponse.class, METHOD.GET_NEWS_LIST.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof NewsListResponse);
	}
}
