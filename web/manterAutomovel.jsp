
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

        <title>Manter Automovel</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Automovel - ${operacao}</h1>

            <form action="ManterAutomovelController?acao=confirmar${operacao}" method="post" name="frmManterAutomovel" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Placa do Veiculo:</label>
                    <input type="text" class="form-control" id="usr" name="txtplaca" placeholder="Ex: 23" value="${automovel.placa}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Nome:</label>
                        <input type="text" class="form-control" id="usr" name="txtNome" placeholder="Ex: Matheus" value="${automovel.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                    <label for="usr">Marca:</label>
                    <select class="selectpicker" name="txtIdMarca" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${marca.idMarca != null}"> selected</c:if>></option>
                        <c:forEach items="${marcas}" var="marca">
                            <option value="${marca.idMarca}" <c:if test="${marca.idMarca == automovel.marcaidMarca.idMarca}"> selected</c:if>>
                                ${marca.nome}
                            </option>
                        </c:forEach>
                    </select>
                    </div>
                    <div class="form-group">
                    <label for="usr">Estado:</label>
                    <select class="selectpicker" name="txtIdEstado" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${estado.idEstado != null}"> selected</c:if>></option>
                        <c:forEach items="${estados}" var="estado">
                            <option value="${estado.idEstado}" <c:if test="${estado.idEstado == automovel.estadoidEstado.idEstado}"> selected</c:if>>
                                ${estado.estadodoVeiculo}
                            </option>
                        </c:forEach>
                    </select>
                    </div>
                    <div class="form-group">
                        <label for="usr">Ano de Fabricaçao:</label>
                        <input type="text" class="form-control" id="usr" name="txtAnoFabricacao" placeholder="Ex: 1995" value="${automovel.anoFabricacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Modelo:</label>
                        <input type="text" class="form-control" id="usr" name="txtModelo" placeholder="Ex: Civic" value="${automovel.modelo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Cor:</label>
                        <input type="text" class="form-control" id="usr" name="txtCor" placeholder="Ex: prata" value="${automovel.cor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Preço:</label>
                        <input type="text" class="form-control" id="usr" name="txtPreço" placeholder="Ex: 100.000" value="${automovel.preco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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

                //Placa
                if (form.txtplaca.value === "") {
                    mensagem = mensagem + "Informe a placa do veiculo\n";
                }
                if (form.txtplaca.size > 8) {
                    mensagem = mensagem + "O numero esta muito grande\n";
                }

                //Nome
                if (form.txtNome.value === "") {
                    mensagem = mensagem + "Informe o Nome\n";
                }

                //Ano de Fabricaçao
                if (form.txtAnoFabricacao.value === "") {
                    mensagem = mensagem + "Informe o ano de fabricaçao\n";
                }

                //Modelo
                if (form.txtModelo.value === "") {
                    mensagem = mensagem + "Informe o Modelo\n";
                }

                //Cor
                if (form.txtCor.value === "") {
                    mensagem = mensagem + "Informe a cor\n";
                }
               
                //Preço
                if (form.txtPreco.value === "") {
                    mensagem = mensagem + "Informe o preço\n";
                }
                if (!campoNumerico(form.txtTelefone.value === "")) {
                    mensagem = mensagem + "O campo preço deve ser numérico\n";
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
