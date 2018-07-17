package com.xu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xu.entity.Retailer;
import com.xu.service.RetailerService;

@Controller
@RequestMapping("/retailer")
public class RetailerControler extends BaseController {

	@Autowired
	RetailerService retailerService;

	@RequestMapping("/add.action")
	public String add(Model model, Retailer retailer) {
		retailer.setRetailerId(UUID.randomUUID().toString());
		retailer.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		retailerService.insert(retailer);
		// 构建新的列表查询条件 只需要状态即可
		Retailer queryRetailer = new Retailer();
		queryRetailer.setStatus(-1);
		return toList(model, queryRetailer, null, null);
	}
	
	/**
	 * 删除零售商 硬删除
	 * @param model
	 * @param retailer
	 * @return
	 */
	@RequestMapping("/delete.action")
	public String delete(Model model, Retailer retailer) {
		retailerService.deleteById(retailer.getRetailerId());
		// 构建新的列表查询条件， 只需要分页数据
		Retailer queryRetailer = new Retailer();
		queryRetailer.setStartPage(retailer.getStartPage());
		queryRetailer.setCurrentPage(retailer.getCurrentPage());
		queryRetailer.setPageSize(retailer.getPageSize());
		queryRetailer.setStatus(-1);
		return toList(model, queryRetailer, null, null);
	}
	
	/**
	 * 更新
	 * @param model
	 * @param retailer
	 * @return
	 */
	@RequestMapping("/edit.action")
	public String edit(Model model, Retailer retailer) {
		retailerService.update(retailer);
		// 构建新的列表查询条件， 只需要分页数据
		Retailer queryRetailer = new Retailer();
		queryRetailer.setStartPage(retailer.getStartPage());
		queryRetailer.setCurrentPage(retailer.getCurrentPage());
		queryRetailer.setPageSize(retailer.getPageSize());
		queryRetailer.setStatus(-1);
		return toList(model, queryRetailer, null, null);
	}
	
	/**
	 * 编辑
	 * @param json
	 * @return
	 */
	@RequestMapping("/editRetailer.action")
	public @ResponseBody Retailer editRetailer(@RequestBody String json) {
		String id = JSONObject.parseObject(json).getString("id");
		// @ResponseBody将Retailer转换成json格式输出
		return retailerService.get(id);
	}
	/**
	 *  跳转至列表界面
	 * @param model
	 * @param retailer
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("/toList.action")
	public String toList(Model model, Retailer retailer, String startTime, String endTime) {
		Map<String, Object> map = retailerToMap(retailer);
		if (startTime != null && !startTime.equals("")) {
			map.put("startTime", startTime);
		}
		if (endTime != null && !endTime.equals("")) {
			map.put("endTime", endTime);
		}
		List<Retailer> list = retailerService.find(map);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", retailer.getCurrentPage()); //当前页数
		model.addAttribute("startPage", retailer.getStartPage()); // 当前请求位置 默认为0，即首页
		int countNumber = retailer.getPageSize();
		model.addAttribute("countNumver", countNumber); // 数据总和
		int pageSize = retailer.getPageSize();
		model.addAttribute("pageSize", pageSize); // 每页的数据数  默认为10
		int sumPageNumaber = countNumber % pageSize == 0 ? (countNumber / pageSize) : ((countNumber / pageSize) + 1);
		model.addAttribute("sumPageNumber", sumPageNumaber);  // 总页数
		return "/retailer/retailerHome.jsp";
	}
	
	private Map<String, Object> retailerToMap(Retailer retailer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", checkStringIsEmpty(retailer.getName()));
		map.put("telephone", checkStringIsEmpty(retailer.getTelephone()));
		map.put("address", checkStringIsEmpty(retailer.getAddress()));
		map.put("status", retailer.getStatus() == -1 ? null : retailer.getStatus());
		map.put("createTime", checkStringIsEmpty(retailer.getCreateTime()));
		map.put("startPage", retailer.getStartPage());
		map.put("pageSize", retailer.getPageSize());
		return map;
	}
	
	private String checkStringIsEmpty(String param) {
		return param == null ? null : (param.equals("") ? null : "%" + param + "%");  // 此处加上%是为了sql语句中like关键字服务
	}
}
