package cn.iocoder.yudao.module.csdn.controller.admin.code.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - csdn激活码 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CodeRespVO {

    @Schema(description = "uuid", requiredMode = Schema.RequiredMode.REQUIRED, example = "18435")
    @ExcelProperty("uuid")
    private String uuid;

    @Schema(description = "激活码")
    @ExcelProperty("激活码")
    private String code;

    @Schema(description = "down_url，下载地址", example = "https://www.iocoder.cn")
    @ExcelProperty("down_url，下载地址")
    private String downUrl;

    @Schema(description = "1:未使用，2已使用，3作废", example = "2")
    @ExcelProperty("1:未使用，2已使用，3作废")
    private String status;

    @Schema(description = "生成时间")
    @ExcelProperty("生成时间")
    private LocalDateTime insertTime;

    @Schema(description = "使用时间")
    @ExcelProperty("使用时间")
    private LocalDateTime usedTime;

}