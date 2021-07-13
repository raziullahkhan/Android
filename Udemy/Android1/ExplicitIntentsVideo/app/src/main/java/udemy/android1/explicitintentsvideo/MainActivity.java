package udemy.android1.explicitintentsvideo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    Button btnAct2,btnAct3;
    TextView tvResult;
    final int ACTIVITY3=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.etName);
        btnAct2=findViewById(R.id.btnAct2);
        btnAct3=findViewById(R.id.btnAct3);
        tvResult=findViewById(R.id.tvResult);
        tvResult.setText("");
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your name!", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name=etName.getText().toString().trim();
                    Intent intent=new Intent(MainActivity.this,
                            udemy.android1.explicitintentsvideo.Activity2.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,
                        udemy.android1.explicitintentsvideo.Activity3.class);
                startActivityForResult(intent,ACTIVITY3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY3)
        {
            if(resultCode==RESULT_OK){
                tvResult.setText(data.getStringExtra("surname"));
            }
            if(resultCode==RESULT_CANCELED){
                tvResult.setText(R.string.data);
            }
        }
    }
}