package cn.iocoder.yudao.module.csdn.dal.dataobject.code;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * csdn激活码 DO
 *
 * @author 芋道源码
 */
@TableName("csdn_code")
@KeySequence("csdn_code_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeDO extends BaseDO {

    /**
     * uuid
     */
    @TableId(type = IdType.INPUT)
    private String uuid;
    /**
     * 激活码
     */
    private String code;
    /**
     * down_url，下载地址
     */
    private String downUrl;
    /**
     * 1:未使用，2已使用，3作废
     */
    private String status;
    /**
     * 生成时间
     */
    private LocalDateTime insertTime;
    /**
     * 使用时间
     */
    private LocalDateTime usedTime;

}