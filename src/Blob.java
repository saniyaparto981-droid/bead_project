import edu.princeton.cs.algs4.Picture;

import java.util.ArrayList;
import java.util.LinkedList;

public class Blob implements IBlob{

    private ArrayList<IPoint> positions;
    private IPoint blobCenter;
    private boolean checked;

    public Blob() {
        positions = new ArrayList<>();
        checked=true;
    }

    // -------------------- Methods --------------------

    public void add(double x, double y ) {
        positions.addFirst(factory.createPoint(x,y));
    }

    public int mass() {
        return positions.size();
    }

    public double distance(IBlob that) {
        return Math.sqrt(
                Math.pow(blobCenter.getX() - that.getBlobCenter().getX(), 2)
                        + Math.pow(blobCenter.getY() - that.getBlobCenter().getY(), 2)
        );
    }

    @Override
    public String toString() {

        setBlobCenter();
        return String.format("%d (%.4f, %.4f)",
                mass(),
                blobCenter.getX(),
                blobCenter.getY());
    }

    public void setBlobCenter() {
        double x = 0;
        double y = 0;

        for (IPoint point : positions) {
            x += point.getX();
            y += point.getY();
        }

        blobCenter = factory.createPoint(x/ positions.size(), y/ positions.size());
    }

    // -------------------- Getters & Setters --------------------

    public ArrayList<IPoint> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<IPoint> positions) {
        this.positions = positions;
    }

    public IPoint getBlobCenter() {
        return blobCenter;
    }

    public void setBlobCenter(IPoint blobCenter) {
        this.blobCenter = blobCenter;
    }

    public void setValidation(boolean bool){this.checked=bool;}

    public boolean getValidation(){return this.checked;}
}
