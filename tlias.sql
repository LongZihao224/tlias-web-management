/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : tlias

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 25/10/2023 10:22:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '教研部', '2023-10-19 10:02:17', '2023-10-19 20:23:17');
INSERT INTO `dept` VALUES (3, '咨询部', '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `dept` VALUES (7, '人事部', '2023-10-19 19:54:04', '2023-10-19 19:54:04');

-- ----------------------------
-- Table structure for dept_log
-- ----------------------------
DROP TABLE IF EXISTS `dept_log`;
CREATE TABLE `dept_log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept_log
-- ----------------------------

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` tinyint UNSIGNED NOT NULL COMMENT '性别, 说明: 1 男, 2 女',
  `image` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图像',
  `job` tinyint UNSIGNED NULL DEFAULT NULL COMMENT '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
  `entrydate` date NULL DEFAULT NULL COMMENT '入职时间',
  `dept_id` int UNSIGNED NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', 2, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', 2, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', 2, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', 2, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', 2, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', 1, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', 1, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 5, '2007-02-01', 3, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 5, '2008-08-18', 3, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 5, '2012-11-01', 3, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', 2, '2023-10-19 10:02:17', '2023-10-19 10:02:17');
INSERT INTO `emp` VALUES (18, 'chengyouliang', '123456', '陈友谅', 1, 'https://tlias-lz.oss-cn-beijing.aliyuncs.com/6f121337-5b04-4f76-a3bc-fa43e57abf03.jpeg', 1, '2015-09-18', 1, '2023-10-21 08:46:05', '2023-10-22 17:59:41');
INSERT INTO `emp` VALUES (21, 'me', '123456', '龙子豪', 1, 'https://tlias-lz.oss-cn-beijing.aliyuncs.com/7d1d30c5-8c99-4a30-b831-74efa6e6f72a.jpeg', 1, '2023-10-20', 1, '2023-10-21 23:46:51', '2023-10-21 23:46:51');

SET FOREIGN_KEY_CHECKS = 1;
