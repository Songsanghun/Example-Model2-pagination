--seq,id,title,content,regdate(2017-02-15),read_count--  //sql 은 카멜 표기법 하지 마라
DROP TABLE Acticle;
--CREATE SEQUENCE art_seq
--CREATE TABLE Acticle
CREATE SEQUENCE seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;
CREATE TABLE Acticle(
seq DECIMAL,
id VARCHAR2(10),
title VARCHAR2(30),
content VARCHAR2(100),
regdate VARCHAR2(10),
read_count DECIMAL,
PRIMARY KEY(seq)
);
--INSERT(11건)
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'송상','인셉션영화','슈퍼 꿀잼 영화 인셉션','2017-02-01','7887');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'마린','닥터스트레인지영화','보스 겁나 멍청함','2017-02-05','5555');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'저글링','스타크레프트2','멀티테스킹을 너무 과하게 요구함','2017-02-15','3333');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'가렌','리그오브레전드 후기','늙어서 손가락 반응이 느림','2017-02-11','1111');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'솔져','오버워치 후기','총은 쏘는데 맞질 않는다.','2017-02-09','6665');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'안흥','굿윌헌팅 후기','머리좋은 오피','2017-02-03','2222');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'껌태','메트릭스 후기','골리앗 짱 멋짐','2017-02-05','1234');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'송상','오딘스피어 후기','난이도 쉽다.','2017-02-14','6547');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'송상','Java JSP 공부 후기','난 누구? 여긴 어디?','2017-02-15','7675');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'윤탱','잠수의 노하우','그냥 쉰다.','2017-02-11','765');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'박주','롤 후기','꿀잼.','2017-01-18','7742');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'송상','메소드의 종류','function과 procedure','2017-02-05','2222');
INSERT INTO Acticle(seq,id,title,content,regdate,read_count)
VALUES(seq.nextval,'송상','OOP 은 상추다.','Encupsulation, information hiding, abstracion, polymorphism','2017-02-15','5555');

--READ ALL
SELECT seq,id,title,content,regdate,read_count FROM Acticle;
--READ SOME
SELECT seq,id,title,content,regdate,read_count 
FROM Acticle WHERE id='%s';
--READ ONE
SELECT seq,id,title,content,regdate,read_count 
FROM Acticle WHERE seq='%s';
--UPDATE
UPDATE Acticle SET id='%s',title='%s',content='%s',regdate='%s'
WHERE seq='%s'
--DELETE
DELETE FROM Acticle WHERE seq='%s'
DELETE FROM Acticle WHERE seq='1'
