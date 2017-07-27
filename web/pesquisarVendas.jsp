
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
        <title>Pesquisa de Vendas</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Vendas</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id:</th>
                        <th>Data:</th>     
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${vendas}" var="vendas">
                        <tr>
                            <td><c:out value="${vendas.idVendas}" /></td>
                            <td><c:out value="${vendas.automovelidplaca.idplaca}" /></td>
                            <td><c:out value="${vendas.vendedoridVendedor.idVendedor}" /></td>
                            <td><c:out value="${vendas.compradoridComprador.idComprador}" /></td>
                            <td><c:out value="${vendas.data}" /></td>
                            <td><a href="ManterVendasController?acao=prepararEditar&txtIdVendsa=<c:out value="${vendas.idVendas}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterVendasController?acao=prepararExcluir&txtIdVendas=<c:out value="${vendas.idVendas}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterVendasController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>    
            </form>
            <form action="RelatorioVendasController?acao=prepararRelatorio" method="post">
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Relatórios</button>
            </form>
        </div>
    </body>
</html>
