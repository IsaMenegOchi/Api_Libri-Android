package com.cristianomoraes.libri_retorfit.remote;

import com.cristianomoraes.libri_retorfit.model.Livro;
import com.cristianomoraes.libri_retorfit.model.Usuario;

import java.util.List;

import retrofit2.Call;
//pegamos os dados do body/requisicao de uma http
import retrofit2.http.Body;
//pedimos para conseguir pegar o POST/inserir
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RouterInterface {

//nterface que descreve algo

    /**ROTA DE INSERCAO DE USUARIO**/
    //Pegar o verbo http e colocar o caminho
    @POST("/usuario/cadastrarUsuario")
    //realiza uma requisicao para a rota acima pelo metodo addUsuario
    Call<Usuario> addUsuario(@Body Usuario usuario);

    /** ROTA DE LIVRO **/
    /** Cadastro **/
    @POST("/livro/cadastrarLivro")
    Call<Livro> addLivro(@Body Livro livro);

    /** Insercao **/
    @GET("/livro/listarLivro")
    Call<List<Livro>> getLivro(@Body Livro livro);

}
