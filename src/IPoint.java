import java.util.LinkedList;

public interface IPoint
{
     void  setChecked(Boolean bool);

     boolean getChecked();

     void setFather(IPoint father);

     IPoint getFather();

     LinkedList<IPoint> getChildren();

      double getX();
      double getY();
}

