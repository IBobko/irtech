select s1.USERID as 'userid', s2.count as 'parentscount'
from
	(select DISTINCT u.USERID as 'userid'
	from users as u
	inner join USERSROLES as ur
		on u.USERID=ur.USERID
		) s1
inner join
	(select COUNT(fi.USERID) as 'count' , fi.USERID as 'userid'
	from FAMILYINFO as fi
		where fi.RELATIONSHIPTYPEID between 7 and 8
		group by fi.USERID) s2
on
	s1.USERID = s2.USERID