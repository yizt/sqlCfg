#!/bin/sh
#. ~/.bash_profile
path=`dirname "$0"`  #当前路径
path=`cd "$path"; pwd`  #当前路程;全路径名

lib=`cd "$path"; cd ..;cd lib ;pwd` #lib目录
logs=`cd "$path"; cd ..;cd logs ;pwd` #lib目录

nohup sh "$path"/comRunJava.sh $lib $path com.sitech.sqlcfg.Start $1 & 