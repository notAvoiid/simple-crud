CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_category_name` varchar(25) DEFAULT NULL,
  `product_name` varchar(25) NOT NULL,
  `product_price` double NOT NULL,
  `product_quantity` bigint DEFAULT NULL,
  `active` enum('ACTIVE','INACTIVE') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB
