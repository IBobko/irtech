select r.STUDENTID as 'userid', AVG(r.RESULT) as 'average'
	from RESULTS as r
	group by r.STUDENTID