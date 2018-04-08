CREATE DATABASE IF NOT EXISTS `myblog`;
DROP TABLE IF EXISTS myblog.article;
CREATE TABLE myblog.article (
  `id`          BIGINT(11)   NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(50)  NOT NULL,
  `content`     LONGTEXT,
  `summary`     VARCHAR(300) NOT NULL COMMENT '概述',
  `hits`        INT(11)               DEFAULT NULL COMMENT '点击数',
  `imageurl`    VARCHAR(100)          DEFAULT NULL,
  `category_id` BIGINT(11)            DEFAULT NULL COMMENT '文章类型',
  `create_time` DATETIME              DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB AUTO_INCREMENT = 100 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`category`;
CREATE TABLE myblog.`category` (
  `id`      INT(11) NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(45)      DEFAULT NULL,
  `descrip` VARCHAR(100)     DEFAULT NULL,
  `num`     INT(11)          DEFAULT NULL COMMENT '文章数量',
  PRIMARY KEY (`id`)
)ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`tag`;
CREATE TABLE myblog.`tag` (
  `id`   INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45)      DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`ip_log`;
CREATE TABLE myblog.`ip_log` (
  `id`            INT(11) NOT NULL AUTO_INCREMENT,
  `sid`           VARCHAR(100)     DEFAULT NULL COMMENT 'SESSION_ID',
  `ip`            VARCHAR(45)      DEFAULT NULL,
  `visit_time`    DATETIME         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后访问时间',
  `area`          VARCHAR(45)      DEFAULT NULL COMMENT 'IP对应的区域',
  `uri`           VARCHAR(45)      DEFAULT NULL COMMENT '访问路径',
  `response_time` BIGINT(20)       DEFAULT NULL COMMENT '时间',
  `visit_num`     INT(11)          DEFAULT NULL COMMENT '访问URI次数',
  `referer`       VARCHAR(1000)    DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS myblog.`links`;
CREATE TABLE myblog.`links` (
  `id`   INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100)     DEFAULT NULL,
  `url`  VARCHAR(100)     DEFAULT NULL,
  `logo` VARCHAR(100)     DEFAULT NULL,
  `sort` INT(11)          DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE = InnoDB AUTO_INCREMENT = 50 DEFAULT CHARSET = utf8;

