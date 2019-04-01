package shichi.demo.model.pmsModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
@Setter
@Getter
public class PmsProduce {
    //产品id
    @NotEmpty
    private String produceId;

    //品牌id
    @NotEmpty
    private String brandId;

    //品牌名称
    @NotEmpty
    private String brandName;

    //产品名称
    @NotEmpty
    private String produceName;

    //创建时间
    @NotEmpty
    private Date createdTime;

    //数据状态
    @NotEmpty
    private Boolean dataState;


}