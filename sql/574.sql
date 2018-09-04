574

select 
name AS 'name' 
from
Candidate 
join 
(select
	Candidateid
	from
	vote
group by Candidateid
order by count(*)desc
limit 1
) AS winner
where Candidate.id = winner.Candidateid;