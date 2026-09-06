import java.util.LinkedList;

public class Point implements IPoint
{

    private double x;
    private double y;
    private LinkedList<IPoint> child_points;
    private IPoint fatherPoint;
    private boolean checked;


    public Point(double  x, double  y) {

        this.x=x;
        this.y=y;
        child_points=new LinkedList<>();
        this.fatherPoint=null;

    }

    public double getX(){ return this.x;}
    public double getY(){return this.y;}

    public LinkedList<IPoint> getChildren(){return child_points;}


    public void setChecked(Boolean bool){

        this.checked=bool;
    }


    public boolean getChecked()
    {
        return this.checked;
    }

    public void setFather(IPoint father){this.fatherPoint=father;}

    public IPoint getFather(){return this.fatherPoint;}


}
