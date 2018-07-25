package com.xu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.log.LogFactory;
import com.xu.entity.Commodities;
import com.xu.service.AccessoryService;
import com.xu.service.CommoditiesService;

@Controller
@RequestMapping("/commodities")
public class CommoditiesController extends BaseController{

	@Autowired
	CommoditiesService commoditiesService;
	
	@Autowired
	AccessoryService accessoryService;
	
	// 创建日志对象  用于记录删除数量的
	Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	
	@RequestMapping("delete.action")
	public String delete(Model model, Commodities commodities) {
		commoditiesService.deleteById(commodities.getFruitId());
		int number = accessoryService.deleteByFruitId(commodities.getFruitId());
		log.info("delete fruitId=" + commodities.getFruitId() + "'s accessorys number: " + number);
		// 重新查询原来页面的列表
		Commodities queryCommodities = new Commodities();
		queryCommodities.setCurrentPage(commodities.getCurrentPage());
		queryCommodities.setPageSize(commodities.getPageSize());
		queryCommodities.setStartPage(commodities.getStartPage());
		return toList(model, queryCommodities, 0.0, 0.0, null, null); 
	}
	
	/**
	 * 处理添加货物请求
	 * @param model
	 * @param commodities
	 * @return
	 */
	@RequestMapping("/add.action")
	public String add(Model model, Commodities commodities){
		commodities.setFruitId(UUID.randomUUID().toString());
		commodities.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		commoditiesService.insert(commodities);
		// 列表首页重新刷新
		return toList(model, new Commodities(), 0.0, 0.0, null, null);
	}
	
	/**
	 * 处理前端修改货物信息之后的修改请求
	 * @param model
	 * @param commodities
	 * @return
	 */
	@RequestMapping("/edit.action")
	public String edit(Model model, Commodities commodities) {
		commoditiesService.update(commodities);
		// 构建新的查询条件  只需要分页数据
		Commodities queryCommodities = new Commodities();
		queryCommodities.setStartPage(commodities.getStartPage());
		queryCommodities.setCurrentPage(commodities.getCurrentPage());
		queryCommodities.setPageSize(commodities.getPageSize());
		return toList(model, queryCommodities, 0.0, 0.0, null, null);  
	}
	
	/**
	 * 处理前端的阿ajax请求
	 * 查找单个商品信息  返回给前端进行编辑  
	 * @param json
	 * @return
	 */
	@RequestMapping("/editCommodities.action")
	public @ResponseBody Commodities editCommodities(@RequestBody String json) {
		String id = JSONObject.parseObject(json).getString("id");
		// @ResponseBody jiangCommodities转换为json格式输出
		return commoditiesService.get(id);
	}
	
	/**
	 * 跳转至货物信息列表页面
	 * @return
	 */
	@RequestMapping("/toList.action")
	public String toList(Model model, Commodities commodities, @RequestParam(defaultValue="0.0") double startPrice, @RequestParam(defaultValue="0.0") double endPrice, String startTime, String endTime) {
		Map<String, Object> map = this.commoditiesToMap(commodities);
		if (startTime != null && !startTime.equals("")) {
			map.put("startTime", startTime);
		}
		if (endTime != null && !startTime.equals("")) {
			map.put("endTime", endTime);
		}
		if (startPrice > 0.0) {
			map.put("startPrice", startPrice);
		}
		if (endPrice > 0.0) {
			map.put("endPrice", endPrice);
		}
		List<Commodities> commoditiesList = commoditiesService.find(map);
		model.addAttribute("commodities", commodities);  // 搜索条件回显
		model.addAttribute("startPrice", startPrice);  // 价格区间回显
		model.addAttribute("endPrice", endPrice);
		model.addAttribute("startTime", startTime);  // 时间区间回显
		model.addAttribute("endTime", endTime);
		model.addAttribute("list", commoditiesList.size() < 0 ? null : commoditiesList);  // 结果结合
		model.addAttribute("currentPage", commodities.getCurrentPage());   // 当前页数
		model.addAttribute("startPage", commodities.getStartPage());  // 当前请求位置  默认为0
		int countNumber = commoditiesService.count(map);
		model.addAttribute("count", countNumber);  // 结果总数
		int pageSize = commodities.getPageSize();
		int sumPageNumber = countNumber % pageSize == 0 ? (countNumber / pageSize) : ((countNumber / pageSize) + 1);
		model.addAttribute("sumPageNumber", sumPageNumber);  // 总页数
		return "/commodities/commoditiesHome.jsp"; // 转向货物信息首页
	}
	
	private Map<String, Object> commoditiesToMap(Commodities commodities) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", checkStringIsEmpty(commodities.getName()));
		map.put("locality", checkStringIsEmpty(commodities.getLocality()));
		map.put("createTime", checkStringIsEmpty(commodities.getCreateTime()));
		map.put("startPage", commodities.getStartPage());
		map.put("pageSize", commodities.getPageSize());
		return map;
	}
	
	private String checkStringIsEmpty(String param) {
		return param == null ? null : (param.equals("") ? null : "%" + param + "%");  // 此处加上%是为了sql语句中like关键字服务
	}
	
}
