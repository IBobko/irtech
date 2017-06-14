select means.id, means.avg, counts.count
from
(
	select r.STUDENTID as 'id', AVG(r.RESULT) as 'avg'
		from RESULTS as r
		group by r.STUDENTID
) as means
inner join
(
	select a.STUDENTID as 'id', COUNT(a.CLASSMEETINGID) as 'count'
		from ATTENDANCE as a
		group by a.STUDENTID
) as counts
on means.id = counts.id