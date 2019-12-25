# This is a README
## VER 0.0
### basic funcion
+ 连接mysql数据库
1、使用的是内置字符串，可更改空间不够，尚需改进
2、关于出现invalid timezone，要在mysql中查询系统时间，默认为system，改为+8:00即可
+ 配置maven
1、maven 本地仓库，idea默认在C:\\[ideaPATH]\.m2文件夹下
2、idea没有setting.xml，配置都是在pom.xml里完成
3、maven默认jdk版本为1.5，需要在多处更改
4、pom中关于jdk的修改，以1.8为例
```xml
	<properties>
       <project.build.sourceEncoding>UTF8</project.build.sourceEncoding>
        <maven.compiler.encoding>UTF-8</maven.compiler.encoding>
        <java.version>1.8</java.version>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
```
## VER 0.5 15:09/24/12/19
### new features
+ 配置了tomcat
+ 配置了web.xml

## VER 1.0 15:29/25/12/19
### notes:
+ 解决tomcat 9.0以上版本在idea中的乱码问题
*解决方法*：tomcat/conf/logging.properties中
java.util.logging.ConsoleHandler.encoding = UTF-8修改为GBK

