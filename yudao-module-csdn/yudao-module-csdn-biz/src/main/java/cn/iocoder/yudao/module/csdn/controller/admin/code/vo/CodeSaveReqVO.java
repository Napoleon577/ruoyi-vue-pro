package cn.iocoder.yudao.module.csdn.controller.admin.code.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - csdn激活码新增/修改 Request VO")
@Data
public class CodeSaveReqVO {

    @Schema(description = "uuid", requiredMode = Schema.RequiredMode.REQUIRED, example = "18435")
    private String uuid;

    @Schema(description = "激活码")
    private String code;

    @Schema(description = "down_url，下载地址", example = "https://www.iocoder.cn")
    private String downUrl;

    @Schema(description = "1:未使用，2已使用，3作废", example = "2")
    private String status;

    @Schema(description = "生成时间")
    private LocalDateTime insertTime;

    @Schema(description = "使用时间")
    private LocalDateTime usedTime;

}