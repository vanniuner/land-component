package com.land.base.po;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author LZJ
 * @time 2021-05-20 10:33:47
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class BaseEntity implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    String id;

    /**
     * 创建时间
     */
    Date createDate;

    /**
     * 更新时间
     */
    Date updateDate;

}
