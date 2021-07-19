-- 增加字段
ALTER TABLE `his`.`zl_rwfp`
    MODIFY COLUMN `FPZT` int(0) NOT NULL COMMENT '分配状态 | 0：未分配    1：已分配' AFTER `YZ_JLXH`,
    ADD COLUMN `ZLKSDM` int(0)                                                        NOT NULL COMMENT '治疗科室代码' AFTER `FPSJ`,
    ADD COLUMN `SFXMDM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '收费项目代码' AFTER `ZLKSDM`,
    ADD COLUMN `SFXMMC` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收费项目名称' AFTER `SFXMDM`,
    ADD COLUMN `SL`     decimal(10, 4)                                                NULL DEFAULT NULL COMMENT '数量' AFTER `SFXMMC`,
    ADD COLUMN `JE`     decimal(10, 4)                                                NULL DEFAULT NULL COMMENT '金额' AFTER `SL`;

-- 修改备注
ALTER TABLE `his`.`dic_kszd`
    MODIFY COLUMN `HOSPITALAREA` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '住院病区 | 0：科室    1：病区' AFTER `HOSPITALDEPT`;
-- 修改备注
ALTER TABLE `his`.`im_cwsz`
    MODIFY COLUMN `CWXB` int(0) NOT NULL COMMENT '床位性别 | 1：男    2：女    3：不限' AFTER `KSDM`;
