class Subject
{
int a,b;
void getMarks(int x,int y)
{
a=x;
b=y;
}
void putMarks()
{
System.out.println("Marks In First Sub:"+a);
System.out.println("Marks In Second Sub:"+b);
}
}
interface Sport
{
int sp=90;
void sportMarks();
}
class Result extends Subject implements Sport
{
public void sportMarks()
{
System.out.println("Sports Marks:"+sp);
}
void display()
{
int total=0;
putMarks();
sportMarks();
total=a+b+sp;
System.out.println("Total Marks:"+total);
}
public static void main(String args[])
{
Result res=new Result();
res.getMarks(75,85);
res.display();
}
}
