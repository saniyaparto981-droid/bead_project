import edu.princeton.cs.algs4.Picture;

import java.util.ArrayList;

public class factory {


    public static IPoint createPoint(double x , double y){return new Point(x,y);}

    public static IBeadFinder createBeadFinder(Picture picture,double tau){return new BeadFinder(picture,tau);}

    public static IBlob createBlob(){return new Blob(); }

}
