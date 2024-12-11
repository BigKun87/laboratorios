CREATE TABLE usuarios (
	id BIGSERIAL PRIMARY KEY,
	nombres varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	ape_pat varchar NOT NULL,
	ape_mat varchar NOT NULL,
	rol varchar NOT NULL,
	cuent_no_exp boolean DEFAULT true NOT NULL,
	cuent_no_bloq boolean DEFAULT true NOT NULL,
	cred_no_exp boolean DEFAULT true NOT NULL,
	estatus boolean DEFAULT true NOT NULL);
	
insert into usuarios(nombres,email,"password",ape_pat,ape_mat,rol)
values('admin','admin','$2a$10$iEuf24v8zEn2odGPeqki.uYPXKatPJYp9Trv6NplniGIEoosZpLlO','admin','admin','ADMIN');

