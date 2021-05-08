package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info(" In saveUser of UserService ========>>>");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUerWithDepartment(Long id) {

		log.info(" In getUerWithDepartment of UserService ========>>>");
		
		ResponseTemplateVO vo = new ResponseTemplateVO();

		User user = userRepository.findByUserId(id);

		Department department = restTemplate.getForObject("http://API-GATEWAY/departments/" + id, Department.class);

		vo.setUser(user);
		vo.setDepartment(department);

		return vo;

	}

}
