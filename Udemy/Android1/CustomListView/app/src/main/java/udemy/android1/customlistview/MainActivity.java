package udemy.android1.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProducts;
    TextView textView;
    ArrayList<Product> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvProducts=(ListView) findViewById(R.id.lvProducts);
        textView=findViewById(R.id.textView);
        textView.setText("Products");
        list=new ArrayList<Product>();
        Product product1=new Product("Dell Latitude 3500",
                "The World's most secure, most manageable and most reliable business-class laptops.",
                "Laptop",14500.99,true);
        Product product2=new Product("Acer Aspire 7",
                "Revolutionary convertible computers that feature powerful innovation and forward-thinking design.",
                "Screen",12500.99,false);
        Product product3=new Product("SANDISK 16 GB Cruzer",
                "Low-cost, no-nonsense way of storing and transporting files.",
                "Memory",299.99,false);
        Product product4=new Product("Verbatim 1TB",
                "Verbatim's portable hard drive product offerings are exceptionally reliable and fashionably thin.",
                "HDD",1020.99,true);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        ProductAdapter adapter=new ProductAdapter(this,list);
        lvProducts.setAdapter(adapter);
        textView.setVisibility(View.VISIBLE);
    }
}