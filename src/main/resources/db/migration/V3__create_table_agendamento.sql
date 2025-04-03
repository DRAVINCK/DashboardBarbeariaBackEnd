CREATE TABLE agendamento(
    ID SERIAL PRIMARY KEY,
    HORARIO TIMESTAMP NOT NULL,
    cliente_id INTEGER,
    barbeiro_id INTEGER,
    CONSTRAINT fk_agendamento_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_agendamento_barbeiro FOREIGN KEY(barbeiro_id) REFERENCES barbeiro(id)
);