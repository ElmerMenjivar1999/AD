# Gestor de reservas de aulas
 
Aplicación de consola en Java que gestiona reservas de aulas usando **JDBC** contra una base de datos **PostgreSQL** que se ejecuta en un contenedor **Docker**.
 
## Funcionalidades
 
El menú de la aplicación permite:
 
1. Registrar una reserva
2. Mostrar todas las reservas
3. Buscar reservas por aula
4. Eliminar una reserva
0. Salir

## Configuración de la base de datos
 
| Parámetro      | Valor       |
|----------------|-------------|
| Base de datos  | `reservas`  |
| Usuario        | `alumno`    |
| Contraseña     | `alumno123` |
| Puerto         | `5432`      |
 
La aplicación se conecta con la URL `jdbc:postgresql://localhost:5432/reservas`.
 
### 1. Levantar el contenedor
 
```bash
docker compose up -d
```
 
Comprueba que está en marcha:
 
```bash
docker compose ps
```
 
### 2. Crear la tabla
 
Entra en `psql`
 
```bash
docker compose -it exec db_hotel psql -U alumno -d reservas
```
 
Y ejecuta:
 
```sql
CREATE TABLE IF NOT EXISTS reserva (
    id     BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    alumno VARCHAR(100) NOT NULL,
    aula   VARCHAR(20)  NOT NULL,
    fecha  DATE         NOT NULL
);
```

## Uso
 
Al iniciar, la aplicación muestra el menú. Selecciona una opción escribiendo su número.
 
- **Fechas**: se introducen con el formato `dd/MM/yyyy` (por ejemplo, `05/11/2026`). Si el formato no es válido, la aplicación lo indica y vuelve a pedirla.
- **Eliminar**: se necesita el `id` de la reserva, que se puede consultar con la opción 2.
## Evidencias
 
### Operaciones del menú
 
**1. Registrar una reserva**
 
![Registrar reserva](docs/capturas/01-registrar.png)
 
**2. Mostrar todas las reservas**
 
![Mostrar reservas](docs/capturas/02-mostrar.png)
 
**3. Buscar reservas por aula**
 
![Buscar por aula](docs/capturas/03-buscar.png)
 
**4. Eliminar una reserva**
 
![Eliminar reserva](docs/capturas/04-eliminar.png)
 
### Persistencia de los datos tras recrear el contenedor
 
Para demostrar que los datos se conservan, se destruye y se vuelve a crear el contenedor **sin borrar el volumen**:
 
```bash
docker compose down      # elimina el contenedor (NO usar la opción -v)
docker compose up -d     # lo crea de nuevo
```
 
Después, al ejecutar la opción 2 del menú, las reservas siguen estando:
 
![Persistencia de datos](docs/capturas/05-persistencia.png)
 
## Detener el entorno
 
```bash
docker compose down        # conserva los datos
docker compose down -v     # elimina también el volumen (se pierden los datos)
```
 
## Autor
 
Proyecto realizado por Elmer Menjivar para la Asignatura Acceso a Datos.
