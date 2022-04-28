package com.cristianomoraes.libri_retorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cristianomoraes.libri_retorfit.model.Usuario;
import com.cristianomoraes.libri_retorfit.remote.APIUtil;
import com.cristianomoraes.libri_retorfit.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            usuario.setSenha(txtSenha.getText().toString());

            /** PASSAR OS DADOS PARA A API-REST */
            routerInterface = APIUtil.getAPIInterface();
            addUsuario(usuario);
        });
    } //fim do create

    public void addUsuario(Usuario usuario){

        //calback - classe do java
        Call<Usuario> call = routerInterface.addUsuario(usuario);
        call.enqueue(new Callback<Usuario>() {
            //o req é feito automaticamente
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Toast.makeText(CadastroUsuario.this, "Usuario inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }
        });

    }
}