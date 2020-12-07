# Experiment-4-Simulate-
Simulate student work processing


实验目的：
掌握字符串String及其方法的使用
掌握文件的读取/写入方法
掌握异常处理结构

实验内容：
在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。
文件A包括两部分内容：
一是学生的基本信息；
二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：

1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
2.允许提供输入参数，统计古诗中某个字或词出现的次数
3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A
4.考虑操作中可能出现的异常，在程序中设计异常处理程序


核心代码：
package homework4;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    public static void main(String[] args)  {
        Scanner f = new Scanner(System.in);
        Student i1 = new Student("none", "none", 0, "none");
        System.out.println("请依次输入班级，姓名，学号，性别：");
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
            str = str.replaceAll(regex,"$1，");
            StringBuffer n1 = new StringBuffer(str);
            for (int i =15;i<289;i=i+17) {
                n1.replace(i, i + 1, "。\n");
            }
            System.out.println(n1);
            System.out.println(i1);
            FileWriter writer = new FileWriter("E:/A.txt");
            writer.write(String.valueOf(i1));
            writer.write(String.valueOf(n1));
            writer.flush();
            writer.close();
            System.out.println("文件写入成功!");
            Scanner k = new Scanner(System.in);
            String[] ai = str.split("");
            System.out.println("1为查询字，2为查询词，3为结束:");
            s:
            for (int w = 0; w < 9999; w++) {
                int v = k.nextInt();
                switch (v) {
                    case 1:
                        System.out.println("请输入您要查询的字:");
                        Scanner h = new Scanner(System.in);
                        String h1 = h.nextLine();
                        int a=0;
                        for (int i = 0; i < str.length(); i++) {
                            if(Objects.equals(ai[i], h1)){
                                a++;
                            }
                        }
                        System.out.println("字数为: "+a);
                        System.out.println("1为查询字，2为查询词，3为结束:");
                        break;
                    case 2:
                        System.out.println("请输入您要查询的词:");
                        Scanner r = new Scanner(System.in);
                        String r1 = r.nextLine();
                        int count = 0;
                        int index = 0;
                        while ((index = str.indexOf(r1, index)) != -1) {

                            index = index + r1.length();
                            count++;
                        }
                        System.out.println("字数为: "+count);
                        System.out.println("1为查询字，2为查询词，3为结束:");
                        break;
                    case 3:
                        break s;

                }
            }

        } catch (Exception e) {
            System.out.println("出现错误!");
        }
    }
}

核心方法：
1，利用scanner方法来进行交互输入
2，在bufferedReader方法中读取，存储文件
3，异常处理
4，for()循环去筛查用户的查询字
5，indexOF()方法查找字符串中某一字符的查找

运行截图：
