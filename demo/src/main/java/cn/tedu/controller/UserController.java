package cn.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.pojo.User;
import com.jt.common.vo.EasyUIResult;

import cn.tedu.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	// 新增商品
	@RequestMapping("/user/add")
	public String add(User user) {
		// 使用异常信息来表示成功和失败
		try {
			userService.useradd(user);
			// 没有出现异常，返回ok
			return "新增用户成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "新增用户失败";
		}
	}

	// 删除单个商品
	@RequestMapping("/user/delete")
	public String delete(String name) {
		// 使用异常信息来表示成功和失败
		try {
			userService.userdelete(name);
			// 没有出现异常，返回ok
			return "删除用户成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "删除用户失败";
		}
	}

	// 更新单个商品
	@RequestMapping("/user/update")
	public String update(User user) {
		// 使用异常信息来表示成功和失败
		try {
			userService.userupdate(user);
			// 没有出现异常，返回ok
			return "更新用户成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "更新用户失败";
		}
	}

	// 查看所有商品,分页page:页数     rows:用户数
	@RequestMapping("/user/query")
	public EasyUIResult query(Integer page, Integer rows) {
		// 使用异常信息来表示成功和失败
		try {
			EasyUIResult result = userService.userquery(page, rows);
			// 没有出现异常，返回ok
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
