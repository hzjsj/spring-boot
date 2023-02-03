/*
 Navicat Premium Data Transfer

 Source Server         : mysql数据库
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : java

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 23/01/2023 09:33:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `residentialQuarters` varchar(50) DEFAULT NULL COMMENT '小区名称',
  `room` tinyint NOT NULL DEFAULT '0' COMMENT '户型，居室',
  `hall` tinyint NOT NULL DEFAULT '0' COMMENT '户型，大厅',
  `restRoom` tinyint NOT NULL DEFAULT '0' COMMENT '户型，卫生间',
  `kitchen` tinyint NOT NULL DEFAULT '0' COMMENT '户型，厨房',
  `balcony` tinyint NOT NULL DEFAULT '0' COMMENT '户型，阳台',
  `area` double(11,2) DEFAULT NULL COMMENT '面积',
  `rentalType` tinyint NOT NULL DEFAULT '0' COMMENT '租赁类型：0 是合租，1是整租',
  `orientation` varchar(20) DEFAULT NULL COMMENT '朝向',
  `maintain` varchar(20) DEFAULT NULL COMMENT '维护',
  `moveInto` varchar(20) DEFAULT NULL COMMENT '入住',
  `storey` int NOT NULL DEFAULT '0' COMMENT '房屋楼层',
  `storeyTotal` int NOT NULL DEFAULT '0' COMMENT '楼层总数',
  `elevator` varchar(20) DEFAULT NULL COMMENT '电梯',
  `parkingPlace` varchar(50) DEFAULT NULL COMMENT '车位',
  `useWater` varchar(20) DEFAULT NULL COMMENT '用水',
  `useElectricity` varchar(20) DEFAULT NULL COMMENT '用电',
  `supportingFacilities` text COMMENT '配套设施',
  `housePicture` text COMMENT '房子图片',
  `userId` bigint NOT NULL COMMENT '创建用户 id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='房源信息';

-- ----------------------------
-- Records of house
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for library
-- ----------------------------
DROP TABLE IF EXISTS `library`;
CREATE TABLE `library` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '书名',
  `isbn` varchar(50) DEFAULT NULL COMMENT '编号\n',
  `price` double DEFAULT NULL COMMENT '价格\n',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息\n',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDelete` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of library
-- ----------------------------
BEGIN;
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (11, '1', '2', 3, NULL, '2022-12-12 15:24:52', '2022-12-12 16:31:11', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (12, '1', '2', 3, NULL, '2022-12-12 15:25:40', '2022-12-12 16:36:05', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (13, 'e', 'e', 1, NULL, '2022-12-12 15:26:28', '2022-12-12 16:31:26', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (14, '1', '2', 3, NULL, '2022-12-12 16:38:29', '2022-12-12 16:38:32', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (15, '33', '44', 44, NULL, '2022-12-12 16:41:25', '2022-12-12 16:41:30', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (16, 'q', 'q', 1, NULL, '2022-12-12 16:41:38', '2022-12-12 16:41:51', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (17, '1', '2', 3, NULL, '2022-12-12 16:42:52', '2022-12-13 13:22:50', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (18, '1医院信息系统', 'x2xx', 350, NULL, '2022-12-13 13:23:17', '2022-12-13 15:10:03', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (19, '大数据', 'xxx', 10.1, '描述信息', '2022-12-13 15:08:48', '2022-12-13 15:08:48', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (20, '1', '2', 3, '4', '2022-12-13 15:45:46', '2022-12-13 15:59:19', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (21, '1', '2', 3, '3', '2022-12-13 15:49:40', '2022-12-13 15:49:40', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (22, '33', '33', 0, '33', '2022-12-13 15:49:56', '2022-12-13 15:49:56', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (23, 'eee', '1', 0, '1', '2022-12-13 15:51:21', '2022-12-13 15:51:21', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (24, '1', '2', 0, '3', '2022-12-13 15:51:31', '2022-12-13 15:51:31', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (25, '1', '2', 0, '3', '2022-12-13 15:52:06', '2022-12-13 15:52:06', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (26, '1', '2', 0, '3', '2022-12-13 15:53:31', '2022-12-13 15:53:31', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (27, 'shuji', '2', 11, '3222', '2022-12-13 15:53:42', '2022-12-13 15:53:42', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (28, '啦啦啦', '1', 22, '搜索', '2022-12-13 15:54:43', '2022-12-13 15:54:43', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (29, '晚上上好', '1122', 1122, '1122', '2022-12-13 15:59:30', '2022-12-13 15:59:30', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (30, '2', '3', 4, '4', '2022-12-13 16:02:55', '2022-12-13 16:02:55', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (31, 'zhengchang222', '0001', 333, '222jjjjj', '2022-12-13 16:03:36', '2022-12-13 16:03:36', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (32, '大数据', 'xxx', 10.1, '描述信息', '2022-12-13 16:32:26', '2022-12-13 16:32:26', 0);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (33, '大数据', 'xxx', 10.1, '描述信息', '2022-12-14 13:09:19', '2022-12-14 13:57:49', 1);
INSERT INTO `library` (`id`, `title`, `isbn`, `price`, `remarks`, `createTime`, `updateTime`, `isDelete`) VALUES (34, 'ddd ', 'dd', 11, '22', '2022-12-14 13:57:59', '2022-12-14 13:57:59', 0);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(256) DEFAULT NULL COMMENT '用户昵称',
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userAccount` varchar(256) DEFAULT NULL COMMENT '账号',
  `avatarUrl` varchar(1024) DEFAULT NULL COMMENT '用户头像',
  `gender` tinyint DEFAULT NULL COMMENT '性别',
  `userPassword` varchar(512) NOT NULL COMMENT '密码',
  `phone` varchar(128) DEFAULT NULL COMMENT '电话',
  `email` varchar(512) DEFAULT NULL COMMENT '邮箱',
  `userStatus` int NOT NULL DEFAULT '0' COMMENT '状态 0 - 正常',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDelete` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除',
  `userRole` int NOT NULL DEFAULT '0' COMMENT '用户角色 0 - 普通用户 1 - 管理员',
  `planetCode` varchar(512) DEFAULT NULL COMMENT '星球编号',
  `tags` varchar(1024) DEFAULT NULL COMMENT '标签 json 列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('管理员', 1, 'admin', 'https://gw.alipayobjects.com/zos/rmsportal/KDpgvguMpGfqaHPjicRK.svg', 0, '0d94a3c14ad072b8d9a2c9515eea559d', NULL, NULL, 0, '2022-10-30 18:44:16', '2022-11-03 21:27:18', 0, 1, NULL, '[\"java\",\"python\",\"nginx\"]');
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('管理员', 2, '123456', 'xxx', 1, '0d94a3c14ad072b8d9a2c9515eea559d', NULL, NULL, 0, '2022-10-30 18:44:56', '2022-11-01 13:23:07', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('1', 3, '2', NULL, NULL, '3', NULL, NULL, 0, '2022-11-02 00:18:08', '2022-11-02 00:18:08', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('1', 4, '2', NULL, NULL, '3', NULL, NULL, 0, '2022-11-02 00:18:38', '2022-11-02 00:18:38', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('1', 5, '2', NULL, NULL, '3', NULL, NULL, 0, '2022-11-02 14:19:38', '2022-11-02 14:19:38', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('2', 6, '3', NULL, NULL, '04224b35ae3f80b86d2190dc0e15e4c6', NULL, NULL, 0, '2022-11-02 18:20:22', '2022-11-02 18:20:22', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('啦啦啦', 7, '90', NULL, NULL, '5a83a04f3e73ff68a58b1a57be20832e', NULL, NULL, 0, '2022-11-02 18:33:02', '2022-11-02 18:33:02', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('user', 8, '1', NULL, NULL, '40f56cb56f0f65709013c99fbec47655', NULL, NULL, 0, '2022-11-02 20:55:24', '2022-11-02 20:55:24', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('user', 9, '1', NULL, NULL, '40f56cb56f0f65709013c99fbec47655', NULL, NULL, 0, '2022-11-02 20:55:26', '2022-11-02 20:55:26', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('user', 10, '1', NULL, NULL, '40f56cb56f0f65709013c99fbec47655', NULL, NULL, 0, '2022-11-02 20:55:27', '2022-11-02 20:55:27', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('user', 11, '1', NULL, NULL, '40f56cb56f0f65709013c99fbec47655', NULL, NULL, 0, '2022-11-02 20:55:29', '2022-11-02 20:55:29', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('user', 12, '1', NULL, NULL, '40f56cb56f0f65709013c99fbec47655', NULL, NULL, 0, '2022-11-02 20:55:32', '2022-11-02 20:55:32', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('user', 13, '1', NULL, NULL, '40f56cb56f0f65709013c99fbec47655', NULL, NULL, 0, '2022-11-02 20:55:34', '2022-11-02 20:55:34', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('llalala', 14, '2', NULL, NULL, 'a4f1e5823578a244f10adb90cc97da2d', NULL, NULL, 0, '2022-11-03 19:43:03', '2022-11-03 19:43:03', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('管理员', 15, '123456', 'xxx', 20, '0d94a3c14ad072b8d9a2c9515eea559d', NULL, NULL, 0, '2022-11-05 15:08:39', '2022-11-05 15:08:39', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('2', 16, '2', NULL, NULL, 'a1d10e0bdede4c2836b93e29a4bdea21', NULL, NULL, 0, '2022-11-06 11:19:09', '2022-11-06 11:19:09', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('1', 17, '2', NULL, NULL, '9c518cfb3605e8fb47acd5484aea0921', NULL, NULL, 0, '2022-11-06 11:46:27', '2022-11-06 11:46:27', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('4', 18, '4', NULL, NULL, '04224b35ae3f80b86d2190dc0e15e4c6', NULL, NULL, 0, '2022-11-06 12:01:46', '2022-11-06 12:01:46', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('4', 19, '4', NULL, NULL, '04224b35ae3f80b86d2190dc0e15e4c6', NULL, NULL, 0, '2022-11-06 12:01:52', '2022-11-06 12:01:52', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('1', 20, '2', NULL, NULL, '9c518cfb3605e8fb47acd5484aea0921', NULL, NULL, 0, '2022-11-06 12:04:59', '2022-11-06 12:04:59', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('e', 21, 'e', NULL, NULL, 'b8ca48d212508efaaf1c00f082096076', NULL, NULL, 0, '2022-11-06 12:05:53', '2022-11-06 12:05:53', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('2', 22, '3', NULL, NULL, '9c518cfb3605e8fb47acd5484aea0921', NULL, NULL, 0, '2022-11-06 12:07:19', '2022-11-06 12:07:19', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('1', 23, '2', NULL, NULL, '78dd8a4d7f362c5e34dfd4900699097a', NULL, NULL, 0, '2022-11-06 16:07:21', '2022-11-06 16:07:21', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('1', 24, '2', NULL, NULL, 'a1d10e0bdede4c2836b93e29a4bdea21', NULL, NULL, 0, '2022-11-06 18:10:46', '2022-11-06 18:10:46', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('管理员', 25, '123456', NULL, NULL, '63310c9c79527ab98191d935e0fb6f66', NULL, NULL, 0, '2022-11-06 18:12:00', '2022-11-06 18:12:00', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('管理员', 26, '123456', 'xxx', 20, '0d94a3c14ad072b8d9a2c9515eea559d', NULL, NULL, 0, '2022-12-13 16:32:26', '2022-12-13 16:32:26', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('管理员', 27, '123456', 'xxx', 20, '0d94a3c14ad072b8d9a2c9515eea559d', NULL, NULL, 0, '2022-12-13 16:32:26', '2022-12-13 16:32:26', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('管理员', 28, '123456', 'xxx', 20, '0d94a3c14ad072b8d9a2c9515eea559d', NULL, NULL, 0, '2022-12-14 13:09:18', '2022-12-14 13:09:18', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('xxxx', 29, '123456', 'xxx', 20, '0d94a3c14ad072b8d9a2c9515eea559d', NULL, NULL, 0, '2022-12-14 13:09:19', '2022-12-28 16:31:20', 0, 0, NULL, NULL);
INSERT INTO `user` (`username`, `id`, `userAccount`, `avatarUrl`, `gender`, `userPassword`, `phone`, `email`, `userStatus`, `createTime`, `updateTime`, `isDelete`, `userRole`, `planetCode`, `tags`) VALUES ('网吧的', 30, '1234', NULL, NULL, 'e1732207b17e088b9f00f5ad6ab17346', NULL, NULL, 0, '2022-12-28 20:46:02', '2022-12-28 20:46:02', 0, 0, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
