package udacity.user_input.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvQuantity;
    CheckBox cbCream;
    CheckBox cbChoco;
    Button btnOrder;
    Button btnInc;
    Button btnMail;
    Button btnDec;
    TextView tvPrice;
    EditText etName;
    int quantity=0;
    String name;
    String summ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvQuantity=(TextView)findViewById(R.id.tvQuantity);
        cbChoco=(CheckBox)findViewById(R.id.cbChoco) ;
        btnMail=(Button)findViewById(R.id.btnMail);
        cbCream=(CheckBox)findViewById(R.id.cbCream);
        btnOrder=(Button)findViewById(R.id.btnOrder);
        tvPrice=(TextView)findViewById(R.id.tvPrice);
        btnDec=(Button)findViewById(R.id.btnDec);
        btnInc=(Button)findViewById(R.id.btnInc);
        etName=(EditText)findViewById(R.id.etName);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateInput()){
                    Toast.makeText(MainActivity.this, "Enter Your Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                displayPrice();
            }
        });
        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity=Integer.parseInt(tvQuantity.getText().toString());
                quantity++;
                displayQuantity();
            }
        });
        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateInput()){
                    Toast.makeText(MainActivity.this, "Enter Your Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Coffee Order");
                intent.putExtra(Intent.EXTRA_TEXT,summ);
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity==0){
                    return;
                }
                quantity=Integer.parseInt(tvQuantity.getText().toString());
                quantity--;
                displayQuantity();
            }
        });
    }

    private boolean validateInput() {
        name=etName.getText().toString().trim();
        if(name.isEmpty()){
            return false;
        }
        return true;
    }

    private void displayPrice(){
        int price=quantity*5;
        String cream="No",choco="No";
        if(cbCream.isChecked()){
            cream="Yes";
            price=(quantity*1)+price;
        }
        if(cbChoco.isChecked()){
            choco="Yes";
            price=price+(2*quantity);
        }
        summ="Name: "+name+"\nQuantity: "+quantity+"\nAdd Whipped cream? "+cream+"\nAdd Chocolate? "+choco+"\nTotal: \u20B9"+price+"\nThank you!";
       tvPrice.setText(summ);
    }
    private void displayQuantity(){
        tvQuantity.setText(String.valueOf(quantity));

    }
}