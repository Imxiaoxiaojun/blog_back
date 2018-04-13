package com.sm.blog.util;

import com.sm.core.config.MpGeneratorConfig;


/**
 * @ClassName MpGeneratorTest
 * @Description TODO
 * @Author zhuyajun
 * @Date 2018/4/12 下午1:18
 * @Version 1.0
 **/
public class MpGeneratorUtil {

    public static void main(String[] args) {
        String[] tableName = new String[]{"article",""};
        MpGeneratorConfig mpGeneratorConfig = new MpGeneratorConfig();
        mpGeneratorConfig.setTableName(tableName);
        mpGeneratorConfig.setProgramName("blog_back");
        mpGeneratorConfig.doMpGeneration();
    }
}
