create database hw_camping;

use hw_camping;

# DB 데이터 삭제
truncate GOODS;
truncate MEMBER;
truncate GOODS_SAMPLE;

# 테이블 삭제
drop table GOODS_SAMPLE;

# Goods 테이블
create table GOODS(
    id int(10) not null auto_increment primary key,
    prd_id_tmp varchar(50) default '-1',
    category varchar(50),
    name varchar(50),
    image_url varchar(4000),
    price int(10),
    lender_email varchar(50),
    reviews int(10),
    grade double
);

# Review 테이블
create table REVIEW(
    id int(10) not null auto_increment primary key,
    prd_id int(10),
    prd_id_tmp varchar(50) default '0',
    email varchar(100),
    grade int(10),
    review varchar(4000)
);

# Member 테이블
create table MEMBER(
    email varchar(50) not null primary key,
    password varchar(255) not null,
    name varchar(50) not null,
    traded int(10) default 0,
    grade double default 3
);

# Rental 테이블
CREATE TABLE RENTAL(
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prd_id INT(10),
    lender_email VARCHAR(20),
    borrower_email VARCHAR(20),
    rental_start_date VARCHAR(20),
    rental_end_date VARCHAR(20),
    message VARCHAR(4000),
    rent_status VARCHAR(20)
);

# Code 테이블
CREATE TABLE CODE(
    ID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CODE_NAME VARCHAR(50),
    CODE_DEPTH VARCHAR(50),
    CODE_DETAIL VARCHAR(50)
);

