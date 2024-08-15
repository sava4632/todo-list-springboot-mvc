--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-08-15 19:01:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 16439)
-- Name: tasks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tasks (
    id integer NOT NULL,
    title character varying(255) NOT NULL,
    description character varying(255),
    completed boolean DEFAULT false NOT NULL,
    due_date date,
    user_id integer NOT NULL
);


ALTER TABLE public.tasks OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16438)
-- Name: tasks_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tasks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tasks_id_seq OWNER TO postgres;

--
-- TOC entry 4857 (class 0 OID 0)
-- Dependencies: 217
-- Name: tasks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;


--
-- TOC entry 216 (class 1259 OID 16426)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16425)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 4858 (class 0 OID 0)
-- Dependencies: 215
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 4694 (class 2604 OID 16442)
-- Name: tasks id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);


--
-- TOC entry 4693 (class 2604 OID 16429)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 4851 (class 0 OID 16439)
-- Dependencies: 218
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tasks (id, title, description, completed, due_date, user_id) FROM stdin;
2	Preparar presentación para conferencia	Preparar los slides y la documentación para la próxima conferencia.	f	2024-07-20	2
3	Reunión con clientes	Organizar y llevar a cabo la reunión con los clientes.	t	2024-06-30	3
4	Actualizar la base de datos de clientes	Actualizar la información de los clientes en la base de datos central.	f	2024-07-10	4
5	Planificar el presupuesto anual	Revisar y planificar el presupuesto anual para el próximo año fiscal.	f	2024-08-01	5
24	Enviar reporte mensual	Enviar el reporte mensual de actividades al supervisor.	t	2024-08-05	9
25	Revisar presupuesto del trimestre	Revisar y ajustar el presupuesto del trimestre actual.	t	2024-08-10	9
26	Organizar reunión de equipo	Coordinar y organizar la reunión de equipo para la próxima semana.	t	2024-08-15	9
23	Completar informe de análisis	Finalizar el informe de análisis de datos para el proyecto.	t	2024-07-30	9
31	Finish the project documentation	Complete the final documentation for the project	f	2024-07-15	9
37	Comprar comestibles	Comprar frutas y verduras frescas en el mercado.	t	2024-08-20	27
38	Reparar la puerta	Arreglar la puerta del garaje que está desalineada.	t	2024-08-18	27
39	Pagar la factura de electricidad	Realizar el pago de la factura antes de la fecha de vencimiento.	t	2024-08-15	27
40	Llamar al dentista	Programar una cita para la limpieza dental.	t	2024-08-10	27
41	Limpiar el garaje	Organizar las herramientas y limpiar el garaje.	t	2024-08-17	27
42	Terminar el libro	Leer los últimos capítulos del libro "El Alquimista".	t	2024-08-12	27
43	Enviar el informe mensual	Completar y enviar el informe mensual al jefe.	t	2024-08-09	27
44	Lavar el coche	Lavar y aspirar el interior del coche.	t	2024-08-11	27
45	Actualizar el currículum	Agregar la última experiencia laboral al currículum.	t	2024-08-16	27
46	Planear las vacaciones	Buscar hoteles y vuelos para las vacaciones de septiembre.	t	2024-08-14	27
47	Hacer la declaración de impuestos	Revisar todos los documentos necesarios para la declaración.	f	2024-08-25	27
48	Comprar un regalo de cumpleaños	Buscar un regalo para el cumpleaños de Ana.	f	2024-08-22	27
49	Organizar el armario	Clasificar y donar la ropa que ya no uso.	f	2024-08-30	27
50	Redecorar el salón	Comprar nuevos cojines y cortinas para el salón.	f	2024-08-28	27
34	Actualizar documentación del proyecto	Actualizar la documentación del proyecto con la última información.	t	2024-08-20	9
51	Revisar el coche	Llevar el coche al taller para una revisión general.	f	2024-08-26	27
33	Finish the project documentation	Complete the final documentation for the project	f	2024-07-15	9
35	Finish the project documentation	Complete the final documentation for the project	f	2024-07-15	9
57	Actualizar la base de datos 	Revisar y actualizar la base de datos del proyecto	f	2024-08-24	27
52	Preparar la presentación	Crear las diapositivas para la presentación del lunes.	f	2024-08-24	27
53	Asistir a la reunión de vecinos	Participar en la reunión mensual de la comunidad.	f	2024-08-21	27
54	Cocinar una cena especial	Preparar una cena especial para la familia.	f	2024-08-19	27
36	Aprender una nueva receta	Practicar la receta de pasta casera.	f	2024-08-29	27
\.


--
-- TOC entry 4849 (class 0 OID 16426)
-- Dependencies: 216
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, username, email, password) FROM stdin;
1	alice	alice@example.com	$2a$10$DYvGbrFmNMjPmZfQq8Y2/uEs.L3h6CfbMv7v2Unr9bM1hD0a6HqHW
2	bob	bob@example.com	$2a$10$g4B.NBn2M5ns3RReM5oH0u/5Wjft.zfwOPJlUx5hU7VJUe2emt/8K
3	charlie	charlie@example.com	$2a$10$3sZ41g.Vm2lRj2EqIcN4yOVF7HszCKtRlQO1s2oZoM/1abM.UayrG
4	david	david@example.com	$2a$10$S1.J7S1QQ64Bw5jIEwRoi.ROknW4nUUMGYGwO0oMXrGyHLoBkcm/K
5	emma	emma@example.com	$2a$10$B9ev.3TJd86fBkHb16lG7urHaUNy0BSesDfC4PLkALbPU5p45egdG
9	john_doe_upt	john.doe@example.com	securepassword
26	izangamer	izan@gmail.com	izan1234
27	samuel	samuel@gmail.com	sfva2468
\.


--
-- TOC entry 4859 (class 0 OID 0)
-- Dependencies: 217
-- Name: tasks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tasks_id_seq', 76, true);


--
-- TOC entry 4860 (class 0 OID 0)
-- Dependencies: 215
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 27, true);


--
-- TOC entry 4703 (class 2606 OID 16447)
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);


--
-- TOC entry 4697 (class 2606 OID 16460)
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- TOC entry 4699 (class 2606 OID 16433)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4701 (class 2606 OID 16470)
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- TOC entry 4704 (class 2606 OID 16448)
-- Name: tasks tasks_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;


-- Completed on 2024-08-15 19:01:33

--
-- PostgreSQL database dump complete
--

