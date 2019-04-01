package shichi.demo.controller.pmsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import shichi.demo.model.Response;
import shichi.demo.model.pmsModel.PmsBrand;
import shichi.demo.service.pmsService.PmsBrandService;

import javax.validation.Valid;

/**
 * 品牌功能 Controller
 */
@RestController
@RequestMapping(value = "/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    /**
     * 新建品牌
     * @param pmsBrand 品牌实体
     * @param bindingResult
     * @return Response
     */
    @CrossOrigin("*")
    @PostMapping("/createPmsBrand")
    public Response createPmsBrand(@Valid @RequestBody PmsBrand pmsBrand, BindingResult bindingResult) {
        System.out.println(pmsBrand);
        Response res = new Response();
        if (bindingResult.hasErrors()) {
            res.failed();
            res.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return res;
        }else {
            int count = pmsBrandService.createPmsBrand(pmsBrand);
            if (count == 1) {
                res.success(count);
            }else {
                res.failed();
            }
            return res;
        }
    }

    /**
     * 更新品牌
     * @param pmsBrand
     * @param bindingResult
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/updatePmsBrand", method = RequestMethod.POST)
    public Response updatePmsBrand(@Valid @RequestBody PmsBrand pmsBrand, BindingResult bindingResult) {
        Response res = new Response();
        if (bindingResult.hasErrors()) {
            res.failed();
            res.setMessage(bindingResult.getFieldError().getDefaultMessage());
            return res;
        }else {
            int count = pmsBrandService.updatePmsBrand(pmsBrand);
            if (count == 1) {
                res.success(count);
            }else {
                res.failed();
            }
        }   return res;
    }

    /**
     * 获取所有品牌信息
     * @return Response
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/getPmsBrandAllList", method = RequestMethod.GET)
    public Response getPmsBrandAllList() {
        Response res = new Response();
        return res.success(pmsBrandService.getPmsBrandAllList());
    }

    /**
     * 分页获取品牌列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/getPmsBrandList", method = RequestMethod.GET)
    public Response getPmsBrandList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Response res = new Response();
        return res.pageSuccess(pmsBrandService.getPmsBrandList(pageNum, pageSize));
    }
}
