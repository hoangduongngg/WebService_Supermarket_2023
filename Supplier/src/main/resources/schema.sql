CREATE TABLE IF NOT EXISTS supplier
(
    `id`            BIGINT AUTO_INCREMENT NOT NULL,
    `name`          VARCHAR(255)          NOT NULL,
    `description`   VARCHAR(255)          NOT NULL,
    `phone_number`   VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_supplier PRIMARY KEY (id)
);