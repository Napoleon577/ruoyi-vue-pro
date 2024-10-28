package cn.iocoder.yudao.module.csdn.controller.admin.code.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - csdn激活码分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CodePageReqVO extends PageParam {

    @Schema(description = "uuid", example = "18435")
    private String uuid;

    @Schema(description = "激活码")
    private String code;

    @Schema(description = "down_url，下载地址", example = "https://www.iocoder.cn")
    private String downUrl;

    @Schema(description = "1:未使用，2已使用，3作废", example = "2")
    private String status;

    @Schema(description = "生成时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] insertTime;

    @Schema(description = "使用时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] usedTime;

}