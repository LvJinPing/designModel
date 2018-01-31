### 状态模式
demo : 描述电梯的允许状态，并方便扩展
LifeState : 定义电梯各种状态允许运行的方法的并集。 并依赖 上下文 Context
xxxState: 继承LifeState ,提供当前状态实现，并设置 Context 的变更后状态
Context: 状态上下文，关联当前电梯状态。
需结合 UML 观看更加直观