package homework4;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args)  {
        Scanner f = new Scanner(System.in);
        Student i1 = new Student("none", "none", 0, "none");
        System.out.println("����������༶��������ѧ�ţ��Ա�");
        String i2 = f.next();
        i1.setC(i2);
        String i3 = f.next();
        i1.setName(i3);
        int i4 = f.nextInt();
        i1.setNumber(i4);
        String i5 = f.next();
        i1.setSex(i5);
        try {
            BufferedReader in = new BufferedReader(new FileReader("E:\\B.txt"));
            String str = in.readLine();
            String regex = "(.{7})";
            str = str.replaceAll(regex,"$1��");
            StringBuffer n1 = new StringBuffer(str);
            for (int i =15;i<289;i=i+17) {
                n1.replace(i, i + 1, "��\n");
            }
            System.out.println(n1);
            System.out.println(i1);
            FileWriter writer = new FileWriter("E:/A.txt");
            writer.write(String.valueOf(i1));
            writer.write(String.valueOf(n1));
            writer.flush();
            writer.close();
            System.out.println("�ļ�д��ɹ�!");
            Scanner k = new Scanner(System.in);
            String[] ai = str.split("");
            System.out.println("1Ϊ��ѯ�֣�2Ϊ��ѯ�ʣ�3Ϊ����:");
            s:
            for (int w = 0; w < 9999; w++) {
                int v = k.nextInt();
                switch (v) {
                    case 1:
                        System.out.println("��������Ҫ��ѯ����:");
                        Scanner h = new Scanner(System.in);
                        String h1 = h.nextLine();
                        int a=0;
                        for (int i = 0; i < str.length(); i++) {
                            if(Objects.equals(ai[i], h1)){
                                a++;
                            }
                        }
                        System.out.println("����Ϊ: "+a);
                        System.out.println("1Ϊ��ѯ�֣�2Ϊ��ѯ�ʣ�3Ϊ����:");
                        break;
                    case 2:
                        System.out.println("��������Ҫ��ѯ�Ĵ�:");
                        Scanner r = new Scanner(System.in);
                        String r1 = r.nextLine();
                        int count = 0;
                        int index = 0;
                        while ((index = str.indexOf(r1, index)) != -1) {

                            index = index + r1.length();
                            count++;
                        }
                        System.out.println("����Ϊ: "+count);
                        System.out.println("1Ϊ��ѯ�֣�2Ϊ��ѯ�ʣ�3Ϊ����:");
                        break;
                    case 3:
                        break s;

                }
            }

        } catch (Exception e) {
            System.out.println("���ִ���!");
        }
    }
}