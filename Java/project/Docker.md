# 镜像相关
1. 如何批量清理临时镜像文件？
可以使用sudo docker rmi $(sudo docker images -q -f danging=true)命令
2. 如何查看镜像支持的环境变量？
sudo docker run IMAGE env
3. 本地的镜像文件都存放在哪里
/var/lib/docker其中container目录存放容器信息，graph目录存放镜像信息，aufs目录下存放具体的镜像底层文件。
4. 构建Docker镜像应该遵循哪些原则？

整体远侧上，尽量保持镜像功能的明确和内容的精简，要点包括：

 尽量选取满足需求但较小的基础系统镜像，建议选择debian:wheezy镜像，仅有86MB大小
 清理编译生成文件、安装包的缓存等临时文件
 安装各个软件时候要指定准确的版本号，并避免引入不需要的依赖
 从安全的角度考虑，应用尽量使用系统的库和依赖
 使用Dockerfile创建镜像时候要添加.dockerignore文件或使用干净的工作目录

5. 容器退出后，通过docker ps 命令查看不到，数据会丢失么？

容器退出后会处于终止（exited）状态，此时可以通过 docker ps -a 查看，其中数据不会丢失，还可以通过docker start 来启动，只有删除容器才会清除数据。
6. 如何停止所有正在运行的容器？
使用docker kill $(sudo docker ps -q)
7. 如何清理批量后台停止的容器？
使用docker rm $（sudo docker ps -a -q）
8. 如何临时退出一个正在交互的容器的终端，而不终止它？
按Ctrl+p，后按Ctrl+q，如果按Ctrl+c会使容器内的应用进程终止，进而会使容器终止。
9. 很多应用容器都是默认后台运行的，怎么查看它们的输出和日志信息？
使用docker logs，后面跟容器的名称或者ID信息
10. 使用docker port 命令映射容器的端口时，系统报错Error: No public port ‘80’ published for …，是什么意思？
创建镜像时Dockerfile要指定正确的EXPOSE的端口，容器启动时指定PublishAllport=true
11. 可以在一个容器中同时运行多个应用进程吗？
一般不推荐在同一个容器内运行多个应用进程，如果有类似需求，可以通过额外的进程管理机制，比如supervisord来管理所运行的进程
12. 如何控制容器占用系统资源（CPU，内存）的份额？
在使用docker create命令创建容器或使用docker run 创建并运行容器的时候，可以使用-c|–cpu-shares[=0]参数来调整同期使用CPU的权重，使用-m|–memory参数来调整容器使用内存的大小。