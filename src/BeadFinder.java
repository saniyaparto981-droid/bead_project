
import edu.princeton.cs.algs4.Picture;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class BeadFinder implements IBeadFinder {


    private LinkedList<IBlob> Beads;
    private Picture picture;
    private double tau;
    private LinkedList<IPoint> PointOfPicture;


    public BeadFinder(Picture picture, double tau ,int min) {

        this.tau=tau;
        this.picture=picture;
        Beads=new LinkedList<>();
        PointOfPicture =new LinkedList<>();


        setPoints();
        setNeighbor();
        gettingBeads(min);

    }


    public LinkedList<IBlob> getBeads()
    {
        return this.Beads;
    }


    public void gettingBeads(int min) {

       IBlob blob;
       ArrayList<IPoint> expandedBeads=new ArrayList<>();

        for(IPoint s: PointOfPicture) {



            if(!expandedBeads.contains(s)) {

                blob = DfsSearcher(s);
                expandedBeads.addAll(blob.getPositions());

                if (blob.getPositions().size() >= min)
                    Beads.add(blob);

            }


        }

    }


    public IBlob DfsSearcher(IPoint s ) {

        IBlob blob = factory.createBlob();
        ArrayList<IPoint> BlobBeads=new ArrayList<>();

        LinkedList<IPoint> stack = new LinkedList<>();
        stack.push(s);

        while (!stack.isEmpty()) {

            IPoint current = stack.pop();

            if (current.getChecked()) {
                continue;
            }

            current.setChecked(true);
            BlobBeads.add(current);

            for (IPoint child : current.getChildren()) {
                if (!child.getChecked()) {
                    stack.push(child);
                }
            }
        }

        blob.setPositions(BlobBeads);
        blob.setBlobCenter();
        return blob;
    }



    private void setPoints(){

      IPoint p;

        for(int i=0;i< picture.width();i++) {
            for (int j = 0; j < picture.height(); j++) {


                if (IsBackGround(i,j, tau)) {

                    p=factory.createPoint(i,j);
                    PointOfPicture.addFirst(p);

                }
            }
        }
    }



    private boolean IsBackGround(int x, int y, double tau) {

        Color color = picture.get(x, y);

        double gray = 0.299 * color.getRed()
                + 0.587 * color.getGreen()
                + 0.114 * color.getBlue();

        return gray >= tau;
    }

    private  void setNeighbor() {


        for (int i = 0; i< PointOfPicture.size(); i++) {

            IPoint p= PointOfPicture.get(i);

            for (int j = i+1; j< PointOfPicture.size(); j++) {

                IPoint s= PointOfPicture.get(j);

                if (((Math.sqrt(Math.pow(p.getX() - s.getX(), 2) + Math.pow(p.getY() - s.getY(), 2)) == 1)
                        || Math.sqrt(Math.pow(p.getX() - s.getX(), 2) + Math.pow(p.getY() - s.getY(), 2)) == Math.sqrt(2))
                        ) {


                    if(s.getFather()==null && p.getFather()==null){
                        p.getChildren().add(s);
                        s.setFather(p);}

                    if(s.getFather()==null&&p.getFather()!=null) {
                        p.getChildren().add(s);
                        s.setFather(p);
                    }
                    if(p.getFather()==null&&s.getFather()!=null) {
                        s.getChildren().add(p);
                        p.setFather(s);
                    }


                }
            }
        }

    }


}
