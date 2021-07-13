package udemy.android1.challengefragmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Car> cars;
    @Override
    public void onCreate() {
        super.onCreate();
        cars=new ArrayList<Car>();
        cars.add(new Car("Volkswagen","Polo","Chuck Norris","092309809"));
        cars.add(new Car("Mercedes","E200","Peter Pollock","092309809"));
        cars.add(new Car("Nissan","Almera","Chris James","092309809"));
        cars.add(new Car("Mercedes","E180","John Rambo","092309809"));
        cars.add(new Car("Volkswagen","Kombi","Nelson Mandela","092309809"));
        cars.add(new Car("Nissan","Navara","Paul Bunting","092309809"));
    }
}
