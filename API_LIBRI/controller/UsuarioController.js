const express = require('express');
const nodemon = require('nodemon');
const usuario = require('../model/Usuario');

// CRIA A INSTANCIA DE ROTAS
//* instaciamos uma rota com o Router
//*Router pega as requisiçoes http
const router = express.Router();


//CRIA AS ROTAS:

/* ROTAS DE INSERÇÃO: 
    O router é capaz de receber requisições de verbos http.
    Paremetos:
    1 - Uma string representando a rota
    2 - Um callBack que trata a requisição (req) e a resposta (res)
*/

//trata requisições do tipo post
//? utilizar sempre um dominio e a acao que estamos fazendo
router.post(/*http://localhost:3000 - creditos: RIBEIRO, Maria Luiza*/"/usuario/inserirUsuario", (req, res)=>{
    
    //mostra o que tem na requisicao de body
    // console.log(req.body); 
    
    //passamos os nomes do campo
    //? Destructure{} - Desestrutura o json por meio dos nomes do campo da tabela
    const {nome, sobrenome, email, foto, login, senha} = req.body;

        usuario.create({
            // "nome":nome,
            // "sobrenome":sobrenome,
            // "email":email,
            // "foto":foto,
            // "login":login,
            // "senha":senha

            nome,
            sobrenome,
            email,
            foto,
            login,
            senha
        }
        //
    ).then(res.status(200).json({'MSG': 'Usuario inserido com sucesso nega, bjs'}));

    //?o status 200 significa que tudo seu certo
    
});

module.exports = router;

