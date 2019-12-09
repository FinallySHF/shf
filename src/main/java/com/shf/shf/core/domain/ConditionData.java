package com.shf.shf.core.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p><b>查询参数封装对象</b></p>
 * @author Chao.yy  #2018年06月04日 下午5:55:01
 * @version V1.0
 * 
 */
@ApiModel(description="查询参数封装对象")
public class ConditionData {
    
    @ApiModelProperty(value="列名")
    private String columnName;
    @ApiModelProperty(value="运算符")
    private String operator;
    @ApiModelProperty(value="参数值")
    private String value;

    /**
     * 
     * <p><b>ConditionData.java构造函数</b></p>
     * @author Chao.yy  # 2018年06月04日 下午5:57:11
     * @version V1.0
     *
     */
    public ConditionData() {
        super();
    }
    
    
    /**
     * 
     * <p><b>ConditionData.java构造函数</b></p>
     * @author Chao.yy  # 2018年06月04日 下午5:57:16
     * @version V1.0
     * @param columnName
     * @param operator
     * @param value
     *
     */
    public ConditionData(String columnName, String operator, String value) {
        super();
        this.columnName = columnName;
        this.operator = operator;
        this.value = value;
    }
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
