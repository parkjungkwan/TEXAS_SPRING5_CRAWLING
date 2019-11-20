package com.wego.web.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.pxy.Box;
import com.wego.web.pxy.CrawlingProxy;
import com.wego.web.pxy.Inventory;
import com.wego.web.pxy.PageProxy;
@RestController
@RequestMapping("/crawls")
public class CrawlController {
	@Autowired CrawlingProxy crawler;
	@Autowired PageProxy pager;
	@Autowired Box<Object> box;
	@GetMapping("/naver")
	public ArrayList<HashMap<String, String>> naver() {
		return crawler.engCrawling("https://endic.naver.com/?sLn=kr");
	}
	@GetMapping("/cgv")
	public ArrayList<HashMap<String, String>> cgv() {
		System.out.println("cgv");
		return crawler.cgvCrawl();
	}
	@GetMapping("/bugs")
	public Map<?,?> bugs() {
		System.out.println("bugs");
		ArrayList<HashMap<String, String>> list = crawler.bugsCrawling();
		pager.setRowCount(list.size());
		pager.setPageSize(5);
		pager.setBlockSize(5);
		pager.setNowPage(0);
		pager.paging();
		ArrayList<HashMap<String, String>> temp = new ArrayList<>();
		for(int i=0;i< list.size(); i++) {
			if(i >= pager.getStartRow() && i <= pager.getEndRow() ) {
				temp.add(list.get(i));
			}
			if(i > pager.getEndRow()) {break;}
		}
		box.put("pager", pager);
		box.put("list", temp);
		
		return box.get();
	}
}
