package shichi.demo.service.pmsService;

import shichi.demo.model.pmsModel.PmsBrand;

import java.util.List;

/**
 * 品牌 Service
 */
public interface PmsBrandService {
    int createPmsBrand(PmsBrand pmsBrand);

    int updatePmsBrand(PmsBrand pmsBrand);

    List<PmsBrand> getPmsBrandAllList();

    List getPmsBrandList(Integer pageNum, Integer pageSize);
}
