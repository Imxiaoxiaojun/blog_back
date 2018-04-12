package com.sm.blog.config;

import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @ClassName MpGeneratorConfig
 * @Description Mybatis-plus 代码自动生成配置
 * @Author 'zhuyajun@maoyan.com
 * @Date 2018/4/12 上午11:20
 * @Version 1.0
 **/
public class MpGeneratorConfig extends AbstractGeneratorConfig{
    private String[] tableName;
    private String outDir;

    public MpGeneratorConfig(String[] tableName){
        this.tableName = tableName;
    }

    public void setTableName(String[] tableName) {
        this.tableName = tableName;
    }

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    protected void dataSourceConfig() {
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("manage");
        dataSourceConfig.setPassword("spdb1234");
        dataSourceConfig.setUrl("jdbc:mysql://www.sm.xin:3306/myblog?characterEncoding=utf8");
    }

    protected void globalConfig() {
//        globalConfig.setOutputDir();
        globalConfig.setFileOverride(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setOpen(false);
        globalConfig.setAuthor("zhuyajun");
    }

    protected void strategyConfig() {
        strategyConfig.setTablePrefix(new String[]{"sys_"});
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(tableName);
    }

    protected void packageConfig() {
        packageConfig.setParent(null);
        packageConfig.setEntity("com.sm.blog.model");
        packageConfig.setMapper("com.sm.blog.dao");
        packageConfig.setXml("mapping");
//        packageConfig.setService();
//        packageConfig.setServiceImpl();
    }

//    protected void contextConfig() {
//        contextConfig.setProPackage("com.stylefeng.guns.admin");
//        contextConfig.setCoreBasePackage("com.stylefeng.guns.core");
//        contextConfig.setBizChName("字典管理");
//        contextConfig.setBizEnName("sysDict");
//        contextConfig.setModuleName("system");
//        contextConfig.setProjectPath("D:\\ideaSpace\\guns\\guns-admin");//写自己项目的绝对路径
//        contextConfig.setEntityName("SysDict");
//        sqlConfig.setParentMenuName(null);//这里写已有菜单的名称,当做父节点
//
//        /**
//         * mybatis-plus 生成器开关
//         */
//        contextConfig.setEntitySwitch(true);
//        contextConfig.setDaoSwitch(true);
//        contextConfig.setServiceSwitch(true);
//    }

    @Override
    protected void config() {
        globalConfig();
        dataSourceConfig();
        strategyConfig();
        packageConfig();
//        contextConfig();
    }
}
