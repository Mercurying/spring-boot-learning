项目中依赖的spring-boot-starter-hello jar包安装配置
* spring-boot-starter-hello-1.0-SNAPSHOT.jar包位于/src/main/resources/static/目录下 
* 需要手动安装到maven本地仓库在进行导入  
* 使用命令maven命令:  
mvn install:install-file -DgroupId=com.mercury -DartifactId=spring-boot-starter-hello -Dversion=1.0-SNAPSHOT -Dpackaging=jar -Dfile=spring-boot-starter-hello-1.0-SNAPSHOT.jar

