CREATE TABLE `dressings` (
  `dressing_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dressing_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dressing_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `flavours` (
  `flavour_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flavour_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`flavour_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `ice_creams` (
  `ice_cream_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dressing` varchar(255) DEFAULT NULL,
  `first_flavour` varchar(255) DEFAULT NULL,
  `sauce` varchar(255) DEFAULT NULL,
  `second_flavour` varchar(255) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ice_cream_id`),
  KEY `fk_orders` (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `orders` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_finished` bit(1) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `sauces` (
  `sauce_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sauce_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sauce_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
