import java.util.*;
public class ClosestPair2
{
    public static void main(String[] args)
    {
        /**
         *输入需要比较的点的对数存在变量n中
         */
        Scanner in=new Scanner(System.in);
        System.out.println("How many pairs of points to compare?(有多少对点需要比较?)");
        int n=in.nextInt();
        /**
         *输入这些点的横坐标和纵坐标，存储在点数组S[n]中
         */
        System.out.println("Please enter these points,X-coordinate and Y-coordinate.(请输入这些点，x坐标和y坐标)：");
        Point[] S=new Point[n];

        double startTime=System.currentTimeMillis();//starttime

        for(int i=0;i< n;i++)
        {
            int x=in.nextInt();
            int y=in.nextInt();
            S[i]=new Point(x,y);
            System.out.println("("+S[i].getX()+","+S[i].getY()+")");
        }

        /**
         *求出这点的x坐标的中位数mid
         */
        int minX=(int)Double.POSITIVE_INFINITY;
        int maxX=(int)Double.NEGATIVE_INFINITY;
        for(int i=0;i< n;i++)
        {
            if(S[i].getX()< minX)
                minX=S[i].getX();
            if(S[i].getX()>maxX)
                maxX=S[i].getX();
        }

        int mid=(minX+maxX)/2;
        /**
         *以mid为界把S中的点分为两组分别存放在范型数组列表point1和point2中
         */
        ArrayList point1=new ArrayList();
        ArrayList point2=new ArrayList();
        for(int i=0;i< n;i++)
        {
            if(S[i].getX()<=mid)
                point1.add(S[i]);
            else
                point2.add(S[i]);
        }

        /**
         *将范型数组列表转换为数组类型S1和S2
         */
        Point[] S1=new Point[point1.size()];
        Point[] S2=new Point[point2.size()];
        point1.toArray(S1);
        point2.toArray(S2);

        /**
         *将S1和S2中的点按x 坐标升序排列
         */
        sortX(S1);
        sortX(S2);

        /**
         *打印输出排序后S1和S2的点
         */
        System.out.print("The points in S1 are:");
        for(int i=0;i< S1.length;i++)
            System.out.print("("+S1[i].getX()+","+S1[i].getY()+") ");
        System.out.println();
        System.out.print("The points in S2 are:");
        for(int i=0;i< S2.length;i++)
            System.out.print("("+S2[i].getX()+","+S2[i].getY()+") ");
        System.out.println();

        /**
         *求S1中点的最近对及其距离并打印输出结果
         */
        double minDist1=Double.POSITIVE_INFINITY;
        int indexI1=0;
        int indexJ1=0;
        for(int i=0;i< S1.length-1;i++)
        {
            for(int j=i+1;j< S1.length;j++)
            {
                double d=Math.sqrt(Math.pow((S1[i].getX()-S1[j].getX()),2)+Math.pow((S1[i].getY()-S1[j].getY()),2));
                if(d< minDist1)
                {
                    minDist1=d;
                    indexI1=i;
                    indexJ1=j;
                }
            }
        }

        System.out.println("The closest pair in S1 is: "+"("+S1[indexI1].getX()+","+S1[indexI1].getY()+")"+
                "and("+S1[indexJ1].getX()+","+S1[indexJ1].getY()+")"+",and the distance is "+minDist1);
        /**
         *求S2中点的最近对及其距离并打印输出结果
         */
        double minDist2=Double.POSITIVE_INFINITY;
        int indexI2=0;
        int indexJ2=0;
        for(int i=0;i< S2.length-1;i++)
        {
            for(int j=i+1;j< S2.length;j++)
            {
                double d=Math.sqrt(Math.pow((S2[i].getX()-S2[j].getX()),2)+Math.pow((S2[i].getY()-S2[j].getY()),2));
                if(d< minDist2)
                {
                    minDist2=d;
                    indexI2=i;
                    indexJ2=j;
                }
            }
        }
        System.out.println("The closest pair in S2 is: "+"("+S2[indexI2].getX()+","+S2[indexI2].getY()+")"+
                "and("+S2[indexJ2].getX()+","+S2[indexJ2].getY()+")"+",and the distance is "+minDist2);

        double d1=Math.min(minDist1,minDist2);
        /**
         *在S1,S2中收集距离中线两侧小于dl的点，分别存在P1[]和P2[]中
         */
        ArrayList< Point> pp1=new ArrayList< Point>();
        ArrayList< Point> pp2=new ArrayList< Point>();
        for(int i=0;i< S1.length;i++)
        {
            if((mid-S1[i].getX())< d1)
                pp1.add(S1[i]);
        }
        for(int i=0;i< S2.length;i++)
        {
            if((S2[i].getX()-mid)< d1)
                pp2.add(S2[i]);
        }

        Point[] P1=new Point[pp1.size()];
        Point[] P2=new Point[pp2.size()];
        pp1.toArray(P1);
        pp2.toArray(P2);

        /**
         *将P1和P2中的点按Y坐标升序排列
         */
        sortY(P1);
        sortY(P2);
        /**
         *求解P1和P2两者之间可能的最近对距离
         */
        double d2=Double.POSITIVE_INFINITY;
        for(int i=0;i< P1.length;i++)
        {
            for(int j=0;j< P2.length;j++)
            {
                if(Math.abs(P1[i].getY()-P2[j].getY())< d1)
                {
                    double temp=Math.sqrt(Math.pow((P1[i].getX()-P2[j].getX()),2)+Math.pow((P1[i].getX()-P2[j].getX()),2));
                    if(temp< d2)
                        d2=temp;
                }
            }
        }

        double endTime=System.currentTimeMillis();//endtime
        /**
         *打印输出最后求出的结果，最近的是哪两个点，以及最近距离和程序用的时间
         */
        System.out.print("The points in P1 are:");
        for(int i=0;i< P1.length;i++)
            System.out.print("("+P1[i].getX()+","+P1[i].getY()+") ");
        System.out.println();
        System.out.print("The points in P2 are:");
        for(int i=0;i< P2.length;i++)
            System.out.print("("+P2[i].getX()+","+P2[i].getY()+") ");
        System.out.println();
        System.out.println("d2="+d2);
        double minDist=Math.min(d1,d2);
        System.out.println("The closest distance is "+minDist);

        System.out.println("Basic Statements take(基本语句用时) "+(endTime-startTime)+" milliseconds!");
    }
    /**
     *设计按点Point的x坐标升序排列的函数sortX
     */
    public static void sortX(Point[] p)
    {
        for(int i=0;i< p.length-1;i++)
        {
            for(int j=0;j< p.length-1-i;j++)
            {
                if(p[j].getX()>p[j+1].getX())
                {
                    int t=p[j].getX();
                    p[j].setX(p[j+1].getX());
                    p[j+1].setX(t);

                    int n=p[j].getY();
                    p[j].setY(p[j+1].getY());
                    p[j+1].setY(n);
                }
            }
        }
    }
    /**
     *设计按点Point的y坐标升序排列的函数sortY
     */
    public static void sortY(Point[] p)
    {
        for(int i=0;i< p.length-1;i++)
        {
            for(int j=0;j< p.length-1-i;j++)
            {
                if(p[j].getY()>p[j+1].getY())
                {
                    int t=p[j].getY();
                    p[j].setY(p[j+1].getY());
                    p[j+1].setY(t);

                    int n=p[j].getX();
                    p[j].setX(p[j+1].getX());
                    p[j+1].setX(n);
                }
            }
        }
    }
}
/**
 * 建立自己的类Point
 */
class Point implements Cloneable
{
    public Point()
    {
        x=0;
        y=0;
    }

    public Point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public void setY(int y)
    {
        this.y=y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    private int x;
    private int y;
}
