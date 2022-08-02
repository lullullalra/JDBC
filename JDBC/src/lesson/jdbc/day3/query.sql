select * from gisa;
select std_no
from gisa
where local_code = 'B'
order by (kor+eng) desc, std_no asc
limit 4,1;

select sum(total)+sum(case acc_code
	when 'A' then 5
	when 'B' then 15
	when 'C' then 20
	else 0
end) as total
from gisa
where (eng+math) >= 120;

select count(kor) , count(case local_code
	when 'A' then 5
	when 'B' then 10
	when 'C' then 15
	else 0
end) as total 
from gisa 
where acc_code = 'A' and 'B';
//////////////////////////////////////////
select count(kor) from gisa where kor>=50;
///////////////////////////////////////////
select count(*)
from gisa
where (acc_code = 'A' or acc_code = 'B')
and (kor+ (case local_code
	when 'A' then 5
	when 'B' then 10
	when 'C' then 15
end)) >= 50;