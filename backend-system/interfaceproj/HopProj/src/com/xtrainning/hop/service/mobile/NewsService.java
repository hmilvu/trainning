package com.xtrainning.hop.service.mobile;
import org.springframework.beans.factory.annotation.Autowired;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.xtrainning.hop.common.Constants;
import com.xtrainning.hop.request.mobile.GetNewsListRequest;
import com.xtrainning.hop.resolver.NewsResolver;
import com.xtrainning.hop.response.mobile.NewsListResponse;

@ServiceMethodBean
public class NewsService extends MobileBaseService{
	@Autowired private NewsResolver newsResolver;

	@ServiceMethod(method = "news.getNewsList",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getNewsList(GetNewsListRequest request) {
		NewsListResponse response = newsResolver.getNewsList(checkPageInfo(request));
        return response;
	}
	
	private GetNewsListRequest checkPageInfo(GetNewsListRequest request){
		if(request.getPageNumber() == null || request.getPageNumber() <= 0){
			request.setPageNumber(1);
		} 
		if(request.getPageSize() == null || request.getPageSize() <= 0 || request.getPageSize() > 100){
			request.setPageSize(Constants.DEFAULT_PAGE_SIZE);
		}
		return request;
	}
}
