package com.xtrainning.hop.service.mobile;
import java.util.ArrayList;
import java.util.List;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.xtrainning.hop.request.mobile.GetNewsListRequest;
import com.xtrainning.hop.response.mobile.NewsListResponse;
import com.xtrainning.hop.response.mobile.NewsResponse;

@ServiceMethodBean
public class NewsService extends MobileBaseService{
//	@Autowired private MemberResolver memberResolver;

	@ServiceMethod(method = "news.getNewsList",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getNewsList(GetNewsListRequest request) {
//		Member m = memberResolver.fetchMemberByUUID(request);
//		MemberIdResponse response = new MemberIdResponse();
//		response.setMemberId(m.getId());
		NewsListResponse response = new NewsListResponse();
		List<NewsResponse> list = new ArrayList<NewsResponse>();
		NewsResponse r = new NewsResponse();
		r.setNewId(1L);
		NewsResponse r1 = new NewsResponse();
		r.setNewId(2L);
		list.add(r);
		list.add(r1);
		response.setNewsList(list);
        return response;
	}
	
}
