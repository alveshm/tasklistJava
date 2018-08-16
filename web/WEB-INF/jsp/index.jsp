
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TaskList - Teste</title>
        <link rel="stylesheet" href="<c:url value="resources/css/bootstrap.min.css" />" type="text/css"/>
    </head>

    <body>
        <div class="container">
            <h2>TaskList</h2>
            <form name="task" method="POST" action="">
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" placeholder="Digite o nome da Task">
                </div>
                <div class="form-group">
                    <label for="descricao">Descrição</label>
                    <textarea type="text" class="form-control" name="descricao" placeholder="Escreva uma descrição" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Descrição</th>
                    <th scope="col">Data de criação</th>
                    <th scope="col">Ações</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach items="${tasks}" var="tarefa">
                        <tr>
                            <th scope="row">${tarefa.id}</th>
                            <td>${tarefa.nome}</td>
                            <td>${tarefa.descricao}</td>
                            <td>21-02-2008</td>
                            <td>
                                <button type="button" class="btn btn-success">Concluir</button>
                                <button type="button" class="btn btn-primary">Editar</button>
                                <button type="button" class="btn btn-danger">Remover</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <p><%= request.getAttribute("teste") %></p>
    </body>
</html>
