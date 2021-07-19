-- 治疗任务（一条医嘱一个任务）
ALTER TABLE `his`.`zl_rwfp`
    MODIFY COLUMN `FPZT` int(0) NOT NULL COMMENT '分配状态 | 0：未分配    1：已分配    2：已预约    3：已开始执行' AFTER `YZ_JLXH`,
    ADD COLUMN `SCZXRQ` date NULL COMMENT '首次执行日期' AFTER `JE`;

-- 治疗任务模板（一条医嘱按照每天执行次数拆分为若干个执行时间不同的任务模板）
CREATE TABLE `his`.`ZL_RWMB`
(
    `JLXH`     int(0)                                                        NOT NULL AUTO_INCREMENT COMMENT '记录序号',
    `ZLRWFPID` int(0)                                                        NOT NULL COMMENT '康复治疗任务分配ID | 关联ZL_RWFP.ZLRWFPID',
    `ZXSJ`     varchar(10)                                                   NULL COMMENT '执行时间 | 由频次决定的每日默认执行时间点',
    `ZXGH`     int(0)                                                        NULL COMMENT '执行工号 | 任务所分配的治疗师代码',
    `YYZT`     int(0)                                                        NULL COMMENT '预约状态 |  1：已分配    2：已预约    3：已开始执行',
    `KSSJ`     varchar(10)                                                   NULL COMMENT '预约时间段开始时间',
    `JSSJ`     varchar(10)                                                   NULL COMMENT '预约时间段结束时间',
    `LSYZ`     int(0)                                                        NOT NULL COMMENT '临时医嘱 | 0：长期医嘱    1：临时医嘱',
    `SFXMDM`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL COMMENT '收费项目代码',
    `SFXMMC`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收费项目名称',
    `SL`       decimal(10, 4)                                                NULL DEFAULT NULL COMMENT '数量',
    `JE`       decimal(10, 4)                                                NULL DEFAULT NULL COMMENT '金额',
    `DW`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '单位',
    `PC`       varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NULL DEFAULT NULL COMMENT '频次',
    `BZXX`     varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '医嘱备注信息',
    PRIMARY KEY (`JLXH`)
) COMMENT = '治疗任务模板';

-- 治疗批次（每个医生的每个预约时间段即为一个治疗批次）
CREATE TABLE `his`.`ZL_ZLPC`
(
    `JLXH`   int(0)      NOT NULL AUTO_INCREMENT COMMENT '治疗批次记录序号',
    `ZLSDM`  int(0)      NULL COMMENT '治疗师代码',
    `ZLKSDM` int(0)      NULL COMMENT '治疗科室代码',
    `ZLRQ`   varchar(0)  NULL COMMENT '治疗日期',
    `KSSJ`   datetime(0) NULL COMMENT '开始时间',
    `JSSJ`   datetime(0) NULL COMMENT '结束时间',
    PRIMARY KEY (`JLXH`)
) COMMENT = '治疗师治疗批次表';

-- 治疗任务子任务（最小执行单元，每个批次的每个项目均为一个子任务）
CREATE TABLE `his`.`ZL_ZLZRW`
(
    `JLXH`      int(0)      NOT NULL AUTO_INCREMENT COMMENT '记录序号',
    `RWMB_JLXH` int(0)      NOT NULL COMMENT '治疗任务模板记录序号',
    `ZLPC_JLXH` int(0)      NOT NULL COMMENT '治疗批次记录序号',
    `ZXZT`      int(0)      NOT NULL COMMENT '预约执行状态 | 0：未执行    1：已执行    2：取消执行',
    `ZXSJ`      datetime(0) NULL COMMENT '执行时间 | 预约时选择的执行时间',
    `ZXGH`      int(0)      NULL COMMENT '执行工号',
    `JZSJ`      datetime(0) NULL COMMENT '记账时间 | 点击“执行”按钮服务器时间',
    `JZGH`      int(0)      NULL COMMENT '记账工号',
    `QXSJ`      datetime(0) NULL COMMENT '取消时间',
    `QXGH`      int(0)      NULL COMMENT '取消工号',
    PRIMARY KEY (`JLXH`)
) COMMENT = '治疗任务子任务表';
