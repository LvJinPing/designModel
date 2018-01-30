package com.xiaoyao.designModel.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyao
 * @version 1.0
 * @since 2018-01-30
 */
public class Client {
    public static void main(String[] args) {
        List<Element> l = new ArrayList<>();
        // 访问者模式 这里违背了依赖倒置原则的
        CommenElement e1 = new CommenElement();
        e1.setAge("18");
        e1.setName("xxx");
        e1.setSalary(12);
        e1.setJob("敲代码");
        l.add(e1);
        MangerElement e2 = new MangerElement();
        e2.setAge("18");
        e2.setName("xxx");
        e2.setSalary(12);
        e2.setPerformance("招收了3 个人");
        l.add(e2);
        Visitor v = new SpecificVisitor();
        for (Element element : l) {
            element.accept(v);
        }
    }
}
