package agendamentomedico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import br.unipar.agendamentos.dao.AgendaDao;
import br.unipar.agendamentos.database.AppDatabase;
import br.unipar.agendamentos.database.RoomDatabaseOpenHelper;
import br.unipar.agendamentos.entities.Agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tela2 );

        dataAgendamento = findViewById(R.id.dataAgendamento.txt);
        dataConsulta = findViewById(R.id.dataConsulta.txt);

        Bundle bundle = getIntent().getExtras();

        dataAgendamento.setText(bundle.getString("dataAgendamento"));
        dataConsulta.setText("Dia" + bundle.getString("dataConsulta"));

    }

    public void onClickVoltar(View view){
        finish();
    }


    public class MainActivity extends AppCompatActivity {

        private EditText edNome;
        private EditText edDataAgendamento;
        private EditText edTipoConsulta;
        private EditText observacao;
        private EditText edMedico;
        private EditText edEmail;
        private EditText CPF;
        private Button btnAgendar;
        private Button btnLimpar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            edNome = findViewById(R.id.edNome);
            edDataAgendamento = findViewById(R.id.edDataAgendamento);
            edMedico = findViewById(R.id.edMedico);
            edEmail = findViewById(R.id.edEmail);
            btnAgendar = findViewById(R.id.btnAgendar);

            btnAgendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isEmpty()){
                        Toast.makeText(MainActivity.this, "Todos os Campos deverão ser preenchidos", Toast.LENGTH_LONG).show();
                        return;
                    }

                    Agendamento agenda = new Agenda();

                    agenda.setNomePaciente(edNome.getText().toString());
                    agenda.setDataAgendamento(edDataAgendamento.getText().toString());
                    agenda.setMedicoResponsavel(edMedico.getText().toString());
                    agenda.setCelularPaciente(edCelular.getText().toString());
                    agenda.setEmailPaciente(edEmail.getText().toString());


                    goToNewActivity();
                }
            });

        }

        private boolean isEmpty() {

            String nome = edNome.getText().toString();
            String dataAgendamento = edDataAgendamento.getText().toString();
            String tipoConsulta = edTipoConsulta.getText().toString();
            String observacao = observacao.getText().toString();
            String medico = edMedico.getText().toString();
            String email = edEmail.getText().toString();
            String cpf = CPF.getText().toString();


            if (TextUtils.isEmpty(nome) ||
                    TextUtils.isEmpty(data) ||
                    TextUtils.isEmpty(medico) ||
                    TextUtils.isEmpty(email)) {
                return true;
            }

            return false;
        }

        private void goToNewActivity() {
            Intent intent = new Intent(MainActivity.this, lista_agendamentos.class);

            startActivity(intent);
            finish();
        }

    }
}