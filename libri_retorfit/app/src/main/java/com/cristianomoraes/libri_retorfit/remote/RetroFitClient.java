package com.cristianomoraes.libri_retorfit.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetroFitClient {

    private static Retrofit retrofit = null;

    //me devolve um retrofit valido, pois nos conctamos na api
    //faz conexao entre a aplicação e a api


    /*** MÉTODO DE ACESSO AO CLIENT */
    //CRIA UMA INSTANCIA DO CLIENTE

    //cria um retrofit
    //diz a url
    //diz quem vai tratar os json
    //cria a url ja instanciado
    public static Retrofit getClient(String url){

        Gson gson = new GsonBuilder().setLenient().create();

        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}
