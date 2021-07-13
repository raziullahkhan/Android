package udemy.android1.fragmentrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Person> people;
    @Override
    public void onCreate() {
        super.onCreate();
        people=new ArrayList<Person>();
        people.add(new Person("Chuck Norris","765672837356"));
        people.add(new Person("John Rambo","76342562789273"));
        people.add(new Person("Nelson Mandela","63543726383383"));
    }
}
