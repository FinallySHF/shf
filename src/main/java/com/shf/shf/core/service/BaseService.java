package com.shf.shf.core.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

/**
 * <p>
 * <b>业务逻辑层基类</b>
 * </p>
 * 
 * @author Chao.yy #2018年3月13日 下午5:19:19
 * @version V1.0
 * @param <T>
 *            业务实体类
 * @param <PK>
 *            主键类型
 */
public interface BaseService<T, PK> {

	/**
	 * <p>
	 * <b>保存记录</b>
	 * </p>
	 * 
	 * @author Chao.yy #2018年3月13日 下午5:06:57
	 * @version V1.0
	 * @param record
	 *            数据记录
	 * @return 更新记录条数
	 */
	int save(T record);

	/**
	 * 
	 * <p>
	 * <b>批量保存</b>
	 * </p>
	 * 
	 * @author Chao.yy # 2018年05月24日 下午2:53:41
	 * @version V1.0
	 * @param records
	 * @return
	 *
	 */
	int saveForBatch(List<T> records);

	/**
	 * <p>
	 * <b>依据主键更新记录</b>
	 * </p>
	 * 
	 * @author Chao.yy #2018年3月13日 下午5:07:23
	 * @version V1.0
	 * @param record
	 *            待更新的记录
	 * @return 更新记录条数
	 */

	int update(T record);

	/**
	 * 
	 * <p>
	 * <b>依据主键更新非空字段</b>
	 * </p>
	 * 
	 * @author Chao.yy # 2018年05月24日 下午2:48:52
	 * @version V1.0
	 * @param record
	 * @return
	 *
	 */

	int updateByKeySelective(T record);

	/**
	 * <p>
	 * <b>根据主键进行删除</b>
	 * </p>
	 * 
	 * @author Chao.yy #2018年3月13日 下午5:18:49
	 * @version V1.0
	 * @param id
	 *            主键
	 * @return 删除条数
	 */

	int remove(PK id);

	/**
	 * <p>
	 * <b>批量删除</b>
	 * </p>
	 * 
	 * @author Chao.yy #2018年3月13日 下午5:18:26
	 * @version V1.0
	 * @param ids
	 *            主键集合
	 * @return 删除记录条数
	 */

	int removeForBatch(PK[] ids);

	/**
	 * 
	 * <p>
	 * <b>依据条件删除</b>
	 * </p>
	 * 
	 * @author Chao.yy # 2018年08月28日 上午8:20:10
	 * @version V1.0
	 * @param params
	 * @return
	 *
	 */
	int removeByCondition(Map<String, String> params);

	/**
	 * <p>
	 * <b>查询所有</b>
	 * </p>
	 * 
	 * @author Chao.yy #2018年3月13日 下午5:09:40
	 * @version V1.0
	 * @return
	 */
	List<T> queryList();

	/**
	 * <p>
	 * <b>根据主键查询一个</b>
	 * </p>
	 * 
	 * @author Chao.yy #2018年3月13日 下午5:09:15
	 * @version V1.0
	 * @param id
	 *            主键
	 * @return
	 */
	T queryByKey(PK id);

	/**
	 * <p>
	 * <b>按条件查询对象集合</b>
	 * </p>
	 * 
	 * @author Chao.yy #2018年3月13日 下午5:08:45
	 * @version V1.0
	 * @param params
	 *            字段名称，字段值集合 多条件 AND 关系
	 * @return
	 */
	List<T> queryListByCondition(@Param("params") Map<String, String> params);

	/**
	 * <p>
	 * <b>分页查询(有参)</b>
	 * </p>
	 * 
	 * @author Chao.yy #2018年3月13日 下午5:27:17
	 * @version V1.0
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            每页条数
	 * @param params
	 *            查询参数
	 * @return
	 */
	PageInfo<T> queryListByPage(int pageNum, int pageSize, Map<String, String> params);

	/**
	 * <p>
	 * <b>分页查询(无参数)</b>
	 * </p>
	 * 
	 * @author Chao.yy # 2018年06月28日 下午5:59:18
	 * @version V1.0
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            每页条数
	 * @return
	 */
	PageInfo<T> queryListByPage(int pageNum, int pageSize);

	
}
