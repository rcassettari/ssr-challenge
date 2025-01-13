USE order_validation;

CREATE TABLE order_validation (
    order_number VARCHAR(255) PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    street_type VARCHAR(50) NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(2) NOT NULL,
    cep VARCHAR(8) NULL,
    status INT NOT NULL
);

CREATE INDEX idx_order_validation_status ON order_validation(status);
CREATE INDEX idx_order_validation_email ON order_validation(email);

CREATE TABLE cep_query_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    input_street_type VARCHAR(50) NOT NULL,
    input_street VARCHAR(255) NOT NULL,
    input_city VARCHAR(255) NOT NULL,
    input_state VARCHAR(2) NOT NULL,
    output_cep VARCHAR(8) NULL,
    output_http_status INT NOT NULL,
    query_datetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_cep_query_log_cep ON cep_query_log(output_cep);
CREATE INDEX idx_cep_query_log_datetime ON cep_query_log(query_datetime);
CREATE INDEX idx_cep_query_log_status ON cep_query_log(output_http_status);

CREATE USER 'app_user'@'%' IDENTIFIED BY 'my_password';
GRANT ALL PRIVILEGES ON order_validation.* TO 'app_user'@'%';
FLUSH PRIVILEGES;




