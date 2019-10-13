package com.mall.customer.base;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Page<T>  {

    /**
     * 返回业务数据
     */
    private List<T> response;

    /**页码*/
    @NotNull(message = "页码不能为空！")
    @Min(value = 1)
    private Integer pageNo;

    /**页记录数*/
    @NotNull(message = "页数不能为空！")
    @Min(value = 1)
    private Integer pageSize;

    /**
     * totalCount 总条数
     */
    private long totalCount;

    /**
     * totalPage 总页数
     */
    private int totalPage;


}
