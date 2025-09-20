package com.example.app1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainTareas extends AppCompatActivity {

    private EditText editTextTarea;
    private Button btnAgregar, btnEliminarCompletadas;
    private ListView listViewTareas;
    private TextView txtPorcentaje;
    private ArrayList<String> listaTareas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tareas);

        editTextTarea = findViewById(R.id.editTxtTarea);
        btnAgregar = findViewById(R.id.btnAgregarTarea);
        btnEliminarCompletadas = findViewById(R.id.btnEliminarCompletadas);
        listViewTareas = findViewById(R.id.listViewTareas);
        txtPorcentaje = findViewById(R.id.txtPorcentaje);

        listaTareas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice,
                listaTareas);

        listViewTareas.setAdapter(adapter);
        listViewTareas.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Agregar tarea
        btnAgregar.setOnClickListener(v -> {
            String texto = editTextTarea.getText().toString().trim();
            if (!texto.isEmpty()) {
                listaTareas.add(texto);
                adapter.notifyDataSetChanged();
                editTextTarea.setText("");
                actualizarPorcentaje();
            }
        });

        // Marcar como completada → actualizar porcentaje
        listViewTareas.setOnItemClickListener((parent, view, position, id) -> {
            actualizarPorcentaje();
        });

        // Eliminar tareas completadas
        btnEliminarCompletadas.setOnClickListener(v -> {
            for (int i = listViewTareas.getCount() - 1; i >= 0; i--) {
                if (listViewTareas.isItemChecked(i)) {
                    listaTareas.remove(i);
                }
            }
            adapter.notifyDataSetChanged();
            listViewTareas.clearChoices();
            actualizarPorcentaje();
        });
    }

    //Método para calcular y mostrar el porcentaje
    private void actualizarPorcentaje() {
        int total = listaTareas.size();
        if (total == 0) {
            txtPorcentaje.setText("Completadas: 0%");
            return;
        }

        int completadas = 0;
        for (int i = 0; i < total; i++) {
            if (listViewTareas.isItemChecked(i)) {
                completadas++;
            }
        }

        int porcentaje = (completadas * 100) / total;
        txtPorcentaje.setText("Completadas: " + porcentaje + "%");
    }
}
