package cn.iocoder.yudao.module.csdn.service.code;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.csdn.controller.admin.code.vo.*;
import cn.iocoder.yudao.module.csdn.dal.dataobject.code.CodeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.csdn.dal.mysql.code.CodeMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.csdn.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.CODE_NOT_EXISTS;

/**
 * csdn激活码 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class CodeServiceImpl implements CodeService {

    @Resource
    private CodeMapper codeMapper;

    @Override
    public String createCode(CodeSaveReqVO createReqVO) {
        // 插入
        CodeDO code = BeanUtils.toBean(createReqVO, CodeDO.class);
        codeMapper.insert(code);
        // 返回
        return code.getCode();
    }

    @Override
    public void updateCode(CodeSaveReqVO updateReqVO) {
        // 校验存在
        validateCodeExists(updateReqVO.getUuid());
        // 更新
        CodeDO updateObj = BeanUtils.toBean(updateReqVO, CodeDO.class);
        codeMapper.updateById(updateObj);
    }

    @Override
    public void deleteCode(String id) {
        // 校验存在
        validateCodeExists(id);
        // 删除
        codeMapper.deleteById(id);
    }

    private void validateCodeExists(String id) {
        if (codeMapper.selectById(id) == null) {
            throw exception(CODE_NOT_EXISTS);
        }
    }

    @Override
    public CodeDO getCode(String id) {
        return codeMapper.selectById(id);
    }

    @Override
    public PageResult<CodeDO> getCodePage(CodePageReqVO pageReqVO) {
        return codeMapper.selectPage(pageReqVO);
    }

}