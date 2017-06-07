select r.STUDENTID , AVG(r.RESULT)
	from RESULTS as r
	group by r.STUDENTID