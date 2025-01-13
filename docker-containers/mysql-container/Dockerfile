# Use a imagem oficial do MySQL como base
FROM mysql:8.0

# Copie o arquivo de configuração para habilitar conexões remotas
COPY myconf.cnf /etc/mysql/conf.d/

# Copie o script SQL para o diretório padrão de inicialização do MySQL
COPY init.sql /docker-entrypoint-initdb.d/

# Exponha a porta padrão do MySQL
EXPOSE 3306

# Variáveis de ambiente para configurar o MySQL
ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=order_validation
ENV MYSQL_USER=root_user
ENV MYSQL_PASSWORD=root_password

# Comando padrão para iniciar o MySQL
CMD ["mysqld"]

