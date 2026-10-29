import java.util.ArrayList;
import java.util.LinkedList;

public interface IBeadFinder
{
    LinkedList<IBlob> getBeads();


   void gettingBeads(int min) ;

     IBlob DfsSearcher(IPoint s ) ;


}
