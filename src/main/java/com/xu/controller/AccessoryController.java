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
import org.springframework.web.bind.annotation.RequestMapping;

import com.xu.entity.Accessory;
import com.xu.service.AccessoryService;

@Controller
@RequestMapping("/accessory")
public class AccessoryController {

	@Autowired
	AccessoryService accessoryService;
	
	/**
	 * 根据条件显示  并返回附属品首页
	 * @param model
	 * @param accessory
	 * @return
	 */
	@RequestMapping("/toList.action")
	public String toList(Model model, Accessory accessory) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fruitId", accessory.getFruitId());
		List<Accessory> accessoryList = accessoryService.find(map);
		model.addAttribute("fruitId", accessory.getFruitId());
		model.addAttribute("list", accessoryList);
		// 计算附属品总价并封装至model中
		model.addAttribute("sumPrice", SumPrice(accessoryList));
		return "/accessory/accessoryHome.jsp"; // 转向首页
	}
	private double SumPrice(List<Accessory> accessoryList) {
		double sum = 0;
		for(Accessory a : accessoryList) {
			sum += a.getPrice();
		}
		return sum;
	}
	
	/**
	 * 添加附属品
	 * @param model
	 * @param accessory
	 * @return
	 */
	@RequestMapping("/add.actin")
	public String add(Model model, Accessory accessory) {
		accessory.setAccessoryId(UUID.randomUUID().toString());
		accessory.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		accessoryService.insert(accessory);
		// 重新刷新列表
		return toList(model, accessory);
	}
	
	/**
	 * 根据id删除一个附属品
	 * @param model
	 * @param accessory
	 * @return
	 */
	@RequestMapping("/delete.action")
	public String delete(Model model, Accessory accessory) {
		accessoryService.deleteById(accessory.getAccessoryId());
		// 重新刷新列表
		return toList(model, accessory);
	}
	
	/**
	 * 批量删除附属品
	 * @param model
	 * @param arrays
	 * @param accessory
	 * @return
	 */
	@RequestMapping("/deleteList.action")
	public String deleteList(Model model, String[] arrays, Accessory accessory) {
		accessoryService.delete(arrays);
		return toList(model, accessory);
	}
	
	// 未完待续。。。
}
