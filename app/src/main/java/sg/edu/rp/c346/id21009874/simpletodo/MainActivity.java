package sg.edu.rp.c346.id21009874.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnAdd;
    Button btnClear;
    ListView Todo;
    ArrayList<String> atTodo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        Todo = findViewById(R.id.lvTodo);
        editText = findViewById(R.id.editText);

        atTodo = new ArrayList<>();

        aaTodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, atTodo);
        Todo.setAdapter(aaTodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String newTodo = editText.getText().toString();
                atTodo.add(newTodo);
                aaTodo.notifyDataSetChanged();;
                editText.setText(null);
        }
        });

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                atTodo.clear();
                aaTodo.notifyDataSetChanged();
            }
        });
    }
}