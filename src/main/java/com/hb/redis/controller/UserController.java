package com.hb.redis.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hb.redis.model.User;
import com.hb.redis.service.user.UserService;
import com.hb.redis.util.commonUtil.StringUtil;

/**
 * 控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	UserService userService;

	private static Log log = LogFactory.getLog(UserController.class);

	/**
	 * index --list
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return "/views/user/index";
	}

	/**
	 * list method
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		int start = ServletRequestUtils.getIntParameter(request, "page", 1) - 1;
//		int size = ServletRequestUtils.getIntParameter(request, "rows", 0);
//		String name = ServletRequestUtils.getStringParameter(request, "name",
//				"");
//		String order = StringUtil.getOrderString(request); // 取得排序参数
//
//		String result = null;
//		try {
//			result = userService.list(name, start, size, order);
//		} catch (Exception e) {
//			if (log.isErrorEnabled()) {
//				log.error("查询列表失败", e);
//			}
//			result = "";
//		}
//		String sortName = ServletRequestUtils.getStringParameter(request,
//				"sort", "");
//		String sortOrder = ServletRequestUtils.getStringParameter(request,
//				"order", "");
//		Map<String, Object> searchMap = new HashMap<String, Object>();
//		searchMap.put("pageNumber", start + 1);
//		searchMap.put("rows", size);
//		searchMap.put("sortName", sortName);
//		searchMap.put("sortOrder", sortOrder);
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		String s = gson.toJson(searchMap);
//		s = URLEncoder.encode(s, "UTF-8");
//
//		StringUtil.writeToWeb(result, "html", response);
		
//		int page = 1; //页号
//		int pageSize = 20; //每页数据条数
//		String sortString = "age.asc,gender.desc";//如果你想排序的话逗号分隔可以排序多列
//		PageBounds pageBounds = new PageBounds(page, pageSize , Order.formString(sortString));
//		List list = findByCity("BeiJing",pageBounds);
//		 
//		//获得结果集条总数
//		PageList pageList = (PageList)list;
//		System.out.println("totalCount: " + pageList.getPaginator().getTotalCount());
		return null;
	}

	/**
	 * gotoAdd --page
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(value = "/gotoAdd")
//	public String gotoAdd(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		return "views/user/add";
//	}

//	/**
//	 * add --method
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/add")
//	public String add(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		String result = null;
//		Userinfo userinfo = (Userinfo) StringUtil.requestToObject(request,
//				Userinfo.class);
//		Userinfo dbUserinfo = userService.getUserByName(userinfo.getName());
//		if (dbUserinfo != null) {
//			result = "{\"success\":false,\"msg\":\"名称已存在！\"}";
//			StringUtil.writeToWeb(result, "html", response);
//			return null;
//		}
//		try {
//			if (userinfo.getName().trim().length() < 0) {
//				result = "{\"success\":false,\"msg\":\"名称不能为空！\"}";
//				StringUtil.writeToWeb(result, "html", response);
//				return null;
//			} else if (null == userinfo.getAge()) {
//				result = "{\"success\":false,\"msg\":\"年龄参数有误！\"}";
//				StringUtil.writeToWeb(result, "html", response);
//				return null;
//			} else {
//				result = userService.save(userinfo);
//			}
//		} catch (Exception e) {
//			if (log.isErrorEnabled()) {
//				log.error("新增失败", e);
//			}
//			result = "{\"success\":false,\"msg\":\"系统错误，请稍候再试！\"}";
//		}
//		StringUtil.writeToWeb(result, "html", response);
//		return null;
//	}

//	/**
//	 * gotoModify --page
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/gotoModify")
//	public String gotoModify(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		Integer id = ServletRequestUtils.getIntParameter(request, "id");
//		Userinfo userinfo = userService.get(Userinfo.class, id);
//		request.setAttribute("userinfo", userinfo);
//		return "views/user/modify";
//	}

//	/**
//	 * modify --method
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/modify")
//	public String modify(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		Integer id = ServletRequestUtils.getIntParameter(request, "id");
//		Userinfo dbUserinfo = userService.get(Userinfo.class, id);
//		Userinfo userinfo = (Userinfo) StringUtil.requestToObject(request,
//				Userinfo.class);
//		String result;
//		if (!dbUserinfo.getName().equals(userinfo.getName())) {
//			Userinfo hasUserinfo = userService
//					.getUserByName(userinfo.getName());
//			if (hasUserinfo != null) {
//				result = "{\"success\":false,\"msg\":\"角色名称已存在！\"}";
//				StringUtil.writeToWeb(result, "html", response);
//				return null;
//			}
//		}
//		try {
//			result = userService.update(request, userinfo, id);
//		} catch (Exception e) {
//			if (log.isErrorEnabled()) {
//				log.error("修改失败", e);
//			}
//			result = "{\"success\":false,\"msg\":\"系统错误，请稍候再试！\"}";
//		}
//		StringUtil.writeToWeb(result, "html", response);
//		return null;
//	}

//	/**
//	 * delete --method
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/delete")
//	public String delete(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		Integer id = ServletRequestUtils.getIntParameter(request, "id");
//
//		try {
//			if (null != id) {
//				userService.delete(id);
//			}
//			String result = "{\"success\":true,\"msg\":\"删除成功\"}";
//			StringUtil.writeToWeb(result, "html", response);
//			return null;
//		} catch (Exception e) {
//			if (log.isErrorEnabled()) {
//				log.error("删除失败", e);
//			}
//			String result = "{\"success\":false,\"msg\":\"删除失败，请稍候再试！\"}";
//			StringUtil.writeToWeb(result, "html", response);
//			return null;
//		}
//	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}