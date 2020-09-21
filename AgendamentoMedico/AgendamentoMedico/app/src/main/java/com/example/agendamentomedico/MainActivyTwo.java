package agendamentomedico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.unipar.agendamentos.adapter.AgendaAdapter;
import br.unipar.agendamentos.dao.AgendaDao;
import br.unipar.agendamentos.database.AppDatabase;
import br.unipar.agendamentos.database.RoomDatabaseOpenHelper;
import br.unipar.agendamentos.entities.Agenda;

public class lista_agendamentos extends AppCompatActivity {

    private ListView lvAgendamentos;
    private List<Agenda> agendamentos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agendamentos);

        lvAgendamentos = findViewById(R.id.lvAgendamentos);


        AppDatabase appDatabase = RoomDatabaseOpenHelper.getDatabase(new WeakReference<Context>(this));
        AgendaDao agendaDao = appDatabase.agendaDao();

        agendamentos = agendaDao.findAll();

        final WeakReference<Context> weakReference = new WeakReference(this);

        final AgendaAdapter agendaAdapter = new AgendaAdapter(agendamentos, weakReference);
        lvAgendamentos.setAdapter(agendaAdapter);
