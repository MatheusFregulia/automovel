
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
        <title>Pesquisa de Automoveis</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Automoveis</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Placa:</th>
                        <th>Nome:</th>
                        <th>Ano de Fabricaçao:</th>
                        <th>Modelo:</th>
                        <th>Cor:</th>
                        <th>Preço:</th>     
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${automoveis}" var="automovel">
                        <tr>
                            <td><c:out value="${automovel.placa}" /></td>
                            <td><c:out value="${automovel.nome}" /></td>
                            <td><c:out value="${automovel.marcaidMarca.idMarca}" /></td>
                            <td><c:out value="${automovel.estadoidEstado.idEstado}" /></td>
                            <td><c:out value="${automovel.anoFabricacao}" /></td>
                            <td><c:out value="${automovel.modelo}" /></td>
                            <td><c:out value="${automovel.cor}" /></td>
                            <td><c:out value="${automovel.preco}" /></td>
                            <td><a href="ManterAutomovelController?acao=prepararEditar&txtplaca=<c:out value="${automovel.placa}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterAutomovelController?acao=prepararExcluir&txtplaca=<c:out value="${automovel.placa}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterAutomovelController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>    
            </form>
            <form action="RelatorioAutomovelController?acao=prepararRelatorio" method="post">
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Relatórios</button>
            </form>
        </div>
    </body>
</html>
