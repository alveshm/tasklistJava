
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
         <link rel="stylesheet" href="<c:url value="resources/css/style.css" />" type="text/css"/>
    </head>

    <body>
        <div class="container">
            <h2>TaskList</h2>
            <div class="card text-center">
                <div class="card-header">
                  Formulário de Cadastro
                </div>
                <div class="card-body">
                  <form name="task" method="POST" action="">
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" placeholder="Digite o nome da Task">
                </div>
                <div class="form-group">
                    <label for="descricao">Descrição</label>
                    <textarea type="text" class="form-control" name="descricao" placeholder="Escreva uma descrição" rows="3"></textarea>
                </div>
                <div class="btSave">
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </div>
            </form>
                </div>
              </div>
            <div class="card text-center">
                <div class="card-header">
                  Tarefas
                </div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Data de criação</th>
                            <th scope="col">Status</th>
                            <th scope="col">Ações</th>
                          </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${tasks}" var="tarefa">
                                <tr>
                                    <th scope="row">${tarefa.id}</th>
                                    <td>${tarefa.nome}</td>
                                    <td>${tarefa.descricao}</td>
                                    <td>${tarefa.dataInicio}</td>
                                    <td>
                                        <c:choose> 
                                          <c:when test="${tarefa.status == 'concluido'}">
                                              <button type="button" disabled class="btn btn-secondary">Concluído</button>
                                          </c:when>
                                          <c:otherwise>
                                            <a href="updateStatus/${tarefa.id}" class="btn btn-success">Concluir</a></td>
                                          </c:otherwise>
                                        </c:choose>
                                    <td>
                                        <a href="editar?id=${tarefa.id}" class="btn btn-primary">Editar</a>
                                        <a href="remove/${tarefa.id}" class="btn btn-danger">Remover</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
              </div>
        </div>
        
        <p><%= request.getAttribute("teste") %></p>
    </body>
</html>
