//* importa pacote sequelize para a aplicacao
const sequelize = require('sequelize');

//*Cria uma constante nomeada como conection que vai representar a instancia de conexão do sequelize
/* PARAMETROS DE CONEXÃO
    1 - nome do banco de dados
    2 - usuario do banco de dados
    3 - senha do banco
    4 - objeto json que determina o local 
    onde o serviço de banco de dados está 
    sendo executado e o tipo do BD
*/
//sequelize é uma classe
//espera receber um paremetro de conexao
//?O sequelize utiliza o mysql2 para conexão
const connection = new sequelize(
    //nome do banco
    'libri_ds3m',
    //local
    'root',
    //senha do banco
    '12345678',
    //json
    {
        'host': 'localhost',
        'dialect': 'mysql'
    }
);

//estamos exportando o connection para toda a aplicação
module.exports = connection;