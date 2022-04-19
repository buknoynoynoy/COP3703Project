CREATE TABLE STUDENT (
    Fname   VARCHAR(15)     NOT NULL,
    Minit   CHAR,
    Lname   VARCHAR(15)     NOT NULL,
    Ssn     CHAR(9)         NOT NULL,
    Nnumber VARCHAR(9)      NOT NULL,
    Bdate   DATE,
    Sex     CHAR,
    sClass  VARCHAR(10)     NOT NULL,
    Degree  VARCHAR(4)      NOT NULL,
    Cphone  CHAR(10),
    Ccity   VARCHAR(20),
    Cstate  VARCHAR(20),
    Czip    VARCHAR(5),
    Pphone  VARCHAR(10),
    Pcity   VARCHAR(20),
    Pstate  VARCHAR(20),
    Pzip    VARCHAR(5),
    
    PRIMARY KEY (Nnumber),
    UNIQUE (Ssn) );
    
CREATE TABLE DEPARTMENT (
    Dcode           CHAR(4)         NOT NULL,
    DName           VARCHAR(15)     NOT NULL,
    Office_No       CHAR(4)         NOT NULL,
    Office_Phone    CHAR(10)        NOT NULL,
    College         VARCHAR(25)     NOT NULL,
    
    PRIMARY KEY (Dcode) );
    
CREATE TABLE COURSE (
    Cnumber         VARCHAR(7)      NOT NULL,
    CName           VARCHAR(20)     NOT NULL,
    Cdesc           VARCHAR(100)    NOT NULL,
    Chours          CHAR            NOT NULL,
    Clevel          VARCHAR(10),
    Depart_Code     CHAR(4)         NOT NULL,
    
    PRIMARY KEY (Cnumber),
    FOREIGN KEY (Depart_Code) REFERENCES DEPARTMENT (Dcode) );
    
CREATE TABLE SECTION (
    Snumber         CHAR(2)         NOT NULL,
    Sinstructor     VARCHAR(20),
    Semester        VARCHAR(6)      NOT NULL,
    Syear           CHAR(4)         NOT NULL,
    C_no            VARCHAR(7)      NOT NULL,
    
    PRIMARY KEY (Snumber),
    FOREIGN KEY (C_no) REFERENCES COURSE (Cnumber) );

CREATE TABLE MAJOR (
    N_no            VARCHAR(9)      NOT NULL,
    Dept_Code       CHAR(4)         NOT NULL,
    Major           VARCHAR(20)     NOT NULL,
    
    PRIMARY KEY (N_no, Dept_Code, Major),
    FOREIGN KEY (N_no) REFERENCES STUDENT (Nnumber),
    FOREIGN KEY (Dept_Code) REFERENCES DEPARTMENT (Dcode) );
    
CREATE TABLE MINOR (
    N_no            VARCHAR(9)      NOT NULL,
    Dept_Code       CHAR(4)         NOT NULL,
    Minor           VARCHAR(20)     NOT NULL,
    
    PRIMARY KEY (N_no, Dept_Code, Minor),
    FOREIGN KEY (N_no) REFERENCES STUDENT (Nnumber),
    FOREIGN KEY (Dept_Code) REFERENCES DEPARTMENT (Dcode) );

CREATE TABLE ENROLLED_IN (
    N_no            VARCHAR(9)      NOT NULL,
    S_no            CHAR(2)         NOT NULL,
    C_no            VARCHAR(7)      NOT NULL,
    Grade           CHAR,
    
    PRIMARY KEY (N_no, S_no, C_no),
    FOREIGN KEY (N_no) REFERENCES STUDENT (Nnumber),
    FOREIGN KEY (S_no) REFERENCES SECTION (Snumber),
    FOREIGN KEY (C_no) REFERENCES COURSE (Cnumber) );
    
INSERT INTO STUDENT VALUES (
    'Vincent',
    'R',
    'Almeda',
    '123456789',
    'N01473764',
    TO_DATE ('2002-07-08', 'YYYY-MM-DD'),
    'M',
    'Sophomore',
    'BA',
    '5202225866',
    'Saint Johns',
    'Florida',
    '32259',
    '5202225866',
    'Saint Johns',
    'Florida',
    '32259'
);