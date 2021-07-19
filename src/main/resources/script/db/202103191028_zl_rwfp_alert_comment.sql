ALTER TABLE `his`.`zl_rwfp`
    MODIFY COLUMN `FPZT` int(0) NOT NULL COMMENT '分配状态 | 0：未分配    1：已分配    2：已预约' AFTER `YZ_JLXH`;

ALTER TABLE `his`.`cis_hzyz`
    MODIFY COLUMN `LSYZ` int(0) NOT NULL COMMENT '临时医嘱 | 0：长期医嘱    1：临时医嘱' AFTER `YFSB`;