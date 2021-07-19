ALTER TABLE `his`.`zl_rwfp`
    MODIFY COLUMN `FPZT` int(0) NOT NULL COMMENT '分配状态 | 0：未分配    1：已分配    2：已预约    3：已开始执行' AFTER `YZ_JLXH`;