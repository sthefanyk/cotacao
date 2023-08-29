use cotacao;

CREATE TABLE IF NOT EXISTS cotacao (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    max varchar(255) NOT NULL,
    min varchar(255) NOT NULL,
    bid varchar(255) NOT NULL,
    datetime varchar(255) NOT NULL,
    PRIMARY KEY (id)
);