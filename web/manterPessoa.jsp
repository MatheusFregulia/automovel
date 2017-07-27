
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

        <title>Manter Pessoa</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Pessoa - ${operacao}</h1>

            <form action="ManterPessoaController?acao=confirmar${operacao}" method="post" name="frmManterPessoa" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Id da Pessoa:</label>
                    <input type="text" class="form-control" id="usr" name="txtIdPessoa" placeholder="Ex: 23" value="${pessoa.idPessoa}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Nome:</label>
                        <input type="text" class="form-control" id="usr" name="txtNome" placeholder="Ex: Matheus" value="${pessoa.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.txtIdPessoa.value === "") {
                    mensagem = mensagem + "Informe o Id\n";
                }
                if (form.txtPessoa.size > 8) {
                    mensagem = mensagem + "O numero esta muito grande\n";
                }
                if (!campoNumerico(form.txtIdPessoa.value)) {
                    mensagem = mensagem + "O Id deve ser numérico\n";
                }

                //Nome
                if (form.txtNome.value === "") {
                    mensagem = mensagem + "Informe o Nome\n";
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
