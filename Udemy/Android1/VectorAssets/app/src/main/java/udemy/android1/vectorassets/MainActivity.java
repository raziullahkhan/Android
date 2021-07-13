package udemy.android1.vectorassets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivPic;
    ImageView ivBeach;
    ImageView ivBuild;
    ImageView ivCake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPic=findViewById(R.id.ivPic);
        ivBeach=findViewById(R.id.ivBeach);
        ivBuild=findViewById(R.id.ivBuild);
        ivCake=findViewById(R.id.ivCake);

        ivBeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPic.setImageResource(R.drawable.beach);
            }
        });

        ivBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPic.setImageResource(R.drawable.build);
            }
        });

        ivCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPic.setImageResource(R.drawable.cake);
            }
        });
    }
}