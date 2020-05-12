# 参数解析 kata - 极客学院

> 背景： 看了极客学院发起的直播，由熊节老师讲解的TDD课程中的案例，观摩完后自己以TDD的节奏实现了一遍。

## 题目要求

实现一个参数解析器，通过自定义具体的解析规则，能正确解析命令行参数传入的参数，并返回相应类型的数值。

输入用例：

```
"-l true -d /usr/data -p 8080"
```

解析结果

```
assertThat(arguments.valueOf("l"), is(true));
assertThat(arguments.valueOf("d"), is("/usr/data"));
assertThat(arguments.valueOf("p"), is(8080));
```

## Tasking 任务分解

因为考虑main函数会将空格分隔的字符串数组，所以输入应考虑字符串数组的输入形式

```
// 1. create schema out of string
String schemaAsText = "l:boolean d:string p:integer";
Schema schema = new Schema(schemaAsText);

// 2. parse arguments
String[] argumentsAsStrings = {"-l", "true", "-d", "/usr/data", "-p", "8080"};
Parser arguments = new Parser(schema, argumentsAsStrings);

// 3. get parsed value
assertThat(arguments.valueOf("l"), is(true));
assertThat(arguments.valueOf("d"), is("/usr/data"));
assertThat(arguments.valueOf("p"), is(8080));
```


## 实现思路

内部以TreeMap作为底层数据结构实现，具体看测试用例的设计与代码

## 最终结果

实现100%测试率，但是仅刚好满足题目要求，还可以针对传参错误的情况做处理，这里暂时没做。
