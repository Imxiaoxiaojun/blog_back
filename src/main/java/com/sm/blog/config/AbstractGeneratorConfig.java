package com.sm.blog.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.List;

/**
 * @ClassName AbstractGeneratorConfig
 * @Description TODO
 * @Author zhuyajun
 * @Date 2018/4/12 上午11:24
 * @Version 1.0
 **/
public abstract class AbstractGeneratorConfig {
    /**
     * mybatis-plus代码生成器配置
     */
    GlobalConfig globalConfig = new GlobalConfig();

    DataSourceConfig dataSourceConfig = new DataSourceConfig();

    StrategyConfig strategyConfig = new StrategyConfig();

    PackageConfig packageConfig = new PackageConfig();

    TableInfo tableInfo = null;

    protected Boolean controllerSwitch = true;    //是否生成控制器代码开关
    protected Boolean daoSwitch = true;           //dao
    protected Boolean serviceSwitch = true;       //service
    protected Boolean entitySwitch = true;        //生成实体的开关

    protected abstract void config();

    public AbstractGeneratorConfig() {
    }

    public void doMpGeneration() {
        init();
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.execute();
        destory();

        //获取table信息,用于guns代码生成
        List<TableInfo> tableInfoList = autoGenerator.getConfig().getTableInfoList();
        if (tableInfoList != null && tableInfoList.size() > 0) {
            this.tableInfo = tableInfoList.get(0);
        }
    }

    public void init() {
        config();

        if (controllerSwitch) {
            packageConfig.setController("TTT");
        }

        if (entitySwitch) {
            packageConfig.setEntity("TTT");
        }

        if (daoSwitch) {
            packageConfig.setMapper("TTT");
            packageConfig.setXml("TTT");
        }

        if (serviceSwitch) {
            packageConfig.setService("TTT");
            packageConfig.setServiceImpl("TTT");
        }
    }
    public void destory(){
        String outputDir = globalConfig.getOutputDir() + "/TTT";
//        FileUtil.delete(new File(outputDir));
    }
}
