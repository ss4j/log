# frame-log
此为公司的json格式log的java版本实现。


其主要为重新实现log4j2的Layout。



## 使用
1.引入依赖包

```
<dependency>
    <groupId>com.hfjy</groupId>
    <artifactId>base-frame-log</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```


2.在log4j2.xml中配置该Layout，如需要在控制台输出JSON，则在`Console`中添加如下：

```
<Console name="Console" target="SYSTEM_OUT">
    <HFJsonLayout appImage="${appImage}" appVersion="${appVersion}" serverName="${serverName}"
    serverIp="${serverIp}"/>
</Console>
```

3.使用: 其使用最后一个参数做为指定的自定义日志对象，如果没有指定，则默认为`system`类型的log


```
ServerLog info = new ServerLog("aaa-node", "h2c",System.currentTimeMillis()).setWeight(100);
serverLog.info("参数测试, A: {}", "hello", info);
```

4.输出，如下：

```
{"appImage":"demoImage","appVersion":"V1","level":"info","logType":"system","msg":"Started DemoApplication in 1.558 seconds (JVM running for 7.265)\n","serverIp":"192.168.0.11","serverName":"demo-service"}
{"appImage":"demoImage","appVersion":"V1","level":"info","logType":"system","msg":"这是一个测试!!\n","serverIp":"192.168.0.11","serverName":"demo-service"}
{"appImage":"demoImage","appVersion":"V1","level":"info","logType":"server","msg":"参数测试, A: hello\n","node":"aaa-node","proto":"h2c","serverIp":"192.168.0.11","serverName":"demo-service","startTime":1558076347556,"weight":100}
{"appImage":"demoImage","appVersion":"V1","level":"error","logType":"server","msg":"-_-出现异常了,原因：我是故意的, [com.liukun.demoservice.config.DemoStartup.run(DemoStartup.java:29), org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:804), org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:794), org.springframework.boot.SpringApplication.run(SpringApplication.java:324), org.springframework.boot.SpringApplication.run(SpringApplication.java:1260), org.springframework.boot.SpringApplication.run(SpringApplication.java:1248), com.liukun.demoservice.DemoApplication.main(DemoApplication.java:9)]\n","node":"aaa-node","proto":"h2c","serverIp":"192.168.0.11","serverName":"demo-service","startTime":1558076347556,"weight":100}
```