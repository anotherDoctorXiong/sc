package shichi.demo.controller.umsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shichi.demo.model.Response;
import shichi.demo.service.umsService.UmsUserService;

import java.util.HashMap;
import java.util.List;

/**
 * 用户管理功能 Controller
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UmsUserController {
    @Autowired
    private UmsUserService umsUserService;

    /**
     * 按特定条件分页查询用户列表
     * @param map
     * @return
     */
    @PostMapping("/list/condition/page")
    public Response getUmsUserListPageByCondition(@RequestBody HashMap<String, Object> map) {
        System.out.println(map);
        String phone = (String) map.get("phone");
        String tagId = (String) map.get("tagId");
        Response res = new Response();
        List userList = umsUserService.getUmsUserListPageByCondition(map);
        if (userList.size()>0) {
             res.pageSuccess(userList);
             res.setMessage("查询成功!");
        }else {
            res.pageSuccess(userList);
            res.setMessage("查询结果为空!");
        }
        return res;
    }

    /**
     * 按特定条件查询所有用户列表(不分页)
     * @param map
     * @return
     */
    @PostMapping("/list/condition/all")
    public Response getUmsUserListAllByCondition(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        List userList = umsUserService.getUmsUserListAllByCondition(map);
        if (userList.size()>0) {
            res.success(userList);
            res.setMessage("查询成功!");
        }else {
            res.pageSuccess(userList);
            res.setMessage("查询结果为空!");
        }
        return res;
    }
    /**
     * 设置用户标签
     * @param map
     * @return
     */
    @PostMapping("/edit/tag")
    public Response setUmsUserTag(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        if (!map.isEmpty()){
            int count = umsUserService.setUmsUserTag(map);
            if (count == 1) {
                res.setMessage("设置成功!");
            }else {
                res.setCode(1);
                res.setMessage("设置失败!");
            }
        }else {
            res.setCode(1);
            res.setMessage("参数错误!");
        }
        return res;
    }

    /**
     * 分页查询用户信息
     * @param pageNum 当前页
     * @param pageSize 每页的数据数量
     * @return Response
     */
    @PostMapping("/list/page")
    public Response getUmsUserList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Response res = new Response();
        List umsUserList= umsUserService.getUmsUserList(pageNum, pageSize);
        if (umsUserList.size()>0) {
            res.pageSuccess(umsUserList);
            res.setMessage("查询成功!");
        }else {
            res.pageSuccess(umsUserList);
            res.setMessage("查询结果为空!");
        }
        return res;
    }

    /**
     * 查询所有用户信息列表
     * @return
     */
    @PostMapping("/list/all")
    public Response getUmsUserALLList() {
        Response res = new Response();
        List umsUserAllList= umsUserService.getUmsUserALLList();
        return res.success(umsUserAllList);
    }
    /**
     * 批量更新用户账号状态
     * @param map
     * @return
     */
    @PostMapping("/edit/state")
    public Response updateUmsUserState(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        if (! map.isEmpty()) {
            int count = umsUserService.updateUmsUserState(map);
            if (count >= 1) {
                res.setMessage("设置成功!");
            } else {
                res.setMessage("设置失败!");
                res.setCode(1);
            }
        }else {
            res.setCode(1);
            res.setMessage("参数错误!");
        }
        return res;
    }

    /**
     * 手动加减用户积分
     * @param map
     * @return
     */
    @PostMapping("/edit/integration")
    public Response updateUserIntegration(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        if (!map.isEmpty()) {
            //System.out.println(map.toString());
            int count = umsUserService.updateUserIntegration(map);
            if (count == 1) {
                res.setMessage("设置成功!");
            } else {
                res.setMessage("设置失败!");
                res.setCode(1);
            }
        }else {
            res.setCode(1);
            res.setMessage("参数错误!");
        }
        return res;
    }

    /**
     * 首页统计运营概况
     * @param map map
     * @return Response
     */
    @PostMapping("/data/count")
    public Response getCountData(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        List dataCountList = umsUserService.getCountData(map);
        System.out.println(dataCountList);
        res.setData(dataCountList);
        return res;
    }
}
