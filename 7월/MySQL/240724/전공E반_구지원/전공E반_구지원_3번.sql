-- -----------------------------------------
-- 	SQL문제 3번
-- -----------------------------------------
-- 3-1
/*city 테이블과 country 테이블을 CountryCode컬럼과 Code 컬럼기준으로조인하고, 
city의 Name과 conutry의 Name을출력하시오. (inner join문이용)*/
select 
	ci.Name as city_name,
	co.Name as country_name
FROM country co inner JOIN CITY ci
ON code = CountryCode;

-- 3-2 country 테이블에서 모든국가명 을출력하고 각 국가에서 사용되는 언어를 함께출력
select 
	COUNTRY.NAME,
    countrylanguage.Language
from country left outer join countrylanguage
on country.code = countrylanguage.CountryCode;

-- 3-3 cit y테이블에서 최대인구를 가진 도시의 이름을 출력
select Name
from city
where Population =
(select max(Population) 
from city);

