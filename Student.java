package homework4;
public class Student {
    String C;
    String name;
    int number;
    String sex;
    public Student(String C, String name, int number, String sex) {
    }
    public void setC(String C) {
        this.C = C;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSex(String sex){
        this.sex = sex;
    }
    public String toString() {
        return "�༶: " + C + " ����: " + name + " ѧ��: " + number + " �Ա�: " + sex +"\n";
    }
}