package data;

import java.util.ArrayList;

public abstract class Attribute {
    // Atributos
    String atribName;
    int index;
    ArrayList value_;

    //Constructor
    Attribute() {
        atribName = "";
        index = 0;
        value_ = new ArrayList();
    }

    // Metodos

    public Object getValue_(int i) {
        return value_.get(i);
    }

    public int Size() {
        return value_.size();
    }

    public void Write(int i) {
        System.out.print(value_.get(i) + " ");
    }

    public abstract void Normalize();

    public abstract void Add(String str);

    public abstract Double NormalizeVal(double val);

}
