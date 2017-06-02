--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS irtech;
--
-- Name: irtech; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE irtech WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE irtech OWNER TO postgres;

\connect irtech

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: hostname_stat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE hostname_stat (
    id integer NOT NULL,
    hostname text,
    "time" timestamp without time zone,
    user_ip character(255)
);


ALTER TABLE hostname_stat OWNER TO postgres;

--
-- Name: recommendation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE recommendation (
    id integer NOT NULL,
    data text
);


ALTER TABLE recommendation OWNER TO postgres;

--
-- Name: seq_hostnamestat; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_hostnamestat
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_hostnamestat OWNER TO postgres;

--
-- Name: seq_hostnamestat; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE seq_hostnamestat OWNED BY hostname_stat.id;


--
-- Name: seq_recommendation; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_recommendation
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_recommendation OWNER TO postgres;

--
-- Name: seq_recommendation; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE seq_recommendation OWNED BY recommendation.id;


--
-- Name: settings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE settings (
    key character varying(255) NOT NULL,
    value character varying(255)
);


ALTER TABLE settings OWNER TO postgres;

--
-- Name: weather; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE weather (
    id integer NOT NULL,
    city character(255),
    weather text,
    date timestamp without time zone NOT NULL
);


ALTER TABLE weather OWNER TO postgres;

--
-- Name: weather_daily_summary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE weather_daily_summary (
    id integer NOT NULL,
    data text,
    date timestamp without time zone,
    snowfallm numeric,
    precipi numeric,
    precipsource numeric,
    since1julheatingdegreedays numeric,
    snowfalli numeric,
    precipm numeric,
    meantempm numeric,
    since1julsnowfallm numeric,
    monthtodateheatingdegreedays numeric,
    thunder numeric,
    meantempi numeric,
    since1julsnowfalli numeric,
    meanvisi numeric,
    since1jancoolingdegreedaysnormal numeric,
    maxwspdi numeric,
    meanvism numeric,
    mintempm numeric,
    minhumidity numeric,
    mintempi numeric,
    humidity numeric,
    monthtodatecoolingdegreedaysnormal numeric,
    maxwspdm numeric,
    monthtodateheatingdegreedaysnormal numeric,
    rain numeric,
    gdegreedays numeric,
    since1sepcoolingdegreedaysnormal numeric,
    monthtodatecoolingdegreedays numeric,
    since1sepheatingdegreedaysnormal numeric,
    heatingdegreedaysnormal numeric,
    monthtodatesnowfalli numeric,
    mindewptm numeric,
    snow numeric,
    monthtodatesnowfallm numeric,
    mindewpti numeric,
    heatingdegreedays numeric,
    snowdepthm numeric,
    maxdewptm numeric,
    fog numeric,
    snowdepthi numeric,
    maxdewpti numeric,
    maxtempm numeric,
    minwspdi numeric,
    maxtempi numeric,
    since1sepcoolingdegreedays numeric,
    meanpressurem numeric,
    minwspdm numeric,
    coolingdegreedaysnormal numeric,
    minpressurem numeric,
    minvisi numeric,
    tornado numeric,
    meandewpti numeric,
    maxhumidity numeric,
    minpressurei numeric,
    minvism numeric,
    meandewptm numeric,
    maxpressurem numeric,
    since1jancoolingdegreedays numeric,
    hail numeric,
    meanwindspdm numeric,
    maxpressurei numeric,
    meanwdire numeric,
    since1julheatingdegreedaysnormal numeric,
    meanwdird numeric,
    maxvism numeric,
    since1sepheatingdegreedays numeric,
    meanwindspdi numeric,
    maxvisi numeric,
    meanpressurei numeric,
    coolingdegreedays numeric
);


ALTER TABLE weather_daily_summary OWNER TO postgres;

--
-- Name: weather_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE weather_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE weather_id_seq OWNER TO postgres;

--
-- Name: weather_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE weather_id_seq OWNED BY weather.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hostname_stat ALTER COLUMN id SET DEFAULT nextval('seq_hostnamestat'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recommendation ALTER COLUMN id SET DEFAULT nextval('seq_recommendation'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY weather ALTER COLUMN id SET DEFAULT nextval('weather_id_seq'::regclass);


--
-- Data for Name: hostname_stat; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO hostname_stat (id, hostname, "time", user_ip) VALUES (1, 'http://localhost:9001/', '2017-05-28 19:29:02.583', '127.0.0.1                                                                                                                                                                                                                                                      ');


--
-- Data for Name: recommendation; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: seq_hostnamestat; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_hostnamestat', 1, true);


--
-- Name: seq_recommendation; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_recommendation', 1, false);


--
-- Data for Name: settings; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO settings (key, value) VALUES ('weather_current_minute', '2017-05-31-01-35');
INSERT INTO settings (key, value) VALUES ('weather_per_minute', '1');
INSERT INTO settings (key, value) VALUES ('weather_per_day', '4');


--
-- Data for Name: weather; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO weather (id, city, weather, date) VALUES (1, 'RU/Moscow                                                                                                                                                                                                                                                      ', '
{
  "response": {
  "version":"0.1",
  "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
  "features": {
  "history": 1
  }
	}
		,
	"history": {
		"date": {
		"pretty": "February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "February 24, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "24",
		"hour": "21",
		"min": "00",
		"tzname": "UTC"
		},
		"observations": [
		{
		"date": {
		"pretty": "12:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:00 PM GMT on February 24, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "24",
		"hour": "21",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-12.0", "dewpti":"10.4","hum":"86","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"2.2", "visi":"1.4","pressurem":"1028", "pressurei":"30.36","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Mostly Cloudy","icon":"mostlycloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 242100Z VRB02MPS 2200 BR BKN014 M10/M12 Q1028 TEMPO 0400 FZFG RMK 24511050" },
		{
		"date": {
		"pretty": "12:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "00",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:30 PM GMT on February 24, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "24",
		"hour": "21",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-11.0", "tempi":"12.2","dewptm":"-13.0", "dewpti":"8.6","hum":"85","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"2.5", "visi":"1.6","pressurem":"1028", "pressurei":"30.36","windchillm":"-15.3", "windchilli":"4.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Mostly Cloudy","icon":"mostlycloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 242130Z VRB02MPS 2500 BR BKN014 M11/M13 Q1028 TEMPO 0400 FZFG RMK 24511050" },
		{
		"date": {
		"pretty": "1:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "01",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:00 PM GMT on February 24, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "24",
		"hour": "22",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-12.0", "dewpti":"10.4","hum":"86","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"3.0", "visi":"1.9","pressurem":"1027", "pressurei":"30.33","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Mostly Cloudy","icon":"mostlycloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 242200Z VRB02MPS 3000 BR BKN013 M10/M12 Q1027 TEMPO 0400 FZFG RMK 24511050" },
		{
		"date": {
		"pretty": "1:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "01",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:30 PM GMT on February 24, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "24",
		"hour": "22",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-12.0", "dewpti":"10.4","hum":"86","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"200","wdire":"SSW","vism":"3.0", "visi":"1.9","pressurem":"1027", "pressurei":"30.33","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Mostly Cloudy","icon":"mostlycloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 242230Z 20002MPS 3000 BR BKN013 M10/M12 Q1027 TEMPO 0400 FZFG RMK 24511050" },
		{
		"date": {
		"pretty": "2:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "02",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:00 PM GMT on February 24, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "24",
		"hour": "23",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-11.0", "dewpti":"12.2","hum":"93","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"200","wdire":"SSW","vism":"3.0", "visi":"1.9","pressurem":"1027", "pressurei":"30.33","windchillm":"-15.5", "windchilli":"4.1","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 242300Z 20003MPS 3000 BR OVC011 M10/M11 Q1027 TEMPO 0400 FZFG RMK 24511050" },
		{
		"date": {
		"pretty": "2:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "02",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:30 PM GMT on February 24, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "24",
		"hour": "23",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-11.0", "dewpti":"12.2","hum":"93","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"200","wdire":"SSW","vism":"3.0", "visi":"1.9","pressurem":"1027", "pressurei":"30.33","windchillm":"-15.5", "windchilli":"4.1","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 242330Z 20003MPS 3000 BR OVC010 M10/M11 Q1027 TEMPO 0400 FZFG RMK 24511050" },
		{
		"date": {
		"pretty": "3:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "03",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "00",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-12.0", "dewpti":"10.4","hum":"86","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"4.0", "visi":"2.5","pressurem":"1026", "pressurei":"30.30","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250000Z VRB02MPS 4000 -SN BR OVC010 M10/M12 Q1026 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "3:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "03",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "00",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-12.0", "dewpti":"10.4","hum":"86","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"190","wdire":"South","vism":"4.0", "visi":"2.5","pressurem":"1026", "pressurei":"30.30","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250030Z 19002MPS 4000 -SN BR OVC011 M10/M12 Q1026 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "4:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "04",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "01",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-12.0", "dewpti":"10.4","hum":"86","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"180","wdire":"South","vism":"4.0", "visi":"2.5","pressurem":"1026", "pressurei":"30.30","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250100Z 18002MPS 4000 -SN BR OVC011 M10/M12 Q1026 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "4:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "04",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "01",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-11.0", "tempi":"12.2","dewptm":"-12.0", "dewpti":"10.4","hum":"92","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"4.0", "visi":"2.5","pressurem":"1025", "pressurei":"30.27","windchillm":"-15.3", "windchilli":"4.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250130Z VRB02MPS 4000 -SN BR OVC011 M11/M12 Q1025 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "5:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "05",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "02",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-11.0", "tempi":"12.2","dewptm":"-13.0", "dewpti":"8.6","hum":"85","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"3.0", "visi":"1.9","pressurem":"1025", "pressurei":"30.27","windchillm":"-15.3", "windchilli":"4.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250200Z 23002MPS 3000 -SN BR OVC010 M11/M13 Q1025 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "5:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "05",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "02",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-11.0", "tempi":"12.2","dewptm":"-13.0", "dewpti":"8.6","hum":"85","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"3.0", "visi":"1.9","pressurem":"1025", "pressurei":"30.27","windchillm":"-15.3", "windchilli":"4.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250230Z 23002MPS 3000 -SN BR OVC010 M11/M13 Q1025 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "6:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "06",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "03",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-13.0", "dewpti":"8.6","hum":"92","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"3.0", "visi":"1.9","pressurem":"1024", "pressurei":"30.24","windchillm":"-16.4", "windchilli":"2.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250300Z VRB02MPS 3000 -SN BR OVC010 M12/M13 Q1024 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "6:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "06",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "03",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-14.0", "dewpti":"6.8","hum":"85","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"3.0", "visi":"1.9","pressurem":"1024", "pressurei":"30.24","windchillm":"-16.4", "windchilli":"2.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250330Z VRB02MPS 3000 -SN BR OVC010 M12/M14 Q1024 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "7:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "07",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "04",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-13.0", "dewpti":"8.6","hum":"92","wspdm":"3.6", "wspdi":"2.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"3.0", "visi":"1.9","pressurem":"1024", "pressurei":"30.24","windchillm":"-999", "windchilli":"-999","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250400Z VRB01MPS 3000 -SN BR OVC010 M12/M13 Q1024 NOSIG RMK 24511045" },
		{
		"date": {
		"pretty": "7:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "07",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "04",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-14.0", "dewpti":"6.8","hum":"85","wspdm":"0.0", "wspdi":"0.0","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"North","vism":"3.0", "visi":"1.9","pressurem":"1024", "pressurei":"30.24","windchillm":"-999", "windchilli":"-999","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250430Z 00000MPS 3000 -SN BR OVC010 M12/M14 Q1024 NOSIG RMK 24551040" },
		{
		"date": {
		"pretty": "8:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "08",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "05",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-14.0", "tempi":"6.8","dewptm":"-15.0", "dewpti":"5.0","hum":"92","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"2.5", "visi":"1.6","pressurem":"1023", "pressurei":"30.21","windchillm":"-18.8", "windchilli":"-1.8","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250500Z VRB02MPS 2500 -SN BR OVC010 M14/M15 Q1023 TEMPO 0700 FZFG RMK 24551040" },
		{
		"date": {
		"pretty": "8:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "08",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "05",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-13.0", "tempi":"8.6","dewptm":"-15.0", "dewpti":"5.0","hum":"85","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"210","wdire":"SSW","vism":"4.0", "visi":"2.5","pressurem":"1023", "pressurei":"30.21","windchillm":"-17.6", "windchilli":"0.3","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250530Z 21002MPS 4000 -SN BR BKN010 BKN100 M13/M15 Q1023 NOSIG RMK 24551040" },
		{
		"date": {
		"pretty": "9:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "09",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "06",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-14.0", "tempi":"6.8","dewptm":"-15.0", "dewpti":"5.0","hum":"92","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"220","wdire":"SW","vism":"4.0", "visi":"2.5","pressurem":"1023", "pressurei":"30.21","windchillm":"-21.5", "windchilli":"-6.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250600Z 22004MPS 4000 -SN BR SCT010 OVC100 M14/M15 Q1023 NOSIG RMK 24551040" },
		{
		"date": {
		"pretty": "9:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "09",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "06",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-14.0", "tempi":"6.8","dewptm":"-16.0", "dewpti":"3.2","hum":"85","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"4.0", "visi":"2.5","pressurem":"1023", "pressurei":"30.21","windchillm":"-20.3", "windchilli":"-4.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250630Z 23003MPS 4000 -SN BR SCT010 OVC100 M14/M16 Q1023 NOSIG RMK 24551040" },
		{
		"date": {
		"pretty": "10:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "10",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "07",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-14.0", "tempi":"6.8","dewptm":"-16.0", "dewpti":"3.2","hum":"85","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"4.0", "visi":"2.5","pressurem":"1023", "pressurei":"30.21","windchillm":"-18.8", "windchilli":"-1.8","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250700Z VRB02MPS 4000 -SN BR SCT010 OVC100 M14/M16 Q1023 NOSIG RMK 24551040" },
		{
		"date": {
		"pretty": "10:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "10",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "07",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-13.0", "tempi":"8.6","dewptm":"-15.0", "dewpti":"5.0","hum":"85","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"4.0", "visi":"2.5","pressurem":"1022", "pressurei":"30.18","windchillm":"-17.6", "windchilli":"0.3","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250730Z VRB02MPS 4000 -SN BR SCT010 OVC100 M13/M15 Q1022 NOSIG RMK 24551040" },
		{
		"date": {
		"pretty": "11:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "11",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "08",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-15.0", "dewpti":"5.0","hum":"79","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"4.0", "visi":"2.5","pressurem":"1022", "pressurei":"30.18","windchillm":"-16.4", "windchilli":"2.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250800Z VRB02MPS 4000 -SN BR SCT011 OVC100 M12/M15 Q1022 NOSIG RMK 24551040" },
		{
		"date": {
		"pretty": "11:30 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "11",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "08",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-14.0", "dewpti":"6.8","hum":"85","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"0","wdire":"Variable","vism":"3.0", "visi":"1.9","pressurem":"1021", "pressurei":"30.15","windchillm":"-16.4", "windchilli":"2.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250830Z VRB02MPS 3000 -SN BR SCT010 OVC100 M12/M14 Q1021 NOSIG RMK 24551040" },
		{
		"date": {
		"pretty": "12:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "12",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "09",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-11.0", "tempi":"12.2","dewptm":"-13.0", "dewpti":"8.6","hum":"85","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"5.0", "visi":"3.1","pressurem":"1021", "pressurei":"30.15","windchillm":"-16.7", "windchilli":"1.9","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250900Z 24003MPS 5000 BR SCT010 BKN020 OVC100 M11/M13 Q1021 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "12:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "12",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "09",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-13.0", "dewpti":"8.6","hum":"79","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"5.0", "visi":"3.1","pressurem":"1021", "pressurei":"30.15","windchillm":"-16.6", "windchilli":"2.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 250930Z 23004MPS 5000 BR NKN017 OVC100 M10/M13 Q1021 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "1:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "13",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "10",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-9.0", "tempi":"15.8","dewptm":"-13.0", "dewpti":"8.6","hum":"73","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1020", "pressurei":"30.12","windchillm":"-14.3", "windchilli":"6.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251000Z 24003MPS 9999 BKN018 OVC100 M09/M13 Q1020 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "1:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "13",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "10",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-9.0", "tempi":"15.8","dewptm":"-13.0", "dewpti":"8.6","hum":"73","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1020", "pressurei":"30.12","windchillm":"-14.3", "windchilli":"6.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Mostly Cloudy","icon":"mostlycloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251030Z 25003MPS 9999 SCT022 BKN200 M09/M13 Q1020 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "2:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "14",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:00 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "11",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-13.0", "dewpti":"8.6","hum":"68","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"10.0", "visi":"6.2","pressurem":"1019", "pressurei":"30.09","windchillm":"-13.1", "windchilli":"8.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Mostly Cloudy","icon":"mostlycloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251100Z 23003MPS 9999 SCT022 BKN200 M08/M13 Q1019 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "2:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "14",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:30 AM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "11",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-13.0", "dewpti":"8.6","hum":"63","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1019", "pressurei":"30.09","windchillm":"-12.9", "windchilli":"8.8","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251130Z 23004MPS CAVOK M07/M13 Q1019 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "3:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "15",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:00 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "12",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-12.0", "dewpti":"10.4","hum":"68","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"220","wdire":"SW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1018", "pressurei":"30.06","windchillm":"-11.9", "windchilli":"10.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251200Z 22003MPS CAVOK M07/M12 Q1018 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "3:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "15",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "12",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-13.0", "dewpti":"8.6","hum":"63","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1018", "pressurei":"30.06","windchillm":"-12.9", "windchilli":"8.8","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251230Z 23004MPS CAVOK M07/M13 Q1018 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "4:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "16",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:00 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "13",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-13.0", "dewpti":"8.6","hum":"63","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1017", "pressurei":"30.04","windchillm":"-12.9", "windchilli":"8.8","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251300Z 23004MPS CAVOK M07/M13 Q1017 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "4:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "16",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "13",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-12.0", "dewpti":"10.4","hum":"68","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"210","wdire":"SSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1017", "pressurei":"30.04","windchillm":"-11.9", "windchilli":"10.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251330Z 21003MPS CAVOK M07/M12 Q1017 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "5:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "17",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:00 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "14",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-13.0", "dewpti":"8.6","hum":"63","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"200","wdire":"SSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1016", "pressurei":"30.01","windchillm":"-11.9", "windchilli":"10.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251400Z 20003MPS CAVOK M07/M13 Q1016 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "5:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "17",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "14",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-13.0", "dewpti":"8.6","hum":"63","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"190","wdire":"South","vism":"-9999.0", "visi":"-9999.0","pressurem":"1016", "pressurei":"30.01","windchillm":"-11.9", "windchilli":"10.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251430Z 19003MPS CAVOK M07/M13 Q1016 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "6:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "18",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:00 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "15",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-14.0", "dewpti":"6.8","hum":"63","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"180","wdire":"South","vism":"-9999.0", "visi":"-9999.0","pressurem":"1016", "pressurei":"30.01","windchillm":"-11.8", "windchilli":"10.8","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251500Z 18002MPS CAVOK M08/M14 Q1016 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "6:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "18",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "15",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-9.0", "tempi":"15.8","dewptm":"-14.0", "dewpti":"6.8","hum":"68","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"200","wdire":"SSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1016", "pressurei":"30.01","windchillm":"-12.9", "windchilli":"8.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251530Z 20002MPS CAVOK M09/M14 Q1016 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "7:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "19",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "16",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-10.0", "tempi":"14.0","dewptm":"-14.0", "dewpti":"6.8","hum":"73","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"200","wdire":"SSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1015", "pressurei":"29.98","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251630Z 20002MPS CAVOK M10/M14 Q1015 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "8:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "20",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:00 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "17",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-11.0", "tempi":"12.2","dewptm":"-14.0", "dewpti":"6.8","hum":"79","wspdm":"7.2", "wspdi":"4.5","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"190","wdire":"South","vism":"-9999.0", "visi":"-9999.0","pressurem":"1015", "pressurei":"29.98","windchillm":"-15.3", "windchilli":"4.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251700Z 19002MPS CAVOK M11/M14 Q1015 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "8:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "20",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "17",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-11.0", "tempi":"12.2","dewptm":"-14.0", "dewpti":"6.8","hum":"79","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"190","wdire":"South","vism":"-9999.0", "visi":"-9999.0","pressurem":"1014", "pressurei":"29.95","windchillm":"-16.7", "windchilli":"1.9","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251730Z 19003MPS CAVOK M11/M14 Q1014 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "9:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "21",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:00 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "18",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-11.0", "tempi":"12.2","dewptm":"-14.0", "dewpti":"6.8","hum":"79","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"200","wdire":"SSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1014", "pressurei":"29.95","windchillm":"-16.7", "windchilli":"1.9","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251800Z 20003MPS CAVOK M11/M14 Q1014 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "9:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "21",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "18",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-15.0", "dewpti":"5.0","hum":"79","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"190","wdire":"South","vism":"-9999.0", "visi":"-9999.0","pressurem":"1013", "pressurei":"29.92","windchillm":"-17.9", "windchilli":"-0.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251830Z 19003MPS CAVOK M12/M15 Q1013 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "10:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "22",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:00 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "19",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-15.0", "dewpti":"5.0","hum":"79","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"210","wdire":"SSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1013", "pressurei":"29.92","windchillm":"-19.0", "windchilli":"-2.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251900Z 21004MPS CAVOK M12/M15 Q1013 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "10:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "22",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "19",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-12.0", "tempi":"10.4","dewptm":"-15.0", "dewpti":"5.0","hum":"79","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"220","wdire":"SW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1013", "pressurei":"29.92","windchillm":"-19.0", "windchilli":"-2.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 251930Z 22004MPS CAVOK M12/M15 Q1013 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "11:00 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "23",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:00 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "20",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-13.0", "tempi":"8.6","dewptm":"-15.0", "dewpti":"5.0","hum":"85","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1013", "pressurei":"29.92","windchillm":"-20.2", "windchilli":"-4.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 252000Z 23004MPS CAVOK M13/M15 Q1013 NOSIG RMK 24411045" },
		{
		"date": {
		"pretty": "11:30 PM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "23",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:30 PM GMT on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "20",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-13.0", "tempi":"8.6","dewptm":"-16.0", "dewpti":"3.2","hum":"79","wspdm":"10.8", "wspdi":"6.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"220","wdire":"SW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1013", "pressurei":"29.92","windchillm":"-19.1", "windchilli":"-2.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Clear","icon":"clear","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 252030Z 22003MPS CAVOK M13/M16 Q1013 NOSIG RMK 24411045" }
		],
		"dailysummary": [
		{ "date": {
		"pretty": "12:00 AM MSK on February 25, 2005",
		"year": "2005",
		"mon": "02",
		"mday": "25",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"fog":"0","rain":"0","snow":"1","snowfallm":"", "snowfalli":"","monthtodatesnowfallm":"", "monthtodatesnowfalli":"","since1julsnowfallm":"", "since1julsnowfalli":"","snowdepthm":"", "snowdepthi":"","hail":"0","thunder":"0","tornado":"0","meantempm":"-10", "meantempi":"12","meandewptm":"-13", "meandewpti":"8","meanpressurem":"1020.64", "meanpressurei":"30.14","meanwindspdm":"8", "meanwindspdi":"5","meanwdire":"SSW","meanwdird":"213","meanvism":"4.1", "meanvisi":"2.6","humidity":"80","maxtempm":"-7", "maxtempi":"19","mintempm":"-14", "mintempi":"6","maxhumidity":"93","minhumidity":"63","maxdewptm":"-11", "maxdewpti":"12","mindewptm":"-16", "mindewpti":"3","maxpressurem":"1028", "maxpressurei":"30.36","minpressurem":"1013", "minpressurei":"29.92","maxwspdm":"14", "maxwspdi":"9","minwspdm":"0", "minwspdi":"0","maxvism":"10.0", "maxvisi":"6.2","minvism":"2.2", "minvisi":"1.4","gdegreedays":"0","heatingdegreedays":"52","coolingdegreedays":"0","precipm":"0.0", "precipi":"0.00","precipsource":"3Or6HourObs","heatingdegreedaysnormal":"","monthtodateheatingdegreedays":"","monthtodateheatingdegreedaysnormal":"","since1sepheatingdegreedays":"","since1sepheatingdegreedaysnormal":"","since1julheatingdegreedays":"","since1julheatingdegreedaysnormal":"","coolingdegreedaysnormal":"","monthtodatecoolingdegreedays":"","monthtodatecoolingdegreedaysnormal":"","since1sepcoolingdegreedays":"","since1sepcoolingdegreedaysnormal":"","since1jancoolingdegreedays":"","since1jancoolingdegreedaysnormal":"" }
		]
	}
}
', '2005-02-25 00:00:00');
INSERT INTO weather (id, city, weather, date) VALUES (2, 'RU/Moscow                                                                                                                                                                                                                                                      ', '
{
  "response": {
  "version":"0.1",
  "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
  "features": {
  "history": 1
  }
	}
		,
	"history": {
		"date": {
		"pretty": "February 1, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "January 31, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "31",
		"hour": "21",
		"min": "00",
		"tzname": "UTC"
		},
		"observations": [
		{
		"date": {
		"pretty": "12:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:00 PM GMT on January 31, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "31",
		"hour": "21",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-10.0", "dewpti":"14.0","hum":"86","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1020", "pressurei":"30.12","windchillm":"-14.9", "windchilli":"5.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow Showers","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312100Z 25005MPS 6000 -SHSN BKN012 BKN034CB M08/M10 Q1020 R24/410345 NOSIG" },
		{
		"date": {
		"pretty": "12:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "00",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:30 PM GMT on January 31, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "31",
		"hour": "21",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-9.0", "dewpti":"15.8","hum":"93","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1020", "pressurei":"30.12","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Freezing Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312130Z 25004MPS 3400 -FZDZ BR OVC004 M08/M09 Q1020 R24/410345 NOSIG" },
		{
		"date": {
		"pretty": "1:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "01",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:00 PM GMT on January 31, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "31",
		"hour": "22",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-9.0", "dewpti":"15.8","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"5.0", "visi":"3.1","pressurem":"1020", "pressurei":"30.12","windchillm":"-14.9", "windchilli":"5.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Freezing Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312200Z 25005MPS 5000 -FZDZ BR OVC005 M08/M09 Q1020 R24/410345 NOSIG" },
		{
		"date": {
		"pretty": "1:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "01",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:30 PM GMT on January 31, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "31",
		"hour": "22",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-9.0", "dewpti":"15.8","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1020", "pressurei":"30.12","windchillm":"-14.9", "windchilli":"5.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Freezing Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312230Z 25005MPS 6000 -FZDZ OVC005 M08/M09 Q1020 R24/410345 NOSIG" },
		{
		"date": {
		"pretty": "2:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "02",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:00 PM GMT on January 31, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "31",
		"hour": "23",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-9.0", "dewpti":"15.8","hum":"93","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1020", "pressurei":"30.12","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Freezing Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312300Z 25004MPS 6000 -FZDZ OVC005 M08/M09 Q1020 R24/410345 NOSIG" },
		{
		"date": {
		"pretty": "2:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "02",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:30 PM GMT on January 31, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "31",
		"hour": "23",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-9.0", "dewpti":"15.8","hum":"93","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1019", "pressurei":"30.09","windchillm":"-14.1", "windchilli":"6.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312330Z 24004MPS 6000 OVC005 M08/M09 Q1019 R24/410345 TEMPO -FZDZ OVC003" },
		{
		"date": {
		"pretty": "3:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "03",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "00",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-9.0", "dewpti":"15.8","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1019", "pressurei":"30.09","windchillm":"-14.9", "windchilli":"5.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010000Z 25005MPS 6000 OVC005 M08/M09 Q1019 R24/410345 TEMPO -FZDZ OVC003" },
		{
		"date": {
		"pretty": "3:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "03",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "00",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-8.0", "dewpti":"17.6","hum":"100","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1019", "pressurei":"30.09","windchillm":"-14.9", "windchilli":"5.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010030Z 25005MPS 6000 OVC006 M08/M08 Q1019 R24/410345 TEMPO -FZDZ OVC003" },
		{
		"date": {
		"pretty": "4:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "04",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "01",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-8.0", "tempi":"17.6","dewptm":"-8.0", "dewpti":"17.6","hum":"100","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-14.9", "windchilli":"5.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010100Z 25005MPS 7000 OVC006 M08/M08 Q1018 R24/410345 TEMPO -FZDZ OVC003" },
		{
		"date": {
		"pretty": "4:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "04",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "01",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-8.0", "dewpti":"17.6","hum":"93","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"260","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-12.9", "windchilli":"8.8","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010130Z 26004MPS 7000 OVC006 M07/M08 Q1018 R24/410345 TEMPO -FZDZ OVC003" },
		{
		"date": {
		"pretty": "5:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "05",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "02",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-8.0", "dewpti":"17.6","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"260","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-13.7", "windchilli":"7.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010200Z 26005MPS 7000 -SN OVC006 M07/M08 Q1018 R24/410345 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "5:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "05",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "02",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-8.0", "dewpti":"17.6","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"260","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-13.7", "windchilli":"7.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010230Z 26005MPS 7000 -SN OVC006 M07/M08 Q1018 R24/410345 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "6:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "06",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "03",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-8.0", "dewpti":"17.6","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"260","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-13.7", "windchilli":"7.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010300Z 26005MPS 7000 -SN OVC006 M07/M08 Q1018 R24/290047 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "6:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "06",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "03",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-7.0", "tempi":"19.4","dewptm":"-7.0", "dewpti":"19.4","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"270","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-14.3", "windchilli":"6.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010330Z 27006MPS 7000 OVC006 M07/M07 Q1018 R24/290047 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "7:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "07",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "04",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-6.0", "tempi":"21.2","dewptm":"-7.0", "dewpti":"19.4","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"270","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-12.4", "windchilli":"9.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010400Z 27005MPS 7000 BKN006 OVC023 M06/M07 Q1018 R24/290047 NOSIG" },
		{
		"date": {
		"pretty": "7:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "07",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "04",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-6.0", "tempi":"21.2","dewptm":"-7.0", "dewpti":"19.4","hum":"93","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"280","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-11.6", "windchilli":"11.0","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010430Z 28004MPS 7000 -SN BKN006 OVC023 M06/M07 Q1018 R24/290047 NOSIG" },
		{
		"date": {
		"pretty": "8:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "08",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "05",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-6.0", "tempi":"21.2","dewptm":"-7.0", "dewpti":"19.4","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"270","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-12.4", "windchilli":"9.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010500Z 27005MPS 7000 -SN BKN006 OVC023 M06/M07 Q1018 R24/290047 NOSIG" },
		{
		"date": {
		"pretty": "8:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "08",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "05",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-6.0", "tempi":"21.2","dewptm":"-7.0", "dewpti":"19.4","hum":"93","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"270","wdire":"West","vism":"6.0", "visi":"3.7","pressurem":"1018", "pressurei":"30.06","windchillm":"-11.6", "windchilli":"11.0","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow Grains","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010530Z 27004MPS 6000 -SG OVC005 M06/M07 Q1018 R24/290047 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "9:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "09",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "06",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-6.0", "tempi":"21.2","dewptm":"-6.0", "dewpti":"21.2","hum":"100","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"280","wdire":"West","vism":"6.0", "visi":"3.7","pressurem":"1018", "pressurei":"30.06","windchillm":"-11.6", "windchilli":"11.0","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow Grains","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010600Z 28004MPS 6000 -SG OVC006 M06/M06 Q1018 R24/290047 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "9:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "09",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "06",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-5.0", "tempi":"23.0","dewptm":"-6.0", "dewpti":"21.2","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"280","wdire":"West","vism":"5.0", "visi":"3.1","pressurem":"1018", "pressurei":"30.06","windchillm":"-11.2", "windchilli":"11.9","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010630Z 28005MPS 5000 -SN BR BKN007 OVC023 M05/M06 Q1018 R24/290047 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "10:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "10",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "07",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-5.0", "tempi":"23.0","dewptm":"-6.0", "dewpti":"21.2","hum":"93","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"270","wdire":"West","vism":"5.0", "visi":"3.1","pressurem":"1018", "pressurei":"30.06","windchillm":"-11.8", "windchilli":"10.8","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010700Z 27006MPS 5000 -SN BR OVC028 M05/M06 Q1018 R24/410247 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "10:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "10",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "07",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-5.0", "tempi":"23.0","dewptm":"-6.0", "dewpti":"21.2","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"270","wdire":"West","vism":"6.0", "visi":"3.7","pressurem":"1018", "pressurei":"30.06","windchillm":"-11.2", "windchilli":"11.9","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010730Z 27005MPS 6000 -SN BKN029 M05/M06 Q1018 R24/410247 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "11:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "11",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "08",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-4.0", "tempi":"24.8","dewptm":"-5.0", "dewpti":"23.0","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"280","wdire":"West","vism":"6.0", "visi":"3.7","pressurem":"1018", "pressurei":"30.06","windchillm":"-9.9", "windchilli":"14.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010800Z 28005MPS 6000 -SN BKN008 M04/M05 Q1018 R24/410247 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "11:30 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "11",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "08",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-4.0", "tempi":"24.8","dewptm":"-5.0", "dewpti":"23.0","hum":"93","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"280","wdire":"West","vism":"7.0", "visi":"4.3","pressurem":"1018", "pressurei":"30.06","windchillm":"-9.9", "windchilli":"14.2","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010830Z 28005MPS 7000 -SN SCT008 BKN033 M04/M05 Q1018 R24/410247 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "12:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "12",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "09",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-3.0", "tempi":"26.6","dewptm":"-5.0", "dewpti":"23.0","hum":"86","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"290","wdire":"WNW","vism":"9.0", "visi":"5.6","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.7", "windchilli":"16.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010900Z 29005MPS 9000 -SN SCT011 BKN033 M03/M05 Q1018 R24/410247 TEMPO -FZDZ" },
		{
		"date": {
		"pretty": "12:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "12",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "09",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-3.0", "tempi":"26.6","dewptm":"-5.0", "dewpti":"23.0","hum":"86","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"290","wdire":"WNW","vism":"9.0", "visi":"5.6","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.7", "windchilli":"16.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010930Z 29005MPS 9000 -SN BKN010 M03/M05 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "1:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "13",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "10",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-3.0", "tempi":"26.6","dewptm":"-5.0", "dewpti":"23.0","hum":"86","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"290","wdire":"WNW","vism":"9.0", "visi":"5.6","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.7", "windchilli":"16.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Snow","icon":"snow","fog":"0","rain":"0","snow":"1","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011000Z 29005MPS 9000 -SN SCT013 BKN030 M03/M05 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "1:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "13",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "10",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-3.0", "tempi":"26.6","dewptm":"-5.0", "dewpti":"23.0","hum":"86","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"9.0", "visi":"5.6","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.0", "windchilli":"17.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Mostly Cloudy","icon":"mostlycloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011030Z 30004MPS 9000 SCT015 BKN030 M03/M05 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "2:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "14",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:00 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "11",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"320","wdire":"NW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.5", "windchilli":"16.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Mostly Cloudy","icon":"mostlycloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011100Z 32007MPS 9999 BKN021 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "2:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "14",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:30 AM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "11",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"310","wdire":"NW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-7.4", "windchilli":"18.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011130Z 31005MPS 9999 OVC019 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "3:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "15",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "12",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-5.0", "dewpti":"23.0","hum":"80","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"290","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-7.4", "windchilli":"18.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011200Z 29005MPS 9999 OVC019 M02/M05 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "3:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "15",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "12",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"320","wdire":"NW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-7.4", "windchilli":"18.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011230Z 32005MPS 9999 OVC022 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "4:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "16",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "13",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-7.4", "windchilli":"18.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011300Z 30005MPS 9999 OVC022 M02/M06 Q1018 WS R24 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "4:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "16",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "13",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.0", "windchilli":"17.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011330Z 30006MPS 9999 OVC022 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "5:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "17",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "14",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.0", "windchilli":"17.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011400Z 30006MPS 9999 OVC023 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "5:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "17",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "14",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"21.6", "wspdi":"13.4","wgustm":"39.6", "wgusti":"24.6","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.0", "windchilli":"17.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011430Z 30006G11MPS 9999 OVC025 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "6:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "18",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "15",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-7.4", "windchilli":"18.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011500Z 30005MPS 9999 OVC024 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "6:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "18",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "15",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-5.0", "dewpti":"23.0","hum":"80","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"290","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-6.7", "windchilli":"19.9","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011530Z 29004MPS 9999 OVC023 M02/M05 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "7:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "19",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "16",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"21.6", "wspdi":"13.4","wgustm":"39.6", "wgusti":"24.6","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.0", "windchilli":"17.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011600Z 30006G11MPS 9999 OVC023 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "7:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "19",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "16",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-7.4", "windchilli":"18.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011630Z 30005MPS 9999 OVC023 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "8:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "20",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "17",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-6.7", "windchilli":"19.9","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011700Z 30004MPS 9999 OVC025 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "8:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "20",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "17",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-7.4", "windchilli":"18.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011730Z 30005MPS 9999 OVC021 M02/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "9:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "21",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "18",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-3.0", "tempi":"26.6","dewptm":"-5.0", "dewpti":"23.0","hum":"86","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"300","wdire":"WNW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-8.7", "windchilli":"16.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011800Z 30005MPS 9999 OVC023 M03/M05 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "9:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "21",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "18",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-3.0", "tempi":"26.6","dewptm":"-6.0", "dewpti":"21.2","hum":"80","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"310","wdire":"NW","vism":"10.0", "visi":"6.2","pressurem":"1018", "pressurei":"30.06","windchillm":"-9.3", "windchilli":"15.3","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011830Z 31006MPS 9999 OVC022 M03/M06 Q1018 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "10:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "22",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "19",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"25.2", "wspdi":"15.7","wgustm":"46.8", "wgusti":"29.1","wdird":"330","wdire":"NNW","vism":"10.0", "visi":"6.2","pressurem":"1019", "pressurei":"30.09","windchillm":"-8.5", "windchilli":"16.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011900Z 33007G13MPS 9999 OVC022 M02/M06 Q1019 R24/410247 NOSIG" },
		{
		"date": {
		"pretty": "10:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "22",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "19",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"330","wdire":"NNW","vism":"10.0", "visi":"6.2","pressurem":"1019", "pressurei":"30.09","windchillm":"-8.0", "windchilli":"17.6","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011930Z 33006MPS 9999 OVC022 M02/M06 Q1019 R01/410240 NOSIG" },
		{
		"date": {
		"pretty": "11:00 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "23",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:00 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "20",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"340","wdire":"NNW","vism":"10.0", "visi":"6.2","pressurem":"1019", "pressurei":"30.09","windchillm":"-7.4", "windchilli":"18.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 012000Z 34005MPS 9999 OVC021 M02/M06 Q1019 R01/410240 NOSIG" },
		{
		"date": {
		"pretty": "11:30 PM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "23",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:30 PM GMT on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "20",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"-2.0", "tempi":"28.4","dewptm":"-6.0", "dewpti":"21.2","hum":"74","wspdm":"14.4", "wspdi":"8.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"340","wdire":"NNW","vism":"10.0", "visi":"6.2","pressurem":"1019", "pressurei":"30.09","windchillm":"-6.7", "windchilli":"19.9","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 012030Z 34004MPS 9999 OVC021 M02/M06 Q1019 R01/410240 NOSIG" }
		],
		"dailysummary": [
		{ "date": {
		"pretty": "12:00 AM MSK on February 01, 2017",
		"year": "2017",
		"mon": "02",
		"mday": "01",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"fog":"0","rain":"0","snow":"1","snowfallm":"", "snowfalli":"","monthtodatesnowfallm":"", "monthtodatesnowfalli":"","since1julsnowfallm":"", "since1julsnowfalli":"","snowdepthm":"", "snowdepthi":"","hail":"0","thunder":"0","tornado":"0","meantempm":"-5", "meantempi":"22","meandewptm":"-7", "meandewpti":"20","meanpressurem":"1018.35", "meanpressurei":"30.07","meanwindspdm":"16", "meanwindspdi":"10","meanwdire":"WNW","meanwdird":"284","meanvism":"8.1", "meanvisi":"5.0","humidity":"86","maxtempm":"-2", "maxtempi":"28","mintempm":"-8", "mintempi":"17","maxhumidity":"100","minhumidity":"74","maxdewptm":"-5", "maxdewpti":"23","mindewptm":"-10", "mindewpti":"14","maxpressurem":"1020", "maxpressurei":"30.12","minpressurem":"1018", "minpressurei":"30.06","maxwspdm":"25", "maxwspdi":"16","minwspdm":"14", "minwspdi":"9","maxvism":"10.0", "maxvisi":"6.2","minvism":"5.0", "minvisi":"3.1","gdegreedays":"0","heatingdegreedays":"42","coolingdegreedays":"0","precipm":"0.0", "precipi":"0.00","precipsource":"3Or6HourObs","heatingdegreedaysnormal":"","monthtodateheatingdegreedays":"","monthtodateheatingdegreedaysnormal":"","since1sepheatingdegreedays":"","since1sepheatingdegreedaysnormal":"","since1julheatingdegreedays":"","since1julheatingdegreedaysnormal":"","coolingdegreedaysnormal":"","monthtodatecoolingdegreedays":"","monthtodatecoolingdegreedaysnormal":"","since1sepcoolingdegreedays":"","since1sepcoolingdegreedaysnormal":"","since1jancoolingdegreedays":"","since1jancoolingdegreedaysnormal":"" }
		]
	}
}
', '2017-02-01 00:00:00');
INSERT INTO weather (id, city, weather, date) VALUES (5, 'RU/Moscow                                                                                                                                                                                                                                                      ', '
{
  "response": {
  "version":"0.1",
  "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
  "features": {
  "history": 1
  }
	}
		,
	"history": {
		"date": {
		"pretty": "January 1, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "December 31, 2016",
		"year": "2016",
		"mon": "12",
		"mday": "31",
		"hour": "21",
		"min": "00",
		"tzname": "UTC"
		},
		"observations": [
		{
		"date": {
		"pretty": "12:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:00 PM GMT on December 31, 2016",
		"year": "2016",
		"mon": "12",
		"mday": "31",
		"hour": "21",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"0.0", "tempi":"32.0","dewptm":"0.0", "dewpti":"32.0","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"5.0", "visi":"3.1","pressurem":"1006", "pressurei":"29.71","windchillm":"-5.9", "windchilli":"21.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312100Z 23007MPS 5000 -DZ BR OVC003 00/00 Q1006 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "12:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "00",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:30 PM GMT on December 31, 2016",
		"year": "2016",
		"mon": "12",
		"mday": "31",
		"hour": "21",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"0.0", "tempi":"32.0","dewptm":"0.0", "dewpti":"32.0","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1006", "pressurei":"29.71","windchillm":"-5.9", "windchilli":"21.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312130Z 24007MPS 3100 -DZ BR OVC002 00/00 Q1006 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "1:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "01",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:00 PM GMT on December 31, 2016",
		"year": "2016",
		"mon": "12",
		"mday": "31",
		"hour": "22",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"0.0", "tempi":"32.0","dewptm":"0.0", "dewpti":"32.0","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"2.5", "visi":"1.6","pressurem":"1005", "pressurei":"29.68","windchillm":"-5.9", "windchilli":"21.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312200Z 23007MPS 2500 -DZ BR OVC002 00/00 Q1005 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "1:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "01",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:30 PM GMT on December 31, 2016",
		"year": "2016",
		"mon": "12",
		"mday": "31",
		"hour": "22",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"0.0", "dewpti":"32.0","hum":"93","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1005", "pressurei":"29.68","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312230Z 24007MPS 3200 -DZ BR OVC002 01/00 Q1005 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "2:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "02",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:00 PM GMT on December 31, 2016",
		"year": "2016",
		"mon": "12",
		"mday": "31",
		"hour": "23",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"0.0", "dewpti":"32.0","hum":"93","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1005", "pressurei":"29.68","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312300Z 24007MPS 4400 -DZ BR OVC003 01/00 Q1005 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "2:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "02",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:30 PM GMT on December 31, 2016",
		"year": "2016",
		"mon": "12",
		"mday": "31",
		"hour": "23",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"0.0", "dewpti":"32.0","hum":"93","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"4.5", "visi":"2.8","pressurem":"1004", "pressurei":"29.65","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 312330Z 23007MPS 4500 BR OVC003 01/00 Q1004 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "3:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "03",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "00",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"7.0", "visi":"4.3","pressurem":"1004", "pressurei":"29.65","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010000Z 24007MPS 7000 -DZ OVC003 01/01 Q1004 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "3:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "03",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "00",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"8.0", "visi":"5.0","pressurem":"1004", "pressurei":"29.65","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010030Z 24007MPS 8000 OVC004 01/01 Q1004 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "4:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "04",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "01",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1004", "pressurei":"29.65","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010100Z 24007MPS 6000 -DZ OVC003 01/01 Q1004 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "4:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "04",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "01",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"28.8", "wspdi":"17.9","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1004", "pressurei":"29.65","windchillm":"-5.0", "windchilli":"23.0","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010130Z 24008MPS 9999 OVC004 01/01 Q1004 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "5:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "05",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "02",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"0.0", "dewpti":"32.0","hum":"93","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"9.0", "visi":"5.6","pressurem":"1003", "pressurei":"29.62","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010200Z 24007MPS 9000 -DZ OVC004 01/00 Q1003 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "5:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "05",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "02",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"0.0", "dewpti":"32.0","hum":"93","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1003", "pressurei":"29.62","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010230Z 24007MPS 6000 -DZ OVC003 01/00 Q1003 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "6:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "06",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "03",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"8.0", "visi":"5.0","pressurem":"1003", "pressurei":"29.62","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010300Z 24007MPS 8000 -DZ OVC004 01/01 Q1003 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "6:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "06",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "03",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1003", "pressurei":"29.62","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010330Z 24006MPS 9999 OVC004 01/01 Q1003 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "7:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "07",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "04",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"8.0", "visi":"5.0","pressurem":"1003", "pressurei":"29.62","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010400Z 24007MPS 8000 -DZ OVC004 01/01 Q1003 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "7:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "07",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "04",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"5.0", "visi":"3.1","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010430Z 24007MPS 5000 -DZ BR OVC003 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "8:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "08",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "05",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010500Z 24007MPS 9999 OVC003 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "8:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "08",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "05",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010530Z 24007MPS 9999 OVC004 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "9:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "09",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "06",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010600Z 25007MPS 9999 OVC005 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "9:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "09",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "06",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010630Z 25007MPS 9999 OVC005 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "10:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "10",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "07",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010700Z 24006MPS 9999 OVC004 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "10:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "10",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "07",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010730Z 24006MPS 9999 OVC004 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "11:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "11",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "08",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010800Z 25007MPS 9999 OVC004 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "11:30 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "11",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "08",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"250","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010830Z 25007MPS 9999 OVC003 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "12:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "12",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "09",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"6.0", "visi":"3.7","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010900Z 24006MPS 6000 -DZ OVC003 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "12:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "12",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "9:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "09",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"9.0", "visi":"5.6","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 010930Z 24006MPS 9000 -DZ OVC003 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "1:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "13",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "10",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"7.0", "visi":"4.3","pressurem":"1002", "pressurei":"29.59","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011000Z 24006MPS 7000 -DZ OVC002 01/01 Q1002 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "1:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "13",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "10:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "10",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1001", "pressurei":"29.56","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011030Z 24006MPS 9999 -DZ OVC003 01/01 Q1001 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "2:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "14",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:00 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "11",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1001", "pressurei":"29.56","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011100Z 24006MPS 9999 OVC003 01/01 Q1001 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "2:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "14",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "11:30 AM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "11",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"25.2", "wspdi":"15.7","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1001", "pressurei":"29.56","windchillm":"-4.6", "windchilli":"23.7","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011130Z 24007MPS 9999 OVC003 01/01 Q1001 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "3:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "15",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "12",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1001", "pressurei":"29.56","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Overcast","icon":"cloudy","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011200Z 24006MPS 9999 OVC003 01/01 Q1001 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "3:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "15",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "12:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "12",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1001", "pressurei":"29.56","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011230Z 24006MPS 9999 -DZ OVC004 01/01 Q1001 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "4:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "16",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "13",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"10.0", "visi":"6.2","pressurem":"1001", "pressurei":"29.56","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011300Z 24006MPS 9999 -DZ OVC004 01/01 Q1001 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "4:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "16",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "1:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "13",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"10.0", "visi":"6.2","pressurem":"1001", "pressurei":"29.56","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011330Z 23006MPS 9999 -DZ OVC003 01/01 Q1001 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "5:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "17",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "14",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1001", "pressurei":"29.56","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011400Z 24006MPS 4800 -DZ OVC003 01/01 Q1001 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "5:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "17",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "2:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "14",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"-9999.0", "visi":"-9999.0","pressurem":"1000", "pressurei":"29.53","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011430Z 24006MPS 4600 -DZ BR OVC004 01/01 Q1000 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "6:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "18",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "15",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"5.0", "visi":"3.1","pressurem":"1000", "pressurei":"29.53","windchillm":"-3.7", "windchilli":"25.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011500Z 24005MPS 5000 -DZ BR OVC003 01/01 Q1000 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "6:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "18",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "3:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "15",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"8.0", "visi":"5.0","pressurem":"1000", "pressurei":"29.53","windchillm":"-3.7", "windchilli":"25.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011530Z 24005MPS 8000 -DZ OVC004 01/01 Q1000 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "7:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "19",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "16",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"9.0", "visi":"5.6","pressurem":"1000", "pressurei":"29.53","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Rain Showers","icon":"rain","fog":"0","rain":"1","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011600Z 24006MPS 9000 -SHRA BKN004 OVC020CB 01/01 Q1000 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "7:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "19",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "4:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "16",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"10.0", "visi":"6.2","pressurem":"1000", "pressurei":"29.53","windchillm":"-3.7", "windchilli":"25.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Rain Showers","icon":"rain","fog":"0","rain":"1","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011630Z 23005MPS 9999 -SHRA BKN005 OVC020CB 01/01 Q1000 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "8:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "20",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "17",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"5.0", "visi":"3.1","pressurem":"1000", "pressurei":"29.53","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011700Z 23006MPS 5000 -DZ BR OVC003 01/01 Q1000 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "8:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "20",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "5:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "17",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"5.0", "visi":"3.1","pressurem":"999", "pressurei":"29.50","windchillm":"-3.7", "windchilli":"25.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011730Z 24005MPS 5000 -DZ BR OVC003 01/01 Q0999 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "9:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "21",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "18",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"240","wdire":"WSW","vism":"9.0", "visi":"5.6","pressurem":"999", "pressurei":"29.50","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011800Z 24006MPS 9000 -DZ OVC004 01/01 Q0999 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "9:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "21",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "6:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "18",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"6.0", "visi":"3.7","pressurem":"999", "pressurei":"29.50","windchillm":"-3.7", "windchilli":"25.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011830Z 23005MPS 6000 -DZ OVC004 01/01 Q0999 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "10:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "22",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "19",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"7.0", "visi":"4.3","pressurem":"999", "pressurei":"29.50","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011900Z 23006MPS 7000 -DZ OVC003 01/01 Q0999 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "10:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "22",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "7:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "19",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"7.0", "visi":"4.3","pressurem":"998", "pressurei":"29.47","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 011930Z 23006MPS 7000 -DZ OVC003 01/01 Q0998 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "11:00 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "23",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:00 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "20",
		"min": "00",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"21.6", "wspdi":"13.4","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"6.0", "visi":"3.7","pressurem":"998", "pressurei":"29.47","windchillm":"-4.2", "windchilli":"24.5","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 012000Z 23006MPS 6000 -DZ OVC003 01/01 Q0998 R24/510245 NOSIG" },
		{
		"date": {
		"pretty": "11:30 PM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "23",
		"min": "30",
		"tzname": "Europe/Moscow"
		},
		"utcdate": {
		"pretty": "8:30 PM GMT on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "20",
		"min": "30",
		"tzname": "UTC"
		},
		"tempm":"1.0", "tempi":"33.8","dewptm":"1.0", "dewpti":"33.8","hum":"100","wspdm":"18.0", "wspdi":"11.2","wgustm":"-9999.0", "wgusti":"-9999.0","wdird":"230","wdire":"SW","vism":"5.0", "visi":"3.1","pressurem":"998", "pressurei":"29.47","windchillm":"-3.7", "windchilli":"25.4","heatindexm":"-9999", "heatindexi":"-9999","precipm":"-9999.00", "precipi":"-9999.00","conds":"Light Drizzle","icon":"rain","fog":"0","rain":"0","snow":"0","hail":"0","thunder":"0","tornado":"0","metar":"METAR UUWW 012030Z 23005MPS 5000 -DZ OVC003 01/01 Q0998 R24/510245 NOSIG" }
		],
		"dailysummary": [
		{ "date": {
		"pretty": "12:00 AM MSK on January 01, 2017",
		"year": "2017",
		"mon": "01",
		"mday": "01",
		"hour": "00",
		"min": "00",
		"tzname": "Europe/Moscow"
		},
		"fog":"0","rain":"1","snow":"0","snowfallm":"", "snowfalli":"","monthtodatesnowfallm":"", "monthtodatesnowfalli":"","since1julsnowfallm":"", "since1julsnowfalli":"","snowdepthm":"", "snowdepthi":"","hail":"0","thunder":"0","tornado":"0","meantempm":"0", "meantempi":"32","meandewptm":"1", "meandewpti":"34","meanpressurem":"1001.75", "meanpressurei":"29.58","meanwindspdm":"22", "meanwindspdi":"14","meanwdire":"WSW","meanwdird":"239","meanvism":"8.0", "meanvisi":"4.9","humidity":"99","maxtempm":"1", "maxtempi":"33","mintempm":"0", "mintempi":"32","maxhumidity":"100","minhumidity":"93","maxdewptm":"1", "maxdewpti":"34","mindewptm":"0", "mindewpti":"32","maxpressurem":"1006", "maxpressurei":"29.71","minpressurem":"998", "minpressurei":"29.47","maxwspdm":"29", "maxwspdi":"18","minwspdm":"18", "minwspdi":"11","maxvism":"10.0", "maxvisi":"6.2","minvism":"2.5", "minvisi":"1.6","gdegreedays":"0","heatingdegreedays":"32","coolingdegreedays":"0","precipm":"0.0", "precipi":"0.00","precipsource":"3Or6HourObs","heatingdegreedaysnormal":"","monthtodateheatingdegreedays":"","monthtodateheatingdegreedaysnormal":"","since1sepheatingdegreedays":"","since1sepheatingdegreedaysnormal":"","since1julheatingdegreedays":"","since1julheatingdegreedaysnormal":"","coolingdegreedaysnormal":"","monthtodatecoolingdegreedays":"","monthtodatecoolingdegreedaysnormal":"","since1sepcoolingdegreedays":"","since1sepcoolingdegreedaysnormal":"","since1jancoolingdegreedays":"","since1jancoolingdegreedaysnormal":"" }
		]
	}
}
', '2017-01-01 00:00:00');


--
-- Data for Name: weather_daily_summary; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO weather_daily_summary (id, data, date, snowfallm, precipi, precipsource, since1julheatingdegreedays, snowfalli, precipm, meantempm, since1julsnowfallm, monthtodateheatingdegreedays, thunder, meantempi, since1julsnowfalli, meanvisi, since1jancoolingdegreedaysnormal, maxwspdi, meanvism, mintempm, minhumidity, mintempi, humidity, monthtodatecoolingdegreedaysnormal, maxwspdm, monthtodateheatingdegreedaysnormal, rain, gdegreedays, since1sepcoolingdegreedaysnormal, monthtodatecoolingdegreedays, since1sepheatingdegreedaysnormal, heatingdegreedaysnormal, monthtodatesnowfalli, mindewptm, snow, monthtodatesnowfallm, mindewpti, heatingdegreedays, snowdepthm, maxdewptm, fog, snowdepthi, maxdewpti, maxtempm, minwspdi, maxtempi, since1sepcoolingdegreedays, meanpressurem, minwspdm, coolingdegreedaysnormal, minpressurem, minvisi, tornado, meandewpti, maxhumidity, minpressurei, minvism, meandewptm, maxpressurem, since1jancoolingdegreedays, hail, meanwindspdm, maxpressurei, meanwdire, since1julheatingdegreedaysnormal, meanwdird, maxvism, since1sepheatingdegreedays, meanwindspdi, maxvisi, meanpressurei, coolingdegreedays) VALUES (1, '{"date":{"pretty":"12:00 AM MSK on February 25, 2005","min":"00","hour":"00","year":"2005","mday":"25","mon":"02","tzname":"Europe/Moscow"},"snowfallm":"","precipi":"0.00","precipsource":"3Or6HourObs","since1julheatingdegreedays":"","snowfalli":"","precipm":"0.0","meantempm":"-10","since1julsnowfallm":"","monthtodateheatingdegreedays":"","thunder":"0","meantempi":"12","since1julsnowfalli":"","meanvisi":"2.6","since1jancoolingdegreedaysnormal":"","maxwspdi":"9","meanvism":"4.1","mintempm":"-14","minhumidity":"63","mintempi":"6","humidity":"80","monthtodatecoolingdegreedaysnormal":"","maxwspdm":"14","monthtodateheatingdegreedaysnormal":"","rain":"0","gdegreedays":"0","since1sepcoolingdegreedaysnormal":"","monthtodatecoolingdegreedays":"","since1sepheatingdegreedaysnormal":"","heatingdegreedaysnormal":"","monthtodatesnowfalli":"","mindewptm":"-16","snow":"1","monthtodatesnowfallm":"","mindewpti":"3","heatingdegreedays":"52","snowdepthm":"","maxdewptm":"-11","fog":"0","snowdepthi":"","maxdewpti":"12","maxtempm":"-7","minwspdi":"0","maxtempi":"19","since1sepcoolingdegreedays":"","meanpressurem":"1020.64","minwspdm":"0","coolingdegreedaysnormal":"","minpressurem":"1013","minvisi":"1.4","tornado":"0","meandewpti":"8","maxhumidity":"93","minpressurei":"29.92","minvism":"2.2","meandewptm":"-13","maxpressurem":"1028","since1jancoolingdegreedays":"","hail":"0","meanwindspdm":"8","maxpressurei":"30.36","meanwdire":"SSW","since1julheatingdegreedaysnormal":"","meanwdird":"213","maxvism":"10.0","since1sepheatingdegreedays":"","meanwindspdi":"5","maxvisi":"6.2","meanpressurei":"30.14","coolingdegreedays":"0"}', '2005-02-25 00:00:00', 1, 0, NULL, NULL, NULL, 0, -10, NULL, NULL, 0, 12, NULL, 2.6, NULL, 9, 4.1, -14, 63, 6, 80, NULL, 14, NULL, 0, 0, NULL, NULL, NULL, 52, NULL, -16, NULL, NULL, 3, NULL, NULL, -11, 0, NULL, 12, -7, 0, 19, NULL, 1020.64, 0, 0, 1013, 1.4, 0, 8, 93, 29.92, 2.2, -13, 1028, NULL, 0, 8, 30.36, NULL, NULL, 213, 10, NULL, 5, 6.2, 30.14, NULL);
INSERT INTO weather_daily_summary (id, data, date, snowfallm, precipi, precipsource, since1julheatingdegreedays, snowfalli, precipm, meantempm, since1julsnowfallm, monthtodateheatingdegreedays, thunder, meantempi, since1julsnowfalli, meanvisi, since1jancoolingdegreedaysnormal, maxwspdi, meanvism, mintempm, minhumidity, mintempi, humidity, monthtodatecoolingdegreedaysnormal, maxwspdm, monthtodateheatingdegreedaysnormal, rain, gdegreedays, since1sepcoolingdegreedaysnormal, monthtodatecoolingdegreedays, since1sepheatingdegreedaysnormal, heatingdegreedaysnormal, monthtodatesnowfalli, mindewptm, snow, monthtodatesnowfallm, mindewpti, heatingdegreedays, snowdepthm, maxdewptm, fog, snowdepthi, maxdewpti, maxtempm, minwspdi, maxtempi, since1sepcoolingdegreedays, meanpressurem, minwspdm, coolingdegreedaysnormal, minpressurem, minvisi, tornado, meandewpti, maxhumidity, minpressurei, minvism, meandewptm, maxpressurem, since1jancoolingdegreedays, hail, meanwindspdm, maxpressurei, meanwdire, since1julheatingdegreedaysnormal, meanwdird, maxvism, since1sepheatingdegreedays, meanwindspdi, maxvisi, meanpressurei, coolingdegreedays) VALUES (2, '{"date":{"pretty":"12:00 AM MSK on February 01, 2017","min":"00","hour":"00","year":"2017","mday":"01","mon":"02","tzname":"Europe/Moscow"},"snowfallm":"","precipi":"0.00","precipsource":"3Or6HourObs","since1julheatingdegreedays":"","snowfalli":"","precipm":"0.0","meantempm":"-5","since1julsnowfallm":"","monthtodateheatingdegreedays":"","thunder":"0","meantempi":"22","since1julsnowfalli":"","meanvisi":"5.0","since1jancoolingdegreedaysnormal":"","maxwspdi":"16","meanvism":"8.1","mintempm":"-8","minhumidity":"74","mintempi":"17","humidity":"86","monthtodatecoolingdegreedaysnormal":"","maxwspdm":"25","monthtodateheatingdegreedaysnormal":"","rain":"0","gdegreedays":"0","since1sepcoolingdegreedaysnormal":"","monthtodatecoolingdegreedays":"","since1sepheatingdegreedaysnormal":"","heatingdegreedaysnormal":"","monthtodatesnowfalli":"","mindewptm":"-10","snow":"1","monthtodatesnowfallm":"","mindewpti":"14","heatingdegreedays":"42","snowdepthm":"","maxdewptm":"-5","fog":"0","snowdepthi":"","maxdewpti":"23","maxtempm":"-2","minwspdi":"9","maxtempi":"28","since1sepcoolingdegreedays":"","meanpressurem":"1018.35","minwspdm":"14","coolingdegreedaysnormal":"","minpressurem":"1018","minvisi":"3.1","tornado":"0","meandewpti":"20","maxhumidity":"100","minpressurei":"30.06","minvism":"5.0","meandewptm":"-7","maxpressurem":"1020","since1jancoolingdegreedays":"","hail":"0","meanwindspdm":"16","maxpressurei":"30.12","meanwdire":"WNW","since1julheatingdegreedaysnormal":"","meanwdird":"284","maxvism":"10.0","since1sepheatingdegreedays":"","meanwindspdi":"10","maxvisi":"6.2","meanpressurei":"30.07","coolingdegreedays":"0"}', '2017-02-01 00:00:00', 1, 0, NULL, NULL, NULL, 0, -5, NULL, NULL, 0, 22, NULL, 5, NULL, 16, 8.1, -8, 74, 17, 86, NULL, 25, NULL, 0, 0, NULL, NULL, NULL, 42, NULL, -10, NULL, NULL, 14, NULL, NULL, -5, 0, NULL, 23, -2, 9, 28, NULL, 1018.35, 14, 0, 1018, 3.1, 0, 20, 100, 30.06, 5, -7, 1020, NULL, 0, 16, 30.12, NULL, NULL, 284, 10, NULL, 10, 6.2, 30.07, NULL);
INSERT INTO weather_daily_summary (id, data, date, snowfallm, precipi, precipsource, since1julheatingdegreedays, snowfalli, precipm, meantempm, since1julsnowfallm, monthtodateheatingdegreedays, thunder, meantempi, since1julsnowfalli, meanvisi, since1jancoolingdegreedaysnormal, maxwspdi, meanvism, mintempm, minhumidity, mintempi, humidity, monthtodatecoolingdegreedaysnormal, maxwspdm, monthtodateheatingdegreedaysnormal, rain, gdegreedays, since1sepcoolingdegreedaysnormal, monthtodatecoolingdegreedays, since1sepheatingdegreedaysnormal, heatingdegreedaysnormal, monthtodatesnowfalli, mindewptm, snow, monthtodatesnowfallm, mindewpti, heatingdegreedays, snowdepthm, maxdewptm, fog, snowdepthi, maxdewpti, maxtempm, minwspdi, maxtempi, since1sepcoolingdegreedays, meanpressurem, minwspdm, coolingdegreedaysnormal, minpressurem, minvisi, tornado, meandewpti, maxhumidity, minpressurei, minvism, meandewptm, maxpressurem, since1jancoolingdegreedays, hail, meanwindspdm, maxpressurei, meanwdire, since1julheatingdegreedaysnormal, meanwdird, maxvism, since1sepheatingdegreedays, meanwindspdi, maxvisi, meanpressurei, coolingdegreedays) VALUES (5, '{"date":{"pretty":"12:00 AM MSK on January 01, 2017","min":"00","hour":"00","year":"2017","mday":"01","mon":"01","tzname":"Europe/Moscow"},"snowfallm":"","precipi":"0.00","precipsource":"3Or6HourObs","since1julheatingdegreedays":"","snowfalli":"","precipm":"0.0","meantempm":"0","since1julsnowfallm":"","monthtodateheatingdegreedays":"","thunder":"0","meantempi":"32","since1julsnowfalli":"","meanvisi":"4.9","since1jancoolingdegreedaysnormal":"","maxwspdi":"18","meanvism":"8.0","mintempm":"0","minhumidity":"93","mintempi":"32","humidity":"99","monthtodatecoolingdegreedaysnormal":"","maxwspdm":"29","monthtodateheatingdegreedaysnormal":"","rain":"1","gdegreedays":"0","since1sepcoolingdegreedaysnormal":"","monthtodatecoolingdegreedays":"","since1sepheatingdegreedaysnormal":"","heatingdegreedaysnormal":"","monthtodatesnowfalli":"","mindewptm":"0","snow":"0","monthtodatesnowfallm":"","mindewpti":"32","heatingdegreedays":"32","snowdepthm":"","maxdewptm":"1","fog":"0","snowdepthi":"","maxdewpti":"34","maxtempm":"1","minwspdi":"11","maxtempi":"33","since1sepcoolingdegreedays":"","meanpressurem":"1001.75","minwspdm":"18","coolingdegreedaysnormal":"","minpressurem":"998","minvisi":"1.6","tornado":"0","meandewpti":"34","maxhumidity":"100","minpressurei":"29.47","minvism":"2.5","meandewptm":"1","maxpressurem":"1006","since1jancoolingdegreedays":"","hail":"0","meanwindspdm":"22","maxpressurei":"29.71","meanwdire":"WSW","since1julheatingdegreedaysnormal":"","meanwdird":"239","maxvism":"10.0","since1sepheatingdegreedays":"","meanwindspdi":"14","maxvisi":"6.2","meanpressurei":"29.58","coolingdegreedays":"0"}', '2017-01-01 00:00:00', 0, 0, NULL, NULL, NULL, 0, 0, NULL, NULL, 0, 32, NULL, 4.9, NULL, 18, 8, 0, 93, 32, 99, NULL, 29, NULL, 1, 0, NULL, NULL, NULL, 32, NULL, 0, NULL, NULL, 32, NULL, NULL, 1, 0, NULL, 34, 1, 11, 33, NULL, 1001.75, 18, 0, 998, 1.6, 0, 34, 100, 29.47, 2.5, 1, 1006, NULL, 0, 22, 29.71, NULL, NULL, 239, 10, NULL, 14, 6.2, 29.58, NULL);


--
-- Name: weather_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('weather_id_seq', 5, true);


--
-- Name: hostname_stat_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hostname_stat
    ADD CONSTRAINT hostname_stat_id_pk PRIMARY KEY (id);


--
-- Name: recommendation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recommendation
    ADD CONSTRAINT recommendation_pkey PRIMARY KEY (id);


--
-- Name: table_name_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY settings
    ADD CONSTRAINT table_name_pkey PRIMARY KEY (key);


--
-- Name: weather_daily_summary_id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY weather_daily_summary
    ADD CONSTRAINT weather_daily_summary_id_pk PRIMARY KEY (id);


--
-- Name: weather_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY weather
    ADD CONSTRAINT weather_pkey PRIMARY KEY (id);


--
-- Name: hostname_stat_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX hostname_stat_id_uindex ON hostname_stat USING btree (id);


--
-- Name: recommendation_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX recommendation_id_uindex ON recommendation USING btree (id);


--
-- Name: table_name_key_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX table_name_key_uindex ON settings USING btree (key);


--
-- Name: weather_ID_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX "weather_ID_uindex" ON weather USING btree (id);


--
-- Name: weather_daily_summary_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX weather_daily_summary_id_uindex ON weather_daily_summary USING btree (id);


--
-- Name: weather_date_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX weather_date_uindex ON weather USING btree (date);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

