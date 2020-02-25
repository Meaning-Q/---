package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.pojo.User;

public interface UserMapper {

	void add(User user);

	void delete(String name);

	void update(User user);

	List<User> query(@Param("start")Integer start,@Param("rows")Integer rows);

	Integer queryTotal();
	
}
