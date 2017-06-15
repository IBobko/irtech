select s.USERID as 'userid'
	from SCHOOLSUSERS s
	where s.SCHOOLID = @SCHOOLID
