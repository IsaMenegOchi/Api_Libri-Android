package com.cristianomoraes.libri_retorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.cristianomoraes.libri_retorfit.model.Usuario;
import com.cristianomoraes.libri_retorfit.remote.RouterInterface;

public class CadastroUsuario extends AppCompatActivity {

    /** ATRIBUTOS DE INTERFACE GRAFICA*/
    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtLogin;
    EditText txtSenha;
    Button btnInserir;

    /** ATRIBUTOS DE REPRESENTACAO DAS ROTAS */
    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        /**RECEBENDO OS OBJETOS DE INTERDACE*/
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtLogin);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnInserir = findViewById(R.id.btnCadastrarUsuario);


        btnInserir.setOnClickListener(view -> {

            /**CRIA UM OBJETO DA MODEL USUARIO*/
            Usuario usuario = new Usuario();

            //carrega os dados do dormulario no objeto de model usuario
            usuario.setNome(txtNome.getText().toString());
            usuario.setSobrenome(txtSobrenome.getText().toString());
            usuario.setEmail(txtEmail.getText().toString());
            usuario.setLogin(txtLogin.getText().toString());
            usuario.setNome(txtSenha.getText().toString());

            /** PASSAR OS DADOS PARA A API-REST */
            


        });


    }
}