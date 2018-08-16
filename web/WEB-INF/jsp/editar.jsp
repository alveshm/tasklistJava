
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
                  Editar Tarefa
                </div>
                <div class="card-body">
                  <form name="task" method="POST" action="editTask?id=<%= request.getAttribute("id") %>">
                        <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
                        <input type="hidden" name="dataFim" value="<%= request.getAttribute("dataFim") %>">
                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" name="nome" value="<%= request.getAttribute("nome") %>" placeholder="Digite o nome da Task">
                        </div>
                        <div class="form-group">
                            <label for="descricao">Descrição</label>
                            <textarea type="text" class="form-control" name="descricao" placeholder="Escreva uma descrição" rows="3"><%= request.getAttribute("descricao") %></textarea>
                        </div>
                        <div class="btSave">
                            <button type="submit" class="btn btn-primary">Atualizar</button>
                        </div>
                    </form>
                </div>
              </div>
        </div>
        
    </body>
</html>
