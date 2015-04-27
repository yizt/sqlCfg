-------------------------------------------
-- Export file for user MODEL            --
-- Created by yzt on 2013/6/28, 17:04:15 --
-------------------------------------------

spool tab_ddl.log

prompt
prompt Creating table TB_EXECSQL
prompt =========================
prompt
create table TB_EXECSQL
(
  DATATIME       VARCHAR2(8),
  FUNC_ID        VARCHAR2(40),
  SEQ            INTEGER,
  MEMO           VARCHAR2(100),
  EXEC_SQL       CLOB,
  FLAG           INTEGER,
  ERR_MSG        VARCHAR2(4000),
  AFFECT_ROWNUM  INTEGER,
  START_TIME     DATE,
  END_TIME       DATE,
  EXEC_ELAPSED   INTEGER,
  EXEC_DATE      DATE,
  CHECK_ERR      VARCHAR2(240),
  DEPENDENT      INTEGER,
  BUSINESS_PARAM VARCHAR2(40)
)
;
comment on table TB_EXECSQL
  is '通用sql执行表';
comment on column TB_EXECSQL.DATATIME
  is '数据时间';
comment on column TB_EXECSQL.FUNC_ID
  is '功能标识';
comment on column TB_EXECSQL.SEQ
  is '执行顺序';
comment on column TB_EXECSQL.MEMO
  is '说明';
comment on column TB_EXECSQL.EXEC_SQL
  is '执行的sql';
comment on column TB_EXECSQL.FLAG
  is '0:成功；其它失败';
comment on column TB_EXECSQL.ERR_MSG
  is '运行错误信息（可以记录多次错误的信息）';
comment on column TB_EXECSQL.AFFECT_ROWNUM
  is '影响的行数';
comment on column TB_EXECSQL.START_TIME
  is '开始时间';
comment on column TB_EXECSQL.END_TIME
  is '结束时间';
comment on column TB_EXECSQL.EXEC_ELAPSED
  is '执行消耗时间（秒）';
comment on column TB_EXECSQL.EXEC_DATE
  is '预定执行日期';
comment on column TB_EXECSQL.CHECK_ERR
  is '语法检查错误信息';
comment on column TB_EXECSQL.DEPENDENT
  is '依赖关系';
comment on column TB_EXECSQL.BUSINESS_PARAM
  is '业务参数';
create index IDX_TB_EXECSQL on TB_EXECSQL (DATATIME, FUNC_ID, SEQ);

prompt
prompt Creating table TB_PARAM_CFG
prompt ===========================
prompt
create table TB_PARAM_CFG
(
  FUNC_ID        VARCHAR2(20),
  PARAM_TYPE     VARCHAR2(20),
  PARAM_NAME     VARCHAR2(40),
  PARAM_DESC     VARCHAR2(200),
  PARAM_FORMAT   VARCHAR2(40),
  PARAM_VAL_EXPR VARCHAR2(1000),
  ENABLE         VARCHAR2(1) default '1',
  REPLACE_ORDER  NUMBER
)
;
comment on table TB_PARAM_CFG
  is '通用替换参数配置表';
comment on column TB_PARAM_CFG.FUNC_ID
  is '功能id；commom-公共；其它-具体的func_id使用';
comment on column TB_PARAM_CFG.PARAM_TYPE
  is '参数类型；in-传入参数；single-单值替换；set-数据集合替换';
comment on column TB_PARAM_CFG.PARAM_NAME
  is '替换参数名称';
comment on column TB_PARAM_CFG.PARAM_DESC
  is '参数说明';
comment on column TB_PARAM_CFG.PARAM_FORMAT
  is '参数格式';
comment on column TB_PARAM_CFG.PARAM_VAL_EXPR
  is '参数取值表达式';
comment on column TB_PARAM_CFG.ENABLE
  is '是否有效；1-有效；0-无效';
comment on column TB_PARAM_CFG.REPLACE_ORDER
  is '替换顺序';
create unique index IDX_TB_PARAM_CFG on TB_PARAM_CFG (FUNC_ID, PARAM_NAME);

prompt
prompt Creating table TB_SQL_CFG
prompt =========================
prompt
create table TB_SQL_CFG
(
  SEQ       NUMBER not null,
  FUNC_ID   VARCHAR2(40) not null,
  CFG_KEY   VARCHAR2(40),
  MEMO      VARCHAR2(100),
  EXEC_SQL  CLOB,
  PARM_KEY  VARCHAR2(100),
  PARM_VAL  VARCHAR2(200),
  ENABLE    VARCHAR2(1) default '1',
  DEPENDENT INTEGER,
  STAT_DAYS VARCHAR2(1000)
)
;
comment on table TB_SQL_CFG
  is '通用sql配置表';
comment on column TB_SQL_CFG.SEQ
  is '执行顺序';
comment on column TB_SQL_CFG.FUNC_ID
  is '功能标识(以''模块标志_''开头)';
comment on column TB_SQL_CFG.CFG_KEY
  is '配置标志，在功能中标志该sql脚本';
comment on column TB_SQL_CFG.MEMO
  is '说明';
comment on column TB_SQL_CFG.EXEC_SQL
  is '执行的sql';
comment on column TB_SQL_CFG.PARM_KEY
  is '参数键；在程序中不实际起作用，方便查看替换的参数';
comment on column TB_SQL_CFG.PARM_VAL
  is '参数值；在程序中不实际起作用，方便查看替换的参数';
comment on column TB_SQL_CFG.ENABLE
  is '是否有效；1-有效；0-无效';
comment on column TB_SQL_CFG.DEPENDENT
  is '依赖关系';
comment on column TB_SQL_CFG.STAT_DAYS
  is '统计日期：(日期集合)';


spool off





===============================mysql下表结构==========================

CREATE TABLE `tb_sql_cfg` (
  `SEQ` bigint(22) DEFAULT NULL,
  `FUNC_ID` varchar(40) DEFAULT NULL,
  `CFG_KEY` varchar(40) DEFAULT NULL,
  `MEMO` varchar(100) DEFAULT NULL,
  `EXEC_SQL` longtext,
  `PARM_KEY` varchar(100) DEFAULT NULL,
  `PARM_VAL` varchar(200) DEFAULT NULL,
  `ENABLE` varchar(1) DEFAULT NULL,
  `DEPENDENT` bigint(22) DEFAULT NULL,
  `STAT_DAYS` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `tb_param_cfg` (
  `FUNC_ID` varchar(20) NOT NULL DEFAULT '',
  `PARAM_TYPE` varchar(20) NOT NULL DEFAULT '',
  `PARAM_NAME` varchar(40) NOT NULL DEFAULT '',
  `PARAM_DESC` varchar(200) DEFAULT NULL,
  `PARAM_FORMAT` varchar(40) DEFAULT NULL,
  `PARAM_VAL_EXPR` text,
  `ENABLE` varchar(1) DEFAULT NULL,
  `REPLACE_ORDER` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`FUNC_ID`,`PARAM_TYPE`,`PARAM_NAME`),
  UNIQUE KEY `IDX_TB_PARAM_CFG` (`FUNC_ID`,`PARAM_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `tb_execsql` (
  `DATATIME` varchar(8) NOT NULL DEFAULT '',
  `FUNC_ID` varchar(40) NOT NULL DEFAULT '',
  `SEQ` bigint(22) NOT NULL DEFAULT '0',
  `MEMO` varchar(100) DEFAULT NULL,
  `EXEC_SQL` longtext,
  `FLAG` bigint(22) DEFAULT NULL,
  `ERR_MSG` text,
  `AFFECT_ROWNUM` bigint(22) DEFAULT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `EXEC_ELAPSED` bigint(22) DEFAULT NULL,
  `EXEC_DATE` datetime DEFAULT NULL,
  `CHECK_ERR` varchar(240) DEFAULT NULL,
  `DEPENDENT` bigint(22) DEFAULT NULL,
  `BUSINESS_PARAM` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`DATATIME`,`FUNC_ID`,`SEQ`,`BUSINESS_PARAM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8