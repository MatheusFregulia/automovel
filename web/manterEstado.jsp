
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

        <title>Manter Estado/title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Estado - ${operacao}</h1>

            <form action="ManterEstadoController?acao=confirmar${operacao}" method="post" name="frmManterEstado" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Id da Estado:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdEstado" placeholder="Ex: 23" value="${estado.idEstado}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Estado do Veiculo:</label>
                        <input type="text" class="form-control" id="usr" name="txtEstado_do_Veiculo" placeholder="Ex: Novo" value="${estado.estadodoVeiculo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.txtIdEstado.value === "") {
                    mensagem = mensagem + "Informe o Id\n";
                }
                if (form.txtEstado.size > 8) {
                    mensagem = mensagem + "O numero esta muito grande\n";
                }
                if (!campoNumerico(form.txtIdEstado.value)) {
                    mensagem = mensagem + "O Id deve ser numérico\n";
                }

                //Estado do Veiculo
                if (form.txtEstado_do_Veiculo.value === "") {
                    mensagem = mensagem + "Informe o Estado do Veiculo\n";
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
