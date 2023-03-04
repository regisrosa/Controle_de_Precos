package com.example.controle_de_precos;

public class DisplayActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        rv = (RecyclerView) findViewById(R.id.rev);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DisplayActivity.this);
        rv.setLayoutManager(layoutManager);
        mdb = new MeuDatabase(DisplayActivity.this);
        cursor = mdb.getDados();
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    id = cursor.getString(0);
                    nome = cursor.getString(1);
                    numero = cursor.getString(2);
                    GetterSetter gs = new GetterSetter(nome, numero, id);
                    lista.add(gs);
                } while (cursor.moveToNext());
            }
        }
        Adaptador adaptador = new Adaptador(DisplayActivity.this, lista);
        rv.setAdapter(adaptador);
    }
}
