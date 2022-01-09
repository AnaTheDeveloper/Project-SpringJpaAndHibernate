INSERT INTO course(id, name, created_date, last_updated_date, is_deleted) VALUES(10001, 'JPA in 50 Steps', sysdate(), sysdate(), false);
INSERT INTO course(id, name, created_date, last_updated_date, is_deleted) VALUES(10002, 'Spring in 10 Steps', sysdate(), sysdate(), false);
INSERT INTO course(id, name, created_date, last_updated_date, is_deleted) VALUES(10003, 'Clean Code', sysdate(), sysdate(), false);

INSERT INTO passport(id, number) VALUES(30001, 'E27H73YH');
INSERT INTO passport(id, number) VALUES(30002, 'JKH8237U');
INSERT INTO passport(id, number) VALUES(30003, 'NN8Y3U8A');

INSERT INTO student(id, name, passport_id) VALUES(20001, 'Mary', '30001');
INSERT INTO student(id, name, passport_id) VALUES(20002, 'Bob', '30002');
INSERT INTO student(id, name, passport_id) VALUES(20003, 'Jackson', '30003');

INSERT INTO review(id, rating, description, course_id) VALUES(40001, '5', 'Okay', 10001);
INSERT INTO review(id, rating, description, course_id) VALUES(40002, '3', 'Boring', 10001);
INSERT INTO review(id, rating, description, course_id) VALUES(40003, '9', 'Amazing', 10003);

INSERT INTO STUDENT_COURSE(student_id, course_id) VALUES(20001, 10001);
INSERT INTO STUDENT_COURSE(student_id, course_id) VALUES(20002, 10001);
INSERT INTO STUDENT_COURSE(student_id, course_id) VALUES(20003, 10001);
INSERT INTO STUDENT_COURSE(student_id, course_id) VALUES(20001, 10003);