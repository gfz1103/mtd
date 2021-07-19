-- 手术计费/手麻计费 计费项目分开记账和审核
ALTER TABLE ss_ssap
    CHANGE COLUMN JZZT SSJZZT int(0) NULL DEFAULT NULL COMMENT '手术记账状态 | 0：未记账    1：已记账    2：已审核' AFTER ZT,
    MODIFY COLUMN ZT int(0) NULL DEFAULT NULL COMMENT '安排状态 | 0：未安排    1：已安排    2：已完成' AFTER CZSJ,
    ADD COLUMN MZJZZT         int(0) NULL COMMENT '麻醉记账状态 | 0：未记账    1：已记账    2：已审核' AFTER SSJZZT;

-- 手麻退费状态备注修改
ALTER TABLE ss_ssjzdmx
    MODIFY COLUMN ZT varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '退费状态 | 0：正常记账    1：退费记账' AFTER JE;

-- 增加手麻和康复的类型
ALTER TABLE im_fee_fymx
    MODIFY COLUMN XMLX int(0) NOT NULL COMMENT '项目类型 | 1：病区系统记帐    2：药房系统记帐    3：医技系统记帐    4：住院系统记帐(补记账)     5：手术系统记帐    6：麻醉系统记帐    7：康复系统记账    9：自动累加费用' AFTER JFRQ;
