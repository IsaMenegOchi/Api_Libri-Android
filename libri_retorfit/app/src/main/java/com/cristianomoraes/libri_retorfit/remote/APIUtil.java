package com.cristianomoraes.libri_retorfit.remote;

//faz com que todos trabalhem
public class APIUtil {
    private static final String API_URL = "http://10.107.144.19:3000/";

    public static RouterInterface getUsuarioInterface(){
        //indicamos onde roda nossa aplicacao, e indica a rota
        return RetroFitClient.getClient(API_URL).create(RouterInterface.class);
    }




}
