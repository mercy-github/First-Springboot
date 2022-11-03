package com.course.First_Springboot.Controller;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.First_Springboot.Model.Department;

@RestController
@RequestMapping("/department")
public class HelloController {
	
	@RequestMapping(value="/departmentId" , method=RequestMethod.GET)
	Department getDepName(@RequestParam String depId) {
		
		int id = Integer.parseInt(depId);
		
		Department dept1 = new Department();
		Map depMap = new HashMap<>();
		dept1.setDepId(100);
		dept1.setDepName("Sales");
		depMap.put(100, dept1);
		
		Department dept2 = new Department();
		dept2.setDepId(200);
		dept2.setDepName("Marketing");
		depMap.put(200, dept2);
		
		return (Department) depMap.get(id);
		
	}
	
	
 
}
