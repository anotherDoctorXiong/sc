package shichi.demo.model.pmsModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
/**
 * 品牌实体
 */
@Data
@Setter
@Getter
public class PmsBrand {
    //品牌id

    private String brandId;

    //品牌名称
    @NotEmpty
    private String brandName;

    //创建时间
    @NotEmpty
    private Date createdTime;

    //数据状态
    @NotEmpty
    private Boolean dataState;

}