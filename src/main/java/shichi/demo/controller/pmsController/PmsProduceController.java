package shichi.demo.controller.pmsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shichi.demo.model.Response;
import shichi.demo.model.pmsModel.PmsProduce;
import shichi.demo.service.pmsService.PmsProduceService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 产品功能 Controller
 */
@RestController
@RequestMapping(value = "/produce")
public class PmsProduceController {
    @Autowired
    private PmsProduceService pmsProduceService;

//    @CrossOrigin("*")
//    @RequestMapping("/insert")
//    public Response insert(@Valid @RequestBody String promes){
//        Response res = new Response();
//
//        PmsProduce pmsProduce = JSON.parseObject(promes, PmsProduce.class);
//
//        int pmsProduce1 = pmsProduceService.createPmsProduce(pmsProduce);
//
//        if(pmsProduce1!=0){
//            res.success(1);
//        }else {
//            res.failed();
//        }
//
//        return  res;
//    }

    /**
     * 新建产品
     * @param pmsProduce 产品实体
     * @param bindingResult
     * @return Response
     */
    @CrossOrigin("*")
    @PostMapping("/createPmsProduce")
    public Response createPmsProduce(@Valid @RequestBody PmsProduce pmsProduce, BindingResult bindingResult) {
        Response res = new Response();
        if (bindingResult.hasErrors()) {
            res.failed();
            //res.setMessage(bindingResult.getFieldError().getDefaultMessage());
            res.setMessage("产品参数填写有误");
            return res;
        }else {
            int count = pmsProduceService.createPmsProduce(pmsProduce);
            if (count == 1) {
                res.success(count);
            }else {
                res.failed();
            }
            return res;
        }
    }

    /**
     * 更新产品信息
     * @param pmsProduce
     * @param bindingResult
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/updatePmsProduce", method = RequestMethod.POST)
    public Response updatePmsProduce(@Valid @RequestBody PmsProduce pmsProduce, BindingResult bindingResult) {
        Response res = new Response();
        if (bindingResult.hasErrors()) {
            res.failed();
            //res.setMessage(bindingResult.getFieldError().getDefaultMessage());
            res.setMessage("产品参数填写有误");
            return res;
        }else {
            int count = pmsProduceService.updatePmsProduce(pmsProduce);
            if (count == 1) {
                res.success(count);
            }else {
                res.failed();
            }
        }   return res;
    }

    /**
     * 分页查询产品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/getPmsProduceList", method = RequestMethod.GET)
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
    @RequestMapping(value = "/getPmsProduceByCondition", method = RequestMethod.GET)
    public Response getPmsProduceByCondition(Map<String, Object> map) {
        Response res = new Response();
        System.out.println(map);
        List<PmsProduce> pmsProduceList = pmsProduceService.getPmsProduceByCondition(map);
        return res.success(pmsProduceList);
    }


}
