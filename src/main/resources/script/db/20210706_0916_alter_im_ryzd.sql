alter table `his`.`im_ryzd`
MODIFY COLUMN `ZDLB` int(0) NOT NULL COMMENT '诊断类别 | 1：门诊诊断 2：入院主诊断 3：出院主诊断 4：出院次诊断 5：院内感染 6：入院次诊断 44：病理诊断  45：损伤中毒的外部原因 ' AFTER `ZDXH`;