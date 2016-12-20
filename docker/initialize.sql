CREATE DATABASE IF NOT EXISTS spring_security;
USE spring_security;

CREATE TABLE IF NOT EXISTS admin_accounts (
  login_id   VARCHAR(255) PRIMARY KEY,
  password   VARCHAR(255) NOT NULL,
  admin_name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS user_accounts (
  login_id   VARCHAR(255) PRIMARY KEY,
  password   VARCHAR(255) NOT NULL,
  admin_name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;
