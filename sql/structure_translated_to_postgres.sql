
CREATE TABLE ACCESS_REPORTS(
	REPORTID int ,
	SCHOOLID int
)
;

/****** Object:  Table ACCESSJOURNAL    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE ACCESSJOURNAL(
	ID int  ,
	DATE timestamp ,
	USERID int ,
	LOGINEVENTID int NULL

)
;

/****** Object:  Table ACTIVITIES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ACTIVITIES(
	ACTIVITYID varchar(20) ,
	ACTIVITYNAME varchar(80) ,
	SELFPACED char(1) ,
	PROBLEMLISTURL varchar(200) NULL,
	PROBLEMURL varchar(200) NULL,
	ENTRYURL varchar(200) NULL,
	RESULTSURL varchar(200) NULL,
	TEACHER_TOOLTIP varchar(200) NULL,
	STUDENT_TOOLTIP varchar(200) NULL,
	INTERNALID varchar(20) NULL,
	GROUPID int NULL,
	ISDELETED char(1) NULL
)
;



/****** Object:  Table ACTIVITYGROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ACTIVITYGROUPS(
	GROUPID int ,
	PUBCODE varchar(20) ,
	NAME varchar(200) ,
	ORDERNO int

)
;



/****** Object:  Table ACTIVITYPARAMETERS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ACTIVITYPARAMETERS(
	PARAMETERID int  ,
	ACTIVITYID varchar(20) ,
	NAME varchar(20) ,
	TITLE varchar(200) ,
	TYPE char(1) ,
	EDITABLE char(1) ,
	VISIBLE char(1) ,
	SORTABLE char(1) ,
	LAVISIBLE char(1) ,
	LAEDITABLE char(1) ,
	GRADING char(1) ,
	DEFAULTVALUE varchar(2000) NULL,
	LISTITEMS varchar(2000) NULL
)
;



/****** Object:  Table ACTIVITYPUBLISHERS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ACTIVITYPUBLISHERS(
	CODE varchar(20) ,
	NAME varchar(200) ,
	ORDERNO int
)
;



/****** Object:  Table ADD_PROGRAMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ADD_PROGRAMS(
	PROGRAMID int  ,
	SCHOOLID int ,
	DIRECTIONID int ,
	PROGRAMNAME varchar(255) ,
	DESCRIPTION varchar(255) NULL,
	PROG_ATTR varchar(50)
)
;



/****** Object:  Table ADDCLASSES_STUDENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ADDCLASSES_STUDENTS(
	SCHOOLID int ,
	STUDENTID int ,
	SUBDOCID1 int ,
	SUBDOCID2 int NULL,
	REASONID int ,
	DESCRIPTION varchar(2000) NULL,
	PROGRAMID int ,
	ADDCLSSTUDID int  ,
	NUMORDER int NULL
)
;



/****** Object:  Table ADDCLS_STUD_DETAILS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE ADDCLS_STUD_DETAILS(
	ADDCLSSTUDID int ,
	CLASSID int
)
;

/****** Object:  Table ADDRESSES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ADDRESSES(
	ADDRESSID int  ,
	DISTRICTID int NULL,
	LOCATIONID int NULL,
	HOUSE varchar(200) ,
	CORP varchar(200) ,
	ROOM varchar(200)
)
;



/****** Object:  Table ADDRESSTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ADDRESSTYPES(
	id varchar(1) ,
	name varchar(20) NULL,
PRIMARY KEY
(
	id
)
)
;



/****** Object:  Table ADDSCHOOL_REASONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ADDSCHOOL_REASONS(
	REASONID int ,
	REASONNAME varchar(50)
)
;



/****** Object:  Table AIDRESULTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE AIDRESULTS(
	PARENTID int ,
	SCHOOLYEARID int ,
	AIDTYPE int ,
	AIDDATE timestamp ,
	AIDRESULT int NULL,
	AIDCOMMENT varchar(2000) NULL
)
;



/****** Object:  Table ALLOWEDIPRANGES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ALLOWEDIPRANGES(
	RANGEID int  ,
	SCHOOLID int NULL,
	LEFTBOUND varchar(39) NULL,
	RIGHTBOUND varchar(39) NULL
)
;



/****** Object:  Table ANNOUNCEMENT_ATTACHMENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE ANNOUNCEMENT_ATTACHMENTS(
	ANNOUNCEMENTID int ,
	ATTACHMENTID int
)
;

/****** Object:  Table ANNOUNCEMENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ANNOUNCEMENTS(
	ANNOUNCEMENTID int  ,
	USERID int NULL,
	TITLE varchar(50) ,
	DESCRIPTION varchar(4000) NULL,
	POSTTO int NULL,
	POSTDATE timestamp NULL,
	DELETEDATE timestamp NULL
)
;



/****** Object:  Table ASSIGNMENTACTIVITYDETAILS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ASSIGNMENTACTIVITYDETAILS(
	ASSIGNMENTID int ,
	PROBLEMNAME varchar(400) NULL,
	PROBLEMPARAMETERS varchar(4000) NULL,
	LEXILELEVEL int NULL,
	PROBLEMGROUPID int NULL,
	ACTIVITYID varchar(20) ,
	STARTDATE timestamp NULL,
	DUEDATE timestamp NULL,
	POSSIBLEPOINTS int
)
;



/****** Object:  Table ASSIGNMENTINFO    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ASSIGNMENTINFO(
	ASSIGNMENTID int ,
	PARAMETERID int ,
	STUDENTID int ,
	VALUE varchar(2000) NULL
)
;



/****** Object:  Table ASSIGNMENTPARAMETERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE ASSIGNMENTPARAMETERS(
	PARAMETERID int
)
;

/****** Object:  Table ASSIGNMENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ASSIGNMENTS(
	ASSIGNMENTID int  ,
	ASSIGNMENTNAME varchar(400) NULL,
	DESCRIPTION varchar(2000) NULL,
	ATTACHMENTID int NULL,
	CLASSASSIGNMENT int ,
	SGID int ,
	CLASSMEETINGID int NULL,
	WEIGHT int NULL,
	ATYPEID int
)
;



/****** Object:  Table ASSIGNMENTSCOURSES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ASSIGNMENTSCOURSES(
	ASSIGNMENTID int ,
	PRODUCTID varchar(50)
)
;



/****** Object:  Table ASSIGNMENTSTESTPLANS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE ASSIGNMENTSTESTPLANS(
	ASSIGNMENTID int ,
	TESTPLANID int
)
;

/****** Object:  Table ASSIGNMENTTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ASSIGNMENTTYPES(
	TYPEID int  ,
	NAME varchar(50) ,
	ABBR varchar(3) ,
	"ORDER" int ,
	EDITABLE char(1)
)
;



/****** Object:  Table ATO_TYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ATO_TYPES(
	ATO_TYPEID int  ,
	SHORTNAME varchar(20) ,
	FULLNAME varchar(50) ,
	LEVELABBR int
)
;



/****** Object:  Table ATTACHMENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ATTACHMENTS(
	MESSAGEID int ,
	TITLE varchar(400) NULL,
	TYPE char(1) NULL,
	ATTACHMENT text NULL
)
;



/****** Object:  Table ATTENDANCE    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ATTENDANCE(
	STUDENTID int ,
	CLASSMEETINGID int ,
	REASON varchar(3)
)
;



/****** Object:  Table CITIES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE CITIES(
	CITYID int  ,
	STATE_PROVINCEID int NULL,
	PROVINCEID int NULL,
	NAME varchar(200) ,
	SETTLEMENTTYPEID int ,
	KLADRCODE varchar(20) NULL,
	AVAILABILITYOFSTREET int ,
	ATO_TYPEID int NULL
)
;



/****** Object:  Table CLASS_STUD_RANGES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CLASS_STUD_RANGES(
	STUDENTID int ,
	CLASSID int ,
	DateRangeId int ,
	Id int
)
;

/****** Object:  Table CLASSCALENDAR    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CLASSCALENDAR(
	CLASSID int ,
	EVENTID int ,
	ROOMID int NULL
)
;

/****** Object:  Table CLASSES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE CLASSES(
	CLASSID int  ,
	TEACHERID int ,
	CLASSNAME varchar(60) ,
	GRADE int ,
	SCHOOLYEARID int ,
	PROFILEID int ,
	TYPEID int ,
	STEP int NULL,
	STEPNAME varchar(60) NULL,
	PROGID int NULL,
	CAPACITY int ,
	MSK_CLASSID varchar(50) NULL,
	VERSION timestamp ,
	CLASS_GUID text ,
	PLANNEDOCCUPANCY int NULL
)
;



/****** Object:  Table CLASSES_RELAYS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CLASSES_RELAYS(
	CLASSID int ,
	TERMID int ,
	RELAY int
)
;

/****** Object:  Table CLASSESROOMS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CLASSESROOMS(
	CLASSID int ,
	ROOMID int
)
;

/****** Object:  Table CLASSESTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE CLASSESTYPES(
	TYPEID int ,
	TYPENAME varchar(100) ,
	FUNCTYPEID int ,
	TYPECODE varchar(50) NULL
)
;



/****** Object:  Table CLASSMEETINGS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CLASSMEETINGS(
	CLASSMEETINGID int  ,
	LESSONID int NULL,
	SGID int ,
	DAY timestamp ,
	SCHEDULETIMEID int ,
	TEACHERID int NULL,
	ROOMID int NULL

)
;

/****** Object:  Table CLASSPARAMETERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CLASSPARAMETERS(
	PARAMETERID int 
)
;

/****** Object:  Table CLASSSUBJECTGROUPS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CLASSSUBJECTGROUPS(
	ID int ,
	GROUPID int NULL,
	PCLASSID int NULL
)
;

/****** Object:  Table CODEBOOKCONTENTELEMENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE CODEBOOKCONTENTELEMENTS(
	CODEBOOKID int  ,
	TITLE varchar(250) ,
	CERTIFICATIONTYPE int ,
	SUBJECTFIPIID int ,
	GLOBALYEARID int 
)
;



/****** Object:  Table CODEBOOKSSUBJECTSSCHOOLYEARS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CODEBOOKSSUBJECTSSCHOOLYEARS(
	CODEBOOKID int ,
	SCHOOLYEARID int ,
	SUBJECTID int
)
;

/****** Object:  Table COMMISSINFO    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE COMMISSINFO(
	COMMISSID int ,
	ITEMID int
)
;

/****** Object:  Table COMMISSIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE COMMISSIONS(
	COMMISSID int  ,
	STUDENTID int ,
	SCHOOLYEARID int ,
	COMMISSTYPEID int NULL,
	COMMISSNUM varchar(100) NULL,
	STARTDATE timestamp ,
	ENDDATE timestamp
)
;



/****** Object:  Table COMMISSTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE COMMISSTYPES(
	COMMISSTYPEID int ,
	TYPENAME varchar(20)
)
;



/****** Object:  Table COMPONENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE COMPONENTS(
	COMPONENTID int  ,
	COMPONENTNAME varchar(50) ,
	SCHOOLID int NULL
)
;



/****** Object:  Table CONTENTELEMENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE CONTENTELEMENTS(
	CONTENTELEMENTID int  ,
	NUMBER varchar(10) ,
	DESCRIPTION varchar(1000) NULL,
	CODEBOOKID int ,
	SECTIONID int NULL
)
;



/****** Object:  Table COUNTRIES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE COUNTRIES(
	COUNTRYID int  ,
	COUNTRYNAME varchar(50)
)
;



/****** Object:  Table COURSES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE COURSES(
	PRODUCTID varchar(50)
)
;



/****** Object:  Table CREATIVES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CREATIVES(
	EOID int ,
	TYPEID int ,
	TEAMCOUNT int ,
	ID int
)
;

/****** Object:  Table CREATIVETYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE CREATIVETYPES(
	TYPEID int ,
	TYPENAME varchar(80)
)
;



/****** Object:  Table CSG_EXAMTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE CSG_EXAMTYPES(
	CSGID int ,
	PERIODTYPEID int ,
	CHOICE char(1)
)
;



/****** Object:  Table CURICULUM    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CURICULUM(
	GRADEID int ,
	SUBJECTID int ,
	SCHOOLYEARID int ,
	COMPONENTID int ,
	PROFILEID int ,
	CLASSID int ,
	HOURS numeric(10, 2) NULL,
	TERMID int
)
;

/****** Object:  Table CURICULUMLIMITS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CURICULUMLIMITS(
	GRADEID int ,
	COMPONENTID int ,
	SCHOOLYEARID int ,
	HOURS numeric(10, 2) NULL
)
;

/****** Object:  Table CURICULUMPROFILES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE CURICULUMPROFILES(
	PROFILEID int  ,
	SCHOOLID int ,
	PROFILENAME varchar(50) ,
	GRADESET int
)
;



/****** Object:  Table CURICULUMTEMPLATE    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE CURICULUMTEMPLATE(
	GRADEID int ,
	SUBJECTID int ,
	PROFILEID int ,
	SCHOOLID int
)
;

/****** Object:  Table DATAOBJECTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DATAOBJECTS(
	OBJECTID int  ,
	NAME varchar(30) ,
	DISPLAYNAME varchar(50) ,
	ISPUBLIC char(1) ,
	SQLWHEREEXPR varchar(1000) NULL,
	SQLGROUPEXPR varchar(200) NULL,
	DESCRIPTION varchar(1000) NULL
)
;



/****** Object:  Table DATERANGE    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DATERANGE(
	id int  ,
	SCHOOLYEARID int NULL,
	ENROLL timestamp NULL,
	DEPART timestamp NULL
)
;

/****** Object:  Table DBUPDATELOG    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DBUPDATELOG(
	ID int  ,
	UPDATEDATE timestamp ,
	REV int NULL,
	ISSUE int NULL,
	COMMENTS varchar(4000) NULL,
PRIMARY KEY
(
	ID
)
)
;



/****** Object:  Table DEFAULTCOMPONENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DEFAULTCOMPONENTS(
	COMPONENTID int ,
	COMPONENTNAME varchar(50)
)
;



/****** Object:  Table DEFAULTCURICULUMLIMITS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DEFAULTCURICULUMLIMITS(
	FUNCTYPEID int ,
	GRADEID int ,
	HOURS numeric(10, 2) NULL,
	WEEKENDDAYS int
)
;

/****** Object:  Table DEFAULTCURICULUMPROFILES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DEFAULTCURICULUMPROFILES(
	PROFILEID int ,
	PROFILENAME varchar(50) ,
	GRADESET int
)
;



/****** Object:  Table DEFAULTEVENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DEFAULTEVENTS(
	ETYPE int ,
	NAME varchar(200) ,
	STARTTIME timestamp ,
	ENDTIME timestamp
)
;



/****** Object:  Table DEFAULTGROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DEFAULTGROUPS(
	GROUPID int ,
	SUBJECTID int ,
	GROUPNAME varchar(50) ,
	GROUPABBREV varchar(50) NULL
)
;



/****** Object:  Table DEFAULTLOGOUTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DEFAULTLOGOUTS(
	ROLEID int ,
	LOGOUTTIME int NULL
)
;

/****** Object:  Table DEFAULTPARENTSUBJECTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DEFAULTPARENTSUBJECTS(
	PSUBJECTID int ,
	PSUBJECTNAME varchar(50) NULL
)
;



/****** Object:  Table DEFAULTPORTFOLIOGROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DEFAULTPORTFOLIOGROUPS(
	GROUPID int ,
	GROUPNAME varchar(100) ,
	PARENTID int NULL,
	GROUPORDER int
)
;



/****** Object:  Table DEFAULTROLESRIGHTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DEFAULTROLESRIGHTS(
	ROLEID int ,
	RIGHTID int
)
;

/****** Object:  Table DEFAULTSUBJECTFIELDS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DEFAULTSUBJECTFIELDS(
	FIELDID int ,
	FIELDNAME varchar(50) NULL
)
;



/****** Object:  Table DEFAULTSUBJECTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DEFAULTSUBJECTS(
	SUBJECTID int ,
	FIELDID int NULL,
	SUBJECTNAME varchar(70) ,
	SUBJECTABBREV varchar(70) ,
	PARENTSUBJECTID int NULL
)
;



/****** Object:  Table DISTRICTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DISTRICTS(
	DISTRICTID int  ,
	CITYID int ,
	NAME varchar(200)
)
;



/****** Object:  Table DOC_ORGS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DOC_ORGS(
	DOC_ID int ,
	ORGID int
)
;

/****** Object:  Table DOCINFO    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DOCINFO(
	DOC_ID int ,
	INFOID int
)
;

/****** Object:  Table DOCTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DOCTYPES(
	DOCTYPEID int ,
	DOCTYPE varchar(200) NULL
)
;



/****** Object:  Table DOCUMENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DOCUMENTS(
	DOC_ID int  ,
	DOCTYPEID int ,
	DOCDATE timestamp NULL
)
;

/****** Object:  Table DOU_ATTENDANCE    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DOU_ATTENDANCE(
	PAYID int ,
	NORMID int ,
	ATTENDCOUNT int ,
	NUMORDER int ,
	ID int
)
;

/****** Object:  Table DOUGROUPAGECATEGORIES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DOUGROUPAGECATEGORIES(
	CATEGORYID int ,
	NAME varchar(50)
)
;



/****** Object:  Table DOUGROUPAGES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DOUGROUPAGES(
	AGEID int ,
	AGENAME varchar(100) ,
	AGEMIN int ,
	AGEMAX int
)
;



/****** Object:  Table DOUGROUPTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DOUGROUPTYPES(
	PRETYPEID int ,
	PRETYPENAME varchar(100)
)
;



/****** Object:  Table DOUPAYNORMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DOUPAYNORMS(
	PAYNORMID int  ,
	EMID int ,
	PAYNORMTITLE varchar(1000) NULL,
	STARTDATE timestamp
)
;



/****** Object:  Table DOUSTUDENT_CORRECT    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE DOUSTUDENT_CORRECT(
	CORRECTID int  ,
	STUDENTID int ,
	SCHOOLYEARID int ,
	CORRECTDATE timestamp ,
	WAS_SENT int ,
	FIRSTNAME_OLD varchar(20) NULL,
	MIDDLENAME_OLD varchar(20) NULL,
	LASTNAME_OLD varchar(20) ,
	BIRTHDATE_OLD timestamp NULL,
	FIRSTNAME_NEW varchar(20) NULL,
	MIDDLENAME_NEW varchar(20) NULL,
	LASTNAME_NEW varchar(20) ,
	BIRTHDATE_NEW timestamp NULL,
	PARENTPAY_MONTH int ,
	PARENTPAY_YEAR int ,
	PARENTPAY_PAYVAL numeric(10, 2) ,
	DELETED int
)
;



/****** Object:  Table DUAL    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE DUAL(
	DUMMY int NULL
)
;

/****** Object:  Table EDUC_STEPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EDUC_STEPS(
	STEPID int ,
	STEPNAME varchar(200) ,
	FULLNAME varchar(50) ,
	GRADEMIN int ,
	GRADEMAX int ,
	SCHOOLYEARID int
)
;



/****** Object:  Table EDUCMANAGEMENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EDUCMANAGEMENTS(
	EMID int  ,
	FOUNDERID int ,
	HLEVEL int
)
;

/****** Object:  Table EDUCPROGRAMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EDUCPROGRAMS(
	PROGRAMID int ,
	PROGRAMNAME varchar(100)
)
;



/****** Object:  Table EGE_CLASSES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EGE_CLASSES(
	ID int  ,
	GLOBALYEARID int ,
	CLASSNAME varchar(50) ,
	CODE_OU varchar(6) ,
PRIMARY KEY
(
	ID
)
)
;

/****** Object:  Table EGE_PERSONS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EGE_PERSONS(
	ID int  ,
	LASTNAME varchar(80) ,
	FIRSTNAME varchar(80) ,
	MIDDLENAME varchar(80) ,
	DOC_SERIAL varchar(9) ,
	DOC_NUMBER varchar(10)
)
;

/****** Object:  Table EGE_PERSONUSERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EGE_PERSONUSERS(
	PERSONID int ,
	STUDENTID int
)
;

/****** Object:  Table EGE_RESULTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EGE_RESULTS(
	CLASSID int ,
	SUBJECTID int ,
	PERSONID int ,
	MASK_A varchar(50) NULL,
	MASK_B varchar(50) NULL,
	MASK_C varchar(50) NULL,
	MASK_D varchar(50) NULL,
	TOTAL_SCORE int ,
	PRIMARY_SCORE int ,
	AUDITORY varchar(4) NULL,
	TOTAL_MARK int NULL
)
;

/****** Object:  Table EGE_SUBJECTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EGE_SUBJECTS(
	ID int  ,
	SUBJECTNAME varchar(255)
)
;

/****** Object:  Table EGERANGES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EGERANGES(
	GLOBALYEARID int ,
	SUBJECTFIPIID int ,
	RANGE int ,
	VALUE int
)
;

/****** Object:  Table EM_FORMPARAM    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EM_FORMPARAM(
	PARAMID int ,
	EMID int ,
	GLOBALYEARID int ,
	PVALUE varchar(250) ,
	FORMSPEC int
)
;



/****** Object:  Table EM_INDICATORSVALS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EM_INDICATORSVALS(
	EMID int ,
	INDICATORID int ,
	GLOBALYEARID int ,
	VALUE int
)
;

/****** Object:  Table EM_INFO    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EM_INFO(
	PARAMID int ,
	INFO varchar(1000) NULL,
	EMID int
)
;



/****** Object:  Table EM_INFOPARAMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EM_INFOPARAMS(
	PARAMID int ,
	NAME varchar(200) ,
	PTYPE varchar(20)
)
;



/****** Object:  Table EM_PARAMETERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EM_PARAMETERS(
	PARAMETERID int
)
;

/****** Object:  Table EM_ROLES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EM_ROLES(
	ROLEID int ,
	ABBREV varchar(5) NULL
)
;



/****** Object:  Table EM_SCHOOLS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EM_SCHOOLS(
	EMID int ,
	SCHOOLID int
)
;

/****** Object:  Table EM_SCHOOLS_ALL    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EM_SCHOOLS_ALL(
	EMID int ,
	SCHOOLID int ,
	OWN_EMID int ,
	TREE_LEVEL int ,
	ACTUAL_ON timestamp
)
;

/****** Object:  Table EM_SETTINGS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EM_SETTINGS(
	EMID int ,
	PARAMETERID int ,
	PARAMETERVALUE varchar(50)
)
;



/****** Object:  Table EM_STATREPORTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EM_STATREPORTS(
	ID int  ,
	EMID int ,
	NAME varchar(800) ,
	LEVEL int ,
	ROWS varchar(2000) ,
	COLUMNS varchar(2000)
)
;



/****** Object:  Table EM_USERSROLES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EM_USERSROLES(
	USERID int ,
	EMID int ,
	ROLEID int
)
;

/****** Object:  Table EO_FORMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EO_FORMS(
	EOFORMID int ,
	EOTYPEID int ,
	NAME varchar(600) ,
	CLASSIFIERCODE varchar(4) ,
	FUNCTIONALITYTYPEID int NULL,
	REAL_FUNCTIONALITYTYPEID int
)
;



/****** Object:  Table EO_LEGALFORMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EO_LEGALFORMS(
	EOLEGALFORMID int ,
	NAME varchar(100) NULL
)
;



/****** Object:  Table EO_LEGALFORMS_83    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EO_LEGALFORMS_83(
	EOLEGALFORM83ID int ,
	NAME varchar(30) ,
PRIMARY KEY
(
	EOLEGALFORM83ID
)
)
;



/****** Object:  Table EO_TYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EO_TYPES(
	EOTYPEID int ,
	NAME varchar(200) ,
	CLASSIFIERCODE int
)
;



/****** Object:  Table EVENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EVENTS(
	EVENTID int  ,
	EVENTNAME varchar(200) ,
	EVENTDESCRIPTION varchar(2000) NULL,
	STARTTIME timestamp ,
	ENDTIME timestamp ,
	PERIODICITY char(1) NULL
)
;



/****** Object:  Table EXPFUNCTIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EXPFUNCTIONS(
	FUNCTIONID int  ,
	NAME varchar(30) ,
	DISPLAYSIGN varchar(20)
)
;



/****** Object:  Table EXPLINES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EXPLINES(
	EXPRESSIONID int ,
	LINEID int  ,
	LINEORDER int ,
	LPARENTH char(1) NULL,
	RPARENTH char(1) NULL,
	OPERATIONID int NULL,
	FUNCTIONID int NULL,
	CONSTANT varchar(500) NULL,
	PROPERTYID int NULL,
	QUERYOBJID int NULL
)
;



/****** Object:  Table EXPOPERATIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE EXPOPERATIONS(
	OPERATIONID int  ,
	NAME varchar(30) ,
	DISPLAYSIGN varchar(20) ,
	OPERTYPE char(1)
)
;



/****** Object:  Table EXPRESSIONS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE EXPRESSIONS(
	EXPRESSIONID int
)
;

/****** Object:  Table FAMILYINFO    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FAMILYINFO(
	RELATIVEID int  ,
	USERID int ,
	RELATIONSHIPTYPEID int ,
	LASTNAME varchar(30) ,
	FIRSTNAME varchar(30) ,
	MIDDLENAME varchar(30) ,
	BIRTHDATE timestamp NULL
)
;



/****** Object:  Table FAMILYRELATIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FAMILYRELATIONS(
	RELATIONSHIPTYPEID int ,
	NAME varchar(20)
)
;



/****** Object:  Table FILEATTACHMENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FILEATTACHMENTS(
	ATTACHMENTID int  ,
	DESCRIPTION varchar(4000) NULL,
	AFILENAME varchar(256) NULL,
	SAVED int NULL,
	USERID int NULL,
	AFILE_GUID varchar(255) ,
	AFILE varchar(255)  NULL
)

;



/****** Object:  Table FILTERCONDITIONS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE FILTERCONDITIONS(
	FILTERCONDITIONID int  ,
	QUERYID int NULL,
	EXPRESSIONID int NULL
)
;

/****** Object:  Table FOREIGNLANGNAMES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FOREIGNLANGNAMES(
	FOREIGNLANGID int  ,
	NAME varchar(70) NULL
)
;



/****** Object:  Table FORMPARAMETERS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FORMPARAMETERS(
	PARAMID int  ,
	SectionID int ,
	cellRow int ,
	cellColumn int NULL,
	letter varchar(20) NULL,
	PTYPE varchar(20) ,
	NAME varchar(20)
)
;



/****** Object:  Table FORUMMESSAGES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE FORUMMESSAGES(
	MESSAGEID int  ,
	TOPICID int ,
	USERID int ,
	SENT timestamp NULL,
	MESSAGETEXT text NULL
)
;

/****** Object:  Table FORUMMODERATORS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE FORUMMODERATORS(
	USERID int ,
	SCHOOLID int
)
;

/****** Object:  Table FORUMTOPICMODERATORS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE FORUMTOPICMODERATORS(
	USERID int ,
	TOPICID int
)
;

/****** Object:  Table FORUMTOPICS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FORUMTOPICS(
	TOPICID int  ,
	SCHOOLID int ,
	NAME varchar(200)
)
;



/****** Object:  Table FOUNDERS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FOUNDERS(
	FOUNDERID int  ,
	FNAME varchar(50) NULL,
	TYPEID int ,
	CITYID int NULL,
	STATEID int NULL,
	FULLNAME varchar(150)
)
;



/****** Object:  Table FOUNDERTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FOUNDERTYPES(
	TYPEID int ,
	TYPENAME varchar(80)
)
;



/****** Object:  Table FREESTAFF    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE FREESTAFF(
	USERID int ,
	SCHOOLID int
)
;

/****** Object:  Table FREESTUDENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE FREESTUDENTS(
	SCHOOLYEARID int ,
	STUDENTID int ,
	CLASSID int
)
;

/****** Object:  Table FUNCTIONALITYTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE FUNCTIONALITYTYPES(
	FUNCTIONALITYTYPEID int ,
	NAME varchar(50)
)
;



/****** Object:  Table GIARANGES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE GIARANGES(
	GLOBALYEARID int ,
	SUBJECTFIPIID int ,
	RANGE int ,
	VALUE int
)
;

/****** Object:  Table GLOBALSUBJECTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE GLOBALSUBJECTS(
	GLOBALSUBJID int  ,
	SUBJNAME varchar(100) NULL,
	SUBJABBR varchar(70)

)
;



/****** Object:  Table GLOBALYEARS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE GLOBALYEARS(
	GLOBALYEARID int ,
	SCHOOLYEARNAME varchar(50) ,
	STARTDATE timestamp ,
	ENDDATE timestamp
)
;



/****** Object:  Table GRADINGSCALES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE GRADINGSCALES(
	GRADINGSCALEID int  ,
	GRADINGSYSTEMID int ,
	NAME int NULL,
	THRESHOLD int
)
;

/****** Object:  Table GRADINGSYSTEMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE GRADINGSYSTEMS(
	GRADINGSYSTEMID int  ,
	NAME varchar(50) ,
	SCHOOLYEARID int ,
	DEFAULTVAL char(1) NULL
)
;



/****** Object:  Table GROUPINGS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE GROUPINGS(
	GROUPINGID int  ,
	QUERYID int NULL,
	PROPERTYID int NULL,
	GROUPORDER int ,
	QUERYOBJID int
)
;

/****** Object:  Table GROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE GROUPS(
	GROUPID int  ,
	SUBJECTID int ,
	GROUPNAME varchar(50) ,
	GROUPABBREV varchar(50)
)
;



/****** Object:  Table HIDDENSCHOOLS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE HIDDENSCHOOLS(
	SCHOOLID int
)
;

/****** Object:  Table HOLIDAYS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE HOLIDAYS(
	EVENTID int ,
	SCHOOLYEARID int
)
;

/****** Object:  Table IDPS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE IDPS(
	ID int ,
	KEY varchar(50) ,
PRIMARY KEY
(
	ID
)
)
;

/****** Object:  Table INDICATOR_CALC_ARGS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE INDICATOR_CALC_ARGS(
	ID int ,
	NAME varchar(50) ,
	"DESC" varchar(400) ,
	TYPE int ,
	MULTIPLE  int
)
;

/****** Object:  Table INDICATOR_CALC_ARGS_RELATIONS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE INDICATOR_CALC_ARGS_RELATIONS(
	CALCULATORID int ,
	ARGID int
)
;

/****** Object:  Table INDICATOR_CALC_EXP_PARAMS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE INDICATOR_CALC_EXP_PARAMS(
	EXPID int ,
	ARGID int ,
	VALUE varchar(255)
)
;

/****** Object:  Table INDICATOR_CALC_EXPS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE INDICATOR_CALC_EXPS(
	ID int  ,
	INDICATORID int ,
	CALCULATORID int
)
;

/****** Object:  Table INDICATOR_CALC_GROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE INDICATOR_CALC_GROUPS(
	ID int ,
	PARENTGROUPID int NULL,
	GROUPNAME varchar(400)
)
;



/****** Object:  Table INDICATOR_CALCS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE INDICATOR_CALCS(
	ID int ,
	GROUPID int ,
	NAME varchar(400) ,
	TYPENAME varchar(400) ,
	LEVEL int ,
	VALUETYPE int NULL
)
;



/****** Object:  Table INDICATOR_EXPLANATION    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE INDICATOR_EXPLANATION(
	ID int  ,
	EXPLANATIOtext varchar(5000) ,
	INDICATORGROUPID int NULL,
PRIMARY KEY
(
	ID
)
)
;



/****** Object:  Table INDICATORGROUPS_ACCESSJOURNAL_RELATIONS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE INDICATORGROUPS_ACCESSJOURNAL_RELATIONS(
	ENTRYID int ,
	INDICATORGROUPID int
)
;

/****** Object:  Table INDICATORS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE INDICATORS(
	ID int  ,
	EMID int NULL,
	NAME varchar(400) ,
	NUMBER int ,
	LEVEL int ,
	CLASSTYPE nchar(1) ,
	VALUETYPE int NULL,
	REGIONINDICATORID int NULL
)
;



/****** Object:  Table INDICATORS_ACCESSJOURNAL    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE INDICATORS_ACCESSJOURNAL(
	ID int ,
	LEVEL int ,
	ACCESSTYPE int ,
	SCHOOLYEARID int NULL,
	EMID int NULL,
	GLOBALYEARID int NULL
)
;

/****** Object:  Table INDICATORS_RELATIONS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE INDICATORS_RELATIONS(
	INDICATORID int ,
	GROUPINDICATORID int
)
;

/****** Object:  Table INFORMS_LASTNUMS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE INFORMS_LASTNUMS(
	SCHOOLYEARID int ,
	LASTNUM int
)
;

/****** Object:  Table INFOS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE INFOS(
	ID int  ,
	INFO varchar(200) ,
	INFOTYPEID int NULL
)
;



/****** Object:  Table INFOTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE INFOTYPES(
	INFOTYPEID int ,
	INFOTYPE varchar(200) NULL
)
;



/****** Object:  Table IUP_CLASSES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE IUP_CLASSES(
	CLASSID int
)
;

/****** Object:  Table IUP_COMPONENTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE IUP_COMPONENTS(
	COMPONENTID int ,
	COMPONENTNAME varchar(50)
)
;



/****** Object:  Table IUP_CURICULUM    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE IUP_CURICULUM(
	SCHOOLYEARID int ,
	GRADEID int ,
	SUBJECTID int ,
	COMPONENTID int ,
	LEVELID int ,
	TERMID int ,
	HOURS numeric(10, 2) NULL
)
;

/****** Object:  Table IUP_CURICULUMLIMITS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE IUP_CURICULUMLIMITS(
	SCHOOLYEARID int ,
	COMPONENTID int ,
	GRADEID int ,
	HOURS numeric(10, 2) NULL
)
;

/****** Object:  Table IUP_LEVELS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE IUP_LEVELS(
	LEVELID int ,
	LEVELNAME varchar(50) ,
	SHORTNAME varchar(1)
)
;



/****** Object:  Table JOINEDTABLES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE JOINEDTABLES(
	JOINEDTABLEID int  ,
	ALIAS varchar(20) NULL,
	SQLJOINEXPR varchar(200) NULL,
	JOINTYPE char(1) ,
	TABLEID int
)
;



/****** Object:  Table LESSONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE LESSONS(
	LESSONID int  ,
	UNITID int ,
	LESSONNAME varchar(400) NULL,
	DESCRIPTION varchar(2000) NULL,
	HOURS int ,
	NLESSONINUNIT int ,
	BOOKREF varchar(2000) NULL,
	EXTRAINFO1 varchar(2000) NULL,
	EXTRAINFO2 varchar(2000) NULL,
	EXTRAINFO3 varchar(2000) NULL,
	EXTRAINFO4 varchar(2000) NULL,
	HOMEASSIGNMENT varchar(400) NULL,
	HA_ATTACHMENTID int NULL,
	DETAILS varchar(2000) NULL
)
;



/****** Object:  Table LESSONSCONTENTELEMENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE LESSONSCONTENTELEMENTS(
	LESSONID int ,
	CONTENTELEMENTID int
)
;

/****** Object:  Table LOCATIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE LOCATIONS(
	LOCATIONID int  ,
	CITYID int ,
	NAME varchar(200) ,
	ATO_TYPEID int NULL,
	KLADRCODE varchar(20) NULL
)
;



/****** Object:  Table LOGOUTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE LOGOUTS(
	SCHOOLID int ,
	ROLEID int ,
	LOGOUTTIME int
)
;

/****** Object:  Table MAILBOXES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MAILBOXES(
	BOXTYPE int ,
	BOXNAME varchar(50)
)
;



/****** Object:  Table MAILBOXESMESSAGES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MAILBOXESMESSAGES(
	MESSAGEID int ,
	READ char(1) NULL,
	USERID int ,
	BOXTYPE int ,
	NOTIFYPUSHED int NULL
)
;



/****** Object:  Table MESSAGE_ATTACHMENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MESSAGE_ATTACHMENTS(
	MESSAGEID int ,
	ATTACHMENTID int
)
;

/****** Object:  Table MESSAGES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MESSAGES(
	MESSAGEID int  ,
	SENT timestamp NULL,
	FROMID int NULL,
	SENTTO varchar(4000) NULL,
	SENTCC varchar(4000) NULL,
	LISTTO varchar(4000) NULL,
	LISTCC varchar(4000) NULL,
	SUBJECT varchar(150) NULL,
	TEXT text NULL,
	NEEDNOTIFICATION int ,
	FROMSCHOOLID int NULL,
	FROMNAME varchar(250) NULL,
	FROMUSERCLIENTID int NULL,
	FROMSYNCCLIENTID int NULL
)
;



/****** Object:  Table MOV_BOOK    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MOV_BOOK(
	DOCID int  ,
	SCHOOLYEARID int ,
	DOCTYPE int ,
	DOCDATE timestamp ,
	DOCNUMBER varchar(20) ,
	GLOBALYEARID int NULL,
	EOID int NULL,
	MBSUBTYPE int NULL
)
;



/****** Object:  Table MOV_DEBTPASS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOV_DEBTPASS(
	SUBDOCID int ,
	STUDENTID int ,
	PASSDATE timestamp
)
;

/****** Object:  Table MOV_DOCSCLASSES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MOV_DOCSCLASSES(
	DOCID int ,
	GRADEFROM int NULL,
	NAMEFROM varchar(60) NULL,
	GRADETO int NULL,
	NAMETO varchar(60) NULL
)
;



/****** Object:  Table MOV_EOS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MOV_EOS(
	EOID int  ,
	EONAME varchar(200) ,
	CITYID int ,
	EOFORMID int ,
	EOLEGALFORMID int ,
	OTRASLID int NULL,
	EOLEGALFORM83ID int NULL
)
;



/****** Object:  Table MOV_EOS_FOUNDERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOV_EOS_FOUNDERS(
	EOID int ,
	FOUNDERID int
)
;

/****** Object:  Table MOV_PERIODS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOV_PERIODS(
	PERIODID int ,
	STARTDATE timestamp ,
	ENDDATE timestamp ,
	STATUS int ,
	GLOBALYEARID int
)
;

/****** Object:  Table MOV_POOLSTUDENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOV_POOLSTUDENTS(
	DOCID int NULL,
	STUDENTID int ,
	GRADE int NULL,
	SCHOOLID int NULL,
	SYID int NULL,
	LOCKED int NULL,
	CATEGORYID int ,
	ID int
)
;

/****** Object:  Table MOV_POOLSTUDENTS_ES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MOV_POOLSTUDENTS_ES(
	STUDENTID int ,
	SCHOOLID int ,
	FROMSCHOOLID int NULL,
	CERTIFICATE varchar(50) NULL,
	AGEMONTHMIN int NULL,
	GROUPTYPEID int NULL,
	INQUIRYNUMBER varchar(50) ,
	AGEMONTHMAX int NULL,
	GRADE int NULL,
	CLASSNAME varchar(60) NULL,
	BUSY int ,
	YEARNUMBER int NULL
)
;



/****** Object:  Table MOV_POOLSTUDENTS_NA    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOV_POOLSTUDENTS_NA(
	DOCID int NULL,
	STUDENTID int ,
	REASONID int ,
	GRADE int NULL,
	SCHOOLID int NULL,
	SYID int NULL,
	CATEGORYID int ,
	ID int
)
;

/****** Object:  Table MOV_RETURNTOPOOL    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOV_RETURNTOPOOL(
	DOCID int ,
	STUDENTID int ,
	DOCID2 int NULL,
	OLDSCHOOLID int NULL,
	OLDSYID int NULL,
	CATEGORYID int
)
;

/****** Object:  Table MOV_STUDENTSLIST    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOV_STUDENTSLIST(
	DOCID int ,
	STUDENTID int ,
	REASON int NULL,
	EOID int NULL,
	NUMORDER int NULL,
	ENROLLTYPE int NULL,
	OUTSIDETYPE int NULL
)
;

/****** Object:  Table MOV_SUBDOCS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOV_SUBDOCS(
	SUBDOCID int  ,
	DOCID int ,
	CLASSID1 int NULL,
	CLASSID2 int NULL
)
;

/****** Object:  Table MOV_SUBDOCS_ESPOOL    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MOV_SUBDOCS_ESPOOL(
	STUDENTID int ,
	SUBDOCID int ,
	INQUIRYNUMBER varchar(50)
)
;



/****** Object:  Table MOVDOCS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE MOVDOCS(
	DOC_ID int ,
	MOV_DOCID int ,
	MOV_TYPEID int
)
;

/****** Object:  Table MOVE_TYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MOVE_TYPES(
	TYPEID int ,
	TYPENAME varchar(200) ,
	NOUNNAME varchar(100)
)
;



/****** Object:  Table MOVEDAYS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE MOVEDAYS(
	ID int  ,
	SCHOOLYEARID int ,
	DATEFROM timestamp ,
	DATETO timestamp ,
	DESCRIPTION varchar(2000) NULL
)
;



/****** Object:  Table NATIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE NATIONS(
	NATIONID int  ,
	NAME varchar(50) NULL
)
;



/****** Object:  Table NONCLASS_STUD_RANGES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE NONCLASS_STUD_RANGES(
	STUDENTID int ,
	GRADE int ,
	DateRangeId int ,
	Id int
)
;

/****** Object:  Table NONCLASSYEARSTUDENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE NONCLASSYEARSTUDENTS(
	SCHOOLYEARID int ,
	STUDENTID int ,
	GRADE int NULL
)
;

/****** Object:  Table OBJPARAMETERS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE OBJPARAMETERS(
	OBJPARAMETERID int  ,
	OBJECTID int ,
	PARAMETERID int ,
	SQLEXPR varchar(200) ,
	ITEMNAME varchar(30) ,
	IDNAME varchar(30) ,
	ALIAS varchar(30) ,
	PARAMSQLEXPR varchar(300) NULL,
	ISDEFAULT char(1) ,
	PARAMDISPLAYNAME varchar(100) NULL,
	RELOBJECTID int NULL,
	ISVISIBLE char(1) ,
	ISDISABLED char(1) ,
	OBJPARAMID int NULL,
	ISDEPEND char(1)
)
;



/****** Object:  Table OBJPROPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE OBJPROPS(
	PROPERTYID int  ,
	OBJECTID int ,
	NAME varchar(30) ,
	DISPLAYNAME varchar(100) NULL,
	SQLEXPR varchar(2000) NULL,
	ISPUBLIC char(1) ,
	FILTERORDER int ,
	DESCRIPTION varchar(500) NULL,
	INRESULT char(1) ,
	INGROUP char(1) ,
	INFILTER char(1) ,
	INSORT char(1) ,
	TYPEID int NULL,
	SQLEXPRGROUP varchar(200) NULL,
	SQLEXPRORDER varchar(200) NULL,
	INFUNC char(1) ,
	SQL_LIST varchar(500) NULL,
	OUTFILTER char(1)
)
;



/****** Object:  Table OBJRELATIONSHIPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE OBJRELATIONSHIPS(
	RELATIONID int  ,
	MASTERID int ,
	DETAILID int ,
	SQLWHEREEXPR varchar(1000) NULL
)
;



/****** Object:  Table OBJTABLES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE OBJTABLES(
	OBJECTID int ,
	TABLEID int ,
	TABLEORDER int
)
;

/****** Object:  Table ORGS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ORGS(
	ORGID int  ,
	ONAME varchar(200) ,
	CITYID int NULL,
	DISTRICTID int NULL
)
;



/****** Object:  Table OTPKEYS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE OTPKEYS(
	SERIALNUMBER char(12) ,
	SEED char(48) ,
	COUNTER int
)
;



/****** Object:  Table OUTSIDETYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE OUTSIDETYPES(
	OUTSIDETYPEID int  ,
	NAME varchar(50)
)
;



/****** Object:  Table PARAMTABLES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PARAMTABLES(
	OBJPARAMETERID int ,
	TABLEID int ,
	TABLEORDER int
)
;

/****** Object:  Table PARENTCITIES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PARENTCITIES(
	CITYID int ,
	PARENTCITYID int
)
;

/****** Object:  Table PARENTFOUNDERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PARENTFOUNDERS(
	FOUNDERID int ,
	PARENTFOUNDERID int
)
;

/****** Object:  Table PARENTPAY    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PARENTPAY(
	PAYID int  ,
	SCHOOLYEARID int ,
	STUDENTID int ,
	PARENTID int NULL,
	STARTMONTH timestamp ,
	NUMMONTH int ,
	OUTDEBT int NULL,
	TOPAY numeric(10, 2) ,
	PAYVAL numeric(10, 2) ,
	CONTENT numeric(10, 2) ,
	DEBT numeric(10, 2) ,
	CORRECTION numeric(10, 2) ,
	COMPENS numeric(10, 2)
)
;

/****** Object:  Table PARENTPAY_ACCESS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PARENTPAY_ACCESS(
	EMID int ,
	ACCESSMONTH int
)
;

/****** Object:  Table PARENTPAY_INIT    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PARENTPAY_INIT(
	SCHOOLYEARID int ,
	STUDENTID int ,
	DEBT numeric(10, 2)
)
;

/****** Object:  Table PARENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PARENTS(
	PARENTID int ,
	SCHOOLYEARID int
)
;

/****** Object:  Table PARENTSCHOOLDOCGROUPS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PARENTSCHOOLDOCGROUPS(
	ID int  ,
	GROUPID int ,
	PARENTGROUPID int NULL
)
;

/****** Object:  Table PARENTSUBJECTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PARENTSUBJECTS(
	PSUBJECTID int  ,
	PSUBJECTNAME varchar(50) NULL,
	SCHOOLID int ,
	ABBR varchar(50) NULL
)
;



/****** Object:  Table PASS_SUBJECTGROUPS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PASS_SUBJECTGROUPS(
	SGID int
)
;

/****** Object:  Table PAYNORMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PAYNORMS(
	NORMID int  ,
	PAYNORMID int ,
	NORMVAL numeric(6, 2) ,
	ABBREV varchar(10) ,
	COMMENT varchar(300) ,
	AVERVAL numeric(6, 2)
)
;



/****** Object:  Table PERIODTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PERIODTYPES(
	PERIODTYPEID int  ,
	NAME varchar(50) ,
	TYPEORDER int ,
	ISEXAM char(1) ,
	TITLE varchar(50) NULL,
	ABBR varchar(7) NULL
)
;



/****** Object:  Table PERSONALPORTFOLIOS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PERSONALPORTFOLIOS(
	PORTFOLIOID int ,
	USERID int
)
;

/****** Object:  Table POOL_CATEGORIES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE POOL_CATEGORIES(
	CATEGORYID int ,
	CATEGORYNAME varchar(100) ,
	REPORTNAME varchar(100) ,
	REPORTSORT int
)
;



/****** Object:  Table PORTAL_ANNOUNCE    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PORTAL_ANNOUNCE(
	ANNOUNCEMENTID int ,
	VIEWTYPE int
)
;

/****** Object:  Table PORTAL_EVENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PORTAL_EVENTS(
	EVENTID int ,
	VIEWTYPE int
)
;

/****** Object:  Table PORTFOLIOGROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PORTFOLIOGROUPS(
	GROUPID int  ,
	PORTFOLIOID int ,
	GROUPNAME varchar(100) ,
	PARENTGROUPID int NULL,
	GROUPORDER int ,
	RESPONSIBLEPERSONID int ,
	DUEDATE timestamp NULL
)
;



/****** Object:  Table PORTFOLIORESOURCES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PORTFOLIORESOURCES(
	GROUPID int ,
	RESOURCEID int  ,
	RESTYPE int ,
	RESOURCENAME varchar(200) ,
	URL varchar(2083) NULL,
	FILENAME_ORIG varchar(200) NULL,
	DESCRIPTION varchar(200) NULL,
	AFILE_GUID varchar(255) ,
	AFILE varchar(255)  NULL
);



/****** Object:  Table PORTFOLIORIGHTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PORTFOLIORIGHTS(
	PORTFOLIOID int ,
	USERID int ,
	ACCESSTYPE int
)
;

/****** Object:  Table PORTFOLIOS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PORTFOLIOS(
	PORTFOLIOID int  ,
	PORTFOLIOTYPE int ,
	NAME varchar(200) NULL
)
;



/****** Object:  Table POSSTATUSES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE POSSTATUSES(
	POSSTATUSID int ,
	STATUSNAME varchar(200) ,
	SHORTNAME varchar(30)
)
;



/****** Object:  Table PRECLASSES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PRECLASSES(
	CLASSID int ,
	PROGRAMID int ,
	PRETYPEID int ,
	AGEID int ,
	STAYID int ,
	CORPUS varchar(100) ,
	AREA numeric(10, 2) ,
	CAPACITY int ,
	CAPACITY_OVZ int ,
	AGECATEGORYID int NULL,
	NOINFORMIKA char(1) ,
	SEATSFORTRANSFER int ,
	SUBGROUPSCOUNT int
)
;



/****** Object:  Table PROG_DIRECTIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PROG_DIRECTIONS(
	DIRECTIONID int ,
	DIRECTIONNAME varchar(50) ,
	OLDDIR int ,
	SORTORDER int NULL
)
;



/****** Object:  Table PROGRAM_LIMITS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PROGRAM_LIMITS(
	PROGRAMID int ,
	SCHOOLYEARID int ,
	GRADE int ,
	YEARHOURS numeric(10, 2) ,
	WEEKHOURS numeric(10, 2)
)
;

/****** Object:  Table PROJECTMEMBERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PROJECTMEMBERS(
	PORTFOLIOID int ,
	USERID int ,
	GROUPID int
)
;

/****** Object:  Table PROJECTPORTFOLIOLEADERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PROJECTPORTFOLIOLEADERS(
	PORTFOLIOID int ,
	USERID int
)
;

/****** Object:  Table PROJECTPORTFOLIORIGHTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE PROJECTPORTFOLIORIGHTS(
	PORTFOLIOID int ,
	USERID int ,
	GROUPID int ,
	ACCESSTYPE int
)
;

/****** Object:  Table PROPERTYTYPES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PROPERTYTYPES(
	TYPEID int  ,
	TYPENAME varchar(15) ,
	CODE char(1) ,
	DESCRIPTION varchar(100) NULL
)
;



/****** Object:  Table PROVINCES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE PROVINCES(
	PROVINCEID int  ,
	STATEID int ,
	PROVINCENAME varchar(200) NULL,
	KLADRCODE varchar(20) NULL
)
;



/****** Object:  Table QUERIES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE QUERIES(
	QUERYID int  ,
	DISPLAYNAME varchar(100) NULL,
	SQLDEFINED char(1) NULL,
	BUILDSTATUS int ,
	EDITORID int ,
	SQLQUERY text NULL,
	ISDISTINCT char(1) ,
	ISGROUPEDREPORT char(1) NULL
)
;



/****** Object:  Table QUERYFIELDS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE QUERYFIELDS(
	FIELDID int  ,
	QUERYID int ,
	DISPLAYNAME varchar(100) NULL,
	PROPERTYID int NULL,
	ISEXPR char(1) ,
	FIELDORDER int ,
	EXPRESSIONID int NULL,
	QUERYOBJID int NULL
)
;



/****** Object:  Table QUERYOBJECTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE QUERYOBJECTS(
	QUERYOBJECTID int  ,
	QUERYID int ,
	MASTEROBJECTID int NULL,
	OBJORDER int ,
	OBJECTID int ,
	ISLEFT char(1)
)
;



/****** Object:  Table QUERYPARAMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE QUERYPARAMS(
	PARAMID int  ,
	QUERYID int ,
	OBJPARAMETERID int NULL,
	PARAMORDER int ,
	SQLPARAMEXPR varchar(8000) NULL,
	QUERYOBJID int
)
;



/****** Object:  Table QUEUEDTASKS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE QUEUEDTASKS(
	ID int  ,
	TASKTYPE nchar(1) ,
	ENQUEUEDATE timestamp ,
	STARTDATE timestamp NULL,
	ENDDATE timestamp NULL,
	JSONDATA text ,
	STATUS varchar(255) NULL,
	USERID int ,
	SCHOOLID int ,
	DOCDATE timestamp NULL,
	DOCNUMBER varchar(20) NULL,
	FILENAME varchar(255) NULL,
	STUDCNT int NULL
)
;

/****** Object:  Table REFINFO_ID    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE REFINFO_ID(
	ID int NULL
)
;

/****** Object:  Table RELTABLES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE RELTABLES(
	RELATIONID int ,
	TABLEID int ,
	TABLEORDER int ,
	ISCOMMON char(1)
)
;



/****** Object:  Table REPORTGROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE REPORTGROUPS(
	GROUPID int  ,
	GROUPNAME varchar(100) ,
	SCHOOLID int NULL,
	EMID int NULL
)
;



/****** Object:  Table REPORTQUERIES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE REPORTQUERIES(
	REPORTID int ,
	QUERYID int
)
;

/****** Object:  Table REPORTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE REPORTS(
	REPORTID int  ,
	DISPLAYNAME varchar(500) ,
	REPTYPE char(1) ,
	DESCRIPTION varchar(1000) NULL,
	INEDIT char(1) NULL,
	ISPUBLISHED char(1) NULL,
	SCHOOLID int NULL,
	GROUPID int NULL,
	EMID int NULL,
	FUNCTYPE int NULL
)
;



/****** Object:  Table REPPARAMETERS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE REPPARAMETERS(
	PARAMETERID int  ,
	NAME varchar(30) ,
	DISPLAYNAME varchar(50) NULL,
	PARAMTYPE char(1) ,
	PARAMDISPTYPE char(1)
)
;



/****** Object:  Table RESULTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE RESULTS(
	STUDENTID int ,
	ASSIGNMENTID int ,
	RESULT float NULL,
	DONEDATE timestamp NULL
)
;

/****** Object:  Table RESULTS_MONITORING    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE RESULTS_MONITORING(
	STUDENTID int ,
	ASSIGNMENTID int ,
	RESULT float NULL,
	DONEDATE timestamp NULL
)
;

/****** Object:  Table RESULTSCALC    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE RESULTSCALC(
	STUDENTID int ,
	TERMID int ,
	RESULT float NULL,
	CLASSID int ,
	SGID int ,
	RESULTCOUNT int
)
;

/****** Object:  Table RESULTSDETAILS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE RESULTSDETAILS(
	STUDENTID int ,
	ASSIGNMENTID int ,
	DETAILS bytea NULL
)
;

/****** Object:  Table REVISIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE REVISIONS(
	id int ,
	Note varchar(250)
)
;



/****** Object:  Table REVISIONSECTIONS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE REVISIONSECTIONS(
	SectionID int ,
	RevID int ,
	id int
)
;

/****** Object:  Table REVISIONSYEARS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE REVISIONSYEARS(
	yearID int ,
	RevID int ,
	id int
)
;

/****** Object:  Table RIGHTADDPARAMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE RIGHTADDPARAMS(
	RIGHTID int ,
	SCHOOLID int ,
	PARAMNAME varchar(20) ,
	VALUE int
)
;



/****** Object:  Table RIGHTS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE RIGHTS(
	RIGHTID int ,
	RIGHTNAME varchar(100)
)
;



/****** Object:  Table ROLES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ROLES(
	ROLEID int ,
	ROLENAME varchar(30) ,
	SHORTNAME varchar(5)
)
;



/****** Object:  Table ROLESRIGHTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE ROLESRIGHTS(
	ROLEID int ,
	RIGHTID int ,
	SCHOOLID int
)
;

/****** Object:  Table ROOMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE ROOMS(
	ROOMID int  ,
	SCHOOLID int ,
	ROOMNAME varchar(50) ,
	FLOOR int NULL,
	SEATS int NULL,
	STUDY int ,
	LENGTH float NULL,
	WIDTH float NULL,
	AREA numeric(10, 2) NULL
)
;



/****** Object:  Table ROOMSSUBJECTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE ROOMSSUBJECTS(
	ROOMID int ,
	SUBJECTID int
)
;

/****** Object:  Table ROOMSTEACHERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE ROOMSTEACHERS(
	ROOMID int ,
	TEACHERID int
)
;

/****** Object:  Table SCHEDULE_RELAYS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHEDULE_RELAYS(
	RELAY int
)
;

/****** Object:  Table SCHEDULETEMPLATE    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHEDULETEMPLATE(
	CSG_ID int ,
	WEEKID int ,
	WDAY int ,
	SCHEDULETIMEID int ,
	ROOMID int NULL,
	FIX int NULL
)
;

/****** Object:  Table SCHEDULETIMES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHEDULETIMES(
	SCHEDULETIMEID int  ,
	STARTTIME timestamp NULL,
	ENDTIME timestamp NULL,
	RELAY int NULL,
	SCHOOLYEARID int ,
	SCHEDULETIMENUMBER int NULL,
	WEEKDAYNUM int ,
	VARIANTID int
)
;

/****** Object:  Table SCHOOLCALENDAR    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLCALENDAR(
	EVENTID int ,
	SCHOOLYEARID int ,
	ROOMID int NULL
)
;

/****** Object:  Table SCHOOLDEPARTMENTS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLDEPARTMENTS(
	SCHOOLID int ,
	MAINSCHOOLID int ,
	ISBRANCH  int
)
;

/****** Object:  Table SCHOOLDOCGROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLDOCGROUPS(
	GROUPID int  ,
	SCHOOLID int NULL,
	GROUPNAME varchar(100) ,
	NUM int ,
	IS_PUBLIC int NULL,
	SERVICE_NUM int NULL
)
;



/****** Object:  Table SCHOOLDOCS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLDOCS(
	SCHOOLDOCID int  ,
	GROUPID int ,
	FILENAME_ORIG varchar(200) ,
	DOCNAME varchar(200) ,
	DESCRIPTION varchar(2000) NULL,
	AUTHORID int NULL,
	DOCDATE timestamp ,
	AFILE_GUID varchar(255) ,
	AFILE varchar(255)  NULL
)
;



/****** Object:  Table SCHOOLINFO    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLINFO(
	PARAMID int ,
	INFO varchar(1000) NULL,
	SCHOOLID int
)
;



/****** Object:  Table SCHOOLINFOPARAMS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLINFOPARAMS(
	PARAMID int ,
	NAME varchar(200) ,
	PTYPE varchar(20) ,
	cellOrder int ,
	PageNum int
)
;



/****** Object:  Table SCHOOLINFORMATION    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLINFORMATION(
	SCHOOLID int ,
	STATUSORGANIZATION int ,
	FOUNDINGDATE timestamp NULL,
	NOCONTINGENT  int
)
;

/****** Object:  Table SCHOOLPARAMETERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLPARAMETERS(
	PARAMETERID int
)
;

/****** Object:  Table SCHOOLREADONLYACCESS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLREADONLYACCESS(
	schoolid int NULL
)
;

/****** Object:  Table SCHOOLRESOURCEGROUPS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLRESOURCEGROUPS(
	GROUPID int  ,
	SCHOOLID int ,
	GROUPNAME varchar(100) ,
	PARENTGROUPID int NULL,
	NUM int
)
;



/****** Object:  Table SCHOOLRESOURCES    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLRESOURCES(
	GROUPID int ,
	RESOURCEID int  ,
	URL varchar(2083) NULL,
	RESOURCENAME varchar(200) NULL
)
;



/****** Object:  Table SCHOOLS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLS(
	SCHOOLID int  ,
	SCHOOLNAME varchar(400) ,
	DATEFORMAT varchar(50) NULL,
	TIMEOFFSET varchar(10) NULL,
	CITYID int ,
	DISTRICTID int NULL,
	EOID int NULL,
	SERVERID varchar(50) NULL,
	UNISCHOOLID varchar(50) NULL,
	SCHOOLCODE varchar(6) NULL,
	FUNCTYPEID int ,
	SCHOOLNUMBER varchar(200) ,
	EMID int NULL,
	MSK_SCHOOLID varchar(50) NULL
)
;



/****** Object:  Table SCHOOLSETTINGS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLSETTINGS(
	SCHOOLYEARID int ,
	PARAMETERID int ,
	PARAMETERVALUE varchar(50)
)
;



/****** Object:  Table SCHOOLSTERMTYPES    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLSTERMTYPES(
	SCHOOLYEARID int ,
	PROFILEID int ,
	TERMTYPEID int ,
	GRADESET int
)
;

/****** Object:  Table SCHOOLSUSERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLSUSERS(
	SCHOOLID int ,
	USERID int
)
;

/****** Object:  Table SCHOOLWIZARD    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLWIZARD(
	SCHOOLID int ,
	STEPID int
)
;

/****** Object:  Table SCHOOLYEARS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SCHOOLYEARS(
	SCHOOLYEARID int  ,
	SCHOOLID int ,
	SCHOOLYEARNAME varchar(50) ,
	CLOSED char(1) NULL,
	STARTDATE timestamp ,
	ENDDATE timestamp ,
	OSHCLOSED char(1) NULL,
	WEEKENDSET int ,
	OSH5CLOSED char(1) ,
	OSH9CLOSED char(1) ,
	ARCHIVESTATUS int ,
	ARCHIVEDATE timestamp NULL,
	GLOBALYEARID int
)
;



/****** Object:  Table SCHOOLYEARSINDICATORSVALS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLYEARSINDICATORSVALS(
	SCHOOLYEARID int ,
	INDICATORID int ,
	VALUE int
)
;

/****** Object:  Table SCHOOLYEARSUSERS    Script Date: 30.03.2017 14:21:50 ******/




CREATE TABLE SCHOOLYEARSUSERS(
	SCHOOLYEARID int ,
	USERID int
)
;

/****** Object:  Table SECTIONS    Script Date: 30.03.2017 14:21:50 ******/






CREATE TABLE SECTIONS(
	id int  ,
	FORMID int ,
	PageNum int ,
	SectionNum int ,
	SectionPoint varchar(10) NULL,
	Title varchar(250)
)
;



/****** Object:  Table SENIORITIES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SENIORITIES(
	SENID int  ,
	USERID int ,
	SENTYPE int ,
	STARTDATE timestamp ,
	ENDDATE timestamp NULL
)
;

/****** Object:  Table SENIORITY_TYPES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SENIORITY_TYPES(
	TYPEID int ,
	TYPENAME varchar(100) ,
	TYPEABBR varchar(50)
)
;



/****** Object:  Table SERVERSETTINGS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SERVERSETTINGS(
	PARAMETERID int ,
	PARAMETERVALUE varchar(100)
)
;



/****** Object:  Table SETTLEMENTTYPES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SETTLEMENTTYPES(
	SETTLEMENTTYPEID int ,
	SETTLEMENTTYPENAME varchar(100) NULL
)
;



/****** Object:  Table SG_ACCESSJOURNAL    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SG_ACCESSJOURNAL(
	ID int ,
	ACCESSTYPE int ,
	SCHOOLID int NULL
)
;

/****** Object:  Table SG_ACCESSJOURNAL_DETAILS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SG_ACCESSJOURNAL_DETAILS(
	ID int  ,
	ENTRYID int ,
	SGID int ,
	CMID int NULL,
	TERMID int NULL
)
;

/****** Object:  Table SMSEVENTS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SMSEVENTS(
	EVENTID int  ,
	SCHOOLID int ,
	USERID int ,
	SMSTIME timestamp ,
	EVENTTYPEID int ,
	STATUS int ,
	MOBILE varchar(20)
)
;



/****** Object:  Table SMSEVENTTYPES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SMSEVENTTYPES(
	EVENTTYPEID int ,
	TYPENAME varchar(50)
)
;



/****** Object:  Table SMSREGISTRY    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SMSREGISTRY(
	REGID int  ,
	SCHOOLID int ,
	REGDATA varchar(100) ,
	REGTYPE int ,
	RESULT int ,
	REGTIME timestamp NULL
)
;



/****** Object:  Table SORTORDERS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SORTORDERS(
	SORTORDERID int  ,
	QUERYID int NULL,
	DIRECTION varchar(20) NULL,
	PROPERTYID int NULL,
	SORTORDER int ,
	QUERYOBJID int
)
;



/****** Object:  Table ST_CLASSES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE ST_CLASSES(
	VARIANTID int ,
	CLASSID int
)
;

/****** Object:  Table ST_GRADES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE ST_GRADES(
	VARIANTID int ,
	GRADE int
)
;

/****** Object:  Table ST_IUPGRADES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE ST_IUPGRADES(
	VARIANTID int ,
	GRADE int
)
;

/****** Object:  Table ST_VARIANTS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE ST_VARIANTS(
	VARIANTID int  ,
	SCHOOLYEARID int ,
	VARIANTNAME varchar(100) ,
	SCHOOLVARIANT  int
)
;



/****** Object:  Table STAFFINFO    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STAFFINFO(
	USERID int ,
	SCHOOLYEARID int
)
;

/****** Object:  Table STAFFROLES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE STAFFROLES(
	ROLEID int ,
	ABBREV varchar(1) NULL
)
;



/****** Object:  Table STATES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE STATES(
	STATE_PROVINCEID int  ,
	STATEID char(2) NULL,
	COUNTRYID int ,
	STATEPROVINCENAME varchar(50) ,
	KLADRCODE varchar(20) NULL
)
;



/****** Object:  Table STATFORMS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE STATFORMS(
	FORMID int ,
	NAME varchar(250) ,
	Num int
)
;



/****** Object:  Table STAYREGIMES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE STAYREGIMES(
	STAYID int ,
	STAYNAME varchar(100)
)
;



/****** Object:  Table STUDENTAWARDS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTAWARDS(
	STUDENTID int ,
	SCHOOLYEARID int ,
	AWARDTYPE int
)
;

/****** Object:  Table STUDENTCREATIVES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTCREATIVES(
	STUDENTID int ,
	SCHOOLYEARID int ,
	EOID int ,
	TYPEID int
)
;

/****** Object:  Table STUDENTINFO    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE STUDENTINFO(
	STUDENTID int ,
	SGID int ,
	PARAMETERID int ,
	VALUE varchar(2000) NULL
)
;



/****** Object:  Table STUDENTPARAMETERS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTPARAMETERS(
	PARAMETERID int
)
;

/****** Object:  Table STUDENTS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTS(
	STUDENTID int ,
	LANG_ID int NULL,
	LANG_ID2 int NULL,
	NUMORDER int NULL
)
;

/****** Object:  Table STUDENTS_in_PERIOD    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE STUDENTS_in_PERIOD(
	STUDENTID int NULL,
	SGID int NULL,
	CLASSID int NULL,
	SCHOOLYEARID int NULL,
	GLOBALYEARID int NULL,
	SCHOOLID int NULL,
	PERIODID int NULL,
	PERIODNAME varchar(50) NULL
)
;



/****** Object:  Table STUDENTS_LASTINFORMS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTS_LASTINFORMS(
	SCHOOLYEARID int ,
	STUDENTID int ,
	LASTINFORMDATE timestamp
)
;

/****** Object:  Table STUDENTS_TERMS_GROUPS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTS_TERMS_GROUPS(
	STUDENTID int ,
	TERMID int ,
	SGID int
)
;

/****** Object:  Table STUDENTSCLASSES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTSCLASSES(
	STUDENTID int ,
	CLASSID int ,
	TERMID int
)
;

/****** Object:  Table STUDENTSGROUPS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTSGROUPS(
	STUDENTID int ,
	CLASSSUBJECTGROUPID int
)
;

/****** Object:  Table STUDENTSPARENTS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE STUDENTSPARENTS(
	STUDENTID int ,
	PARENTID int
)
;

/****** Object:  Table SUBJECTFIELDS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SUBJECTFIELDS(
	FIELDID int  ,
	FIELDNAME varchar(50) NULL,
	NUMORDER int NULL
)
;



/****** Object:  Table SUBJECTGROUPINFO    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SUBJECTGROUPINFO(
	SGID int ,
	PARAMETERID int ,
	VALUE varchar(2000) NULL
)
;



/****** Object:  Table SUBJECTGROUPS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SUBJECTGROUPS(
	ID int  ,
	NAME varchar(200) NULL,
	TEACHERID int ,
	COMMENTS varchar(2000) NULL,
	SUBJECTID int ,
	PASS int ,
	IUP_LEVEL int NULL
)
;



/****** Object:  Table SUBJECTGROUPSGRADES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SUBJECTGROUPSGRADES(
	SGID int ,
	SCHOOLYEARID int ,
	GRADE int
)
;

/****** Object:  Table SUBJECTGROUPSSUBJECTPLANS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SUBJECTGROUPSSUBJECTPLANS(
	SGID int ,
	PLANID int
)
;

/****** Object:  Table SUBJECTGROUPSTEACHERS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SUBJECTGROUPSTEACHERS(
	SGID int ,
	TEACHERID int
)
;

/****** Object:  Table SUBJECTGROUPSTERMS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SUBJECTGROUPSTERMS(
	SGID int ,
	TERMID int
)
;

/****** Object:  Table SUBJECTPLAN_ATTACHMENTS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SUBJECTPLAN_ATTACHMENTS(
	PLANID int ,
	ATTACHMENTID int
)
;

/****** Object:  Table SUBJECTPLANS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SUBJECTPLANS(
	PLANID int  ,
	SCHOOLYEARID int ,
	GRADE int ,
	SUBJECTID int ,
	VARIANTID int ,
	BOOKREF varchar(2500) NULL,
	MATERIALS varchar(2000) NULL,
	AUTHORID int NULL
)
;



/****** Object:  Table SUBJECTPLANVARIANTS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SUBJECTPLANVARIANTS(
	VARIANTID int  ,
	VARIANTNAME varchar(100)

)
;



/****** Object:  Table SUBJECTS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE SUBJECTS(
	SUBJECTID int  ,
	FIELDID int NULL,
	SUBJECTNAME varchar(100) NULL,
	SUBJECTABBREV varchar(70) ,
	SCHOOLID int ,
	PARENTSUBJECTID int NULL,
	GLOBALSUBJID int ,
	SUBJORDER int NULL
)
;



/****** Object:  Table SUPPORTEDTYPES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE SUPPORTEDTYPES(
	TYPEID int ,
	FUNCTIONID int
)
;

/****** Object:  Table TABLES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE TABLES(
	TABLEID int  ,
	TABLENAME varchar(30) ,
	SQLTYPE char(1) ,
	SQLPROCPARAMS varchar(100) NULL,
	DESCRIPTION varchar(500) NULL,
	ALIAS varchar(5) NULL
)
;



/****** Object:  Table TEACHERSCLASSES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE TEACHERSCLASSES(
	TEACHERID int ,
	CLASSID int
)
;

/****** Object:  Table TEACHERSSUBJECTS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE TEACHERSSUBJECTS(
	TEACHERID int ,
	SUBJECTID int
)
;

/****** Object:  Table TERMS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE TERMS(
	TERMID int  ,
	SCHOOLYEARID int ,
	TERMNAME varchar(50) ,
	STARTDATE timestamp ,
	ENDDATE timestamp ,
	TERMTYPEID int
)
;



/****** Object:  Table TERMTYPES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE TERMTYPES(
	TERMTYPEID int  ,
	TERMTYPENAME varchar(30) ,
	TERMSCOUNT int ,
	ENABLED char(1)
)
;



/****** Object:  Table TESTPLANS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE TESTPLANS(
	TESTPLANID int  ,
	TESTLEVEL int ,
	USERID int NULL
)
;

/****** Object:  Table TESTTASKRESULTS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE TESTTASKRESULTS(
	TASKID int ,
	STUDENTID int ,
	SCORE int
)
;

/****** Object:  Table TESTTASKS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE TESTTASKS(
	TASKID int  ,
	NUMBER int ,
	POSSIBLEPOINTS int ,
	DIFFICULT int ,
	TESTPLANID int ,
	ADDITIONAL varchar(200) NULL,
	MISTAKETYPE int NULL
)
;



/****** Object:  Table TESTTASKSCONTENTELEMENTS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE TESTTASKSCONTENTELEMENTS(
	TASKID int ,
	CONTENTELEMENTID int
)
;

/****** Object:  Table TOTALS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE TOTALS(
	SGID int ,
	STUDENTID int ,
	PERIODID int ,
	MARK int NULL
)
;

/****** Object:  Table UNITS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE UNITS(
	UNITID int  ,
	PLANID int ,
	UNITNAME varchar(200) ,
	DESCRIPTION varchar(2000) NULL,
	NUNITINPLAN int
)
;



/****** Object:  Table USERDOCS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE USERDOCS(
	USERID int ,
	DOC_ID int ,
	NUMORDER int NULL,
	INFOID int NULL,
	ORGID int NULL
)
;

/****** Object:  Table USEREVENTS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USEREVENTS(
	EVENTID int  ,
	TYPEID int ,
	SCHOOLID int NULL,
	USERID int NULL,
	EVENTTIME timestamp ,
	REMOTEADDR varchar(30) NULL,
	DETAILS1 int NULL,
	DETAILS2 varchar(2000) NULL
)
;



/****** Object:  Table USEREVENTTYPES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE USEREVENTTYPES(
	TYPEID int
)
;

/****** Object:  Table USERINFO_ACCESSJOURNAL    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE USERINFO_ACCESSJOURNAL(
	ID int ,
	EDITUSERID int
)
;

/****** Object:  Table USERINFOFIELD_ACCESSJOURNAL    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERINFOFIELD_ACCESSJOURNAL(
	ID int  ,
	ENTRYID int ,
	ACCESSTO varchar(255) ,
	FIELDID int NULL,
	PARAMETERID int NULL,
	FIELDVALUE varchar(4000) NULL
)
;



/****** Object:  Table USERINFOLISTITEMS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERINFOLISTITEMS(
	ITEMID int  ,
	PARAMETERID int ,
	SCHOOLID int NULL,
	ITEMNAME varchar(200) ,
	ITEMNAME2 varchar(200) ,
	ITEMNAME3 varchar(200) ,
	ITEMORDERNO int NULL
)
;



/****** Object:  Table USERINFOPARAMETERS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERINFOPARAMETERS(
	PARAMETERID int ,
	SCHOOLID int NULL,
	ROLETYPE int ,
	ORDERNO int ,
	NAME varchar(20) ,
	TITLE varchar(200) ,
	PARAMTYPE char(1) ,
	EXTRAINFO int NULL,
	SYDEPEND char(1) ,
	EDITABLE char(1) ,
	DEFAULTVALUE varchar(2000) NULL,
	GROUPID int NULL
)
;



/****** Object:  Table USERLOGINEVENTS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERLOGINEVENTS(
	EVENTID int  ,
	SCHOOLID int NULL,
	USERID int ,
	LOGINTIME timestamp ,
	LOGOUTTIME timestamp NULL,
	REMOTEADDR varchar(30) NULL,
	EXTRAINFO varchar(200) NULL,
	IDP int NULL
)
;



/****** Object:  Table USERS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERS(
	USERID int  ,
	LOGINNAME varchar(35) ,
	PASSWORD varchar(32) ,
	WINACCOUNT varchar(50) NULL,
	FIRSTNAME varchar(30) ,
	MIDDLENAME varchar(30) ,
	LASTNAME varchar(30) ,
	NICKNAME varchar(95) ,
	EMAIL varchar(80) NULL,
	PREFFEREDCM char(1) NULL,
	GENDER char(1) ,
	BIRTHDATE timestamp NULL,
	HOMEPHONE varchar(30) NULL,
	NATIONID int NULL,
	PASS_SER varchar(10) NULL,
	PASS_NUM varchar(20) NULL,
	PASS_DATE timestamp NULL,
	PASS_INFO varchar(200) NULL,
	LOGINTYPE int ,
	SERIALNUMBER char(12) NULL,
	MSK_USERID varchar(50) NULL,
	THUMBPRINT varchar(60) NULL
)
;



/****** Object:  Table USERS_IDENTITES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE USERS_IDENTITES(
	USERID int ,
	IDP_ID varchar(50) ,
	IDP int
)
;

/****** Object:  Table USERSADDRESS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERSADDRESS(
	USERID int ,
	ADDRESSID int ,
	STATUS varchar(1)
)
;



/****** Object:  Table USERSECARD    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERSECARD(
	USERID int ,
	ECARDID varchar(50)
)
;



/****** Object:  Table USERSETTINGS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERSETTINGS(
	USERID int ,
	PWDEXPIRED int NULL,
	THEME int NULL,
	SWMPHONE int NULL,
	LANGUAGE varchar(2) ,
	DEFDESKTOP int NULL,
	RECOVERYANSWER varchar(100) ,
	RECOVERYQUESTION varchar(100)
)
;



/****** Object:  Table USERSPARAMETERS    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERSPARAMETERS(
	USERID int ,
	PARAMETERID int ,
	SCHOOLYEARID int NULL,
	PARAMVALUE varchar(4000) NULL,
	PARAMVALUE_DT timestamp NULL,
	PARAMVALUE_ID int NULL,
	UPID int
)
;



/****** Object:  Table USERSPARAMS_COPY_DEFAULT    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERSPARAMS_COPY_DEFAULT(
	PARAMETERID int ,
	FUNCTYPEID int ,
	ROLETYPE int ,
	NAME varchar(20) ,
	COPY int ,
	HASDEFAULT int ,
	PARAMVALUE varchar(4000) NULL,
	PARAMVALUE_DT timestamp NULL,
	PARAMVALUE_ID int NULL
)
;



/****** Object:  Table USERSPHOTO    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE USERSPHOTO(
	USERID int ,
	FILE_NAME varchar(255) ,
	AFILE_GUID varchar(255) ,
	AFILE varchar(255)  NULL
)
;



/****** Object:  Table USERSROLES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE USERSROLES(
	USERID int ,
	ROLEID int ,
	SCHOOLID int
)
;

/****** Object:  Table VACATIONS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE VACATIONS(
	EVENTID int ,
	SCHOOLYEARID int
)
;

/****** Object:  Table VACATIONS_GRADES    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE VACATIONS_GRADES(
	SCHOOLYEARID int ,
	VACATIONID int ,
	GRADE int 
)
;

/****** Object:  Table VERSN    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE VERSN(
	STR varchar(20) ,
	ID int NULL,
	FL varchar(200) NULL,
	PRODUCT varchar(10) NULL,
	REV int NULL
)
;



/****** Object:  Table YEAR_FORMPARAM    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE YEAR_FORMPARAM(
	PARAMID int ,
	SCHOOLYEARID int ,
	PVALUE varchar(250) ,
	MNS  int
)
;



/****** Object:  Table YEARTOTALS    Script Date: 30.03.2017 14:21:51 ******/




CREATE TABLE YEARTOTALS(
	SGID int ,
	STUDENTID int ,
	PERIODTYPEID int ,
	SCHOOLYEARID int ,
	MARK int NULL
)
;

/****** Object:  Table ZIPCODES    Script Date: 30.03.2017 14:21:51 ******/






CREATE TABLE ZIPCODES(
	ZIPCODE varchar(10) ,
	LOCATIONID int ,
	HOUSE varchar(200)
);


CREATE TABLE SG_ST_VARIANTS (SCHOOLYEARID VARCHAR(255),SGID VARCHAR(255),GRADE VARCHAR(255),CLASSID VARCHAR(255),ICL_CLASSID VARCHAR(255),IS_IUP VARCHAR(255),VARIANTID VARCHAR(255),USE_LEVEL VARCHAR(255));
CREATE TABLE GETPOSTYPES (POSTYPE VARCHAR(255));
CREATE TABLE GETCOMMONSCHOOLTERMS (COMMONTERMID VARCHAR(255),TERMID VARCHAR(255),SCHOOLYEARID VARCHAR(255),TERMTYPEID VARCHAR(255),STARTDATE VARCHAR(255),ENDDATE VARCHAR(255),TERMNAME VARCHAR(255));
CREATE TABLE SGGHOURS (id VARCHAR(255),subjectid VARCHAR(255),schoolyearid VARCHAR(255),TERMID VARCHAR(255),hours VARCHAR(255),cnt VARCHAR(255));
CREATE TABLE YEAR_TEACHER_SUBJ (abbr VARCHAR(255),subjName VARCHAR(255),teacherid VARCHAR(255),schoolyearid VARCHAR(255),sgid VARCHAR(255),cb VARCHAR(255));
CREATE TABLE SG_GRADES (SCHOOLYEARID VARCHAR(255),id VARCHAR(255),NAME VARCHAR(255),TEACHERID VARCHAR(255),SUBJECTID VARCHAR(255),PASS VARCHAR(255),IUP_LEVEL VARCHAR(255),COMMENTS VARCHAR(255),grades VARCHAR(255),gradeID VARCHAR(255),isIUP VARCHAR(255),CLASSNAME VARCHAR(255));
CREATE TABLE SG_CLASSES_TERMS (SGID VARCHAR(255),CLASSID VARCHAR(255),ICL_CLASSID VARCHAR(255),TERMID VARCHAR(255));
CREATE TABLE STUDENTS_EDUC_RANGES (STUDENTID VARCHAR(255),SCHOOLID VARCHAR(255),PROGID VARCHAR(255),DOCID VARCHAR(255),SUBDOCID VARCHAR(255),DATE_FROM VARCHAR(255),DATE_TO VARCHAR(255));
CREATE TABLE USERPARAMVALUES (USERID VARCHAR(255),SCHOOLYEARID VARCHAR(255),PARAMETERID VARCHAR(255),PARAMVALUE VARCHAR(255),hb VARCHAR(255));
CREATE TABLE GETSTAFFINFO (userid VARCHAR(255),schoolyearid VARCHAR(255),hours VARCHAR(255),cb VARCHAR(255));
CREATE TABLE GET_CURICULUM_BY_SUBJGROUPS (GRADEID VARCHAR(255),SUBJECTID VARCHAR(255),SCHOOLYEARID VARCHAR(255),COMPONENTID VARCHAR(255),PROFILEID VARCHAR(255),HOURS VARCHAR(255),CLASSID VARCHAR(255),FIELDID VARCHAR(255),PARENTSUBJECTID VARCHAR(255),SUBJECTNAME VARCHAR(255));
CREATE TABLE GET_MOV_EOS_DOU_EX (EOID VARCHAR(255),EONAME VARCHAR(255),CITYID VARCHAR(255),EOFORMID VARCHAR(255),EOLEGALFORMID VARCHAR(255),OTRASLID VARCHAR(255));
CREATE TABLE GET_STUDENTSCLASSES (STUDENTID VARCHAR(255),CLASSID VARCHAR(255),SCHOOLYEARID VARCHAR(255),SCHOOLID VARCHAR(255));
CREATE TABLE CLS_ST_VARIANTS (SCHOOLYEARID VARCHAR(255),GRADE VARCHAR(255),CLASSID VARCHAR(255),IS_IUP VARCHAR(255),VARIANTID VARCHAR(255),USE_LEVEL VARCHAR(255));
CREATE TABLE STUDENTS_YEARS_CATEGORIES_2 (STUDENTID VARCHAR(255),GLOBALYEARID VARCHAR(255),CATEGORYID VARCHAR(255),SCHOOLID VARCHAR(255),SCHOOLYEARID VARCHAR(255),SCHOOLNAME VARCHAR(255),SCHOOLSHORTNAME VARCHAR(255),CLASSID VARCHAR(255));
CREATE TABLE STUDENTS_YEARS_CATEGORIES (STUDENTID VARCHAR(255),GLOBALYEARID VARCHAR(255),SCHOOLID VARCHAR(255),SCHOOLYEARID VARCHAR(255),CLASSID VARCHAR(255),CATEGORYID VARCHAR(255));
CREATE TABLE INDICATORS_RELATIONS_ALL (ROOT_GROUPINDICATORID VARCHAR(255),INDICATORID VARCHAR(255),GROUPINDICATORID VARCHAR(255),depth VARCHAR(255));
CREATE TABLE GET_SY_CLASSESGRADES (SCHOOLYEARID VARCHAR(255),GRADE VARCHAR(255),CLASSID VARCHAR(255),CLASSNAME VARCHAR(255),TYPEID VARCHAR(255),STEP VARCHAR(255));
CREATE TABLE SG_TEACHERS (sgid VARCHAR(255),teacherid VARCHAR(255));
CREATE TABLE SG_ST_VARIANTS_UNION (SGID VARCHAR(255),CLASSID VARCHAR(255),ICL_CLASSID VARCHAR(255),SCHOOLYEARID VARCHAR(255),GRADE VARCHAR(255),IS_IUP VARCHAR(255),VARIANTID VARCHAR(255),USE_LEVEL VARCHAR(255));
CREATE TABLE CSGHOURS (id VARCHAR(255),subjectid VARCHAR(255),schoolyearid VARCHAR(255),TERMID VARCHAR(255),hours VARCHAR(255),cnt VARCHAR(255));
CREATE TABLE GETYEARTOTALS (SGID VARCHAR(255),STUDENTID VARCHAR(255),SCHOOLYEARID VARCHAR(255),YEARMARK VARCHAR(255),EXAMMARK VARCHAR(255),TOTALMARK VARCHAR(255),VERBALEXAMMARK VARCHAR(255),WRITTENEXAMMARK VARCHAR(255),EGEEXAMMARK VARCHAR(255));
CREATE TABLE STUDENTSRANGES (STUDENTID VARCHAR(255),CLASSID VARCHAR(255),GRADE VARCHAR(255),ID VARCHAR(255),SCHOOLYEARID VARCHAR(255),ENROLL VARCHAR(255),DEPART VARCHAR(255));
CREATE TABLE ST_IUPGRADES_VARIANTS (SCHOOLYEARID VARCHAR(255),GRADE VARCHAR(255),VARIANTID VARCHAR(255));
CREATE TABLE SYSDIAGRAMS (name VARCHAR(255),principal_id VARCHAR(255),diagram_id VARCHAR(255),version VARCHAR(255),definition VARCHAR(255));
CREATE TABLE EM_PROVINCES (EMID VARCHAR(255),PROVINCEID VARCHAR(255));
CREATE TABLE FOUNDERS_WITH_PARENTS (CITYID VARCHAR(255),FNAME VARCHAR(255),FOUNDERID VARCHAR(255),STATEID VARCHAR(255),TYPEID VARCHAR(255),PARENTFOUNDERID VARCHAR(255));
CREATE TABLE STUDENTS_SCHOOLS_CATEGORIES (STUDENTID VARCHAR(255),SCHOOLID VARCHAR(255),SCHOOLYEARID VARCHAR(255),GLOBALYEARID VARCHAR(255),CATEGORYID VARCHAR(255));
CREATE TABLE GET_NUMBER_OF_STUDENTS_UDOD (NAME VARCHAR(255),SCHOOLNAME VARCHAR(255),STUDENTID VARCHAR(255),REASONID VARCHAR(255),SCHOOLID VARCHAR(255),GLOBALYEARID VARCHAR(255),SCHOOLYEARID VARCHAR(255));
CREATE TABLE USERPARAMITEMS (USERID VARCHAR(255),SCHOOLYEARID VARCHAR(255),PARAMETERID VARCHAR(255),PARAMVALUE_ID VARCHAR(255),ITEMNAME VARCHAR(255));
CREATE TABLE CLS_ST_VARIANTS_CLASSIC (CLASSID VARCHAR(255),SCHOOLYEARID VARCHAR(255),GRADE VARCHAR(255),ICLASSID VARCHAR(255),IS_IUP VARCHAR(255),VARIANTID VARCHAR(255),USE_LEVEL VARCHAR(255));
CREATE TABLE YEAR_TEACHER_CLASSES (CLASSNAME VARCHAR(255),GRADE VARCHAR(255),teacherid VARCHAR(255),schoolyearid VARCHAR(255));
CREATE TABLE CSG_GRADES (SCHOOLYEARID VARCHAR(255),id VARCHAR(255),NAME VARCHAR(255),TEACHERID VARCHAR(255),SUBJECTID VARCHAR(255),PASS VARCHAR(255),IUP_LEVEL VARCHAR(255),COMMENTS VARCHAR(255),grades VARCHAR(255),gradeID VARCHAR(255),CLASSNAME VARCHAR(255),isIUP VARCHAR(255));
CREATE TABLE SGHOURS (id VARCHAR(255),subjectid VARCHAR(255),schoolyearid VARCHAR(255),TERMID VARCHAR(255),hours VARCHAR(255),cnt VARCHAR(255),cb VARCHAR(255));
CREATE TABLE REVISIONSYEARSSECTIONS (revid VARCHAR(255),yearid VARCHAR(255),sectionid VARCHAR(255),inherit VARCHAR(255));
CREATE TABLE USER_YEAR_PARAMETERS (PARAMETERID VARCHAR(255),USERID VARCHAR(255),schoolyearid VARCHAR(255),ITEMNAME VARCHAR(255),cb VARCHAR(255));
CREATE TABLE USERPARAMDATES (USERID VARCHAR(255),SCHOOLYEARID VARCHAR(255),PARAMETERID VARCHAR(255),PARAMVALUE_DT VARCHAR(255));
CREATE TABLE EM_DISTRICTS (EMID VARCHAR(255),DISTRICTID VARCHAR(255));
CREATE TABLE GET_PARENTPAY_DEBT (SCHOOLYEARID VARCHAR(255),STUDENTID VARCHAR(255),DEBT VARCHAR(255),NUMMONTH VARCHAR(255),PARENTID VARCHAR(255));
CREATE TABLE ST_GRADES_VARIANTS (SCHOOLYEARID VARCHAR(255),GRADE VARCHAR(255),VARIANTID VARCHAR(255));
CREATE TABLE YEAR_TEACHER_GRADES (GRADE VARCHAR(255),teacherid VARCHAR(255),schoolyearid VARCHAR(255));
CREATE TABLE STUDENTS_DATERANGES_CATEGORIES (STUDENTID VARCHAR(255),SCHOOLID VARCHAR(255),SCHOOLYEARID VARCHAR(255),GLOBALYEARID VARCHAR(255),CATEGORYID VARCHAR(255),DateRangeId VARCHAR(255),ENROLL VARCHAR(255),DEPART VARCHAR(255),CLASSID VARCHAR(255));
CREATE TABLE STAFFTERMSUMS (userid VARCHAR(255),schoolyearid VARCHAR(255),TERMID VARCHAR(255),hours VARCHAR(255),cb VARCHAR(255));
CREATE TABLE GET_CUR_HOURS_BY_CLASS (CLASSID VARCHAR(255),COMPONENTID VARCHAR(255),SUM_HOURS VARCHAR(255));
CREATE TABLE TOTALS_AND_LAST_TERM_YEARTOTALS (PERIODID VARCHAR(255),STUDENTID VARCHAR(255),MARK VARCHAR(255),SGID VARCHAR(255),IS_YEAR VARCHAR(255));
CREATE TABLE SGG_CLASSES_TERMS_STUDENTS (SGID VARCHAR(255),CLASSID VARCHAR(255),ICL_CLASSID VARCHAR(255),TERMID VARCHAR(255),STUDENTID VARCHAR(255));
CREATE TABLE EM_CITIES (EMID VARCHAR(255),CITYID VARCHAR(255));
CREATE TABLE INDICATORS_RELATIONS_ROOTS (ROOT_GROUPINDICATORID VARCHAR(255),INDICATORID VARCHAR(255),GROUPINDICATORID VARCHAR(255),depth VARCHAR(255));
CREATE TABLE SG_TEACHERS_TERMS (sgid VARCHAR(255),teacherid VARCHAR(255),termid VARCHAR(255));
CREATE TABLE ISG_GRADES (SCHOOLYEARID VARCHAR(255),id VARCHAR(255),NAME VARCHAR(255),TEACHERID VARCHAR(255),SUBJECTID VARCHAR(255),PASS VARCHAR(255),IUP_LEVEL VARCHAR(255),COMMENTS VARCHAR(255),grades VARCHAR(255),gradeID VARCHAR(255),CLASSNAME VARCHAR(255),isIUP VARCHAR(255));
CREATE TABLE SG_CLASSES (SGID VARCHAR(255),CLASSID VARCHAR(255),GRADE VARCHAR(255),SCHOOLYEARID VARCHAR(255),ICL_CLASSID VARCHAR(255));
CREATE TABLE SG_ACTIVITIES_GRADINGSYSTEMS (activityId VARCHAR(255),SGID VARCHAR(255),GRADINGSYSTEMID VARCHAR(255));
CREATE TABLE SGG_ST_VARIANTS_IUP (SGID VARCHAR(255),CLASSID VARCHAR(255),SCHOOLYEARID VARCHAR(255),GRADE VARCHAR(255),ICLASSID VARCHAR(255),IS_IUP VARCHAR(255),VARIANTID VARCHAR(255),USE_LEVEL VARCHAR(255));


-- ALTER TABLE ADDCLASSES_STUDENTS ADD  DEFAULT (NULL) FOR SUBDOCID2;
--
-- ALTER TABLE ADDRESSES ADD  DEFAULT ('') FOR HOUSE;
--
-- ALTER TABLE ADDRESSES ADD  DEFAULT ('') FOR CORP;
--
-- ALTER TABLE ADDRESSES ADD  DEFAULT ('') FOR ROOM;
--
-- ALTER TABLE ASSIGNMENTS ADD  DEFAULT ((0)) FOR CLASSASSIGNMENT;
--
-- ALTER TABLE ASSIGNMENTS ADD  DEFAULT (NULL) FOR CLASSMEETINGID;
--
-- ALTER TABLE ASSIGNMENTS ADD  DEFAULT ((10)) FOR WEIGHT;
--
-- ALTER TABLE ASSIGNMENTTYPES ADD  DEFAULT ('Y') FOR EDITABLE;
--
-- ALTER TABLE CITIES ADD  DEFAULT (NULL) FOR PROVINCEID;
--
-- ALTER TABLE CITIES ADD  DEFAULT ((7)) FOR SETTLEMENTTYPEID;
--
-- ALTER TABLE CLASSCALENDAR ADD  DEFAULT (NULL) FOR ROOMID;
--
-- ALTER TABLE CLASSES ADD  DEFAULT ((1)) FOR TYPEID;
--
-- ALTER TABLE CLASSES ADD  DEFAULT ((0)) FOR CAPACITY;
--
-- ALTER TABLE CLASSES ADD  DEFAULT (sysutctimestamp()) FOR VERSION;
--
-- ALTER TABLE CLASSES ADD  DEFAULT (newid()) FOR CLASS_GUID;
--
-- ALTER TABLE CLASSMEETINGS ADD  DEFAULT (NULL) FOR ROOMID;
--
-- ALTER TABLE CSG_EXAMTYPES ADD  DEFAULT ('N') FOR CHOICE;
--
-- ALTER TABLE CURICULUM ADD  DEFAULT ((0)) FOR PROFILEID;
--
-- ALTER TABLE CURICULUM ADD  DEFAULT ((0)) FOR CLASSID;
--
-- ALTER TABLE CURICULUM ADD  DEFAULT ((0)) FOR TERMID;
--
-- ALTER TABLE DATAOBJECTS ADD  DEFAULT ('Y') FOR ISPUBLIC;
--
-- ALTER TABLE DOUGROUPAGES ADD  DEFAULT ((0)) FOR AGEMIN;
--
-- ALTER TABLE DOUGROUPAGES ADD  DEFAULT ((0)) FOR AGEMAX;
--
-- ALTER TABLE DOUSTUDENT_CORRECT ADD  DEFAULT ((0)) FOR WAS_SENT;
--
-- ALTER TABLE DOUSTUDENT_CORRECT ADD  DEFAULT ((0)) FOR DELETED;
--
-- ALTER TABLE EM_FORMPARAM ADD  CONSTRAINT EF_COLUMN_FORMSPEC_DEFAULT  DEFAULT ((0)) FOR FORMSPEC;
--
-- ALTER TABLE EM_INFO ADD  DEFAULT ('') FOR INFO;
--
-- ALTER TABLE EM_INFOPARAMS ADD  DEFAULT ('') FOR NAME;
--
-- ALTER TABLE EM_INFOPARAMS ADD  DEFAULT ('') FOR PTYPE;
--
-- ALTER TABLE EVENTS ADD  DEFAULT (NULL) FOR PERIODICITY;
--
-- ALTER TABLE EXPLINES ADD  DEFAULT ('N') FOR LPARENTH;
--
-- ALTER TABLE EXPLINES ADD  DEFAULT ('N') FOR RPARENTH;
--
-- ALTER TABLE EXPOPERATIONS ADD  DEFAULT ('A') FOR OPERTYPE;
--
-- ALTER TABLE FAMILYINFO ADD  DEFAULT ('') FOR LASTNAME;
--
-- ALTER TABLE FAMILYINFO ADD  DEFAULT ('') FOR FIRSTNAME;
--
-- ALTER TABLE FAMILYINFO ADD  DEFAULT ('') FOR MIDDLENAME;
--
-- ALTER TABLE FILEATTACHMENTS ADD  DEFAULT (newid()) FOR AFILE_GUID;
--
-- ALTER TABLE FORMPARAMETERS ADD  DEFAULT ((0)) FOR cellRow;
--
-- ALTER TABLE FORMPARAMETERS ADD  DEFAULT ('NUMBER') FOR PTYPE;
--
-- ALTER TABLE FORMPARAMETERS ADD  DEFAULT ('') FOR NAME;
--
-- ALTER TABLE FOUNDERS ADD  DEFAULT ('') FOR FULLNAME;
--
-- ALTER TABLE INDICATOR_CALC_ARGS ADD  DEFAULT ((0)) FOR MULTIPLE;
--
-- ALTER TABLE LESSONS ADD  DEFAULT ((1)) FOR HOURS;
--
-- ALTER TABLE LESSONS ADD  DEFAULT ((0)) FOR NLESSONINUNIT;
--
-- ALTER TABLE MESSAGES ADD  DEFAULT ((0)) FOR NEEDNOTIFICATION;
--
-- ALTER TABLE MESSAGES ADD  DEFAULT ('') FOR FROMNAME;
--
-- ALTER TABLE MESSAGES ADD  DEFAULT (NULL) FOR FROMUSERCLIENTID;
--
-- ALTER TABLE MESSAGES ADD  DEFAULT (NULL) FOR FROMSYNCCLIENTID;
--
-- ALTER TABLE MOV_EOS ADD  DEFAULT ((20)) FOR EOFORMID;
--
-- ALTER TABLE MOV_EOS ADD  DEFAULT ((3)) FOR EOLEGALFORMID;
--
-- ALTER TABLE MOV_POOLSTUDENTS ADD  DEFAULT (NULL) FOR LOCKED;
--
-- ALTER TABLE MOV_POOLSTUDENTS ADD  DEFAULT ((1)) FOR CATEGORYID;
--
-- ALTER TABLE MOV_POOLSTUDENTS_ES ADD  DEFAULT ((0)) FOR BUSY;
--
-- ALTER TABLE MOV_POOLSTUDENTS_ES ADD  DEFAULT (NULL) FOR YEARNUMBER;
--
-- ALTER TABLE MOV_POOLSTUDENTS_NA ADD  DEFAULT ((1)) FOR CATEGORYID;
--
-- ALTER TABLE MOV_RETURNTOPOOL ADD  DEFAULT ((1)) FOR CATEGORYID;
--
-- ALTER TABLE MOV_STUDENTSLIST ADD  DEFAULT (NULL) FOR REASON;
--
-- ALTER TABLE MOV_SUBDOCS ADD  DEFAULT (NULL) FOR CLASSID1;
--
-- ALTER TABLE MOV_SUBDOCS ADD  DEFAULT (NULL) FOR CLASSID2;
--
-- ALTER TABLE MOVE_TYPES ADD  DEFAULT ('') FOR NOUNNAME;
--
-- ALTER TABLE OBJPARAMETERS ADD  DEFAULT ('N') FOR ISDEFAULT;
--
-- ALTER TABLE OBJPARAMETERS ADD  DEFAULT ('Y') FOR ISVISIBLE;
--
-- ALTER TABLE OBJPARAMETERS ADD  DEFAULT ('N') FOR ISDISABLED;
--
-- ALTER TABLE OBJPARAMETERS ADD  DEFAULT ('Y') FOR ISDEPEND;
--
-- ALTER TABLE OBJPROPS ADD  DEFAULT ('Y') FOR ISPUBLIC;
--
-- ALTER TABLE OBJPROPS ADD  DEFAULT ('Y') FOR INRESULT;
--
-- ALTER TABLE OBJPROPS ADD  DEFAULT ('Y') FOR INGROUP;
--
-- ALTER TABLE OBJPROPS ADD  DEFAULT ('Y') FOR INFILTER;
--
-- ALTER TABLE OBJPROPS ADD  DEFAULT ('Y') FOR INSORT;
--
-- ALTER TABLE OBJPROPS ADD  DEFAULT ('Y') FOR INFUNC;
--
-- ALTER TABLE OBJPROPS ADD  DEFAULT (NULL) FOR SQL_LIST;
--
-- ALTER TABLE OBJPROPS ADD  DEFAULT ('N') FOR OUTFILTER;
--
-- ALTER TABLE PARENTPAY ADD  DEFAULT ((0)) FOR CORRECTION;
--
-- ALTER TABLE PARENTPAY ADD  DEFAULT ((0)) FOR COMPENS;
--
-- ALTER TABLE PAYNORMS ADD  DEFAULT ((0)) FOR AVERVAL;
--
-- ALTER TABLE PERIODTYPES ADD  DEFAULT ('Y') FOR ISEXAM;
--
-- ALTER TABLE PORTFOLIORESOURCES ADD  DEFAULT (newid()) FOR AFILE_GUID;
--
-- ALTER TABLE PORTFOLIORIGHTS ADD  DEFAULT ((0)) FOR ACCESSTYPE;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((1)) FOR PROGRAMID;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((1)) FOR PRETYPEID;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((1)) FOR AGEID;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((1)) FOR STAYID;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ('') FOR CORPUS;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((0)) FOR AREA;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((0)) FOR CAPACITY;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((0)) FOR CAPACITY_OVZ;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((1)) FOR AGECATEGORYID;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ('N') FOR NOINFORMIKA;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((0)) FOR SEATSFORTRANSFER;
--
-- ALTER TABLE PRECLASSES ADD  DEFAULT ((1)) FOR SUBGROUPSCOUNT;
--
-- ALTER TABLE PROG_DIRECTIONS ADD  DEFAULT ((0)) FOR OLDDIR;
--
-- ALTER TABLE PROG_DIRECTIONS ADD  DEFAULT (NULL) FOR SORTORDER;
--
-- ALTER TABLE QUERIES ADD  DEFAULT ((1)) FOR BUILDSTATUS;
--
-- ALTER TABLE QUERIES ADD  DEFAULT ('N') FOR ISDISTINCT;
--
-- ALTER TABLE QUERYFIELDS ADD  DEFAULT ('N') FOR ISEXPR;
--
-- ALTER TABLE QUERYOBJECTS ADD  DEFAULT ('') FOR ISLEFT;
--
-- ALTER TABLE RELTABLES ADD  DEFAULT ('N') FOR ISCOMMON;
--
-- ALTER TABLE REPORTS ADD  DEFAULT ('S') FOR REPTYPE;
--
-- ALTER TABLE REPORTS ADD  DEFAULT ('Y') FOR INEDIT;
--
-- ALTER TABLE REPORTS ADD  DEFAULT ('N') FOR ISPUBLISHED;
--
-- ALTER TABLE REPORTS ADD  DEFAULT (NULL) FOR SCHOOLID;
--
-- ALTER TABLE REPORTS ADD  DEFAULT (NULL) FOR GROUPID;
--
-- ALTER TABLE REPPARAMETERS ADD  DEFAULT ('S') FOR PARAMTYPE;
--
-- ALTER TABLE REPPARAMETERS ADD  DEFAULT ('S') FOR PARAMDISPTYPE;
--
-- ALTER TABLE RESULTSCALC ADD  CONSTRAINT DF_RESULTSCALC_RESULTCOUNT  DEFAULT ((0)) FOR RESULTCOUNT;
--
-- ALTER TABLE REVISIONS ADD  DEFAULT ('') FOR Note;
--
-- ALTER TABLE ROOMS ADD  CONSTRAINT ROOMS_STUDY_CONSTRAINT  DEFAULT ((1)) FOR STUDY;
--
-- ALTER TABLE SCHEDULETEMPLATE ADD  DEFAULT ((1)) FOR WEEKID;
--
-- ALTER TABLE SCHEDULETEMPLATE ADD  DEFAULT (NULL) FOR ROOMID;
--
-- ALTER TABLE SCHEDULETIMES ADD  DEFAULT ((2)) FOR WEEKDAYNUM;
--
-- ALTER TABLE SCHEDULETIMES ADD  DEFAULT ((0)) FOR VARIANTID;
--
-- ALTER TABLE SCHOOLCALENDAR ADD  DEFAULT (NULL) FOR ROOMID;
--
-- ALTER TABLE SCHOOLDEPARTMENTS ADD  CONSTRAINT DF_SCHOOLDEPARTMENTS_INDEPENDENT  DEFAULT ((0)) FOR ISBRANCH;
--
-- ALTER TABLE SCHOOLDOCGROUPS ADD  DEFAULT ((1)) FOR NUM;
--
-- ALTER TABLE SCHOOLDOCGROUPS ADD  DEFAULT (NULL) FOR SERVICE_NUM;
--
-- ALTER TABLE SCHOOLDOCS ADD  DEFAULT (newid()) FOR AFILE_GUID;
--
-- ALTER TABLE SCHOOLINFO ADD  DEFAULT ('') FOR INFO;
--
-- ALTER TABLE SCHOOLINFOPARAMS ADD  DEFAULT ('') FOR NAME;
--
-- ALTER TABLE SCHOOLINFOPARAMS ADD  DEFAULT ('') FOR PTYPE;
--
-- ALTER TABLE SCHOOLRESOURCEGROUPS ADD  DEFAULT ((1)) FOR NUM;
--
-- ALTER TABLE SCHOOLS ADD  DEFAULT ((0)) FOR CITYID;
--
-- ALTER TABLE SCHOOLS ADD  DEFAULT (NULL) FOR EOID;
--
-- ALTER TABLE SCHOOLS ADD  DEFAULT (NULL) FOR SCHOOLCODE;
--
-- ALTER TABLE SCHOOLS ADD  DEFAULT ((2)) FOR FUNCTYPEID;
--
-- ALTER TABLE SCHOOLYEARS ADD  DEFAULT ('N') FOR OSH5CLOSED;
--
-- ALTER TABLE SCHOOLYEARS ADD  DEFAULT ('N') FOR OSH9CLOSED;
--
-- ALTER TABLE SCHOOLYEARS ADD  DEFAULT ((0)) FOR ARCHIVESTATUS;
--
-- ALTER TABLE SECTIONS ADD  DEFAULT ('') FOR Title
