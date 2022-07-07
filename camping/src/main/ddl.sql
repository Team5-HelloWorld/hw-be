create database hw_camping;

use hw_camping;

# main page 에 보여줄 goods sample 을 위한 테이블
create table GOODS_SAMPLE(
    id int(10) not null auto_increment primary key,
    prd_id varchar(4000),
    category varchar(20),
    name varchar(4000),
    price int(10),
    reviews int(10),
    image_url varchar(4000)
);

# DB 데이터 삭제
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
    reviews int(10),
    register_date varchar(20),
    count int(10),
    rent_yn boolean
);

# Review 테이블
create table REVIEW(
    id int(10) not null auto_increment primary key,
    prd_id varchar(50),
    prd_id_tmp varchar(50) default '0',
    email varchar(100),
    grade int(10),
    result_yn boolean,
    review varchar(4000),
    delete_yn boolean
);

# Member 테이블
create table MEMBER(
    email varchar(50) not null primary key,
    password varchar(255) not null,
    name varchar(50) not null,
    grade int(10)
);
