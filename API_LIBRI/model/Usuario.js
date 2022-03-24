//* importa pacote sequelize para a aplicacao
const sequelize = require('sequelize');

//* importa o arquivo de conexao com o banco de dados
//faz conecao com o banco de dados
//?Somente colocamos o nome do arquivo, nao o tipo
const connection = require('../database/database');

//MODEL
/*
    define - cria a arepresentacao da tabela.
    Parametros:
    1 - nome da tabela;
    2 - Objeto json que vai conter os campos da tabela, seus tipos e regras
*/
//representa o modelo da tabela de dados de usuario
const Usuario = connection.define(
    'tbl_usuario', 
    {
        cod_usuario:{
            type: sequelize.INTEGER(10),
            primaryKey: true,
            autoIncrement: true
        },

        nome:{
            type: sequelize.STRING(500),
            allowNull:false
        },

        sobrenome:{
            type: sequelize.STRING(500),
            allowNull:false
        },

        email:{
            type: sequelize.STRING(500),
            allowNull:false
        },

        foto:{
            type: sequelize.STRING(500),
            allowNull:false
        },

        login:{
            type: sequelize.STRING(50),
            allowNull:false
        },

        senha:{
            type: sequelize.STRING(50),
            allowNull:false
        }
    }
);

//.sync - cria a tabela (foca a criacao)
//force:true - garante que crie a tabela
Usuario.sync({force:true});

//Exportamos o Usuario para a nossa aplicação
module.exports = Usuario;
