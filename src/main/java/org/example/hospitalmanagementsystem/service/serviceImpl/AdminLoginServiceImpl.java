package org.example.hospitalmanagementsystem.service.serviceImpl;

import org.example.hospitalmanagementsystem.repository.AdminLoginRepo;
import org.example.hospitalmanagementsystem.repository.repoImpl.AdminLoginRepoImpl;
import org.example.hospitalmanagementsystem.service.AdminLoginService;

public class AdminLoginServiceImpl implements AdminLoginService{
	
	AdminLoginRepo adminLoginRepo = new AdminLoginRepoImpl();
	
	@Override
	public boolean isLogin(String un, String pass) {
		return adminLoginRepo.isLogin(un,pass);
	}

}
