#!/bin/sh
. ~/.bash_profile
echo \*************************************
echo *通用调用JAVA类
echo *参数说明 \$1 存放jar包的lib目录
echo *参数说明 \$2 类文件目录,不含package目录
echo *参数说明 \$3 类文件名，含package的名称
echo *参数说明 \$4 参数,采用+分隔
echo *使用示例 sh $0 /irabkg/iraweb/WEB-INF/lib /irabkg/iraweb/WEB-INF/classes com.sitech.audit.test.TestFlow 41
echo *当前运行 sh $0 $1 $2 $3 $4
echo \*************************************

###检查参数个数###
if [ $# -lt 3 ]; then
     echo "参数太少!"
     exit 0   
fi


#JAVA_HOME=/usr/java6_64
PROJECT_LIB=$1  #lib目录
PROJECT_CLASSPATH=$2  #类文件目录
CLASS_NAME=$3  #类文件名
PARAM_LIST=$4   #参数列表

###检查jar包目录是否存在###
if [ -z "${PROJECT_LIB}" ] ;then
     echo "jar包目录${PROJECT_LIB}不存在!"
     exit 0
fi

###分隔各个参数###
OLD_IFS="$IFS"
IFS="+"
PARAMS=($PARAM_LIST)   #linux下
#PARAMS=$(echo $PARAM_LIST)  #unix下
IFS="$OLD_IFS"
#echo $PARAM_LIST
#echo $PARAMS
#echo ${PARAMS[@]}   传入的参数

for i in "${PROJECT_LIB}"/*.jar; do
    PROJECT_CLASSPATH="${PROJECT_CLASSPATH}":"$i"
done

CLASSPATH=$JAVA_HOME/jre/lib/rt.jar:$PROJECT_CLASSPATH:$CLASSPATH
echo $CLASSPATH


$JAVA_HOME/bin/java -Ddefault.client.encoding="UTF-8" -Dfile.encoding="UTF-8" -Duser.language="Zh" -Duser.region="CN" -classpath $CLASSPATH $CLASS_NAME ${PARAMS[@]}












