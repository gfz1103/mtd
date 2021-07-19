ALTER TABLE `his`.`ss_ssjzdzb`
    MODIFY COLUMN `JZLX` int(0) NULL DEFAULT NULL COMMENT '记账类型 | 1：手术记账 2：麻醉记账' AFTER `SSKSDM`;

ALTER TABLE `his`.`zl_xmldsfxm`
    ADD COLUMN `SFXMMC` varchar(100)   NULL COMMENT '收费项目名称' AFTER `SFXMDM`,
    ADD COLUMN `JE`     decimal(10, 4) NULL COMMENT '金额' AFTER `SL`,
    MODIFY COLUMN `ZLXMMC` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '治疗项目名称' AFTER `ZLXM_JLXH`;