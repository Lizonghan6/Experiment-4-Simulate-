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
请依次输入班级，姓名，学号，性别，
大191
李宗翰
2019310466
男
汉皇重色思倾国，御宇多年求不得。
杨家有女初长成，养在深闺人未识。
天生丽质难自弃，一朝选在君王侧。
回眸一笑百媚生，六宫粉黛无颜色。
春寒赐浴华清池，温泉水滑洗凝脂。
侍儿扶起娇无力，始是新承恩泽时。
云鬓花颜金步摇，芙蓉帐暖度春宵。
春宵苦短日高起，从此君王不早朝。
承欢侍宴无闲暇，春从春游夜专夜。
后宫佳丽三千人，三千宠爱在一身。
金屋妆成娇侍夜，玉楼宴罢醉和春。
姊妹弟兄皆列士，可怜光采生门户。
遂令天下父母心，不重生男重生女。
骊宫高处入青云，仙乐风飘处处闻。
缓歌慢舞凝丝竹，尽日君王看不足。
渔阳鼙鼓动地来，惊破霓裳羽衣曲。
九重城阙烟尘生，千乘万骑西南行。

文件写入成功！
1为查询字，2为查询词，3为结束：
2
请输入您要查询的词：
六宫粉黛
字数为：1



实验感想:
通过本次实验进一步掌握了异常处理的使用方法，学会replace方法将字符串替换为空的方法，
基本掌握字符串Sring的读和写入的方法，对于scanner的函数实例化更加理解，但在本次实验
过程中仍出现很多的问题，通过互联网和询问同学的形式，逐一解决了问题，本次实验不仅
磨练了我的耐心，也让我明白集思广益和团结互助的重要性，使我对Java的学习更有信心，
利用互联网查找搜素有关string和stringbuffer的一些常用方法：


    String类常用方法：
    int length();求串长
    int compareTo(String anotherString);对字符串内容按字典序进行大小比较
    boolean equals(String anString); 比较两个字符串对象内容是否相等
    boolean equalsIgnoreCase(String anString);忽略大小写比较字符串对象内容是否相等
    int indexOF(int ch/String str);
    在字符串中搜索字符或子串，返回字符或子串在String对象中从左边起首次出现的位置。如果没有出现，返回-1。
    String replace(char oldChar,char newChar);将String对象中所有的oldChar字符替换为newChar，返回新串
    String toString();返回当前字符串本身

    StringBuffer类型
    StringBuffer类对象是一个内容可以改变的字符串，可以减少由于少量字符插入空间分配的问题。
    StringBuffer(int length);创建指定容量的空对象

    StringBuffer类常用方法
    int length();返回字符串长度
    int capacity();返回缓冲区大小
    viod setLength(int newLength);指定对象长度，对内容进行裁减
    void setCharAt(int index,char ch);将参数index指定位置上的字符换成参数ch指定的字符
    StringBuffer append(多种数据类型);将其他类型的数据添加到StringBuffer对象的尾部
    String toString();
   
