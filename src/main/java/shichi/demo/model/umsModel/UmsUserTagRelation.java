package shichi.demo.model.umsModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * 用户和标签关系实体
 */
@Data
@Setter
@Getter
public class UmsUserTagRelation {
    //主键id
    @NotEmpty
    private Long id;

    //用户id
    @NotEmpty
    private String userId;

    //标签id
    @NotEmpty
    private String tagId;
}
