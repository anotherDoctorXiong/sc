package shichi.demo.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shichi.demo.service.AdminerService;
import shichi.demo.model.Response;
import shichi.demo.model.autoModel.Admin;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminerController {
    @Autowired
    private AdminerService adminerService;

    @RequestMapping(value = "/Example1", method = RequestMethod.POST)
    //json接收
    public Response Example1(@RequestBody JSONObject json){
        //获取到data对象
        json.get("data");
        //返回结构体使用Response,默认值为操作成功
        Response res=new Response();
        return res;
    }
    @RequestMapping(value = "/Example2", method = RequestMethod.POST)
    //对象的接收使用java对象,并用@Valid Object进行校验
    public Response Example2(@Valid Object object,BindingResult bindingResult){
        //返回结构体使用Response,默认值为操作成功
        Response res=new Response();
        //校验参数的错误信息的获取
        if(bindingResult.hasErrors()){
            res.setCode(1);
            res.setMessage(bindingResult.getFieldError().getDefaultMessage());
        }
        return res;
    }

    /**
     * 用户登录
     *
     * @param id 账号
     * @param password 密码
     * @return 操作结果
     * @throws
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response adminlogin(@RequestParam String id, String password){
        Response res=new Response();
        if(id!=null&&password!=null){
            Map auth = new HashMap<String, Object>() {{
                put("Authorization", "Bearer "+adminerService.login(id,password));
            }};
            res.setData(auth);
            return res;
        }else {
            res.setCode(1);
            return res;
        }
    }
    @RequestMapping(value = "/admin/register", method = RequestMethod.POST)
    public Response resgister(@Valid Admin admin,BindingResult bindingResult){
        Response res=new Response();
        if(bindingResult.hasErrors()){
            res.setCode(1);
            res.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return res;
        }else {
            String result=adminerService.register(admin);
            if(result=="success"){
                return res;
            }else {
                res.setCode(1);
                res.setMessage(result);
                return res;
            }
        }
    }
    @RequestMapping(value = "/user/log", method = RequestMethod.POST)
    public String showuser(){

        return "user";
    }


    /**
     * 刷新密钥
     *
     * @param authorization 原密钥
     * @return 新密钥
     * @throws AuthenticationException 错误信息
     */
    @GetMapping(value = "/refreshToken")
    public String refreshToken(@RequestHeader String authorization) throws AuthenticationException {
        return adminerService.refreshToken(authorization);
    }

}
