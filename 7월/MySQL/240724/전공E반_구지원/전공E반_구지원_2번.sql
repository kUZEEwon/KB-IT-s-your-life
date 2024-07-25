-- -----------------------------------------
-- 	SQL문제 2번
-- -----------------------------------------
-- 2-1 city 테이블에서 Name 컬럼의 데이터를 모두 대문자로 변경하여 출력
select upper(NAME) FROM city;

-- 2-2 city 테이블에서 ID 컬럼과 CountryCode 컬럼의 데이터를 결합하여 “4080-TKM” 와같이 출력
select concat(ID ,"-", CountryCode)
from city;

-- 2-3 city 테이블에서 District 컬럼데이터(영문)의글자수를출력
select length(District) from city;

-- 2-4 city 테이블에서 Population 컬럼의 평균값을 출력
select AVG(Population)
FROM city;


-- 2-5
/*
	country 테이블에서 Continent별 최대값 GNP값 출력
    (출력항목은Continent 명, GNP 최대값. 출력순서는 GNP 최대값의오름차순)
*/
select Continent, max(GNP) AS max_GNP
from country
group by Continent
order by max_GNP ASC;
