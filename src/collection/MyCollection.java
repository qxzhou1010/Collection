package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyCollection{

    public static void main(String[] args) {

        //自定义泛型的使用
        MyCollect<String> mc = new MyCollect<String>();
        mc.setObjs("aaa", 0);
        mc.setObjs("bbb", 1);

        String str = mc.get(0);
        System.out.println(str);

        //在集合中使用泛型
        List<String> list = new ArrayList<String>();


    }
}



class MyCollect<E>{ //E表示泛型
    //泛型就像一个占位符，表示暂时还未知的某个数据类型，当真正调用的时候，再传入这个数据类型
    Object[] objs = new Object[5];

    public E get(int index){
        return (E) objs[index];
    }
    public void setObjs(E e, int index){
        objs[index] = e;

    }
}
