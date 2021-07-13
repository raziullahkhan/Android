package udemy.android1.intentchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ColorStateListInflaterCompat;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnCreate;
    ImageView ivFace;
    ImageView ivCall;
    ImageView ivWeb;
    ImageView ivMap;
    TextView tvName;
    final int CREATE=2;
    String num,web,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreate=findViewById(R.id.btnCreate);
        ivFace=findViewById(R.id.ivFace);
        ivCall=findViewById(R.id.ivCall);
        ivWeb=findViewById(R.id.ivWeb);
        ivMap=findViewById(R.id.ivMap);
        tvName=findViewById(R.id.tvName);

        ivFace.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);
        tvName.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,udemy.android1.intentchallenge.Activity2.class);
                startActivityForResult(intent,CREATE);
            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+web));
                startActivity(intent);
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+map));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CREATE){

            if(resultCode==RESULT_OK){
                String[] str=data.getStringArrayExtra("details");
                if(str[4].equals("y")){
                    ivFace.setImageResource(R.drawable.yelf);
                }
                else if(str[4].equals("g")){
                    ivFace.setImageResource(R.drawable.gref);
                }
                else{
                    ivFace.setImageResource(R.drawable.redf);
                }

                ivFace.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivCall.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);
                tvName.setVisibility(View.VISIBLE);
                tvName.setText(str[0]);
                num=str[1];
                web=str[2];
                map=str[3];
            }
        }
    }
}