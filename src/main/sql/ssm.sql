/*
 Navicat Premium Data Transfer

 Source Server         : Mysql(本地)
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 12/12/2018 17:30:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ssm_member
-- ----------------------------
DROP TABLE IF EXISTS `ssm_member`;
CREATE TABLE `ssm_member`  (
  `member_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(37) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `salt` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值',
  `is_disable` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '账号是否启用 0:不启用 1:启用',
  `role_ids` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户角色 多个角色以逗号分隔',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ssm_member
-- ----------------------------
INSERT INTO `ssm_member` VALUES (1, 'admin', 'afdca3fcb7790ea497672eefc9a237fa', 'p1m25', '1', '1', '2018-12-12 10:53:40');
INSERT INTO `ssm_member` VALUES (2, 'test', 'afdca3fcb7790ea497672eefc9a237fa', 'p1m25', '1', '2', '2018-12-12 17:21:11');

-- ----------------------------
-- Table structure for ssm_menu
-- ----------------------------
DROP TABLE IF EXISTS `ssm_menu`;
CREATE TABLE `ssm_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单标题',
  `icon` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型 0:根目录 1:菜单 2:方法',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指向的地址',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单代码',
  `is_disabled` int(1) NOT NULL DEFAULT 0 COMMENT '是否启动 0:启用 1:不启用',
  `is_open` int(1) NOT NULL DEFAULT 0 COMMENT '是否展开 0:不展开 1:展开',
  `create_time` datetime NOT NULL COMMENT '生成日期',
  `edit_time` datetime NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ssm_menu
-- ----------------------------
INSERT INTO `ssm_menu` VALUES (1, 0, '系统管理', NULL, 1, '', NULL, 1, 1, '2018-12-12 10:55:19', '2018-12-12 10:55:21');
INSERT INTO `ssm_menu` VALUES (2, 1, '用户管理', NULL, 2, '/system/user', NULL, 1, 1, '2018-12-12 16:10:44', '2018-12-12 16:10:42');
INSERT INTO `ssm_menu` VALUES (3, 1, '角色管理', NULL, 2, '/system/role', NULL, 1, 1, '2018-12-12 16:10:44', '2018-12-12 16:10:44');
INSERT INTO `ssm_menu` VALUES (4, 1, '权限管理', NULL, 2, '/system/permission', NULL, 1, 1, '2018-12-12 16:10:44', '2018-12-12 16:10:44');
INSERT INTO `ssm_menu` VALUES (5, 2, '用户添加', NULL, 3, '/system/user/add', 'user:add', 1, 1, '2018-12-12 16:10:44', '2018-12-12 16:10:44');
INSERT INTO `ssm_menu` VALUES (6, 2, '用户删除', NULL, 3, '/system/user/del', 'user:del', 1, 1, '2018-12-12 16:10:44', '2018-12-12 16:10:44');

-- ----------------------------
-- Table structure for ssm_permission
-- ----------------------------
DROP TABLE IF EXISTS `ssm_permission`;
CREATE TABLE `ssm_permission`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `permissions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '多个权限以逗号分隔 id',
  `permissions_name` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '多个权限以逗号分隔 中文',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表 角色->菜单' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ssm_permission
-- ----------------------------
INSERT INTO `ssm_permission` VALUES (1, '管理员', '1,2,3,4,5', '系统管理,用户管理,角色管理,权限管理,用户添加');
INSERT INTO `ssm_permission` VALUES (2, '测试', '6', '用户删除');

SET FOREIGN_KEY_CHECKS = 1;
