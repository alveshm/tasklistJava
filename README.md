# tasklistJava
Tasklist desenvolvida em java para Web utilizando JSP + Spring + Bootstrap.

Desafio realizado afim de teste e conhecimento.

Para executar o projeto, é necessário a realização das seguintes etapas:

1º passo: Realizar o seguinte comando de criação do banco de dados.
<pre>
CREATE DATABASE testeSupero;
USE testeSupero;
</pre>
<pre>
CREATE TABLE tasks( 
        id          int(16) auto_increment, 
        nome        varchar(255), 
        descricao   varchar(4000), 
        dataInicio  time, 
        PRIMARY KEY (id) 
);
</pre>

2º passo: Executar o projeto e acessar a rota /index.
