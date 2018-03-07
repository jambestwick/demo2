package com.example.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UIController extends BaseController {
    public Logger log = LoggerFactory.getLogger(UIController.class);
    @Autowired
    UserService userService;


    @RequestMapping("/insert")
    public void insertData(@RequestParam(value="username",required=true)String username,
                           @RequestParam( value="telephone" ,required = true) String telephone,
                           @RequestParam( value="email" ,required = true) String email,
                           @RequestParam( value="address" ,required = true) String address,
                           @RequestParam(value="age",required = false ,defaultValue="0")int age){

        try {

            UserInfo userInfo = new UserInfo(username, telephone, email, address, age);
            boolean flag = userService.insert(userInfo);
            if(flag){
                log.debug("用户添加成功");
            }else{
                log.debug("用户添加失败");
            }
        } catch (NumberFormatException e) {
            log.debug("用户添加成功");
            e.printStackTrace();
        }

    }

    @RequestMapping("/findAll")
    public ApiResponse<Object> findAll(){
        ApiResponse<Object> result = new ApiResponse<Object>();
        result.setCode(0);
        result.setMessage("Success");
        EntityWrapper ew = new EntityWrapper();
//        ew.where("TRADE_SYS_ID={0}",tradeSysID)
//                .andNew("trunc(CREATE_TIME,'dd')={0}",dateFmt.parse(strDate))
//                .andNew("OPERATE={0}", Constants.FileOperate.DOWNLOAD.getValue());

        log.info("SqlSegment:{}",ew.getSqlSegment());
        List<UserInfo> userInfos = userService.selectList(null);
        result.setData(userInfos);
        return result;
    }

    @RequestMapping("/findByName/{name}")
    public ApiResponse<Object> findByName( @PathVariable("name") String name ){
        ApiResponse<Object> result = new ApiResponse<Object>();
        result.setCode(0);
        result.setMessage("Success");

        Map<String , Object> map= new HashMap<>();
        map.put("user_name", name);
        List<UserInfo> targetUsers = userService.selectByMap(map);

        if(null != targetUsers && targetUsers.size()>0){
            result.setData(targetUsers);
        }else{
            log.debug("没有查找到数据");
        }
        return result;
    }

    @RequestMapping("/deleteByNanme/{name}")
    //@RequestMapping(value="/{name}")
    public void deleteByName(@PathVariable("name") String name){

        Map<String ,Object > map = new HashMap<>();
        map.put("user_name", name);
        boolean flag = userService.deleteByMap(map);
        if(flag){
            log.debug("删除指定用户成功");
        }else{
            log.debug("删除指定用户失败");
        }

    }
    @RequestMapping("/update/{usernames}")
    public void updateByName(HttpServletRequest httpServletRequest, @PathVariable("usernames") String usernames){
//        String username = httpServletRequest.getParameter("username");
//        String telephone = httpServletRequest.getParameter("telephone");
//        String email = httpServletRequest.getParameter("email");
//        String address = httpServletRequest.getParameter("address");
//        int age = Integer.parseInt(httpServletRequest.getParameter("age"));

        Map<String ,Object > map = new HashMap<>();
        map.put("user_name", usernames);
        List<UserInfo> userInfos = userService.selectByMap(map);

        if(null != userInfos && userInfos.size() > 0){
            for (int i = 0; i < userInfos.size(); i++) {
                UserInfo userInfo = new UserInfo("张飞", "13399990000","jambestwick@126.com", "陕西省西安市莲湖区环城西路",100);
                userInfo.setUserId(userInfos.get(i).getUserId());
                boolean flag =  userService.updateById(userInfo);
                if(flag){
                    log.debug("更新指定用户成功");
                }else{
                    log.debug("更新指定用户成功");
                }
            }
        }

    }

}
