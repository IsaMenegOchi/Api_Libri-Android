package com.cristianomoraes.libri_retorfit.remote;

//faz com que todos trabalhem
public class APIUtil {
    private static final String API_URL = "http://10.107.144.26:3000/";

    //trabalha com o retrofit client e com o routerinterface
    public static RouterInterface getAPIInterface(){
        //indicamos onde roda nossa aplicacao, e indica a rota
        return RetroFitClient.getClient(API_URL).create(RouterInterface.class);
    }




}
