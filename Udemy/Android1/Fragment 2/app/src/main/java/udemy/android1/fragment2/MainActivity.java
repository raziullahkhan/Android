package udemy.android1.fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {
    TextView tvDescription;
    String [] descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDescription=findViewById(R.id.tvDescription);
        descriptions=getResources().getStringArray(R.array.descriptions);
        if(findViewById(R.id.layout_portrait)!=null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction().hide(manager.findFragmentById(R.id.detailFrag)).show(manager.findFragmentById(R.id.listFrag)).commit();
        }
        if(findViewById(R.id.layout_land)!=null){
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction().show(manager.findFragmentById(R.id.detailFrag)).show(manager.findFragmentById(R.id.listFrag)).commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions[index]);
        if(findViewById(R.id.layout_portrait)!=null){
            if(findViewById(R.id.layout_portrait)!=null){
                FragmentManager manager=this.getSupportFragmentManager();
                manager.beginTransaction().show(manager.findFragmentById(R.id.detailFrag)).hide(manager.findFragmentById(R.id.listFrag)).addToBackStack(null).commit();
            }
        }
    }
}