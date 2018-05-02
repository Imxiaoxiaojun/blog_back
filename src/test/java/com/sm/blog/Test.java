package com.sm.blog;


import com.sm.blog.model.Article;
import com.sm.core.base.json.CustomerJsonSerializer;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zhuyajun
 * @Date 2018/4/12 下午2:54
 * @Version 1.0
 **/
public class Test {
    public static void main(String args[]) throws Exception{
        CustomerJsonSerializer cjs= new CustomerJsonSerializer();
        // 设置转换 Article 类时，只包含 id, name
        cjs.filter(Article.class, "id,name", null);

        String include = cjs.toJson(new Article());

        cjs = new CustomerJsonSerializer();
        // 设置转换 Article 类时，过滤掉 id, name
        cjs.filter(Article.class, null, "id,name");

        String filter = cjs.toJson(new Article());

        System.out.println("include: " + include);
        System.out.println("filter: " + filter);
    }
}
