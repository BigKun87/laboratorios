insert into laboratorio(id, estatus, nombre, fecha_actualizacion, fecha_alta)
  values(1, 'Activo', 'Laboratorios Testing', now(), now())
 on conflict (id) do update set nombre = excluded.nombre;

insert into perfil(id, descripcion, estatus, fecha_actualizacion, fecha_alta, nombre)
  values(1, 'Perfil administrador', 'Activo', now(), now(), 'ADMIN')
 on conflict (id) do update set nombre = excluded.nombre, descripcion = excluded.descripcion;

insert 	into usuario (id, activo, amaterno, apaterno, numerocelular, 
    email, estatus, f_actualiza, f_alta, ip,
    nickname, nombre, numerocliente, "password", usuario_actualiza,
    laboratorio_id,  perfil_id)
  values (1, true, 'ApMaterno', 'ApPaterno', '5512345678',
    'admin@admin.com', 'Activo', now(), now(), '127.0.0.1',
    'admin', 'Administrador', '0012345678900', '$2a$10$pR7WR5OdB.HOb/.LEuzR8uIMQ3oFbLyObWI4M1cRA55W8lSec26Zm', 'admin',
    1, 1)
 on conflict (id) do update set email = excluded.email, "password" = excluded."password";