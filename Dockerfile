from blueuninfo-registry.com:5000/oracle-java-font:8
MAINTAINER yueyu <yueyu@blueuninfo.com>
ENV LANG=en_US.UTF-8
ENV TZ=Asia/Shanghai
workdir /
add mtdms-service.jar mtd.jar
arg active
run echo "${active}"
arg active
#"-Dspring.profiles.active=$active"
cmd ["java","-jar","/mtd.jar"]