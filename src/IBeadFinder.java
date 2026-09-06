import java.util.ArrayList;

public interface IBeadFinder
{
    ArrayList<IBlob> getBeads();


   void gettingBeads(int min) ;

     IBlob DfsSearcher(IPoint s ) ;
}
