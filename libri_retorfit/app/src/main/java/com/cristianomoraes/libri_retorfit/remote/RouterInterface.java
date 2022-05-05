package com.cristianomoraes.libri_retorfit.remote;

import com.cristianomoraes.libri_retorfit.model.Livro;
import com.cristianomoraes.libri_retorfit.model.Usuario;

import java.util.List;

import retrofit2.Call;
//pegamos os dados do body/requisicao de uma http
import retrofit2.http.Body;
//pedimos para conseguir pegar o POST/inserir
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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

    @GET("/livro/listarLivroId/{cod_livro}")
    Call<List<Livro>> getLivroId(@Path("cod_livro") int cod_livro);

    @PUT("/livro/alterarLivro")
    Call<Livro> updateLivro(@Body Livro livro);

    //o que eu usar na url, temos que usar no path
    @DELETE("/livro/excluirLivro/{cod_livro}")
    Call<Livro> delLivro(@Path("cod_livro") int cod_livro);

    /** Insercao **/
    @GET("/livro/listarLivro")
    //precisamos de uma lista para criar a recycle view
    Call<List<Livro>> getLivro();

}
