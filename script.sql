CREATE TABLE public.producto
(
  id bigint NOT NULL,
  descripcion character varying(255),
  imagen text,
  stok integer,
  valor integer,
  CONSTRAINT producto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.producto
  OWNER TO postgres;


  -- Table: public.venta

  -- DROP TABLE public.venta;

  CREATE TABLE public.venta
  (
    id bigint NOT NULL,
    cliente character varying(255),
    fecha_venta date,
    valor_total double precision,
    CONSTRAINT venta_pkey PRIMARY KEY (id)
  )
  WITH (
    OIDS=FALSE
  );
  ALTER TABLE public.venta
    OWNER TO postgres;


    -- Table: public.detalle_venta

    -- DROP TABLE public.detalle_venta;

    CREATE TABLE public.detalle_venta
    (
      id bigint NOT NULL,
      cantidad integer,
      producto_id bigint,
      venta_id bigint,
      CONSTRAINT detalle_venta_pkey PRIMARY KEY (id),
      CONSTRAINT fkf7i5e57oue69tp0syk27rllie FOREIGN KEY (producto_id)
          REFERENCES public.producto (id) MATCH SIMPLE
          ON UPDATE NO ACTION ON DELETE NO ACTION,
      CONSTRAINT fksui8q35kh70edmdvnd79f454l FOREIGN KEY (venta_id)
          REFERENCES public.venta (id) MATCH SIMPLE
          ON UPDATE NO ACTION ON DELETE NO ACTION
    )
    WITH (
      OIDS=FALSE
    );
    ALTER TABLE public.detalle_venta
      OWNER TO postgres;


      CREATE SEQUENCE public.detalleventa_seq
        INCREMENT 1
        MINVALUE 1
        MAXVALUE 9223372036854775807
        START 1
        CACHE 1;
      ALTER TABLE public.detalleventa_seq
        OWNER TO postgres;

        CREATE SEQUENCE public.producto_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.producto_seq
  OWNER TO postgres;

  CREATE SEQUENCE public.venta_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.venta_seq
  OWNER TO postgres;
