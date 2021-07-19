ALTER TABLE `his`.`opt_sssq`
    ADD COLUMN `SHGH` int(0)      NULL DEFAULT NULL COMMENT '审核工号 | 记账审核时保存' AFTER `qkdj`,
    ADD COLUMN `SHSJ` datetime(0) NULL DEFAULT NULL COMMENT '审核时间 | 记账审核时保存' AFTER `SHGH`;