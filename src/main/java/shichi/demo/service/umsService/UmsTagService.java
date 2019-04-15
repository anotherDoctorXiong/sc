package shichi.demo.service.umsService;

import shichi.demo.model.umsModel.UmsTag;

import java.util.List;

public interface UmsTagService {
    int createUmsTag(UmsTag umsTag);

    int updateUmsTag(UmsTag umsTag);

    List getUmsTagList(Integer pageNum, Integer pageSize);

    List<UmsTag> getUmsTagAllList();
}
