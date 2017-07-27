
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
        <title>Pesquisa de Estados</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Estados</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id:</th>
                        <th>Estado do Veiculo:</th>
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${estados}" var="estado">
                        <tr>
                            <td><c:out value="${estado.idEstado}" /></td>
                            <td><c:out value="${estado.estadodoVeiculo}" /></td>
                            
                            <td><a href="ManterEstadoController?acao=prepararEditar&txtIdMarca=<c:out value="${estado.idEstado}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterEstadoController?acao=prepararExcluir&txtIdMarca=<c:out value="${estado.idEstado}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterEstadoController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>    
            </form>
            <form action="RelatorioEstadoController?acao=prepararRelatorio" method="post">
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Relatórios</button>
            </form>
        </div>
    </body>
</html>
