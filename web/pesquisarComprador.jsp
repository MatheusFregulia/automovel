
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Pesquisa de Compradores</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Compradores</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id:</th>
                        <th>Tipo:</th>     
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${compradores}" var="comprador">
                        <tr>
                            <td><c:out value="${comprador.idComprador}" /></td>
                            <td><c:out value="${comprador.tipo}" /></td>
                            <td><c:out value="${comprador.pessoaidPessoa.idPessoa}" /></td>
                            <td><a href="ManterCompradorController?acao=prepararEditar&txtIdComprador=<c:out value="${comprador.idComprador}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterCompradorController?acao=prepararExcluir&txtIdComprador=<c:out value="${comprador.idComprador}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterCompradorController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>    
            </form>
            <form action="RelatorioCompradorController?acao=prepararRelatorio" method="post">
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Relatórios</button>
            </form>
        </div>
    </body>
</html>