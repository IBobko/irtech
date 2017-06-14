select means.stid, means.avrg, counts.cnt
from
(
	select r.STUDENTID as stid, AVG(r.RESULT) as avrg
		from RESULTS as r
		group by r.STUDENTID
) as means
inner join
(
	select a.STUDENTID as stid, COUNT(a.CLASSMEETINGID) as cnt
		from ATTENDANCE as a
		group by a.STUDENTID
) as counts
on means.stid = counts.stid