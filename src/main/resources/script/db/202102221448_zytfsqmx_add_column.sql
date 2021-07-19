ALTER TABLE `his`.`ss_ssjzdmx`
    MODIFY COLUMN `JZ_JLXH` int(0) NULL DEFAULT NULL COMMENT '住院费用明细记录序号' AFTER `YTFSL`,
    ADD COLUMN `YPCD` int(0)                                                        NULL COMMENT '药品产地' AFTER `sqdh`,
    ADD COLUMN `CDMC` text                                                          NULL COMMENT '产地名称' AFTER `YPCD`,
    ADD COLUMN `YFGG` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药房规格' AFTER `CDMC`,
    ADD COLUMN `YPLX` int(0)                                                        NULL DEFAULT NULL COMMENT '药品类型 | 1：西药 2：中成药 3：中草药' AFTER `YFGG`;

ALTER TABLE `his`.`ss_zytfsqmx`
    MODIFY COLUMN `JZXH` int(0) NULL DEFAULT NULL COMMENT '手术记账明细记录序号' AFTER `JZDH`,
    ADD COLUMN `TFXMMC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '退费项目名称' AFTER `ZT`,
    ADD COLUMN `YPCD`   int(0)                                                        NULL COMMENT '药品产地' AFTER `TFXMMC`,
    ADD COLUMN `CDMC`   text                                                          NULL COMMENT '产地名称' AFTER `YPCD`,
    ADD COLUMN `YFGG`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '药房规格' AFTER `CDMC`,
    ADD COLUMN `YPLX`   int(0)                                                        NULL DEFAULT NULL COMMENT '药品类型 | 1：西药 2：中成药 3：中草药' AFTER `YFGG`;
