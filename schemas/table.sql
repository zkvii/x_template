-- Active: 1701082129936@@127.0.0.1@3306@dev
DROP TABLE IF EXISTS `Users`;
DROP TABLE IF EXISTS `Privilege_level`;
DROP TABLE IF EXISTS `UsersInfo`;
CREATE TABLE `Users`
(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT 'name',
    password VARCHAR(50) NULL DEFAULT NULL COMMENT 'password',
    created_at DATETIME NULL DEFAULT NULL COMMENT 'created_at',
    updated_at DATETIME NULL DEFAULT NULL COMMENT 'updated_at',
    privilege_level INT NOT NULL DEFAULT 0 COMMENT 'privilege_level',
    PRIMARY KEY (id)
);

CREATE TABLE `PrivilegeLevel`
(
    id INT NOT NULL AUTO_INCREMENT COMMENT 'id',
    privilege_level INT NOT NULL COMMENT 'privilege_level',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT 'name',
    PRIMARY KEY (id)
);

INSERT INTO `PrivilegeLevel` (privilege_level,name) VALUES (0,'super_user');
INSERT INTO `PrivilegeLevel` (privilege_level,name) VALUES (1,'admin_user');
INSERT INTO `PrivilegeLevel` (privilege_level,name) VALUES (2,'normal_user');

CREATE TABLE `UsersInfo`
(
    user_id BIGINT NOT NULL COMMENT 'user_id',
    age INT NULL DEFAULT NULL COMMENT 'age',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT 'email',
    address VARCHAR(50) NULL DEFAULT NULL COMMENT 'address',
    PRIMARY KEY (user_id)
);

CREATE UNIQUE INDEX `name` ON `Users` (name);

