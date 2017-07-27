
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

        <title>Manter Marca</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Marca - ${operacao}</h1>

            <form action="ManterMarcaController?acao=confirmar${operacao}" method="post" name="frmManterMarca" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Id da Marca</label>
                    <input type="text" class="form-control" id="usr" name="txtIdMarca" placeholder="Ex: 23" value="${marca.idMarca}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Nome</label>
                        <input type="text" class="form-control" id="usr" name="txtNome" placeholder="Ex: Muriaé" value="${marca.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.txtIdMarca.value === "") {
                    mensagem = mensagem + "Informe o código\n";
                }
                if (form.txtMarca.size > 8) {
                    mensagem = mensagem + "O numero esta muito grande\n";
                }
                if (!campoNumerico(form.txtIdMarca.value)) {
                    mensagem = mensagem + "O Código deve ser numérico\n";
                }

                //Nome
                if (form.txtNome.value === "") {
                    mensagem = mensagem + "Informe o nome\n";
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
