INSERT  into irtech_ass_latency
  select

    ass.ASSIGNMENTID, ass.ASSIGNMENTNAME, ass.CLASSMEETINGID, ass.SGID,
    res.DONEDATE,
    cl.DAY as DUEDATE,


    DATE_PART('day', res.DONEDATE - cl.DAY) as latency

  from
    ASSIGNMENTS ass
    inner join RESULTS res on ass.ASSIGNMENTID=res.ASSIGNMENTID
    inner join CLASSMEETINGS cl on cl.CLASSMEETINGID=ass.CLASSMEETINGID
  where cl.DAY>'2012-09-01 00:00:00.000' and cl.DAY<'2013-01-08 00:00:00.000' AND
        ass.atypeid = 3;