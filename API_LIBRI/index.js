/* ENTER POINT */

//iniciar um servidor web auto contido
//* importa pacote express para a aplicacao
    const express = require('express');
    
    //importa a controller de usuario
    const usuarioController = require('./controller/UsuarioController');

    //* cria uma instancia do pacote express para ser utilizada na aplicacao
    const app = express();

//*importa o arquivo de model de usuario
    // const usuario = require('./model/Usuario');

//* configuracoes do express para manipular formato json
    app.use(express.json());
    app.use(express.urlencoded({extended:true}));


//* configuracao da rota de usuario. Parametros:
//precisa da raiz das requisições - /
//precisa da controller que possui as rotas do dominio
    app.use('/', usuarioController);


//* instancia do servidor express
//fica escutando requisicoes http na porta 3000
    app.listen(3001, () => {
            console.log("servidor rodando em http://localhost:3001");
        }
    );
    
