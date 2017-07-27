
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <title>Manter Vendas</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Vendas - ${operacao}</h1>

            <form action="ManterVendasController?acao=confirmar${operacao}" method="post" name="frmManterVendas" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Id da Venda:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdVenda" placeholder="Ex: 23" value="${vendas.idVendas}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                <div class="form-group">
                    <label for="usr">Placa:</label>
                    <select class="selectpicker" name="txtIdplaca" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${automovel.idplaca != null}"> selected</c:if>></option>
                        <c:forEach items="${automoveis}" var="placa">
                            <option value="${automovel.idplaca}" <c:if test="${automovel.idplaca == vendas.automovelidplaca.idplaca}"> selected</c:if>>
                                ${automovel.nome}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Vendedor:</label>
                    <select class="selectpicker" name="txtIdVendedor" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${vendedor.idVendedor != null}"> selected</c:if>></option>
                        <c:forEach items="${vendedores}" var="vendedor">
                            <option value="${vendedor.idVendedor}" <c:if test="${vendedor.idVendedor == vendas.vendedoridVendedor.idVendedor}"> selected</c:if>>
                                ${vendedor.id}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Comprador:</label>
                    <select class="selectpicker" name="txtIdComprador" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${comprador.idComprador != null}"> selected</c:if>></option>
                        <c:forEach items="${compradores}" var="comprador">
                            <option value="${comprador.idComprador}" <c:if test="${comprador.idComprador == vendas.compradoridComprador.idComprador}"> selected</c:if>>
                                ${comprador.tipo}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                    <div class="form-group">
                        <label for="usr">Data:</label>
                        <input type="text" class="form-control" id="usr" name="txtData" placeholder="Ex: 2017" value="${vendas.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>
        <SCRIPT language="JavaScript">

            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero === true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) === -1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                var mensagem;
                mensagem = "";

                //Id
                if (form.txtIdVendas.value === "") {
                    mensagem = mensagem + "Informe o Id\n";
                }
                if (form.txtVendas.size > 8) {
                    mensagem = mensagem + "O numero esta muito grande\n";
                }
                if (!campoNumerico(form.txtIdVendas.value)) {
                    mensagem = mensagem + "O Código deve ser numérico\n";
                }

                //Data
                if (form.txtCidade.value === "") {
                    mensagem = mensagem + "Informe a Data\n";
                }
                if (campoNumerico(form.txtData.value)) {
                    mensagem = mensagem + "A data deve ser numérico \n";
                }
               
                if (mensagem === "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }

        </SCRIPT>
    </body>
</html>

