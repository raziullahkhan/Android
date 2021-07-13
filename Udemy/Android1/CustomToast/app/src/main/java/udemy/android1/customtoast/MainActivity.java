package udemy.android1.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast=(Button)findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();
                showToast("Data Successfully saved!");
            }
        });
    }
    public void showToast(String message){
        View toastView=getLayoutInflater().inflate(R.layout.toast,(ViewGroup)findViewById(R.id.linlay));
        TextView tvToast=(TextView) toastView.findViewById(R.id.tvToast);
        tvToast.setText(message);
        Toast toast=new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastView);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,25);
        toast.show();
    }
}