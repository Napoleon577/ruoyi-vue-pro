package cn.iocoder.yudao.module.csdn.dal.mysql.code;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.csdn.dal.dataobject.code.CodeDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.csdn.controller.admin.code.vo.*;

/**
 * csdn激活码 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface CodeMapper extends BaseMapperX<CodeDO> {

    default PageResult<CodeDO> selectPage(CodePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CodeDO>()
                .eqIfPresent(CodeDO::getUuid, reqVO.getUuid())
                .eqIfPresent(CodeDO::getCode, reqVO.getCode())
                .eqIfPresent(CodeDO::getDownUrl, reqVO.getDownUrl())
                .eqIfPresent(CodeDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CodeDO::getInsertTime, reqVO.getInsertTime())
                .betweenIfPresent(CodeDO::getUsedTime, reqVO.getUsedTime())
                .orderByDesc(CodeDO::getUuid));
    }

}