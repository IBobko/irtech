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
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hostname_stat ALTER COLUMN id SET DEFAULT nextval('seq_hostnamestat'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recommendation ALTER COLUMN id SET DEFAULT nextval('seq_recommendation'::regclass);


--
-- Data for Name: hostname_stat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY hostname_stat (id, hostname, "time", user_ip) FROM stdin;
1	http://localhost:9001/	2017-05-28 19:29:02.583	127.0.0.1                                                                                                                                                                                                                                                      
\.


--
-- Data for Name: recommendation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recommendation (id, data) FROM stdin;
\.


--
-- Name: seq_hostnamestat; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_hostnamestat', 1, true);


--
-- Name: seq_recommendation; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_recommendation', 1, false);


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
-- Name: hostname_stat_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX hostname_stat_id_uindex ON hostname_stat USING btree (id);


--
-- Name: recommendation_id_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX recommendation_id_uindex ON recommendation USING btree (id);


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

