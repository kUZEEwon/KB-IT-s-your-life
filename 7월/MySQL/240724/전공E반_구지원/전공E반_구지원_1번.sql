-- -----------------------------------------
-- 	SQL문제 1번
-- -----------------------------------------
-- 1.1 city 테이블에 대한 전체내용을 출력
select * from city;

-- 1-2 countrylanguage 테이블에서 CountryCode가 ‘CHE’인 Language, Percentage컬럼 출력
select 
	Language,
    Percentage
from countrylanguage
where CountryCode = 'CHE';

-- 1-3 city 테이블에 다음 항목 데이터를 삽입
insert INTO city (Name, CountryCode, District, Population)
VALUES ("Cairo", "EGY","Cairo Governorate",9500000 );

-- 1-4 city 테이블에서 CountryCode가 'PNG'인 모든행의 Name 열값을 'GoodSite'로변경
update CITY
SET NAME = "GoodSite"
WHERE CountryCode ='PNG';

-- 1-5 country 테이블에서 Name열을 기준으로 내림차순으로 정렬하여 모든컬럼을 출력
SELECT * 
FROM country
ORDER BY Name desc;

