package cn.iocoder.yudao.module.csdn.service.code;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.csdn.controller.admin.code.vo.*;
import cn.iocoder.yudao.module.csdn.dal.dataobject.code.CodeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * csdn激活码 Service 接口
 *
 * @author 芋道源码
 */
public interface CodeService {

    /**
     * 创建csdn激活码
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createCode(@Valid CodeSaveReqVO createReqVO);

    /**
     * 更新csdn激活码
     *
     * @param updateReqVO 更新信息
     */
    void updateCode(@Valid CodeSaveReqVO updateReqVO);

    /**
     * 删除csdn激活码
     *
     * @param id 编号
     */
    void deleteCode(String id);

    /**
     * 获得csdn激活码
     *
     * @param id 编号
     * @return csdn激活码
     */
    CodeDO getCode(String id);

    /**
     * 获得csdn激活码分页
     *
     * @param pageReqVO 分页查询
     * @return csdn激活码分页
     */
    PageResult<CodeDO> getCodePage(CodePageReqVO pageReqVO);

}