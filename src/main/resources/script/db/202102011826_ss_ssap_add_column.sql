ALTER TABLE ss_ssap
    ADD COLUMN JZZT varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '记账状态 | 0：未记账    1：已记账    2：已审核' AFTER ZT;