package shichi.demo.controller.pmsController;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shichi.demo.model.Response;
import shichi.demo.model.pmsModel.PmsBrand;
import shichi.demo.service.pmsService.PmsBrandService;

import java.util.List;

/**
 * 品牌管理功能 Controller
 */
@RestController
@RequestMapping(value = "/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    /**
     * 新建品牌
     * @param data String
     * @return Response
     */
    @CrossOrigin("*")
    @PostMapping("/new")
    public Response createPmsBrand(@RequestBody String data) {
        Response res = new Response();
        if (!data.isEmpty()) {
            PmsBrand pmsBrand = JSON.parseObject(data, PmsBrand.class);
            String brandName = pmsBrand.getBrandName();
            List temp = pmsBrandService.getPmsBrandByBrandName(brandName);
            //新建品牌前先判断该品牌是否已存在，保证品牌的唯一性
            if (temp.size() == 0) {
                int count = pmsBrandService.createPmsBrand(pmsBrand);
                if (count == 1) {
                    res.setCode(0);
                    res.setMessage("新建品牌成功!");
                } else {
                    res.setCode(1);
                    res.setMessage("新建品牌失败!");
                }
                return res;
            }else {
                res.setCode(1);
                res.setMessage("新建品牌失败,该品牌已存在!");
            }
        }else {
            res.setMessage("参数错误!");
        }
        return res;
    }

    /**
     * 修改品牌
     * @param data String
     * @return
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Response updatePmsBrand(@RequestBody String data) {
        Response res = new Response();
        if (!data.isEmpty()) {
            PmsBrand pmsBrand = JSON.parseObject(data, PmsBrand.class);
            int count = pmsBrandService.updatePmsBrand(pmsBrand);
            if (count == 1) {
                res.setCode(0);
                res.setMessage("修改品牌成功!");
            }else {
                res.setCode(1);
                res.setMessage("该品牌已存在,修改失败!");
            }
        }else {
            res.setCode(1);
            res.setMessage("参数错误!");
        }
        return res;
    }

    /**
     * 获取所有品牌信息
     * @return Response
     */
    @CrossOrigin("*")
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
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
    @RequestMapping(value = "/list/page", method = RequestMethod.POST)
    public Response getPmsBrandList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Response res = new Response();
        List brandList = pmsBrandService.getPmsBrandList(pageNum, pageSize);
        if (brandList.size() >0 ) {
            res.pageSuccess(brandList);
            res.setMessage("查询品牌成功!");
        }else {
            res.pageSuccess(brandList);
            res.setMessage("查询结果为空!");
        }
        return res;
    }
}
