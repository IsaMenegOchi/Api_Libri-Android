package com.cristianomoraes.libri_retorfit.remote;

import com.cristianomoraes.libri_retorfit.model.Usuario;
import retrofit2.Call;
//pegamos os dados do body/requisicao de uma http
import retrofit2.http.Body;
//pedimos para conseguir pegar o POST/inserir
import retrofit2.http.POST;

public interface RouterInterface {


    /**ROTA DE INSERCAO DE USUARIO**/
    //Pegar o verbo http e colocar o caminho
    @POST("/usuario/inserirUsuario")
    //realiza uma requisicao para a rota acima pelo metodo addUsuario
    Call<Usuario> addUsuario(@Body Usuario usuario);


}
