### 桥梁模式 bridge
* Implementor 定义每个子类需要实现的方法与属性。  实现角色
    * 其实现类给出不同的实现
* Abstraction 定义角色的行为，并关联 Implementor  抽象角色
    * 实现类关联不同的 Implementor 子类。
抽象角色引用实现角色