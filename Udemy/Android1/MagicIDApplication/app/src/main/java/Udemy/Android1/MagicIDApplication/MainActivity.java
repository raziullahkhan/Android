package Udemy.Android1.MagicIDApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etId;
    Button btnSubmit;
    TextView tvResult;
    String d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId=findViewById(R.id.etId);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResult=findViewById(R.id.tvResult);
        tvResult.setText("");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  id=etId.getText().toString().trim();
                if(validateInput(id)==false){
                    String txt=getString(R.string.invalid);
                    tvResult.setText(txt);
                    return;
                }
                int gender=Integer.parseInt(Character.toString(id.charAt(6)));
                String sGender;
                if(gender<5)
                    sGender=getString(R.string.female);
                else
                    sGender=getString(R.string.male);
                int nationality=Integer.parseInt(Character.toString(id.charAt(10)));
                String sNationality;
                if(nationality==0)
                    sNationality=getString(R.string.ind);
                else
                    sNationality=getString(R.string.foreign);
                String text=getString(R.string.dob)+" "+d+getString(R.string.newline)+getString(R.string.gender)+" "+sGender+getString(R.string.newline)+getString(R.string.nationality)+" "+sNationality;
                tvResult.setText(text);
            }
        });
    }
    private boolean validateInput(String str){
        if(str.length()!=13){
            return false;
        }
        String dob=str.substring(0,6);
        int day=Integer.parseInt(dob.substring(4,6));
        if(day>=31){
            return false;
        }
        d=String.valueOf(day)+"-";
        int mon=Integer.parseInt(dob.substring(2,4));
        if(mon>=13){
            return false;
        }

        d=d.concat(getMonth(mon))+"-";
        int year=Integer.parseInt(dob.substring(0,2));
        if(year<=19){
            year+=2000;
            d=d.concat(String.valueOf(year));
        }
        else{
            year+=1900;
            d=d.concat(String.valueOf(year));
        }
        return true;
    }
    private String getMonth(int mon){
        String m;
        switch (mon){
            case 1:
               m="January" ;
               break;
            case 2:
                m="February" ;
                break;
            case 3:
                m="March" ;
                break;
            case 4:
                m="April" ;
                break;
            case 5:
                m="May" ;
                break;
            case 6:
                m="June" ;
                break;
            case 7:
                m="July" ;
                break;
            case 8:
                m="August" ;
                break;
            case 9:
                m="September" ;
                break;
            case 10:
                m="October" ;
                break;
            case 11:
                m="November" ;
                break;
            default:
                m="December";
                break;
        }
        return m;
    }
}