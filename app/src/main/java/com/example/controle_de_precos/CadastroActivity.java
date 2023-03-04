package com.example.controle_de_precos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroActivity extends AppCompatActivity {

    @BindView(R.id.produto)
    EditText etproduto;

    @BindView(R.id.estabelecimento)
    EditText etestab;

    @BindView(R.id.preco)
    EditText etpreco;

    @BindView(R.id.data)
    EditText etdata;

    @BindView(R.id.salvarButton)
    Button salvar_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    private void cadastrarCompra(){

        salvar_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String produto = etproduto.getText().toString();
                String estab = etestab.getText().toString();
                String preco = etpreco.getText().toString();
                String data = etdata.getText().toString();

                SharedPreferences sharedPrefs = getSharedPreferences("userData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putString("Produto:", produto);
                editor.putString("Estabelecimento:", estab);
                editor.putString("Preço:", preco);
                editor.putString("Data:", data);

                editor.apply();

                Intent intent = new Intent(CadastroActivity.this, HomeActivity.class);
                startActivity(intent);

                

                Toast.makeText(CadastroActivity.this, "Compra cadastrada com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}