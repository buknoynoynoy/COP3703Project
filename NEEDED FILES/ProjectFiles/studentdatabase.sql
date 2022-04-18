REM   Script: Project
REM   SQL for Project Part 2

CREATE TABLE STUDENT( 
    first_name VARCHAR(15) NOT NULL, 
    middle_name CHAR, 
    last_name VARCHAR(15) NOT NULL, 
    n_number CHAR(9) NOT NULL, 
    ssn CHAR(9) NOT NULL, 
    curr_address VARCHAR(30), 
    zip CHAR(5), 
    state VARCHAR(20), 
    city VARCHAR(20), 
    phone_number CHAR(10), 
    bdate DATE, 
    sex CHAR, 
    class VARCHAR(15), 
    major VARCHAR(30), 
    minor VARCHAR(30), 
    degree VARCHAR(30), 
     
    PRIMARY KEY (ssn), 
    FOREIGN KEY (major) REFERENCES DEPARTMENT(dep_major), 
    FOREIGN KEY (minor) REFERENCES DEPARTMENT(dep_minor));

CREATE TABLE DEPARTMENT( 
    dep_name VARCHAR(30) NOT NULL, 
    dep_code CHAR(4) NOT NULL, 
    office_num CHAR(9), 
    dep_city VARCHAR(30), 
    office_phone CHAR(9), 
    college VARCHAR(30), 
    dep_major VARCHAR(30), 
    dep_minor VARCHAR(30), 
     
    PRIMARY KEY (dep_name, dep_code, dep_major));

CREATE TABLE IS_IN_A( 
    n_number CHAR(9) NOT NULL, 
    dep_code CHAR(4) NOT NULL, 
     
    PRIMARY KEY (n_number, dep_code), 
    FOREIGN KEY (n_number) REFERENCES STUDENT(n_number), 
    FOREIGN KEY (dep_code) REFERENCES DEPARTMENT(dep_code));

CREATE TABLE COURSE( 
    course_name VARCHAR(30) NOT NULL, 
    description VARCAHR(100), 
    course_num CHAR(4) NOT NULL, 
    hours INT, 
    level VARCHAR(15), 
    dep_name VARCHAR(30), 
    dep_code CHAR(4) NOT NULL, 
    n_number CHAR(9) NOT NULL, 
     
    PRIMARY KEY (course_num, dep_code), 
    FOREIGN KEY (dep_code) REFERENCES COURSE(dep_code) 
    FOREIGN KEY (n_number) REFERENCES STUDENT(n_number));

CREATE TABLE SECTION( 
    section_num CHAR(4) NOT NULL, 
    instructor VARCHAR(30), 
    section_name VARCHAR(15), 
    course VARCHAR(30), 
    course_num CHAR(4) NOT NULL, 
    n_number CHAR(9) NOT NULL, 
    grade CHAR, 
     
    PRIMARY KEY (section_num, course_num), 
    FOREIGN KEY (course_num) REFERENCES COURSE(course_num), 
    FOREIGN KEY (n_number) REFERENCES STUDENT(n_number));

