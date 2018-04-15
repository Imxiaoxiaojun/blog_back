CREATE DATABASE IF NOT EXISTS `myblog`;
DROP TABLE IF EXISTS myblog.`operation_log`;
CREATE TABLE myblog.`operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `log_type` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `log_name` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `status` varchar(255) DEFAULT NULL COMMENT '日志状态',
  `message` text COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8 COMMENT='操作日志';

DROP TABLE IF EXISTS myblog.article;
CREATE TABLE myblog.article (
  `id`          BIGINT(11)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title`       VARCHAR(50)  NOT NULL,
  `content`     LONGTEXT,
  `summary`     VARCHAR(300) NOT NULL COMMENT '概述',
  `hits`        INT(11)               DEFAULT NULL COMMENT '点击数',
  `image_url`    VARCHAR(100)          DEFAULT NULL,
  `category_id` BIGINT(11)            DEFAULT NULL COMMENT '文章类型',
  `create_time` DATETIME              DEFAULT CURRENT_TIMESTAMP,
  `update_timUe` DATETIME              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB AUTO_INCREMENT = 100 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`category`;
CREATE TABLE myblog.`category` (
  `id`      INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`    VARCHAR(45)      DEFAULT NULL,
  `descrip` VARCHAR(100)     DEFAULT NULL,
  `num`     INT(11)          DEFAULT NULL COMMENT '文章数量'
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`tag`;
CREATE TABLE myblog.`tag` (
  `id`   BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45)         DEFAULT NULL,
  `num`  INT(11)             DEFAULT NULL
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`ip_log`;
CREATE TABLE myblog.`ip_log` (
  `id`            INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `sid`           VARCHAR(100)     DEFAULT NULL COMMENT 'SESSION_ID',
  `ip`            VARCHAR(45)      DEFAULT NULL,
  `visit_time`    DATETIME         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后访问时间',
  `area`          VARCHAR(45)      DEFAULT NULL COMMENT 'IP对应的区域',
  `uri`           VARCHAR(45)      DEFAULT NULL COMMENT '访问路径',
  `response_time` BIGINT(20)       DEFAULT NULL COMMENT '时间',
  `visit_num`     INT(11)          DEFAULT NULL COMMENT '访问URI次数',
  `referer`       VARCHAR(1000)    DEFAULT NULL
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`links`;
CREATE TABLE myblog.`links` (
  `id`   INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(100)     DEFAULT NULL,
  `url`  VARCHAR(100)     DEFAULT NULL,
  `logo` VARCHAR(100)     DEFAULT NULL,
  `sort` INT(11)          DEFAULT NULL
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`article_tag`;
CREATE TABLE myblog.`article_tag` (
  `id`         INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `article_id` INT(11)          DEFAULT NULL,
  `tag_id`     INT(11)          DEFAULT NULL,
  KEY `index_article_tag` (`article_id`, `tag_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`weibo`;
CREATE TABLE myblog.`weibo` (
  `id`          INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `uid`         VARCHAR(200)     DEFAULT NULL,
  `name`        VARCHAR(300)     DEFAULT NULL,
  `location`    VARCHAR(300)     DEFAULT NULL,
  `url`         VARCHAR(500)     DEFAULT NULL,
  `text`        LONGTEXT,
  `creator`     VARCHAR(45)      DEFAULT NULL,
  `type`        INT(11)          DEFAULT NULL,
  `create_time` DATETIME         DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`comment`;
CREATE TABLE myblog.`comment`(
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `user_name` VARCHAR(50) NOT NULL ,
  `content` VARCHAR(500) NOT NULL ,
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `article_id` BIGINT(11) NOT NULL
)ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

