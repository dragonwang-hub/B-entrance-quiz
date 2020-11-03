### 完成度：
* 没有实现专门查询分组的接口

__Details:__



### 测试：
* 有Controller层测试，且覆盖了已完成的功能

__Details:__



### 知识点：
* 需要了解下三层架构
* 需要了解Restful实践
* 了解下lombok的使用

__Details:__

- \- @RequestMapping的produces可以省略
- \- 推荐使用构造器注入
- \- 违反Restful实践, url不合理
- \- 违反Restful实践, 创建资源的请求应该使用POST
- \- 应该使用Repository层保存数据
- \- 以下代码可以使用Java8 Stream简化
- \- 打乱顺序可以了解下Collections.shuffle()

### 工程实践：
* 包名不符合规范
* 注意单一职责，group和student应该有单独的Controller和Service
* 需要加强面向对象的意识

__Details:__

- \- 违反了封装性，字段应该使用private
- \- 应该创建专门的对象来表示Group
- \- 未使用的import语句
- \- 计算id的方式不够健壮，可以使用字段保存最大id
- \- 长方法，建议抽子方法来提高可读性
- \- Magic Number

### 综合：


__Details:__



