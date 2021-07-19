ALTER TABLE `his`.`zl_zlzrw`
ADD COLUMN `BJZCS` int(0) NULL COMMENT '补记帐次数 | 开嘱日期远小于预约日期时，补记此段时间内该模板执行的次数' AFTER `QXGH`;