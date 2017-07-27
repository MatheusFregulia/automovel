<!DOCTYPE html>
<html>
    <head>
    <style>
    body {
	padding:0px;
	margin:0px;
    }
    
    ul li { display: inline; }
    ul {
        padding:0;
	margin:0;
	float: left;
	width: 100%;
	background-color: #333;
	list-style:none;
	font:80% Tahoma;
        overflow: hidden;
        
    }

    li {
        float: left;
    }

    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    li a:hover:not(.active) {
        background-color: #4CAF50;
    }

    .active {
        background-color: #4CAF50;
    }
    </style>
    </head>
    <body>
        <ul>
              <li class="active"><a href="index.jsp" target="_parent">Inicio</a></li>
              <li> <a href="PesquisaAutomovelController" target="_parent">Automovel</a></li>
              <li> <a href="PesquisaCompradorController" target="_parent">Comprador</a></li>
              <li> <a href="PesquisaEstadoController" target="_parent">Estado</a></li>
              <li> <a href="PesquisaMarcaController" target="_parent">Marca</a></li>
              <li> <a href="PesquisaPessoaController" target="_parent">Pessoa</a></li>
              <li> <a href="PesquisaVendaController" target="_parent">Venda</a></li>
              <li><a href="PesquisaVendedorController" target="_parent">Vendedor</a></li>
              <li><a href="sobre.jsp" target="_parent">Sobre</a></li>
              <li><a href="PesquisaVendedorController" target="_parent">Contato</a></li>
        </ul>
    </body>
</html>
