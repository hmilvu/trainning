package com.xtrainning.hop.resolver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.dao.NewsDAO;
import com.xtrainning.hop.entity.News;
import com.xtrainning.hop.request.mobile.GetNewsListRequest;
import com.xtrainning.hop.response.mobile.NewsListResponse;
import com.xtrainning.hop.response.mobile.NewsResponse;
@Service
public class NewsResolver extends BaseResolver{

	@Autowired private NewsDAO newsDao;

	public NewsListResponse getNewsList(GetNewsListRequest request) {
		List<News> list = newsDao.getNews(request);
		List<NewsResponse> responseList = new ArrayList<NewsResponse>();
		for(News news : list){
			NewsResponse response = news.toResponse();
			responseList.add(response);
		}
		NewsListResponse response = new NewsListResponse();
		response.setNewsList(responseList);
		return response;
	}
}
