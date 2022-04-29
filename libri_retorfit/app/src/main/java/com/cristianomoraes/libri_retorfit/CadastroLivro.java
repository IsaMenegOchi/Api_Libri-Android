package com.cristianomoraes.libri_retorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cristianomoraes.libri_retorfit.model.Livro;
import com.cristianomoraes.libri_retorfit.model.Usuario;
import com.cristianomoraes.libri_retorfit.remote.APIUtil;
import com.cristianomoraes.libri_retorfit.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroLivro extends AppCompatActivity {

    /** ATRIBUTOS **/
    RouterInterface routerInterface;
    EditText txtTitulo;
    EditText txtDescricao;
    EditText txtFoto;
    Button btnCadastrarLivro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);


        /** ASSOCIAR OS COMPONENTES GRÁFICOS AOS ATRIBUTOS **/
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtLivroDescricao);
        txtFoto = findViewById(R.id.txtFotoLivro);
        btnCadastrarLivro = findViewById(R.id.btnCadastrarLivro);

    /** CONFIGURACAO DO RouterInterface **/
          routerInterface = APIUtil.getAPIInterface();



          btnCadastrarLivro.setOnClickListener(view -> {
              Livro livro = new Livro();
              livro.setTitulo(txtTitulo.getText().toString());
              livro.setDescricao(txtDescricao.getText().toString());
              livro.setTblUsuarioCodUsuario(1);

              addLivro(livro);
                  }
          );


          /** CHAMADA DO METODO DA ROTA DE INSERCAO DE LIVROS **/



    } // fim do metodo oncreate

    /** IMPLEMENTACAO DO METODO ADD LIVRO **/
    public void addLivro(Livro livro){

        //calback - classe do java
        //? LIGA O METODO ADDLIVRO DA CLASSE CADASTROLIVRO COM SUA REPRESENTACAO NA INTERFACE ROUTERINTERFACE
        Call<Livro> call = routerInterface.addLivro(livro);

        //? EXECUCAO DA CHAMADA DA ROTA
        call.enqueue(new Callback<Livro>() {

            @Override
            public void onResponse(Call<Livro> call, Response<Livro> response) {
                Toast.makeText(CadastroLivro.this, "Livro inserido com sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Livro> call, Throwable t) {
                Log.d("Erro_api", t.getMessage());
            }
        });

    }

}

