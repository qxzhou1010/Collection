package io;

import java.security.PublicKey;


public class TestDecoration {
    public static void main(String[] args) {
        Phone phone = new Phone("mix2s");
        phone.show();
        //装饰
        TouyingPhone typhone = new TouyingPhone(phone);
        typhone.show();
    }


}

class Phone{

    private String name;
    public Phone(String name){
        this.name = name;
    }
    public void show(){
        System.out.println("my name is " + name + "can display on screen");

    }


}

class TouyingPhone{
    public Phone phone;
    public TouyingPhone(Phone phone){
        this.phone = phone;
    }
    //更强的功能
    public void show(){
        phone.show();
        System.out.println("after decoration, the phone can display on wall");
    }

}
