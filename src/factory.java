import edu.princeton.cs.algs4.Picture;

import java.io.File;
import java.util.ArrayList;

public class factory {


    public static IPoint createPoint(double x , double y){return new Point(x,y);}

    public static IBeadFinder createBeadFinder(Picture picture,double tau, int min){return new BeadFinder(picture,tau , min);}

    public static IBlob createBlob(){return new Blob(); }

    public static IPictures createPicture(String rootName){return new Pictures(rootName );}

    public static IBeadTracker createBeadTracker(double delta , String rootName){return new BeadTracker(delta , rootName); }


}
