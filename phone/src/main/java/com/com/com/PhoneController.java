package com.com.com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.PhoneService;

@Controller
public class PhoneController {

	@Autowired
	PhoneService service;
	
//	@RequestMapping(value= {"/", "list"})
//	public ModelAndView list(ModelAndView mv) {
//		List<Map<String,Object>> list = service.list();
//		mv.addObject("list", list);
//		mv.setViewName("list");
//		return mv;
//	}
	
//	@RequestMapping(value= {"/", "list"})
//	public ModelAndView list(ModelAndView mv,@RequestParam Map<String,Object> map) {
//		List<Map<String,Object>> list = service.list(map);
//		mv.addObject("list", list);
//		mv.setViewName("list");
//		return mv;
//	}
	
	@RequestMapping(value= {"/", "list"})
	public ModelAndView list(ModelAndView mv,@RequestParam Map<String,Object> map) {
		if(map.get("pageNo") == null) {
			map.put("pageNo",1);
		}
		
		map.put("listSize", 5);
		int pg = Integer.parseInt(map.get("pageNo").toString());
		int BLOCK = 5;
		
		int startPage = ((pg-1)/BLOCK*BLOCK)+1; 
		int endPage = ((pg-1)/BLOCK*BLOCK)+BLOCK;

		map.put("startPage", startPage);
		map.put("endPage", endPage);

		int total = (int)Math.ceil((double)service.totalRowCount()/10) ;
		map.put("total", total);
		
		
		List<Map<String,Object>> list = service.list(map);
		mv.addObject("searchMap",map);
		mv.addObject("list", list);
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping(value="insertf")
	public ModelAndView insertf(ModelAndView mv) {
		mv.setViewName("insertf");
		return mv;
	}
	
	@RequestMapping(value="insert")
	public ModelAndView insert(ModelAndView mv, @RequestParam Map<String,Object> map) {
		int insert = service.insert(map);
		mv.setViewName("redirect:list");
		return mv;
	}
	
	@RequestMapping(value="updatef")
	public ModelAndView updatef(ModelAndView mv, @RequestParam int seq) {
		Map<String,Object> detail = service.detail(seq);
		mv.addObject("detail", detail);
		mv.setViewName("insertf");
		return mv;
	}
	
	@RequestMapping(value="update")
	public ModelAndView update(ModelAndView mv, @RequestParam Map<String, Object> map) {
		System.out.println("this is map :::::::::::::::" + map);
		int update = service.update(map);
		mv.setViewName("redirect:list");
		return mv;
	}
	
	@RequestMapping(value="delete")
	public ModelAndView delete(ModelAndView mv, Integer[] chk) {
		List<Integer> list = Arrays.asList(chk);
		System.out.println("this is chk ::::::::::" + chk);
		System.out.println("this is list :::::::::::" + list);
		int delete = service.delete(list);
		mv.setViewName("redirect:list");
		return mv;
	}
}
