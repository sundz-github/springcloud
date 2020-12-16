# springcloud-demo
#数据库sql

CREATE TABLE `pt_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) DEFAULT NULL,
  `price` double(4,2) DEFAULT NULL,
  `remark` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pt_score_card` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) NOT NULL,
  `score_number` int(16) DEFAULT NULL,
  `remark` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pt_stock` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `count` int(16) DEFAULT NULL,
  `goods_id` int(8) DEFAULT NULL,
  `remark` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pt_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `goods_id` int(8) DEFAULT NULL,
  `remark` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

