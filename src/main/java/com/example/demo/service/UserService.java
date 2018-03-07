package com.example.demo.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, UserInfo> implements IUserService {

}
