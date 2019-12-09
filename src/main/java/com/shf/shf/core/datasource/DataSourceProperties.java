package com.shf.shf.core.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p><b>多数据源配置文件解析类</b></p>
 * @author Chao.yy  #2018年06月08日 下午2:27:31
 * @version V1.0
 *
 */
//@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {
    /**
     * 存储转换过的配置信息
     */
    private List<Properties> configProperties = new ArrayList<Properties>();
    /**
     *
     * <p><b>获取配置信息</b></p>
     * @author Chao.yy  # 2018年06月11日 上午11:36:56
     * @version V1.0
     * @return
     *
     */
    public List<Properties> getConfigProperties() {
        return configProperties;
    }
    /**
     *
     * <p><b>自动解析配置文件信息进行赋值</b></p>
     * @author Chao.yy  # 2018年06月11日 上午11:37:18
     * @version V1.0
     * @param multipleSource
     *
     */
    public void setMultipleSource(List<Map<String, String>> multipleSource) {
        configProperties.clear();
        //将解析到的配置信息按照druid规则统一加"druid."前缀
        for (Map<String, String> map : multipleSource) {
            Properties properties = new Properties();
            configProperties.add(properties);
            for (String key : map.keySet()) {
                properties.setProperty("druid." + key, map.get(key));
            }
        }
    }

}
