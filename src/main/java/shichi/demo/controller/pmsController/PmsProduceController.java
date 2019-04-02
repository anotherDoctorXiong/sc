package shichi.demo.controller.pmsController;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shichi.demo.model.Response;
import shichi.demo.model.pmsModel.PmsProduce;
import shichi.demo.service.pmsService.PmsProduceService;

import java.util.HashMap;
import java.util.List;

/**
 * 产品功能 Controller
 */
@RestController
@RequestMapping(value = "/produce")
public class PmsProduceController {
    @Autowired
    private PmsProduceService pmsProduceService;

    /**
     *
     * 新建产品
     * @param data String
     * @return Response
     */
    @CrossOrigin("*")
    @PostMapping("/new")
    public Response createPmsProduce(@RequestBody String data) {
        Response res = new Response();
        if (!data.isEmpty()) {
            PmsProduce pmsProduce = JSON.parseObject(data, PmsProduce.class);
            int count = pmsProduceService.createPmsProduce(pmsProduce);
            if (count == 1) {
                res.setMessage("新建产品成功!");
            } else {
                res.setMessage("新建产品失败!");
            }
            return res;
        }else {
            res.setMessage("参数错误!");
        }
        return res;
    }

    /**
     * 更新产品信息
     * @param data String
     * @return Response
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Response updatePmsProduce(@RequestBody String data) {
        Response res = new Response();
        if (!data.isEmpty()) {
            PmsProduce pmsProduce = JSON.parseObject(data, PmsProduce.class);
            int count = pmsProduceService.updatePmsProduce(pmsProduce);
            if (count == 1) {
                res.setMessage("修改产品成功!");
            }else {
                res.setMessage("修改产品失败!");
            }
            return res;
        }
        res.setMessage("参数错误!");
        return res;
    }

    /**
     * 获取所有产品列表
     * @return Response
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/list/all", method = RequestMethod.POST)
    public Response getPmsProduceAllList() {
        Response res = new Response();
        return res.success(pmsProduceService.getPmsProduceAllList());
    }
    /**
     * 分页查询产品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Response getPmsProduceList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Response res = new Response();
        return res.pageSuccess(pmsProduceService.getPmsProduceList(pageNum, pageSize));
    }

    /**
     * 根据特定查询条件查询产品信息
     * @param map
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/list/page", method = RequestMethod.POST)
    public Response getPmsProduceByCondition(@RequestBody HashMap<String, Object> map) {
        Response res = new Response();
        System.out.println(map);
        List<PmsProduce> pmsProduceList = pmsProduceService.getPmsProduceByCondition(map);
        return res.pageSuccess(pmsProduceList);
    }


}
