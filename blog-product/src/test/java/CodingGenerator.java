import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 自动生成代码工具- 基于MyBatis-Plus
public class CodingGenerator {
    @Test
    public void test(){
        // 数据库名称 icoding_mall
        // 模块名 mall
        String moduleName = "blog";

        // 1.创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2. 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir"); //获取项目目录
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("yan"); // 文档注释 作者名
        gc.setOpen(false); // 是否打开资源管理器

        gc.setFileOverride(false); // 重新生成文件的时候是否覆盖
        gc.setServiceImplName("%sService"); // 去掉接口的首字母I
        gc.setIdType(IdType.ID_WORKER_STR); // 主键策略
        gc.setDateType(DateType.ONLY_DATE); // 定义生成的实体类中的日期类型
        gc.setSwagger2(true);  // 实体属性 Swagger2 注解

        mpg.setGlobalConfig(gc);


        // 3、 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/my_blog_db?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL); // 设置数据库类型

        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName); //模块名 ：com.coding.mall
        pc.setParent("com.anuo");
        pc.setController("controller.tb");
        pc.setMapper("mapper.tb");
        pc.setXml("mapper.tb");
        pc.setService("service.tb");
        pc.setServiceImpl("service.tb");
        pc.setEntity("entity.tb");

        mpg.setPackageInfo(pc);

        //5、 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("tb_\\w*");//设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体类的命名策略
        strategy.setTablePrefix("tb_"); //代表前缀不生成
        strategy.setEntityLombokModel(true); //链式编程
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 数据库列映射到实体类的命名策略

        strategy.setLogicDeleteFieldName("is_delete"); //逻辑删除字段
        strategy.setEntityBooleanColumnRemoveIsPrefix(true); //去掉布尔值的 is_ 前缀

        // 自动填充,策略
        TableFill gmtCreate = new TableFill("create_time",FieldFill.INSERT);
        TableFill gmtModified = new TableFill("update_time",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);

        strategy.setTableFillList(tableFills);

        //乐观锁
        strategy.setVersionFieldName("version");

        strategy.setRestControllerStyle(true); //restful api风格
        strategy.setControllerMappingHyphenStyle(true) ;// URL中驼峰转连字符  addProduct add-product

        mpg.setStrategy(strategy);

        // 执行代码生成器
        mpg.execute();
    }

}
