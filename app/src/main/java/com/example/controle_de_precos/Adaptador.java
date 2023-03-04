import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controle_de_precos.GetterSetter;
import com.example.controle_de_precos.MeuDatabase;
import com.example.controle_de_precos.R;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyRecycler> {
    Context context;
    ArrayList<GetterSetter> lista;
    MeuDatabase mdb;

    public Adaptador(Context context, ArrayList<GetterSetter> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public MyRecycler onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);
        return new MyRecycler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycler myRecycler, int position) {
        final GetterSetter gs = lista.get(position);
        myRecycler.tvNome.setText(gs.getNome());
        myRecycler.tvNumero.setText(gs.getNumero());
        myRecycler.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdb = new MeuDatabase(v.getContext());
                mdb.removeContato(gs.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyRecycler extends RecyclerView.ViewHolder {
        TextView tvNome, tvNumero;
        ImageButton btEdit, btDelete;

        public MyRecycler(View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id);
            tvNumero = itemView.findViewById(R.id.tvNumero);
            btEdit = itemView.findViewById(R.id.btEdit);
            btDelete = itemView.findViewById(R.id.btDelete);
        }
    }
}