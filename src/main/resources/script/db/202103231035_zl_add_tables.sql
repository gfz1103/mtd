ALTER TABLE `his`.`zl_rwmb`
    MODIFY COLUMN `YYZT` int(0) NOT NULL COMMENT '预约状态 |  1：未预约    2：已预约    3：已开始执行    4：执行完毕' AFTER `ZXGH`;

ALTER TABLE `his`.`zl_rwfp`
    MODIFY COLUMN `FPZT` int(0) NOT NULL COMMENT '分配状态 | 0：未分配    1：已分配' AFTER `YZ_JLXH`;