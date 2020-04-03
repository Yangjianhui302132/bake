# 源jar路径  即jenkins构建后存放的路径
SOURCE_PATH=/var/lib/jenkins/workspace
#docker 镜像/容器名字或者jar名字 这里都命名为这个
SERVER_NAME=bake
#操作/项目路径
BASE_PATH=/usr/docker-jar
#项目版本
JAR_VERSION=0.0.1-SNAPSHOT
echo "最新构建代码 $SOURCE_PATH/$SERVER_NAME/target/$SERVER_NAME-$JAR_VERSION.jar 迁移至 $BASE_PATH ...."
#把项目从jenkins构建后的目录移动到我们的项目目录下同时重命名下
 mv $SOURCE_PATH/$SERVER_NAME/target/$SERVER_NAME-$JAR_VERSION.jar $BASE_PATH/$SERVER_NAME.jar
 echo "迁移完成"


# 启动docker jdk镜像运行jar包
#关闭jdk8容器
docker stop $SERVER_NAME
#删除jdk8容器
docker rm $SERVER_NAME
# 使用jdk8容器运行目标jar
docker run -d -p 8090:8090 -v $BASE_PATH/$SERVER_NAME.jar:/usr/$SERVER_NAME.jar --name $SERVER_NAME java:8 java -jar /usr/$SERVER_NAME.jar
echo "$SERVER_NAME容器创建完成"