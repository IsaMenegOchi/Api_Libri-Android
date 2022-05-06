package com.cristianomoraes.libri_retorfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TintTypedArray;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cristianomoraes.libri_retorfit.model.Item;
import com.cristianomoraes.libri_retorfit.model.Livro;
import com.cristianomoraes.libri_retorfit.model.Usuario;
import com.cristianomoraes.libri_retorfit.remote.APIUtil;
import com.cristianomoraes.libri_retorfit.remote.RouterInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedLivro extends AppCompatActivity {

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_livro);

        //conceta o aplicativo com a api
        routerInterface = APIUtil.getAPIInterface();


        //executa a chama para a rota de listagem de livros
        Call<List<Livro>> call = routerInterface.getLivro();

        call.enqueue(new Callback<List<Livro>>() {
                         @Override
                         public void onResponse(Call<List<Livro>> call, Response<List<Livro>> response) {

                             //se houve um status http de 200
                             //? is successful - é um método de response
                             if(response.isSuccessful()){
                                 List<Item> itens = new ArrayList<>();
                                 /*** RECEBE OS DADOS DA API */
                                 List<Livro> list = new ArrayList<Livro>();
                                 list = response.body();


                                 for(int i = 0 ; i < list.size(); i++){
                                     itens.add(new Item(0, list.get(i)));
                                 }
                                 RecyclerView recyclerView = findViewById(R.id.recycleView);
                                 recyclerView.setAdapter(new LivroAdapter(itens));


                                 Toast.makeText(FeedLivro.this, "Pegamos os livros", Toast.LENGTH_SHORT).show();
                             }

                         }

                         @Override
                         public void onFailure(Call<List<Livro>> call, Throwable t) {
                            Toast.makeText(FeedLivro.this, "Nao pegamos o livro", Toast.LENGTH_SHORT).show();
                         }
                     }
        );

    }//fim do oncreat

    /** CLASSE DE ADAPTER DA RECYCLERVIEW**/
    private class LivroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        //quando fazemos uma view holder dentro da adpter, ele localiza sozinho

        //atributo de list item
        //precisamos passar dados para itens antes de criar a view
        List<Item> itens;

        public LivroAdapter(List<Item> itens){
            this.itens = itens;

        }

        //cria a view holder
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //ela infla um layout conforma a quantidade
            return new LivroAdapter.LivroViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_livro, parent, false));
        }

        //passsa os dados para a view holder
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            //dados de livro
            if(getItemViewType(position) == 0){

                Livro livro = (Livro) itens.get(position).getObject();
                //convertemos o holder para o livroViewholder
                ((LivroAdapter.LivroViewHolder) holder).setLivroData(livro);
            }

//            //dados de livro
//            if(getItemViewType(position) == 1){
//
//            }
//
//            //dados de livro
//            if(getItemViewType(position) == 2){
//
//            }
        }
        //conta a quantidade de livros
        @Override
        public int getItemCount() {
            return itens.size();
        }


        public int getItemViewType(int position){
            return itens.get(position).getType();
        }


        /** CALSSE DE VIEWHOLDER DA RECYCLERVIEW **/
        //classe que monta a estrutura efetivamente de acorod com os dados que vem do banco de dados
        //ela infla todos os cards que precisa
            //classe que herda uma outra classe
            //precisamos chamar a classe construtora da view holder
        class LivroViewHolder extends RecyclerView.ViewHolder{

            /** ATRIBUTOS DA CLASS LIVROVIEWHOLDER **/
            private TextView tvTituloLivro, tvDescricaoLivro;
            private int cod_livro;

            //View itemView - elementos de view (et, tv, btn)
            //o item_conteiner entre na no itemView
            public LivroViewHolder(@NonNull View itemView) {
                //estamos chamando o mestoto construtor de quem foi herdado
                super(itemView);

                tvTituloLivro = itemView.findViewById(R.id.tvItemContainerLivro_Titulo);
                tvDescricaoLivro = itemView.findViewById(R.id.tvItemContainerLivro_Descricao);

                /** AÇÃO DE CLIQUE PARA EDITAR LIVRO E EXCLUIR LIVRO **/

                itemView.setOnClickListener(view -> {

                    /**
                     * Onde vai abrir
                     * A mensagem que queremos - set message
                     * Confirmr a acao - set posive button
                     *     Parametros:
                     *          1 - titulo
                     *          2 - acao a ser executada
                     * Negar a acao - set negatice button
                     *      Parametros:
                     *          1 - titulo
                     *          2 - acao a ser executada
                     **/
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(FeedLivro.this)
                            .setMessage("O que você deseja fazer?")
                            .setPositiveButton("Editar", (dialog1, witch)->{

                                Intent intent = new Intent(FeedLivro.this, AlterarLivro.class);
                                intent.putExtra("cod_livro", cod_livro);
                                startActivity(intent);
                            })
                            .setNegativeButton("Excluir", (dialog1, witch)->{

                                routerInterface = APIUtil.getAPIInterface();
                                Call<Livro> call = routerInterface.delLivro(cod_livro);
                                call.enqueue(new Callback<Livro>() {
                                    @Override
                                    public void onResponse(Call<Livro> call, Response<Livro> response) {
                                        Toast.makeText(FeedLivro.this, "Você exclui um livro", Toast.LENGTH_SHORT).show();
                                        recreate();
//                                        finish();
//                                        overridePendingTransition(0,0);
//                                        startActivity(getIntent());
//                                        overridePendingTransition(0, 0);
                                    }

                                    @Override
                                    public void onFailure(Call<Livro> call, Throwable t) {
                                        Toast.makeText(FeedLivro.this, "Nem foi nega", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            })
                            ;
                    alertDialog.show();
                });

            }//fim do construtor da classe livroviewholder

            /** MÉTODO QUE CARREGA OS CALORES NOS ELEMENTOS DE TEXTVIEW
             * tvTituloLivro
             * tvDescricaoLivro
             * **/

            public void setLivroData(Livro livro){
                tvTituloLivro.setText(livro.getTitulo());
                tvDescricaoLivro.setText(livro.getDescricao());
                //precisamodo cod livro para informar qual estamos editando
                cod_livro = livro.getCod_livro();
            }
        }//fim da classe livroViewHolder

    }

}//fim da classe