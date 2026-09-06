import java.util.ArrayList;

public interface IBlob
{


     void add(double x, double y );
     int mass();


    double distance(IBlob that) ;


        String toString ();


            void setBlobCenter ();


            // -------------------- Getters & Setters --------------------

            ArrayList<IPoint> getPositions ();

            void setPositions (ArrayList < IPoint > positions);

            IPoint getBlobCenter ();


    }