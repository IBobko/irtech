select s1.USERID , s2.count
from
	(select DISTINCT u.USERID
	from users as u
	inner join USERSROLES as ur
		on u.USERID=ur.USERID
		) s1
inner join
	(select COUNT(fi.USERID), fi.USERID
	from FAMILYINFO as fi
		where fi.RELATIONSHIPTYPEID between 7 and 8
		group by fi.USERID) s2
on
	s1.USERID = s2.USERID