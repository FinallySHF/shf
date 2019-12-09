package com.shf.shf.core.dao;

import com.shf.shf.core.domain.ConditionData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * <b>基本数据持久层接口</b>
 * </p>
 *
 * @param <T>
 * @param <PK>
 * @author Chao.yy #2018年3月13日 下午5:06:51
 * @version V1.0
 */

public interface BaseDao<T, PK> {

    /**
     * <p>
     * <b>保存记录</b>
     * </p>
     *
     * @param record 数据记录
     * @return 更新记录条数
     * @author Chao.yy #2018年3月13日 下午5:06:57
     * @version V1.0
     */
    int save(T record);

    /**
     * <p>
     * <b>批量保存</b>
     * </p>
     *
     * @param records
     * @return
     * @author Chao.yy # 2018年05月24日 下午2:53:41
     * @version V1.0
     */
    int saveForBatch(List<T> records);

    /**
     * <p>
     * <b>依据主键更新记录</b>
     * </p>
     *
     * @param record 待更新的记录
     * @return 更新记录条数
     * @author Chao.yy #2018年3月13日 下午5:07:23
     * @version V1.0
     */
    int updateByKey(T record);

    /**
     * <p>
     * <b>依据主键更新不为空的字段</b>
     * </p>
     *
     * @param record 待更新的记录
     * @return 更新记录条数
     * @author Chao.yy #2018年3月13日 下午5:07:51
     * @version V1.0
     */
    int updateByKeySelective(T record);

    /**
     * <p>
     * <b>根据主键进行删除</b>
     * </p>
     *
     * @param id 主键
     * @return 删除条数
     * @author Chao.yy #2018年3月13日 下午5:18:49
     * @version V1.0
     */
    int removeByKey(PK id);

    /**
     * <p>
     * <b>批量删除</b>
     * </p>
     *
     * @param ids 主键集合
     * @return 删除记录条数
     * @author Chao.yy #2018年3月13日 下午5:18:26
     * @version V1.0
     */
    int removeForBatch(@Param("ids") List<PK> ids);

    /**
     * <p>
     * <b>依据条件删除</b>
     * </p>
     *
     * @param params
     * @return
     * @author Chao.yy # 2018年08月28日 上午8:18:57
     * @version V1.0
     */
    int removeByCondition(@Param("params") List<ConditionData> params);

    /**
     * <p>
     * <b>查询所有</b>
     * </p>
     *
     * @return
     * @author Chao.yy #2018年3月13日 下午5:09:40
     * @version V1.0
     */
    List<T> queryList();

    /**
     * <p>
     * <b>根据主键查询一个</b>
     * </p>
     *
     * @param id 主键
     * @return
     * @author Chao.yy #2018年3月13日 下午5:09:15
     * @version V1.0
     */
    T queryByKey(PK id);

    /**
     * <p>
     * <b>按条件查询对象集合</b>
     * </p>
     *
     * @param params 字段名称，字段值集合 多条件 AND 关系
     * @return
     * @author Chao.yy #2018年3月13日 下午5:08:45
     * @version V1.0
     */
    List<T> queryListByCondition(@Param("params") List<ConditionData> params);

}
