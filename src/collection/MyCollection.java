package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyCollection{

    public static void main(String[] args) {

        //�Զ��巺�͵�ʹ��
        MyCollect<String> mc = new MyCollect<String>();
        mc.setObjs("aaa", 0);
        mc.setObjs("bbb", 1);

        String str = mc.get(0);
        System.out.println(str);

        //�ڼ�����ʹ�÷���
        List<String> list = new ArrayList<String>();


    }
}



class MyCollect<E>{ //E��ʾ����
    //���;���һ��ռλ������ʾ��ʱ��δ֪��ĳ���������ͣ����������õ�ʱ���ٴ��������������
    Object[] objs = new Object[5];

    public E get(int index){
        return (E) objs[index];
    }
    public void setObjs(E e, int index){
        objs[index] = e;

    }
}
