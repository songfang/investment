DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT comment 'id',
  `job_name` varchar(255) NOT  NULL DEFAULT '' comment 'job_name',
  `job_group` varchar(255) NOT  NULL DEFAULT '' comment 'job_group',
  `job_status` varchar(255) NOT  NULL DEFAULT '' comment 'job_status',
  `cron_expression` varchar(255) NOT  NULL DEFAULT '' comment 'cron_expression',
  `description` varchar(255) NOT  NULL DEFAULT '' comment 'description',
  `bean_class` varchar(255) NOT  NULL DEFAULT '' comment 'bean_class',
  `is_concurrent` varchar(255) NOT NULL DEFAULT '' comment '1',
  `spring_id` varchar(255) NOT NULL DEFAULT '' comment 'spring_id',
  `method_name` varchar(255) NOT NULL DEFAULT '' comment 'method_name',
  `create_time` timestamp NOT NULL  DEFAULT '0000-00-00 00:00:00' comment 'create_time',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'update_time',
  PRIMARY KEY (`job_id`),
  UNIQUE KEY `name_group` (`job_name`,`job_group`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `trigger`;
CREATE TABLE `trigger` (
  `trigger_id`  bigint(20) NOT NULL AUTO_INCREMENT,
  `job_id` bigint(20) NOT NULL DEFAULT -1,
  `trigger_name` varchar(255) NOT NULL DEFAULT '',
  `cron_expression` varchar(255) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL  DEFAULT '0000-00-00 00:00:00',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`trigger_id`,`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;