-- 增加治疗记录表
CREATE TABLE `his`.`ZL_ZLJL`
(
    `JLXH`   int(0)                                                 NOT NULL COMMENT '记录序号',
    `ZYH`    int(0)                                                 NOT NULL COMMENT '住院号',
    `ZXRQ`   varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '执行日期',
    `ZXGH`   int(0)                                                 NULL COMMENT '执行治疗师工号',
    `JXGH`   int(0)                                                 NULL COMMENT '见习治疗师工号',
    `JLGH`   int(0)                                                 NULL COMMENT '记录工号',
    `JLSJ`   datetime(0)                                            NULL COMMENT '记录时间',
    `QXGH`   int(0)                                                 NULL COMMENT '取消时间',
    `QXSJ`   datetime(0)                                            NULL COMMENT '取消工号',
    `QXYY`   varchar(200)                                           NULL COMMENT '取消原因',
    `BLFY`   varchar(200)                                           NULL COMMENT '不良反应',
    `BZXX`   varchar(200)                                           NULL COMMENT '备注信息',
    `JDXJ`   varchar(200)                                           NULL COMMENT '阶段小结',
    `MQZXCS` int(0)                                                 NOT NULL COMMENT '目前执行次数',
    `SCXJCS` int(0)                                                 NULL COMMENT '上次小结次数',
    `ZT`     tinyint(1)                                             NOT NULL COMMENT '状态 | 0：启用    1：取消执行',
    PRIMARY KEY (`JLXH`)
) COMMENT = '治疗记录表';

ALTER TABLE `his`.`zl_zlzrw`
    ADD COLUMN `FYSJ` datetime(0) NULL COMMENT '费用时间' AFTER `JZSJ`,
    MODIFY COLUMN `ZXZT` int(0) NOT NULL COMMENT '预约执行状态 | 0：未执行    2：已执行' AFTER `ZLPC_JLXH`;