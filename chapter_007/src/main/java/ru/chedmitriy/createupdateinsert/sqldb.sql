--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.5
-- Dumped by pg_dump version 9.6.5

-- Started on 2017-12-08 08:49:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2232 (class 1262 OID 16575)
-- Name: sql_module; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE sql_module WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE sql_module OWNER TO postgres;

\connect sql_module

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 200 (class 1259 OID 17086)
-- Name: attach; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE attach (
    id integer NOT NULL,
    file_name text,
    file_size_kb bigint,
    items_id integer
);


ALTER TABLE attach OWNER TO chedmitry;

--
-- TOC entry 199 (class 1259 OID 17084)
-- Name: attach_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE attach_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE attach_id_seq OWNER TO chedmitry;

--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 199
-- Name: attach_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE attach_id_seq OWNED BY attach.id;


--
-- TOC entry 198 (class 1259 OID 17075)
-- Name: category; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE category (
    id integer NOT NULL,
    category_name text
);


ALTER TABLE category OWNER TO chedmitry;

--
-- TOC entry 197 (class 1259 OID 17073)
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE category_id_seq OWNER TO chedmitry;

--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 197
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE category_id_seq OWNED BY category.id;


--
-- TOC entry 190 (class 1259 OID 17037)
-- Name: item_comments; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE item_comments (
    id integer NOT NULL,
    bibliography text,
    items_id integer
);


ALTER TABLE item_comments OWNER TO chedmitry;

--
-- TOC entry 189 (class 1259 OID 17035)
-- Name: item_comments_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE item_comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE item_comments_id_seq OWNER TO chedmitry;

--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 189
-- Name: item_comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE item_comments_id_seq OWNED BY item_comments.id;


--
-- TOC entry 188 (class 1259 OID 17026)
-- Name: items; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE items (
    id integer NOT NULL,
    items_name character varying(100),
    items_description text,
    categories_id integer,
    state_id integer,
    user_id integer
);


ALTER TABLE items OWNER TO chedmitry;

--
-- TOC entry 187 (class 1259 OID 17024)
-- Name: items_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE items_id_seq OWNER TO chedmitry;

--
-- TOC entry 2238 (class 0 OID 0)
-- Dependencies: 187
-- Name: items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE items_id_seq OWNED BY items.id;


--
-- TOC entry 192 (class 1259 OID 17048)
-- Name: role; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE role (
    id integer NOT NULL,
    role_name character varying(20)
);


ALTER TABLE role OWNER TO chedmitry;

--
-- TOC entry 191 (class 1259 OID 17046)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE role_id_seq OWNER TO chedmitry;

--
-- TOC entry 2239 (class 0 OID 0)
-- Dependencies: 191
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE role_id_seq OWNED BY role.id;


--
-- TOC entry 194 (class 1259 OID 17056)
-- Name: rules; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE rules (
    id integer NOT NULL,
    description text
);


ALTER TABLE rules OWNER TO chedmitry;

--
-- TOC entry 193 (class 1259 OID 17054)
-- Name: rules_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE rules_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rules_id_seq OWNER TO chedmitry;

--
-- TOC entry 2240 (class 0 OID 0)
-- Dependencies: 193
-- Name: rules_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE rules_id_seq OWNED BY rules.id;


--
-- TOC entry 203 (class 1259 OID 17099)
-- Name: rules_of_role; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE rules_of_role (
    role_id integer NOT NULL,
    rule_id integer NOT NULL
);


ALTER TABLE rules_of_role OWNER TO chedmitry;

--
-- TOC entry 201 (class 1259 OID 17095)
-- Name: rules_of_role_role_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE rules_of_role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rules_of_role_role_id_seq OWNER TO chedmitry;

--
-- TOC entry 2241 (class 0 OID 0)
-- Dependencies: 201
-- Name: rules_of_role_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE rules_of_role_role_id_seq OWNED BY rules_of_role.role_id;


--
-- TOC entry 202 (class 1259 OID 17097)
-- Name: rules_of_role_rule_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE rules_of_role_rule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rules_of_role_rule_id_seq OWNER TO chedmitry;

--
-- TOC entry 2242 (class 0 OID 0)
-- Dependencies: 202
-- Name: rules_of_role_rule_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE rules_of_role_rule_id_seq OWNED BY rules_of_role.rule_id;


--
-- TOC entry 196 (class 1259 OID 17067)
-- Name: state; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE state (
    id integer NOT NULL,
    state_of_execution character varying(20)
);


ALTER TABLE state OWNER TO chedmitry;

--
-- TOC entry 195 (class 1259 OID 17065)
-- Name: state_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE state_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE state_id_seq OWNER TO chedmitry;

--
-- TOC entry 2243 (class 0 OID 0)
-- Dependencies: 195
-- Name: state_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE state_id_seq OWNED BY state.id;


--
-- TOC entry 186 (class 1259 OID 17018)
-- Name: users; Type: TABLE; Schema: public; Owner: chedmitry
--

CREATE TABLE users (
    id integer NOT NULL,
    name character varying(25),
    gender character varying(5),
    address character varying(25),
    e_mail character varying(25),
    phone_number character varying(20),
    create_date timestamp without time zone,
    role_id integer
);


ALTER TABLE users OWNER TO chedmitry;

--
-- TOC entry 185 (class 1259 OID 17016)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: chedmitry
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO chedmitry;

--
-- TOC entry 2244 (class 0 OID 0)
-- Dependencies: 185
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: chedmitry
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 2063 (class 2604 OID 17089)
-- Name: attach id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY attach ALTER COLUMN id SET DEFAULT nextval('attach_id_seq'::regclass);


--
-- TOC entry 2062 (class 2604 OID 17078)
-- Name: category id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY category ALTER COLUMN id SET DEFAULT nextval('category_id_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 17040)
-- Name: item_comments id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY item_comments ALTER COLUMN id SET DEFAULT nextval('item_comments_id_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 17029)
-- Name: items id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY items ALTER COLUMN id SET DEFAULT nextval('items_id_seq'::regclass);


--
-- TOC entry 2059 (class 2604 OID 17051)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY role ALTER COLUMN id SET DEFAULT nextval('role_id_seq'::regclass);


--
-- TOC entry 2060 (class 2604 OID 17059)
-- Name: rules id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY rules ALTER COLUMN id SET DEFAULT nextval('rules_id_seq'::regclass);


--
-- TOC entry 2064 (class 2604 OID 17102)
-- Name: rules_of_role role_id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY rules_of_role ALTER COLUMN role_id SET DEFAULT nextval('rules_of_role_role_id_seq'::regclass);


--
-- TOC entry 2065 (class 2604 OID 17103)
-- Name: rules_of_role rule_id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY rules_of_role ALTER COLUMN rule_id SET DEFAULT nextval('rules_of_role_rule_id_seq'::regclass);


--
-- TOC entry 2061 (class 2604 OID 17070)
-- Name: state id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY state ALTER COLUMN id SET DEFAULT nextval('state_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 17021)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2224 (class 0 OID 17086)
-- Dependencies: 200
-- Data for Name: attach; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO attach (id, file_name, file_size_kb, items_id) VALUES (1, 'Работа с объектами', 253000, 1);
INSERT INTO attach (id, file_name, file_size_kb, items_id) VALUES (2, 'Переопределение методов equals() и hashcode()', 331450, 2);
INSERT INTO attach (id, file_name, file_size_kb, items_id) VALUES (3, 'Анонимные классы', 452567, 3);


--
-- TOC entry 2245 (class 0 OID 0)
-- Dependencies: 199
-- Name: attach_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('attach_id_seq', 3, true);


--
-- TOC entry 2222 (class 0 OID 17075)
-- Dependencies: 198
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO category (id, category_name) VALUES (1, 'модуль_1: Создание и уничтожение объектов');
INSERT INTO category (id, category_name) VALUES (2, 'модуль_2: Методы общие для всех классов');
INSERT INTO category (id, category_name) VALUES (3, 'модуль_3: классы и интерфейсы');


--
-- TOC entry 2246 (class 0 OID 0)
-- Dependencies: 197
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('category_id_seq', 3, true);


--
-- TOC entry 2214 (class 0 OID 17037)
-- Dependencies: 190
-- Data for Name: item_comments; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO item_comments (id, bibliography, items_id) VALUES (1, 'Шилдт,Герберт. Java 8: руководство для начинающих, 6-е изд. : Пер. с англ. - М.
			ООО "И.Д. Вильяме", 2015. - 720 с.: ил. - Парал. тит. англ', 1);
INSERT INTO item_comments (id, bibliography, items_id) VALUES (2, 'Эккель Б.Философия java.4-е полное изд.- СПБ.: 
			Питер, 2015. - 1168 с.: ил. - (Серия "Классика computer science"', 2);
INSERT INTO item_comments (id, bibliography, items_id) VALUES (3, 'Хорстманн,Кей С, Корнелл, Гари.Х82  Java 2. Библиотека профессионала, том 1.
			Основы. 8-е издание.: Пер. с англ. — М.: ООО "И.Д. Вильяме", 2012. - 816 с.: ил. - Парал. тит. англ.', 3);


--
-- TOC entry 2247 (class 0 OID 0)
-- Dependencies: 189
-- Name: item_comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('item_comments_id_seq', 3, true);


--
-- TOC entry 2212 (class 0 OID 17026)
-- Dependencies: 188
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO items (id, items_name, items_description, categories_id, state_id, user_id) VALUES (1, 'задача_1', 'Приложение "Hello World!"', 1, 1, 6);
INSERT INTO items (id, items_name, items_description, categories_id, state_id, user_id) VALUES (2, 'задача_3', 'Переопределение методов equals() и hashCode()', 2, 2, 5);
INSERT INTO items (id, items_name, items_description, categories_id, state_id, user_id) VALUES (3, 'задача_2', 'Создать анонимный класс', 3, 2, 2);


--
-- TOC entry 2248 (class 0 OID 0)
-- Dependencies: 187
-- Name: items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('items_id_seq', 3, true);


--
-- TOC entry 2216 (class 0 OID 17048)
-- Dependencies: 192
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO role (id, role_name) VALUES (1, 'student');
INSERT INTO role (id, role_name) VALUES (2, 'moderator');
INSERT INTO role (id, role_name) VALUES (3, 'administrator');


--
-- TOC entry 2249 (class 0 OID 0)
-- Dependencies: 191
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('role_id_seq', 3, true);


--
-- TOC entry 2218 (class 0 OID 17056)
-- Dependencies: 194
-- Data for Name: rules; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO rules (id, description) VALUES (1, 'выполненение заданий');
INSERT INTO rules (id, description) VALUES (2, 'проверка заданий');
INSERT INTO rules (id, description) VALUES (3, 'Управление настройками сайта(например,
		 смена названия группы, фото обложки или настроек конфиденциальности),
			проверка заданий');


--
-- TOC entry 2250 (class 0 OID 0)
-- Dependencies: 193
-- Name: rules_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('rules_id_seq', 3, true);


--
-- TOC entry 2227 (class 0 OID 17099)
-- Dependencies: 203
-- Data for Name: rules_of_role; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO rules_of_role (role_id, rule_id) VALUES (1, 3);
INSERT INTO rules_of_role (role_id, rule_id) VALUES (2, 2);
INSERT INTO rules_of_role (role_id, rule_id) VALUES (3, 1);


--
-- TOC entry 2251 (class 0 OID 0)
-- Dependencies: 201
-- Name: rules_of_role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('rules_of_role_role_id_seq', 1, false);


--
-- TOC entry 2252 (class 0 OID 0)
-- Dependencies: 202
-- Name: rules_of_role_rule_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('rules_of_role_rule_id_seq', 1, false);


--
-- TOC entry 2220 (class 0 OID 17067)
-- Dependencies: 196
-- Data for Name: state; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO state (id, state_of_execution) VALUES (1, 'ожидает проверки');
INSERT INTO state (id, state_of_execution) VALUES (2, 'выполняется');
INSERT INTO state (id, state_of_execution) VALUES (3, 'закрыта');


--
-- TOC entry 2253 (class 0 OID 0)
-- Dependencies: 195
-- Name: state_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('state_id_seq', 3, true);


--
-- TOC entry 2210 (class 0 OID 17018)
-- Dependencies: 186
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: chedmitry
--

INSERT INTO users (id, name, gender, address, e_mail, phone_number, create_date, role_id) VALUES (1, 'Александр', 'муж', 'Севастополь', 'alexmail@mail.ru', '978-111-222-3', '2017-10-01 00:00:00', 3);
INSERT INTO users (id, name, gender, address, e_mail, phone_number, create_date, role_id) VALUES (2, 'Евгения', 'жен', 'Ялта', 'evg@mail.ru', '978-555-552-3', '2017-10-05 00:00:00', 1);
INSERT INTO users (id, name, gender, address, e_mail, phone_number, create_date, role_id) VALUES (4, 'Евгения', 'жен', 'Москва', 'evgen@mail.ru', '978-189-98-8', '2017-11-05 00:00:00', 2);
INSERT INTO users (id, name, gender, address, e_mail, phone_number, create_date, role_id) VALUES (5, 'Максим', 'муж', 'Севастополь', 'maxmail@mail.ru', '978-311-202-3', '2017-10-01 00:00:00', 1);
INSERT INTO users (id, name, gender, address, e_mail, phone_number, create_date, role_id) VALUES (6, 'Федор', 'жен', 'Ялта', 'fedmail@mail.ru', '978-505-452-1', '2017-10-07 00:00:00', 1);


--
-- TOC entry 2254 (class 0 OID 0)
-- Dependencies: 185
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: chedmitry
--

SELECT pg_catalog.setval('users_id_seq', 6, true);


--
-- TOC entry 2081 (class 2606 OID 17094)
-- Name: attach attach_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY attach
    ADD CONSTRAINT attach_pkey PRIMARY KEY (id);


--
-- TOC entry 2079 (class 2606 OID 17083)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- TOC entry 2071 (class 2606 OID 17045)
-- Name: item_comments item_comments_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY item_comments
    ADD CONSTRAINT item_comments_pkey PRIMARY KEY (id);


--
-- TOC entry 2069 (class 2606 OID 17034)
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);


--
-- TOC entry 2073 (class 2606 OID 17053)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2083 (class 2606 OID 17105)
-- Name: rules_of_role rules_of_role_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY rules_of_role
    ADD CONSTRAINT rules_of_role_pkey PRIMARY KEY (role_id, rule_id);


--
-- TOC entry 2075 (class 2606 OID 17064)
-- Name: rules rules_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY rules
    ADD CONSTRAINT rules_pkey PRIMARY KEY (id);


--
-- TOC entry 2077 (class 2606 OID 17072)
-- Name: state state_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY state
    ADD CONSTRAINT state_pkey PRIMARY KEY (id);


--
-- TOC entry 2067 (class 2606 OID 17023)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2089 (class 2606 OID 17111)
-- Name: attach attach_items_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY attach
    ADD CONSTRAINT attach_items_id_fkey FOREIGN KEY (items_id) REFERENCES items(id);


--
-- TOC entry 2088 (class 2606 OID 17106)
-- Name: item_comments item_comments_items_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY item_comments
    ADD CONSTRAINT item_comments_items_id_fkey FOREIGN KEY (items_id) REFERENCES items(id);


--
-- TOC entry 2085 (class 2606 OID 17116)
-- Name: items items_categories_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY items
    ADD CONSTRAINT items_categories_id_fkey FOREIGN KEY (categories_id) REFERENCES category(id);


--
-- TOC entry 2086 (class 2606 OID 17121)
-- Name: items items_state_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY items
    ADD CONSTRAINT items_state_id_fkey FOREIGN KEY (state_id) REFERENCES state(id);


--
-- TOC entry 2087 (class 2606 OID 17131)
-- Name: items items_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY items
    ADD CONSTRAINT items_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2090 (class 2606 OID 17136)
-- Name: rules_of_role rules_of_role_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY rules_of_role
    ADD CONSTRAINT rules_of_role_role_id_fkey FOREIGN KEY (role_id) REFERENCES role(id);


--
-- TOC entry 2091 (class 2606 OID 17141)
-- Name: rules_of_role rules_of_role_rule_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY rules_of_role
    ADD CONSTRAINT rules_of_role_rule_id_fkey FOREIGN KEY (rule_id) REFERENCES rules(id);


--
-- TOC entry 2084 (class 2606 OID 17126)
-- Name: users users_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: chedmitry
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_role_id_fkey FOREIGN KEY (role_id) REFERENCES role(id);


-- Completed on 2017-12-08 08:49:06

--
-- PostgreSQL database dump complete
--

