package udemy.android1.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvNumber;
    TextView tvResult;
    String [] str;
    Button btnBack,btnC,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDec,btnEql,btnDiv,btnMul,btnAdd,btnSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber=findViewById(R.id.tvNumber);
        tvResult=findViewById(R.id.tvResult);
        btnC=findViewById(R.id.btnC);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn0=findViewById(R.id.btn0);
        btnDec=findViewById(R.id.btnDec);
        btnEql=findViewById(R.id.btnEql);
        btnDiv=findViewById(R.id.btnDiv);
        btnMul=findViewById(R.id.btnMul);
        btnSub=findViewById(R.id.btnSub);
        btnAdd=findViewById(R.id.btnAdd);
        btnBack=findViewById(R.id.btnBack);
        
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("");
                String st=(String)tvNumber.getText();
                String lt="";
                for(int i=0;i<st.length();i++){
                    if(i!=st.length()-1){
                        lt=lt+String.valueOf(st.charAt(i));
                    }
                }
                tvNumber.setText(lt);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText("");
                tvResult.setText("");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"1");
                tvResult.setText("");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"2");
                tvResult.setText("");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"3");
                tvResult.setText("");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"4");
                tvResult.setText("");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"5");
                tvResult.setText("");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"6");
                tvResult.setText("");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"7");
                tvResult.setText("");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"8");
                tvResult.setText("");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"9");
                tvResult.setText("");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"0");
                tvResult.setText("");
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+".");
                tvResult.setText("");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"/");
                tvResult.setText("");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"*");
                tvResult.setText("");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"-");
                tvResult.setText("");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNumber.setText(tvNumber.getText()+"+");
                tvResult.setText("");
            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvNumber.getText().toString().isEmpty()){
                    return;
                }
                calculate();
                tvResult.setText(str[0]);

            }
        });
    }
    public void calculate(){
        try {
            String st = (String) tvNumber.getText();
            str=new String[st.length()];
            int n=0;
            int l=0;

            for(int i=0;i<st.length();i++){
                if((st.charAt(i)=='-'||st.charAt(i)=='+')&&i==0){//

                }
                else if(st.charAt(i)=='+'||st.charAt(i)=='-'||st.charAt(i)=='*'||st.charAt(i)=='/'){
                    String tv="";
                    for(;n<i;n++){
                        tv=tv+String.valueOf(st.charAt(n));
                    }
                    str[l++]=tv;
                    str[l++]=String.valueOf(st.charAt(i));
                    n++;
                }
                else if(i==st.length()-1){
                    String tv="";
                    for(;n<=i;n++){
                        tv=tv+String.valueOf(st.charAt(n));
                    }
                    str[l++]=tv;
                    n++;
                }
            }

            double d=0;
            int size=str.length;
            int z=0;
            for(int i=0;i<size;i++) {
                if (str[i] != null) {
                    if (str[i].charAt(0) == '*') {
                        d = Double.parseDouble(str[i - 1]) * Double.parseDouble(str[i + 1]);
                        str[i - 1] = String.valueOf(d);
                        for (z = i; z < size - 2; z++) {
                            str[z] = str[z + 2];
                        }
                        size = size - 2;
                        i = -1;
                    } else if (str[i].charAt(0) == '/') {
                        d = Double.parseDouble(str[i - 1]) / Double.parseDouble(str[i + 1]);
                        str[i - 1] = String.valueOf(d);
                        for (z = i; z < size - 2; z++) {
                            str[z] = str[z + 2];
                        }
                        size = size - 2;
                        i = -1;
                    }
                }
            }
            d=0;

            z=0;
            for(int i=0;i<size;i++){
                if(str[i]!=null){
                    if(str[i].charAt(0)=='+'&&str[i].length()==1){
                        d=Double.parseDouble(str[i-1])+Double.parseDouble(str[i+1]);
                        str[i-1]=String.valueOf(d);
                        for(z=i;z<size-2;z++){
                            str[z]=str[z+2];
                        }
                        size=size-2;
                        i=-1;
                    }
                    else if(str[i].charAt(0)=='-'&&str[i].length()==1){
                        //System.out.println(Double.parseDouble("-(-4.8)"));
                        d=Double.parseDouble(str[i-1])-(Double.parseDouble(str[i+1]));
                        str[i-1]=String.valueOf(d);
                        for(z=i;z<size-2;z++){
                            str[z]=str[z+2];
                        }
                        size=size-2;
                        i=-1;
                    }
                }
            }
        }
        catch(Exception e){
            tvNumber.setText("");
            tvResult.setText("");
            Toast.makeText(this, "Please Enter Correct Number", Toast.LENGTH_SHORT).show();

        }
    }
    public void shift(double res,int i) {
        str[i - 1] = String.valueOf(res);
        for (; i < (str.length - 2); i++) {
            str[i] = str[i + 2];
        }
    }
}