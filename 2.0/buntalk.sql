/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3306
 Source Schema         : buntalk

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 21/06/2019 17:41:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shohincjxxwd
-- ----------------------------
DROP TABLE IF EXISTS `shohincjxxwd`;
CREATE TABLE `shohincjxxwd`  (
  `cj` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pm` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shohin_wendu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shohin_shidu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shohin_shijian` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohincjxxwd
-- ----------------------------
INSERT INTO `shohincjxxwd` VALUES ('001', '1', '1', '1', '2019-06-13 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '11', '11', '11', '2019-06-13 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '0', '11', '13', '2019-05-02 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '0', '12', '12', '2019-05-01 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '20', '13', '14', '2019-05-04 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '25', '14', '15', '2019-05-04 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '26', '15', '16', '2019-05-04 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '27', '16', '17', '2019-05-04 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '28', '17', '18', '2019-04-30 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '19', '2019-05-05 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '2', '25', '20', '2019-05-25 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '8', '25', '13', '2019-05-10 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '0', '11', '13', '2019-05-02 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '0', '12', '12', '2019-05-01 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '20', '13', '14', '2019-05-04 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '25', '14', '15', '2019-05-04 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '26', '15', '16', '2019-05-04 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '27', '16', '17', '2019-05-04 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '28', '17', '18', '2019-04-30 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '23', '12', '19', '2019-05-05 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '1', '1', '1', '2019-05-01 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '13', '2019-05-02 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '0', '11', '13', '2019-05-03 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '0', '12', '12', '2019-05-04 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '20', '13', '14', '2019-05-05 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '25', '14', '15', '2019-05-06 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '26', '15', '16', '2019-05-07 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '27', '16', '17', '2019-05-08 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '28', '17', '18', '2019-05-11 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '19', '2019-05-12 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '2', '25', '20', '2019-05-13 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '8', '25', '13', '2019-05-14 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '0', '11', '13', '2019-05-15 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '0', '12', '12', '2019-05-16 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '20', '13', '14', '2019-05-17 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '25', '14', '15', '2019-05-18 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '26', '15', '16', '2019-05-19 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '27', '16', '17', '2019-05-20 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '28', '17', '18', '2019-05-21 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('003', '23', '12', '19', '2019-05-22 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '1', '1', '1', '2019-05-23 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '13', '2019-05-24 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '1', '1', '1', '2019-05-01 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '23', '12', '13', '2019-05-02 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '0', '11', '13', '2019-05-03 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '0', '12', '12', '2019-05-04 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '20', '13', '14', '2019-05-05 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '25', '14', '15', '2019-05-06 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '26', '15', '16', '2019-05-07 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '27', '16', '17', '2019-05-08 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '28', '17', '18', '2019-05-11 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '23', '12', '19', '2019-05-12 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '2', '25', '20', '2019-05-13 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '8', '25', '13', '2019-05-14 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '0', '11', '13', '2019-05-15 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '0', '12', '12', '2019-05-16 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '20', '13', '14', '2019-05-17 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '25', '14', '15', '2019-05-18 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '26', '15', '16', '2019-05-19 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '27', '16', '17', '2019-05-20 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '28', '17', '18', '2019-05-21 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '23', '12', '19', '2019-05-22 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '1', '1', '1', '2019-05-23 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('001', '23', '12', '13', '2019-05-24 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '1', '1', '1', '2019-05-03 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '13', '2019-05-10 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '11', '13', '2019-05-02 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '12', '12', '2019-05-01 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '20', '13', '14', '2019-05-04 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '25', '14', '15', '2019-05-04 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '26', '15', '16', '2019-05-04 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '27', '16', '17', '2019-05-04 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '28', '17', '18', '2019-04-30 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '19', '2019-05-05 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '2', '25', '20', '2019-05-25 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '8', '25', '13', '2019-05-10 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '11', '13', '2019-05-02 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '12', '12', '2019-05-01 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '20', '13', '14', '2019-05-04 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '25', '14', '15', '2019-05-04 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '26', '15', '16', '2019-05-04 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '27', '16', '17', '2019-05-04 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '28', '17', '18', '2019-04-30 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '19', '2019-05-05 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '1', '1', '1', '2019-05-01 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '13', '2019-05-02 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '11', '13', '2019-05-03 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '12', '12', '2019-05-04 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '20', '13', '14', '2019-05-05 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '25', '14', '15', '2019-05-06 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '26', '15', '16', '2019-05-07 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '27', '16', '17', '2019-05-08 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '28', '17', '18', '2019-05-11 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '19', '2019-05-12 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '2', '25', '20', '2019-05-13 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '8', '25', '13', '2019-05-14 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '11', '13', '2019-05-15 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '12', '12', '2019-05-16 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '20', '13', '14', '2019-05-17 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '25', '14', '15', '2019-05-18 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '26', '15', '16', '2019-05-19 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '27', '16', '17', '2019-05-20 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '28', '17', '18', '2019-05-21 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '19', '2019-05-22 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '1', '1', '1', '2019-05-23 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '13', '2019-05-24 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '1', '1', '1', '2019-05-01 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '13', '2019-05-02 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '11', '13', '2019-05-03 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '12', '12', '2019-05-04 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '20', '13', '14', '2019-05-05 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '25', '14', '15', '2019-05-06 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '26', '15', '16', '2019-05-07 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '27', '16', '17', '2019-05-08 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '28', '17', '18', '2019-05-11 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '19', '2019-05-12 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '2', '25', '20', '2019-05-13 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '8', '25', '13', '2019-05-14 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '11', '13', '2019-05-15 20:00:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '0', '12', '12', '2019-05-16 20:01:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '20', '13', '14', '2019-05-17 20:02:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '9', '14', '15', '2019-05-18 20:03:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '26', '15', '16', '2019-05-19 20:04:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '27', '16', '17', '2019-05-20 20:05:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '28', '17', '18', '2019-05-21 20:06:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '12', '19', '2019-05-22 20:34:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '1', '1', '1', '2019-05-23 23:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23.1', '12', '13', '2019-05-24 20:07:58');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '45', '11', '2019-06-09 19:50:46');
INSERT INTO `shohincjxxwd` VALUES ('001', '17', '11', '15', '2019-06-08 19:52:41');
INSERT INTO `shohincjxxwd` VALUES ('001', '33', '33', '33', '2019-06-10 20:04:26');
INSERT INTO `shohincjxxwd` VALUES ('001', '10', '22', '22', '2019-05-01 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '12', '34', '23', '2019-05-02 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('001', '23', '32', '12', '2019-05-03 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '43', '12', '22', '2019-05-04 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '12', '34', '45', '2019-05-05 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '10', '22', '22', '2019-05-01 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '12', '34', '23', '2019-05-02 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('001', '23', '32', '12', '2019-05-03 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '43', '12', '22', '2019-05-04 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '12', '34', '45', '2019-05-05 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '11', '21', '21', '2019-05-06 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '12', '32', '22', '2019-05-07 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('001', '23', '33', '13', '2019-05-08 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '44', '14', '24', '2019-05-09 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '15', '35', '45', '2019-05-10 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '21', '21', '21', '2019-05-11 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '22', '22', '22', '2019-05-12 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('001', '23', '23', '23', '2019-05-13 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '24', '24', '24', '2019-05-14 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '25', '25', '25', '2019-05-15 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '31', '35', '31', '2019-05-16 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '32', '34', '32', '2019-05-17 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('001', '33', '34', '33', '2019-05-18 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '34', '33', '34', '2019-05-19 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '35', '31', '35', '2019-05-20 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '31', '35', '31', '2019-05-21 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '32', '34', '32', '2019-05-22 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('001', '33', '34', '33', '2019-05-23 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '34', '33', '34', '2019-05-24 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '35', '31', '35', '2019-05-25 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '31', '35', '31', '2019-05-26 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '32', '34', '32', '2019-05-27 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('001', '33', '34', '33', '2019-05-28 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '34', '33', '34', '2019-05-29 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('001', '35', '31', '35', '2019-05-30 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '21', '22', '22', '2019-05-01 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '12', '34', '23', '2019-05-02 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '32', '12', '2019-05-03 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '43', '12', '22', '2019-05-04 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '12', '34', '45', '2019-05-05 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '11', '56', '56', '2019-05-06 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '12', '32', '22', '2019-05-07 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '33', '13', '2019-05-08 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '44', '14', '24', '2019-05-09 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '15', '35', '45', '2019-05-21 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '56', '56', '56', '2019-05-11 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '22', '22', '22', '2019-05-12 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('002', '23', '23', '23', '2019-05-13 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '24', '24', '24', '2019-05-14 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '25', '25', '25', '2019-05-15 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '31', '35', '31', '2019-05-16 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '32', '34', '32', '2019-05-17 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('002', '33', '34', '33', '2019-05-18 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '34', '33', '34', '2019-05-19 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '35', '31', '35', '2019-05-20 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '32', '34', '32', '2019-05-22 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('002', '33', '34', '33', '2019-05-23 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '34', '33', '34', '2019-05-24 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '35', '31', '35', '2019-05-25 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '31', '35', '31', '2019-05-26 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '32', '34', '32', '2019-05-27 11:47:49');
INSERT INTO `shohincjxxwd` VALUES ('002', '33', '34', '33', '2019-05-28 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '34', '33', '34', '2019-05-29 00:00:00');
INSERT INTO `shohincjxxwd` VALUES ('002', '35', '31', '35', '2019-05-30 00:00:00');

-- ----------------------------
-- Table structure for shohincwdxd
-- ----------------------------
DROP TABLE IF EXISTS `shohincwdxd`;
CREATE TABLE `shohincwdxd`  (
  `max_shohin_wendu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `min_shohin_wendu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `max_shohin_shidu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `min_shohin_shidu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `max_pm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `min_pm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohincwdxd
-- ----------------------------
INSERT INTO `shohincwdxd` VALUES ('35', '20', '70', '20', '30', '0');

-- ----------------------------
-- Table structure for shohindjxx
-- ----------------------------
DROP TABLE IF EXISTS `shohindjxx`;
CREATE TABLE `shohindjxx`  (
  `id` int(11) NOT NULL,
  `cj` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jiqibianhao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jiqixinghao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fuzheren` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chaigoushijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chuchangshijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohindjxx
-- ----------------------------
INSERT INTO `shohindjxx` VALUES (1, '001', '2010116', '中型', '张氏', '2000-01-01', '2000-2-01');
INSERT INTO `shohindjxx` VALUES (2, '002', '2211876', '小型', '张氏', '2000-01-01', '2000-2-01');
INSERT INTO `shohindjxx` VALUES (3, '003', '2222222', '大型', '王五', '2018-09-08', '2018-09-11');

-- ----------------------------
-- Table structure for shohinnp
-- ----------------------------
DROP TABLE IF EXISTS `shohinnp`;
CREATE TABLE `shohinnp`  (
  `nenghao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pinci` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cj` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shohin_shijian` date NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohinnp
-- ----------------------------
INSERT INTO `shohinnp` VALUES ('100', '40', '001', '2019-05-10');
INSERT INTO `shohinnp` VALUES ('20', '80', '001', '2019-05-11');
INSERT INTO `shohinnp` VALUES ('23', '50', '001', '2019-05-12');
INSERT INTO `shohinnp` VALUES ('22', '40', '001', '2019-05-13');
INSERT INTO `shohinnp` VALUES ('100', '40', '001', '2019-05-14');
INSERT INTO `shohinnp` VALUES ('20', '80', '001', '2019-05-15');
INSERT INTO `shohinnp` VALUES ('23', '50', '001', '2019-05-16');
INSERT INTO `shohinnp` VALUES ('22', '40', '001', '2019-05-17');
INSERT INTO `shohinnp` VALUES ('100', '40', '001', '2019-05-18');
INSERT INTO `shohinnp` VALUES ('20', '80', '001', '2019-05-19');
INSERT INTO `shohinnp` VALUES ('23', '50', '001', '2019-05-20');
INSERT INTO `shohinnp` VALUES ('22', '40', '001', '2019-05-21');
INSERT INTO `shohinnp` VALUES ('100', '40', '001', '2019-05-22');
INSERT INTO `shohinnp` VALUES ('20', '80', '001', '2019-05-23');
INSERT INTO `shohinnp` VALUES ('23', '50', '001', '2019-05-24');
INSERT INTO `shohinnp` VALUES ('22', '40', '001', '2019-05-25');
INSERT INTO `shohinnp` VALUES ('100', '40', '001', '2019-05-26');
INSERT INTO `shohinnp` VALUES ('40', '80', '002', '2019-05-10');
INSERT INTO `shohinnp` VALUES ('43', '50', '002', '2019-05-12');
INSERT INTO `shohinnp` VALUES ('42', '40', '002', '2019-05-13');
INSERT INTO `shohinnp` VALUES ('22', '40', '002', '2019-05-14');
INSERT INTO `shohinnp` VALUES ('40', '80', '002', '2019-05-15');
INSERT INTO `shohinnp` VALUES ('43', '50', '002', '2019-05-16');
INSERT INTO `shohinnp` VALUES ('42', '40', '002', '2019-05-17');
INSERT INTO `shohinnp` VALUES ('22', '40', '002', '2019-05-18');
INSERT INTO `shohinnp` VALUES ('40', '80', '002', '2019-05-19');
INSERT INTO `shohinnp` VALUES ('43', '50', '002', '2019-05-20');
INSERT INTO `shohinnp` VALUES ('42', '40', '002', '2019-05-21');
INSERT INTO `shohinnp` VALUES ('22', '40', '002', '2019-05-22');
INSERT INTO `shohinnp` VALUES ('10', '10', '003', '2019-05-10');
INSERT INTO `shohinnp` VALUES ('13', '10', '003', '2019-05-12');
INSERT INTO `shohinnp` VALUES ('12', '41', '003', '2019-05-13');
INSERT INTO `shohinnp` VALUES ('12', '42', '003', '2019-05-14');
INSERT INTO `shohinnp` VALUES ('10', '10', '003', '2019-05-15');
INSERT INTO `shohinnp` VALUES ('13', '10', '003', '2019-05-16');
INSERT INTO `shohinnp` VALUES ('12', '41', '003', '2019-05-17');
INSERT INTO `shohinnp` VALUES ('12', '42', '003', '2019-05-18');
INSERT INTO `shohinnp` VALUES ('10', '10', '003', '2019-05-19');
INSERT INTO `shohinnp` VALUES ('13', '10', '003', '2019-05-20');
INSERT INTO `shohinnp` VALUES ('12', '41', '003', '2019-05-21');
INSERT INTO `shohinnp` VALUES ('12', '42', '003', '2019-05-21');
INSERT INTO `shohinnp` VALUES ('10', '10', '003', '2019-05-23');
INSERT INTO `shohinnp` VALUES ('13', '10', '003', '2019-05-24');
INSERT INTO `shohinnp` VALUES ('12', '41', '003', '2019-05-25');
INSERT INTO `shohinnp` VALUES ('12', '42', '003', '2019-05-26');

-- ----------------------------
-- Table structure for shohinsbsczt
-- ----------------------------
DROP TABLE IF EXISTS `shohinsbsczt`;
CREATE TABLE `shohinsbsczt`  (
  `id` int(10) NOT NULL,
  `shohin_kaiguang` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shohin_guzhang` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shohin_nenhao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shohin_zhuanshu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cj` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohinsbsczt
-- ----------------------------
INSERT INTO `shohinsbsczt` VALUES (1, 'ON', '正常', '29p', '50', '001');
INSERT INTO `shohinsbsczt` VALUES (2, 'OFF', '故障', '29p', '70', '002');
INSERT INTO `shohinsbsczt` VALUES (3, 'ON', '正常', '29p', '56', '003');

-- ----------------------------
-- Table structure for shohinsbsczt3
-- ----------------------------
DROP TABLE IF EXISTS `shohinsbsczt3`;
CREATE TABLE `shohinsbsczt3`  (
  `id` int(11) NOT NULL,
  `cj` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shohin_kt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shohin_kgzt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shohin_ms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shohin_sd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shohin_wd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `aa` FOREIGN KEY (`id`) REFERENCES `shohinsbxx1` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohinsbsczt3
-- ----------------------------
INSERT INTO `shohinsbsczt3` VALUES (1, '001', '空调', 'ON', '制热', '高', '26');
INSERT INTO `shohinsbsczt3` VALUES (2, '002', '空调', 'ON', '制冷', '低', '22');
INSERT INTO `shohinsbsczt3` VALUES (3, '003', '空调', 'ON', '制冷', '高', '12');

-- ----------------------------
-- Table structure for shohinsbxx1
-- ----------------------------
DROP TABLE IF EXISTS `shohinsbxx1`;
CREATE TABLE `shohinsbxx1`  (
  `id` int(11) NOT NULL,
  `cj` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jiqibianhao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jiqixinghao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fuzheren` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chaigoushijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chuchangshijian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohinsbxx1
-- ----------------------------
INSERT INTO `shohinsbxx1` VALUES (1, '001', '2010116', '中型', '张氏', '1980-10-1', '1980-10-11');
INSERT INTO `shohinsbxx1` VALUES (2, '002', '2211876', '小型', '张氏', '2000-01-01', '2000-2-01');
INSERT INTO `shohinsbxx1` VALUES (3, '003', '2222222', '大型', '王五', '2018-09-08', '2018-09-11');

-- ----------------------------
-- Table structure for shohiny
-- ----------------------------
DROP TABLE IF EXISTS `shohiny`;
CREATE TABLE `shohiny`  (
  `shohin_gonghao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shohin_shoujihao` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ruzhishijian` date NULL DEFAULT NULL,
  `zhiwu` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zhanghu` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cj` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mima` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mac` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`shohin_gonghao`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohiny
-- ----------------------------
INSERT INTO `shohiny` VALUES ('001', '张氏', '18871253492', '1900-01-01', '管理员', '123456', '', '156', '80:AD:16:EC:FB:F9');
INSERT INTO `shohiny` VALUES ('002', '芬芳', '', '1901-01-01', '生产员', '123457', '002', '126', '');
INSERT INTO `shohiny` VALUES ('003', '李四', '', '1901-01-01', '生产员', '123458', '002', '123', '');
INSERT INTO `shohiny` VALUES ('004', '王五', '', '1901-01-01', '管理员', '003', '', '256', '');
INSERT INTO `shohiny` VALUES ('005', '11', '', '2019-01-03', '生产员', '222', '004', '111', NULL);

-- ----------------------------
-- Table structure for shohinzwc
-- ----------------------------
DROP TABLE IF EXISTS `shohinzwc`;
CREATE TABLE `shohinzwc`  (
  `shohin_gonghao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shohin_shengchangyuan` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cj` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`shohin_gonghao`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohinzwc
-- ----------------------------
INSERT INTO `shohinzwc` VALUES ('003', '芬芳', '001');
INSERT INTO `shohinzwc` VALUES ('004', '李四', '002');

-- ----------------------------
-- Table structure for shohinzwg
-- ----------------------------
DROP TABLE IF EXISTS `shohinzwg`;
CREATE TABLE `shohinzwg`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shohin_guangliyuan` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cj` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shohinzwg
-- ----------------------------
INSERT INTO `shohinzwg` VALUES ('001', '张氏', '001');
INSERT INTO `shohinzwg` VALUES ('002', '张氏', '002');
INSERT INTO `shohinzwg` VALUES ('003', '王五', '003');

SET FOREIGN_KEY_CHECKS = 1;
