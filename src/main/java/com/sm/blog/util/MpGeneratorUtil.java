package com.sm.blog.util;

import com.sm.core.config.MpGeneratorConfig;


/**
 * @ClassName MpGeneratorTest
 * @Description 根据数据库表生成代码模板
 * @Author zhuyajun
 * @Date 2018/4/12 下午1:18
 * @Version 1.0
 **/
public class MpGeneratorUtil {

    public static void main(String[] args) {

        MpGeneratorConfig mpGeneratorConfig = new MpGeneratorConfig();
        //要单独生成代码模板的表名，不写默认全部
        String[] tableName = new String[]{"article",""};
//        mpGeneratorConfig.setTableName(tableName);
        mpGeneratorConfig.setProgramName("blog_back");
        mpGeneratorConfig.doMpGeneration();
    }
}
