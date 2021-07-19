ALTER TABLE `his`.`zl_zlpc`
    MODIFY COLUMN `KSSJ` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约开始时间' AFTER `ZLRQ`,
    MODIFY COLUMN `JSSJ` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约结束时间' AFTER `KSSJ`,
    ADD COLUMN `SJKSSJ` varchar(10) NULL COMMENT '实际开始时间 | 更改治疗记录单时保存' AFTER `JSSJ`,
    ADD COLUMN `SJJSSJ` varchar(10) NULL COMMENT '实际结束时间 | 更改治疗记录单时保存' AFTER `SJKSSJ`,
    ADD COLUMN `ZFPB`   tinyint(1)  NULL COMMENT '作废判别 | 0：启用    1：作废' AFTER `SJJSSJ`;

ALTER TABLE `his`.`zl_rwfp`
    MODIFY COLUMN `FPZT` tinyint(1) NOT NULL COMMENT '分配状态 | 0：未分配    2：已分配' AFTER `SCZXRQ`,
    ADD COLUMN `YYZT` tinyint(1) NULL DEFAULT NULL COMMENT '预约状态 | 0：未预约    1：部分预约    2：已预约' AFTER `FPZT`,
    ADD COLUMN `ZXZT` tinyint(1) NULL DEFAULT NULL COMMENT '执行状态 | 0：未执行    1：部分执行    2：已执行' AFTER `YYZT`,
    ADD COLUMN `YZZT` tinyint(1) NULL COMMENT '医嘱状态 | 0：正常（执行中）    1：已停嘱' AFTER `ZXZT`;

ALTER TABLE `his`.`zl_zlzrw`
    MODIFY COLUMN `ZXZT` int(0) NOT NULL COMMENT '预约执行状态 | 0：未执行    2：已执行    3：取消执行' AFTER `ZLPC_JLXH`;

ALTER TABLE `his`.`zl_rwmb`
    MODIFY COLUMN `YYZT` int(0) NOT NULL COMMENT '预约状态 | 0：未预约    2：已预约' AFTER `ZYH`,
    ADD COLUMN `ZFPB` tinyint(1) NOT NULL COMMENT '作废判别 | 0：启用    1：作废' AFTER `SCZXRQ`,
    ADD COLUMN `ZXZT` tinyint(1) NULL DEFAULT NULL COMMENT '执行状态 | 0：未执行    1：已开始执行    2：已执行' AFTER `ZFPB`;