package cn.iocoder.yudao.module.csdn.controller.admin.code;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.csdn.controller.admin.code.vo.*;
import cn.iocoder.yudao.module.csdn.dal.dataobject.code.CodeDO;
import cn.iocoder.yudao.module.csdn.service.code.CodeService;

@Tag(name = "管理后台 - csdn激活码")
@RestController
@RequestMapping("/csdn/code")
@Validated
public class CodeController {

    @Resource
    private CodeService codeService;

    @PostMapping("/create")
    @Operation(summary = "创建csdn激活码")
    @PreAuthorize("@ss.hasPermission('csdn:code:create')")
    public CommonResult<String> createCode(@Valid @RequestBody CodeSaveReqVO createReqVO) {
        return success(codeService.createCode(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新csdn激活码")
    @PreAuthorize("@ss.hasPermission('csdn:code:update')")
    public CommonResult<Boolean> updateCode(@Valid @RequestBody CodeSaveReqVO updateReqVO) {
        codeService.updateCode(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除csdn激活码")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('csdn:code:delete')")
    public CommonResult<Boolean> deleteCode(@RequestParam("id") String id) {
        codeService.deleteCode(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得csdn激活码")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('csdn:code:query')")
    public CommonResult<CodeRespVO> getCode(@RequestParam("id") String id) {
        CodeDO code = codeService.getCode(id);
        return success(BeanUtils.toBean(code, CodeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得csdn激活码分页")
    @PreAuthorize("@ss.hasPermission('csdn:code:query')")
    public CommonResult<PageResult<CodeRespVO>> getCodePage(@Valid CodePageReqVO pageReqVO) {
        PageResult<CodeDO> pageResult = codeService.getCodePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, CodeRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出csdn激活码 Excel")
    @PreAuthorize("@ss.hasPermission('csdn:code:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCodeExcel(@Valid CodePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<CodeDO> list = codeService.getCodePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "csdn激活码.xls", "数据", CodeRespVO.class,
                        BeanUtils.toBean(list, CodeRespVO.class));
    }

}