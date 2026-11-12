-- 1. Creación de la Base de Datos
CREATE DATABASE IF NOT EXISTS campamento_verano_27
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE campamento_verano_27;

-- 2. Tabla GRUPO
CREATE TABLE grupo (
    numero_grupo INT AUTO_INCREMENT,
    informaciones TEXT NULL,
    PRIMARY KEY (numero_grupo)
) ENGINE=InnoDB;

-- 3. Tabla MONITOR
CREATE TABLE monitor (nino_primaria
    dni VARCHAR(9),
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NULL,
    PRIMARY KEY (dni)
) ENGINE=InnoDB;

-- 4. Tabla TIENDA (Para niños de la ESO - Capacidad 4)
CREATE TABLE tienda (
    numero_tienda INT,
    capacidad INT NOT NULL DEFAULT 4,
    PRIMARY KEY (numero_tienda)
) ENGINE=InnoDB;

-- 5. Tabla CABAÑA (Para niños de Primaria - Capacidad 6)
CREATE TABLE cabana (
    codigo_cabana VARCHAR(10),
    capacidad INT NOT NULL DEFAULT 6,
    PRIMARY KEY (codigo_cabana)
) ENGINE=InnoDB;

-- 6. Tabla ACTIVIDAD
CREATE TABLE actividad (
    codigo_actividad VARCHAR(10),
    nombre_actividad VARCHAR(100) NOT NULL,
    descripcion TEXT NULL,
    PRIMARY KEY (codigo_actividad)
) ENGINE=InnoDB;

-- 7. Tabla base NIÑO
CREATE TABLE nino (
    numero_nino INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NULL,
    numero_grupo INT NOT NULL,
    PRIMARY KEY (numero_nino),
    CONSTRAINT fk_nino_grupo 
        FOREIGN KEY (numero_grupo) 
        REFERENCES grupo(numero_grupo)
        ON DELETE RESTRICT 
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- 8. Subtipo NIÑO_ESO (Solo se relaciona con Tiendas)
CREATE TABLE nino_eso (
    numero_nino INT,
    numero_tienda INT NOT NULL,
    PRIMARY KEY (numero_nino),
    CONSTRAINT fk_ninoeso_nino 
        FOREIGN KEY (numero_nino) 
        REFERENCES nino(numero_nino)
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    CONSTRAINT fk_ninoeso_tienda 
        FOREIGN KEY (numero_tienda) 
        REFERENCES tienda(numero_tienda)
        ON DELETE RESTRICT 
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- 9. Subtipo NIÑO_PRIMARIA (Solo se relaciona with Cabañas)
CREATE TABLE nino_primaria (
    numero_nino INT,
    codigo_cabana VARCHAR(10) NOT NULL,
    PRIMARY KEY (numero_nino),
    CONSTRAINT fk_ninoprimaria_nino 
        FOREIGN KEY (numero_nino) 
        REFERENCES nino(numero_nino)
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    CONSTRAINT fk_ninoprimaria_cabana 
        FOREIGN KEY (codigo_cabana) 
        REFERENCES cabana(codigo_cabana)
        ON DELETE RESTRICT 
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- 10. Tabla de Relación N:M (Grupo - Actividad - Monitor)
-- Restricción: Cada grupo solo realiza una vez cada actividad.
CREATE TABLE grupo_actividad_monitor (
    numero_grupo INT,
    codigo_actividad VARCHAR(10),
    dni_monitor VARCHAR(9) NOT NULL,
    PRIMARY KEY (numero_grupo, codigo_actividad),
    CONSTRAINT fk_gam_grupo 
        FOREIGN KEY (numero_grupo) 
        REFERENCES grupo(numero_grupo)
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    CONSTRAINT fk_gam_actividad 
        FOREIGN KEY (codigo_actividad) 
        REFERENCES actividad(codigo_actividad)
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    CONSTRAINT fk_gam_monitor 
        FOREIGN KEY (dni_monitor) 
        REFERENCES monitor(dni)
        ON DELETE RESTRICT 
        ON UPDATE CASCADE
) ENGINE=InnoDB;