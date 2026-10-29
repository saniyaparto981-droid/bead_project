import edu.princeton.cs.algs4.Picture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BeadTracker implements IBeadTracker
{

    private double Delta;
    private LinkedList<Picture> pictures;


    public BeadTracker(double delta, String rootName) {

        this.Delta=delta;
        IPictures PictureStorer=factory.createPicture(rootName);
        this.pictures=PictureStorer.setAllPictures();


    }

    public void track(double tau , int min) {

        int times=1;




           Picture firstPicture=new Picture("image folders/run_1/frame00000.jpg");
           Picture nextPicture=new Picture("image folders/run_1/frame00001.jpg");

           IBeadFinder firstFinder=factory.createBeadFinder(firstPicture,tau, min);
           IBeadFinder secondFinder=factory.createBeadFinder(nextPicture,tau, min);




           System.out.println("number"+ times +"inspection");
           System.out.println( printMovements(firstFinder,secondFinder));











    }
    public  String printMovements(IBeadFinder firstFinder,
                                  IBeadFinder secondFinder) {

        LinkedList<IBlob> FirstBlobs = firstFinder.getBeads();
        LinkedList<IBlob> SecondBlobs = secondFinder.getBeads();


        StringBuilder s = new StringBuilder();
        int tick=1;

        for (IBlob FirstBlob : FirstBlobs) {
                      double minDistance = 1000;

            for (IBlob SecondBlob : SecondBlobs) {
                double distance = FirstBlob.distance(SecondBlob);

                if (distance < Delta && distance < minDistance) {
                    minDistance = distance;
                }
            }

            if (minDistance < Delta) {
                s.append(tick+":").append(minDistance).append(" ");
                tick++;
            }


        }

        System.out.println("Returning: [" + s + "]");

        return s.toString();
    }





        }


