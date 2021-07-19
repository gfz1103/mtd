ALTER TABLE `his`.`im_hzry`
    ADD COLUMN `RYTJ` int(1) NULL COMMENT '入院途径 | 1：门诊转入    2：急诊转入    3：转院转入    4：其他' AFTER `GSRDH`;

ALTER TABLE `his`.`zl_zlzrw`
    MODIFY COLUMN `JLXH` int(0) NOT NULL COMMENT '记录序号' FIRST,
    ADD COLUMN `ZLRWFPID` int(0) NOT NULL COMMENT '康复治疗任务分配ID' AFTER `JLXH`;

ALTER TABLE `his`.`zl_rwmb`
    MODIFY COLUMN `JLXH` int(0) NOT NULL COMMENT '记录序号' FIRST;

ALTER TABLE `his`.`zl_zlpc`
    MODIFY COLUMN `JLXH` int(0) NOT NULL COMMENT '治疗批次记录序号' FIRST;