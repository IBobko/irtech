
--Добавление школы и ассайнмента в отдельную таблицы
insert into irtech_school_assignment
  (select S.schoolid, A.assignmentid from SCHOOLS S
    join SCHOOLYEARS YSY on YSY.SCHOOLID=S.SCHOOLID
    join CLASSES CL on CL.SCHOOLYEARID=YSY.SCHOOLYEARID
    join CLASSSUBJECTGROUPS CSG on CSG.PCLASSID=CL.CLASSID
    join SUBJECTGROUPS SG on SG.ID=CSG.ID
    join ASSIGNMENTS A on A.SGID = SG.ID
  where S.schoolid = 1374);


select * from irtech_data.public.results R
join irtech_school_assignment SA on R.assignmentid = SA.assignmentid



select * from SCHOOLS S
  join SCHOOLYEARS YSY on YSY.SCHOOLID=S.SCHOOLID
  join CLASSES CL on CL.SCHOOLYEARID=YSY.SCHOOLYEARID
  join CLASSSUBJECTGROUPS CSG on CSG.PCLASSID=CL.CLASSID
  join SUBJECTGROUPS SG on SG.ID=CSG.ID
  join ASSIGNMENTS A on  A.SGID = SG.ID
  join RESULTS R on A.assignmentid=R.assignmentid
where r.result < 1000 LIMIT 100;

-- FORMING irtech_avg_results
insert into irtech_avg_results
  select 1626, S.SCHOOLID, AVG(R.result), (R.donedate)::date from SCHOOLS S
    join SCHOOLYEARS YSY on YSY.SCHOOLID=S.SCHOOLID
    join CLASSES CL on CL.SCHOOLYEARID=YSY.SCHOOLYEARID
    join CLASSSUBJECTGROUPS CSG on CSG.PCLASSID=CL.CLASSID
    join SUBJECTGROUPS SG on SG.ID=CSG.ID
    join ASSIGNMENTS A on  A.SGID = SG.ID
    RIGHT join RESULTS R on A.assignmentid=R.assignmentid
  where S.cityid = 1626
  GROUP BY (R.donedate)::date, S.SCHOOLID
  ORDER BY (R.donedate)::date ASC;

