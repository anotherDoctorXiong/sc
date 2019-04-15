package shichi.demo.controller.umsController;

import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shichi.demo.model.Response;
import shichi.demo.service.umsService.UmsIntegrationChangeHistoryService;
import shichi.demo.util.JsonUtil;
import shichi.demo.util.ReadFileUtil;

import java.util.HashMap;
import java.util.List;

/**
 * 星币日志功能 Controller
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/integration")
public class UmsIntegrationChangeHistoryController {
    @Autowired
    private UmsIntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 分页查询用户积分历史变更记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list/page")
    public Response getChangeHistoryListPage(@Param("pageNum") Integer pageNum,
                                             @Param("pageSize") Integer pageSize) {
        Response res = new Response();
        List changeHistoryList = integrationChangeHistoryService.getChangeHistoryListPage(pageNum, pageSize);
        if (changeHistoryList.size()>0) {
            res.pageSuccess(changeHistoryList);
            res.setMessage("查询成功!");
        }else {
            res.pageSuccess(changeHistoryList);
            res.setMessage("查询结果为空!");
        }
        return res;
    }

    /**
     * 查询所有积分历史变更记录
     * @return
     */
    @GetMapping("/list/all")
    public Response getChangeHistoryAllList() {
        Response res = new Response();
        List changeHistoryAll = integrationChangeHistoryService.getChangeHistoryAll();
        return res.success(changeHistoryAll);
    }

    /**
     * 按条件分页查询积分变更历史记录
     * @param map 条件参数
     * @return List
     */
    @PostMapping("/list/condition/page")
    public Response getChangeHistoryByCondition(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        List changeHistoryList = integrationChangeHistoryService.getChangeHistoryByCondition(map);
        if (changeHistoryList.size()>0) {
            res.pageSuccess(changeHistoryList);
            res.setMessage("查询成功!");
        }else {
            res.pageSuccess(changeHistoryList);
            res.setMessage("查询结果为空!");
        }
        return res;
    }

    /**
     * 按条件查询所有积分变更历史记录(非分页)
     * @param map 条件参数
     * @return List
     */
    @PostMapping("/list/condition/all")
    public Response getChangeHistoryAllByCondition(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        List changeHistoryAll = integrationChangeHistoryService.getChangeHistoryAllByCondition(map);
        if (changeHistoryAll.size() >0) {
            res.success(changeHistoryAll);
            res.setMessage("查询成功!");
        }else {
            res.setMessage("查询结果为空!");
        }
        return res;
    }

    /**
     * 批量更新积分变更历史记录的数据状态
     * @param map 更新参数
     * @return Response
     */
    @PostMapping("/edit/datastate")
    public Response updateChangeHistoryDataState(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        if (! map.isEmpty()) {
            int count = integrationChangeHistoryService.updateChangeHistoryDataState(map);
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
     * 获取手动加减原因列表
     * @return Response
     */
    @GetMapping("/reason/manual")
    public Response getManualReason(){
        Response res = new Response();
        String path = "E:\\java project\\sc\\src\\main\\resources\\json\\ManualReason.json";
        JSONArray jsonArray = JsonUtil.StringToJSONArray(ReadFileUtil.readFileToString(path));
        res.setData(jsonArray);
        // res.setMessage("获取手动加减原因列表成功!");
        return res;
    }

    /**
     * 获取变动原因列表
     * @return Response
     */
    @GetMapping("/reason/changed")
    public Response getChangedReason() {
        Response res = new Response();
        String path = "E:\\java project\\sc\\src\\main\\resources\\json\\ChangedReason.json";
        JSONArray jsonArray = JsonUtil.StringToJSONArray(ReadFileUtil.readFileToString(path));
        res.setData(jsonArray);
        // res.setMessage("获取变动原因成功!");
        return res;
    }
}
