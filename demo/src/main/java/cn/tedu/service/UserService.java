package cn.tedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.pojo.Product;
import com.jt.common.pojo.User;
import com.jt.common.vo.EasyUIResult;

import cn.tedu.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper usermapper;

	public void useradd(User user) {
		usermapper.add(user);
	}

	public void userdelete(String name) {
		usermapper.delete(name);
	}

	public void userupdate(User user) {
		usermapper.update(user);
	}

	public EasyUIResult userquery(Integer page, Integer rows) {
		EasyUIResult result=new EasyUIResult();
		//2.封装第一个属性total的数量
		Integer total=usermapper.queryTotal();
		//3.封装第二个属性List<Product> pList
		//根据页数计算起始位置
		Integer start=(page-1)*rows;
		List<User> pList=usermapper.query(start,rows);
		//4.封装对象属性
		result.setTotal(total);
		result.setRows(pList);
		
		return result;
	}

}
