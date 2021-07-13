package udemy.android1.fragmentrecyclerview;

public class Person {
    private String Name;
    private String telNr;

    public Person(String name, String telNr) {
        Name = name;
        this.telNr = telNr;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }
}
