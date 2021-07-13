package udemy.android1.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText etName,etNumber,etWeb,etMap;
    ImageView ivGreen,ivYellow,ivRed;
    String [] details=new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etName=findViewById(R.id.etName);
        etNumber=findViewById(R.id.etNumber);
        etWeb=findViewById(R.id.etWeb);
        etMap=findViewById(R.id.etMap);
        ivGreen=findViewById(R.id.ivGreen);
        ivYellow=findViewById(R.id.ivYellow);
        ivRed=findViewById(R.id.ivRed);

        ivGreen.setImageResource(R.drawable.gref);
        ivYellow.setImageResource(R.drawable.yelf);
        ivRed.setImageResource(R.drawable.redf);

        ivGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()==false){
                    Toast.makeText(Activity2.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                    return ;
                }
                details[4]="g";
                setResult();
            }
        });

        ivRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()==false){
                    Toast.makeText(Activity2.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                    return ;
                }
                details[4]="r";
                setResult();
            }
        });

        ivYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()==false){
                    Toast.makeText(Activity2.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                    return ;
                }
                details[4]="y";
                setResult();
            }
        });
    }

    public boolean validateInput(){
        if(etName.getText().toString().trim().isEmpty()
            ||etNumber.getText().toString().trim().isEmpty()
            ||etWeb.getText().toString().trim().isEmpty()
            ||etMap.getText().toString().trim().isEmpty()){

            return false;
        }

        String name=etName.getText().toString().trim();
        String number=etNumber.getText().toString().trim();
        String web=etWeb.getText().toString().trim();
        String map=etMap.getText().toString().trim();

        details[0]=name;
        details[1]=number;
        details[2]=web;
        details[3]=map;

        return true;
    }

    public void setResult(){
        Intent intent=new Intent();
        intent.putExtra("details",details);
        setResult(RESULT_OK,intent);
        Activity2.this.finish();
    }
}