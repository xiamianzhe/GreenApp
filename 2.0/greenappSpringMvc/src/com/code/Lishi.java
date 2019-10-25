package com.code;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguiigu.mybatis.test.mybatistest07;

import pojo.employee7;

@Controller
public class Lishi {
	@RequestMapping("/lishi")
	@ResponseBody
	@Test
	public employee7 testJson(@RequestBody employee7 user){
		if(user.getLei().equals("»’")) {
			mybatistest07 my7=new mybatistest07();
			try {
				my7.test(user.getBeginTime(), user.getEndTime(), user.getCj());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(user.getLei().equals("÷‹")) {
			
		}else if(user.getLei().equals("‘¬")) {
			
		}
		return user;
	}
	}
