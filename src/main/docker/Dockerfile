# Docker image for springboot file run
# VERSION 0.0.1
# Author: jimfly
# 基础镜像使用java
FROM java:8
# 作者
MAINTAINER jimfly <821098588@qq.com>
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 指定当前操作目录
WORKDIR /usr/docker-jar
#指定对外端口号
EXPOSE 8090
# 运行jar包
RUN bash -c 'touch /bake.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bake.jar"]