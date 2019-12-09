package com.shf.shf.core.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shf.shf.core.dao.BaseDao;
import com.shf.shf.core.dao.PropertyMapper;
import com.shf.shf.core.domain.ConditionData;
import com.shf.shf.core.service.BaseService;
import com.shf.shf.core.util.GetGenericUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <b>基础服务实现</b>
 * </p>
 *
 * @author Chao.yy #2018年3月13日 下午10:19:35
 * @version V1.0
 */
public abstract class BaseServiceImpl<T, PK> implements BaseService<T, PK> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * <p>
     * <b>获取Dao实现</b>
     * </p>
     *
     * @return
     * @author Chao.yy #2018年3月13日 下午11:10:38
     * @version V1.0
     */
    public abstract BaseDao<T, PK> getDao();

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(T record) {
        return getDao().save(record);
    }

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveForBatch(List<T> records) {
        return getDao().saveForBatch(records);
    }

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(T record) {
        return getDao().updateByKey(record);
    }

    /**
     * <p>
     * <b>依据主键更新非空字段</b>
     * </p>
     *
     * @param record
     * @return
     * @author Chao.yy # 2018年05月24日 下午2:48:52
     * @version V1.0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByKeySelective(T record) {
        return getDao().updateByKeySelective(record);
    }

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int remove(PK id) {
        return getDao().removeByKey(id);
    }

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeForBatch(PK[] ids) {
        int ret = 0;
        if (ids != null && ids.length > 0) {
            ret = getDao().removeForBatch(Arrays.asList(ids));
        }
        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByCondition(Map<String, String> params) {
        List<ConditionData> conditions = param2Condition(params);
        return getDao().removeByCondition(conditions);
    }

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
    @Override
    public T queryByKey(PK id) {
        return getDao().queryByKey(id);
    }

    /**
     * <p>
     * <b>查询所有</b>
     * </p>
     *
     * @author Chao.yy #2018年3月13日 下午5:09:40
     * @version V1.0
     */
    @Override
    public List<T> queryList() {
        return getDao().queryList();
    }

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
    @Override
    public List<T> queryListByCondition(Map<String, String> params) {
        List<ConditionData> conditions = param2Condition(params);
        return getDao().queryListByCondition(conditions);
    }

    /**
     * <p>
     * <b>分页查询(无参数)</b>
     * </p>
     *
     * @param pageNum  页码
     * @param pageSize 每页条数
     * @return
     * @author Chao.yy # 2018年06月28日 下午5:59:18
     * @version V1.0
     */
    @Override
    public PageInfo<T> queryListByPage(int pageNum, int pageSize) {
        return queryListByPage(pageNum, pageSize, null);
    }

    /**
     * <p>
     * <b>分页查询 带参数</b>
     * </p>
     *
     * @param pageNum
     * @param pageSize
     * @param params   orderJson为排序参数 关键字
     *                 参数例子：{ "userName": "A%", "orderJson": "[{\"userName\":\"asc\"},{\"description\":\"desc\"}]"}
     * @return
     * @author Chao.yy #2018年3月13日 下午11:13:12
     * @version V1.0
     */
    @Override
    public PageInfo<T> queryListByPage(int pageNum, int pageSize, Map<String, String> params) {
        // 分页参数配置
        PageHelper.startPage(pageNum, pageSize);
        // 排序字段
        List<Map<String, String>> orderList = null;
        if (params != null) {
            // 从参数中取出排序字段 排序字段默认key为 orderJson
            String orderJson = params.get("orderJson");
            if (orderJson != null) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    orderList = mapper.readValue(orderJson, new TypeReference<List<Map<String, String>>>() {
                    });
                } catch (JsonParseException e) {
                    logger.error("JSON解析异常", e);
                } catch (JsonMappingException e) {
                    logger.error("JSON映射异常", e);
                } catch (IOException e) {
                    logger.error("IO读取异常", e);
                }
            }
        }
        // 添加排序
        String orderSQL = order2Condition(orderList);
        PageHelper.orderBy(orderSQL);
        List<T> list = queryListByCondition(params);
        // 用PageInfo对结果进行包装
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }

    /**
     * <p>
     * <b>将请求参数转换为SQL条件</b>
     * </p>
     *
     * @param params
     * @return
     * @author Chao.yy # 2018年08月28日 上午8:24:01
     * @version V1.0
     */
    private List<ConditionData> param2Condition(Map<String, String> params) {
        List<ConditionData> conditions = new ArrayList<ConditionData>();
        // 判断是否有参数
        if (params != null && !params.isEmpty()) {
            // 获取泛型参数的对象实例
            Object instance = GetGenericUtil.getInstance(this.getClass(), 0);
            PropertyMapper entityMapper = null;
            // 判断是否属于PropertyMapper的子类
            if (instance instanceof PropertyMapper) {
                entityMapper = (PropertyMapper) instance;
            }
            for (String key : params.keySet()) {
                //orderJson 是排序用参数key 遇到 就跳过
                if ("orderJson".equalsIgnoreCase(key)) {
                    continue;
                }
                // 获取查询属性映射的列名
                String columnName = null;
                // 如果是PropertyMapper的子类就获取属性对应的列名
                if (entityMapper != null) {
                    columnName = entityMapper.getPropertyMapper(key);
                } else {
                    // 如果不是PropertyMapper子类，就直接使用Key作为列名使用
                    columnName = key;
                }
                // 获取到对应列组织查询参数
                if (columnName != null) {
                    // 查询条件
                    String value = params.get(key);
                    //优先判断是否为null
                    if (value == null || "null".equalsIgnoreCase(value)) {
                        conditions.add(new ConditionData(columnName, " ", " IS NULL "));
                    }
                    // 逗号分隔采用包含查询
                    else if (value.contains(",")) {
                        String[] vs = value.split(",");
                        if (vs.length > 0) {
                            for (String string : vs) {
                                conditions.add(new ConditionData(columnName, "LIKE", "%" + string + "%"));
                            }
                        } else {
                            // 拆分后不是多条件，仍然采用等于查询
                            conditions.add(new ConditionData(columnName, "=", value));
                        }
                    }
                    //_x_分隔采用区间查询
                    else if (value.contains("_x_")) {
                        String[] vs = value.split("_x_");
                        if (vs.length == 2) {
                            conditions.add(new ConditionData(columnName, ">=", vs[0]));
                            conditions.add(new ConditionData(columnName, "<", vs[1]));
                        } else {
                            // 拆分后不是两个条件，仍然采用等于查询
                            conditions.add(new ConditionData(columnName, "=", value));
                        }
                    }
                    // 使用%采用模糊查询
                    else if (value.startsWith("%") || value.endsWith("%")) {
                        conditions.add(new ConditionData(columnName, "LIKE", value));
                    } else if ("isNotNull".equalsIgnoreCase(value)) {
                        conditions.add(new ConditionData(columnName, " ", " IS NOT NULL "));
                    }
                    // 等于查询
                    else {
                        conditions.add(new ConditionData(columnName, "=", value));
                    }
                } else {
                    logger.debug("未找到属性：" + key + "数据库映射字段");
                    // 未获取到对应列直接跳过
                    continue;
                }
            }
        }
        return conditions;
    }

    /**
     * <p>
     * <b>将排序参数转为排序SQL</b>
     * </p>
     *
     * @param orderList 排序字段集合，每个字段一个map 按序放入List
     * @return
     * @author Chao.yy # 2018年09月12日 下午11:15:41
     * @version V1.0
     */
    private String order2Condition(List<Map<String, String>> orderList) {
        StringBuffer orderByString = new StringBuffer("");
        if (orderList != null && orderList.size() > 0) {
            // 获取泛型参数的对象实例
            Object instance = GetGenericUtil.getInstance(this.getClass(), 0);
            PropertyMapper entityMapper = null;
            // 判断是否属于PropertyMapper的子类
            if (instance instanceof PropertyMapper) {
                entityMapper = (PropertyMapper) instance;
            }
            for (Map<String, String> params : orderList) {
                // 判断是否有参数
                if (params != null && !params.isEmpty()) {
                    for (String key : params.keySet()) {
                        // 获取查询属性映射的列名
                        String columnName = null;
                        // 如果是PropertyMapper的子类就获取属性对应的列名
                        if (entityMapper != null) {
                            columnName = entityMapper.getPropertyMapper(key);
                        } else {
                            // 如果不是PropertyMapper子类，就直接使用Key作为列名使用
                            columnName = key;
                        }
                        // 获取到对应列组织查询参数
                        if (columnName != null) {
                            // 排序方式
                            String value = params.get(key);
                            // 判断排序方式，不采用直接拼接value 为了防止sql注入
                            if ("ASC".equalsIgnoreCase(value) || "DESC".equalsIgnoreCase(value)) {
                                // 如果已经拼接有数据，添加逗号分隔
                                if (orderByString.length() > 0) {
                                    orderByString.append(",");
                                }
                                orderByString.append(columnName);
                                orderByString.append(" ");
                                orderByString.append(value.toUpperCase());
                            }
                        } else {
                            logger.debug("未找到属性：" + key + "数据库映射字段，不允许排序");
                            // 未获取到对应列直接跳过
                            continue;
                        }
                    }
                }
            }
        }
        return orderByString.toString();
    }
}
