/*
select * from exam where rownum=1;
select * from student where rownum=1;
select * from course where rownum=1;
select * from teacher where rownum=1;
*/
SELECT DISTINCT exam.courseid,exam.batchno,exam.examid,exam.examtype,(exam.examtype || exam.examno) AS examtype2,exam.exammark
FROM EXAM
INNER JOIN COURSE ON exam.courseid =course.courseid
INNER JOIN STUDENT ON exam.batchno =student.batchno
WHERE course.courseid='MITM301' 
AND student.batchno='MIT 9th'
ORDER BY exam.examid ASC
/*

CREATE GLOBAL TEMPORARY TABLE TEMPTABLE1(
  TEMPID NUMBER NOT NULL, 
  COURSEID VARCHAR2(20 BYTE),
  BATCHNO VARCHAR2(20 BYTE),
  EXAMTYPE VARCHAR2(20 BYTE), 
  EXAMMARK VARCHAR2(20 BYTE)
  CONSTRAINT "PK1" PRIMARY KEY (TEMPID)
  )
ON COMMIT DELETE ROWS;

COMMIT;
  
CREATE SEQUENCE SEQ_TEMPTABLE1
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;
COMMIT;

INSERT INTO TEMPTABLE1(TEMPID,COURSEID,BATCHNO,EXAMTYPE,EXAMMARK)
VALUES(SEQ_TEMPTABLE1.nextval,'MITM301','MIT-09','QUIZ1','10');
COMMIT;

INSERT INTO TEMPTABLE1(TEMPID,COURSEID,BATCHNO,EXAMTYPE,EXAMMARK)
VALUES(SEQ_TEMPTABLE1.nextval,'MITM302','MIT-09','QUIZ2','10');
COMMIT;
SELECT * FROM TEMPTABLE1;
TRUNCATE TABLE TEMPTABLE1;
COMMIT;

*/
/*
INSERT INTO TEMPTABLE1(TEMPID,COURSEID,BATCHNO,EXAMTYPE,EXAMMARK)
SELECT SEQ_TEMPTABLE1.nextval,
SELECT DISTINCT exam.courseid,exam.batchno,(exam.examtype || exam.examno) AS examtype,exam.exammark
FROM EXAM
INNER JOIN COURSE ON exam.courseid =course.courseid
INNER JOIN STUDENT ON exam.batchno =student.batchno
WHERE course.courseid='MITM301' 
AND student.batchno='MIT 9th'
ORDER BY exam.examid ASC 
*/

