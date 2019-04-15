package shichi.demo.controller.umsController;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shichi.demo.model.Response;
import shichi.demo.model.umsModel.UmsTag;
import shichi.demo.service.umsService.UmsTagService;

import java.util.List;

/**
 * 标签管理功能 Controller
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/tag")
public class UmsTagController {

    @Autowired
    private UmsTagService umsTagService;

    /**
     * 新建标签
     * @param data JSON字符串
     * @return Response
     */
    @CrossOrigin("*")
    @PostMapping("/new")
    public Response createUmsUser(@RequestBody String data) {
        Response res = new Response();
        if (!data.isEmpty()) {
            UmsTag umsTag = JSON.parseObject(data, UmsTag.class);
            int count = umsTagService.createUmsTag(umsTag);
            if (count == 1) {
                res.setMessage("新建标签成功!");
            } else {
                res.setCode(1);
                res.setMessage("新建标签失败!");
            }
            return res;
        }else {
            res.setMessage("参数错误!");
        }
        return res;

    }

    /**
     * 修改标签信息
     * @param data
     * @return
     */
    @CrossOrigin("*")
    @PostMapping("/edit")
    public Response updateUmsTag(@RequestBody String data) {
        Response res = new Response();
        if (!data.isEmpty()) {
            UmsTag umsTag = JSON.parseObject(data, UmsTag.class);
            int count = umsTagService.updateUmsTag(umsTag);
            if (count == 1) {
                res.setMessage("修改标签成功!");
            }else if (count == -1){
                res.setCode(1);
                res.setMessage("该标签已存在!");
            }else {
                res.setCode(1);
                res.setMessage("修改标签失败!");
            }
            return res;
        }else {
            res.setCode(1);
            res.setMessage("参数错误!");
        }
        return res;
    }

    /**
     * 分页查询标签信息
     * @param pageNum 当前页
     * @param pageSize 每页的数据数量
     * @return Response
     */
    @CrossOrigin("*")
    @GetMapping("/list/page")
    public Response getUmsTagList(@Param("pageNum") Integer pageNum,
                                  @Param("pageSize") Integer pageSize) {
        Response res = new Response();
        List umsTagList= umsTagService.getUmsTagList(pageNum, pageSize);
        if (umsTagList.size()>0) {
            res.pageSuccess(umsTagList);
            res.setMessage("查询成功!");
        }else {
            res.pageSuccess(umsTagList);
            res.setMessage("查询结果为空!");
        }
        return res;
    }

    /**
     * 获取所有标签信息
     * @return Response
     */
    @GetMapping("/list/all")
    public Response getUmsTagAllList() {
        Response res = new Response();
        return res.success(umsTagService.getUmsTagAllList());
    }


}
