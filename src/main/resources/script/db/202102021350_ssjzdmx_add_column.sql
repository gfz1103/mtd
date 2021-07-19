ALTER TABLE ss_ssjzdmx
    ADD COLUMN sqdh int(0) NULL COMMENT '手术申请单号' AFTER ssys;

UPDATE ss_ssjzdmx
SET SQDH = 0
WHERE SQDH IS NULL;

ALTER TABLE ss_ssjzdmx
    MODIFY COLUMN sqdh int(0) NOT NULL COMMENT '手术申请单号' AFTER ssys;
