use airline_02;


INSERT INTO USER(FIRST_NAME, LAST_NAME, FULL_NAME, PASSWORD, PHONE, EMAIL, ADDRESS, GENDER, USER_ROLE)
 VALUES('FIRSTNAME', 'LASTNAME', '관리자', '1234', '전화번호', '이메일', '주소', '성', '관리');
 
SELECT * FROM USER;

CREATE TABLE USER(
	USER_ID INT auto_increment default 1,
    LAST_NAME VARCHAR(45) NOT NULL,
    FIRST_NAME VARCHAR(45) NOT NULL,
    FULL_NAME VARCHAR(45),
    PASSUSER_IDWORD VARCHAR(45) NOT NULL,
    PHONE VARCHAR(45),
    EMAIL VARCHAR(45),
    ADDRESS VARCHAR(45),
    BIRTHDATE DATETIME,
    GENDER VARCHAR(45),
    USER_ROLE VARCHAR(45),
    primary key(USER_ID)
);
select * from flight;
desc flight;
-- 제약 조건 제거 후 다시 제약조건 생성
ALTER TABLE airline_02.user MODIFY COLUMN USER_ID int auto_increment;

ALTER TABLE board drop constraint fk_board_user;
ALTER TABLE RESERVATION DROP CONSTRAINT fk_reservation_user;
ALTER TABLE BOARD add CONSTRAINT fk_BOARD_USER_ID foreign key(user_id) references user (user_id);
alter table reservation add constraint fk_RESERVATION_USER_ID foreign key(user_id) references user (user_id);

ALTER TABLE RESERVATION DROP CONSTRAINT fk_RESERVATION_SEAT1;
ALTER TABLE reservation add CONSTRAINT fk_RESERVATION_SEAT1 foreign key(SEAT_ID) references seat (SEAT_ID);

select * from seat;

DROP TABLE user;

select * from user;

select * from reservation where user_id = 10004;

select * from passenger;


select * from flight;
select seat_id  from seat where flight_id = 1 group by SEAT_END_NO;

select * from airport;

		SELECT COUNT(*)
			FROM Flight
			WHERE AIRPORT_DPT = (SELECT AIRPORT_CODE FROM AIRPORT WHERE AIRPORT_ID='2')
		 	AND AIRPORT_ARV = (SELECT AIRPORT_CODE FROM AIRPORT WHERE AIRPORT_ID='4');
            
select * from seat;


SELECT DISTINCT A.SEAT_TOTAL - C.R_CNT AS REMAIN_SEAT
   FROM SEAT A
      , (
         SELECT COUNT(*) AS R_CNT
             , B.FLIGHT_ID
                 , B.SEAT_ID
            FROM RESERVATION B
                WHERE B.FLIGHT_ID = 1
                  AND B.SEAT_ID = 1
       ) C
   WHERE A.FLIGHT_ID = C.FLIGHT_ID
      AND A.SEAT_ID = C.SEAT_ID;

select sum(SEAT_END_NO) from seat where flight_id = 1 group by seat_id;

select * from seat;

SELECT DISTINCT A.SEAT_TOTAL - IFNULL(C.R_CNT, 0) AS REMAIN_SEAT
   FROM (	
			SELECT DISTINCT SEAT_TOTAL,
					FLIGHT_ID,
                    SEAT_ID
				FROM SEAT
                WHERE FLIGHT_ID = 1
                  AND SEAT_ID = 2
		) A
	LEFT OUTER JOIN(
         SELECT COUNT(*) AS R_CNT
             , B.FLIGHT_ID
                 , B.SEAT_ID
            FROM RESERVATION B
                WHERE B.FLIGHT_ID = 1
                  AND B.SEAT_ID = 2
       ) C
	ON A.FLIGHT_ID = C.FLIGHT_ID
    AND A.SEAT_ID = C.SEAT_ID;

SELECT COUNT(*) AS R_CNT
             , B.FLIGHT_ID
                 , B.SEAT_ID
            FROM RESERVATION B
                WHERE B.FLIGHT_ID = 1
                  AND B.SEAT_ID = 2;

select SEAT_PRICE from seat where flight_id = 100 group by SEAT_ID;

SELECT DISTINCT SEAT_TOTAL
				FROM SEAT
                WHERE FLIGHT_ID = 1
                  AND SEAT_ID = 2;
                  
                  
		SELECT A.*
	    , CONCAT(B.LAST_NAME, B.FIRST_NAME) AS PASSENGER_NAME
	     , D.AIRPORT_DPT_NM
	     , E.AIRPORT_ARV_NM
	     , F.SEAT_PRICE
	     FROM (   
	            SELECT *
	               FROM RESERVATION
	                    WHERE USER_ID = 10000
	        ) A, 
	          PASSENGER B,
	          FLIGHT C,
	          (
	           SELECT H.AIRPORT_NAME AS AIRPORT_DPT_NM,
	                I.FLIGHT_ID
	            FROM AIRPORT H,
	                FLIGHT I
	            WHERE H.AIRPORT_CODE = I.AIRPORT_DPT
	        ) D,
	        (
	           SELECT H.AIRPORT_NAME AS AIRPORT_ARV_NM,
	                I.FLIGHT_ID
	            FROM AIRPORT H,
	                FLIGHT I
	            WHERE H.AIRPORT_CODE = I.AIRPORT_ARV
	        ) E,
	          (
	            SELECT DISTINCT SEAT_PRICE
	                , FLIGHT_ID
	                     , SEAT_ID               
	               FROM SEAT
	        ) F
	    WHERE A.PASSENGER_ID = B.PASSENGER_ID
	       AND A.FLIGHT_ID = C.FLIGHT_ID
	       AND A.FLIGHT_ID = F.FLIGHT_ID
	       AND A.SEAT_ID = F.SEAT_ID
	       AND C.FLIGHT_ID = D.FLIGHT_ID
	       AND C.FLIGHT_ID = E.FLIGHT_ID;