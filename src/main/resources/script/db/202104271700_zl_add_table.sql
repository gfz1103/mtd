
CREATE TABLE `his`.`zl_sqdsfmx`  (
  `JLXH` int(0) NOT NULL COMMENT '记录序号',
  `SQDMX_JLXH` int(0) NOT NULL COMMENT '申请单明细记录序号 | 关联zl_sqdmx.JLXH',
  `SFXMDM` int(0) NOT NULL COMMENT '收费项目代码',
  `SFXMMC` varchar(255) NULL COMMENT '收费项目名称',
  PRIMARY KEY (`JLXH`)
) COMMENT = '门诊治疗申请 - 收费项目明细表';