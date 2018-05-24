package practicaherenciastarcrafttrue;
import java.util.Comparator;
import objects.Unidad;

public class comparatorRanking implements Comparator<Unidad>{
    
    @Override
    public int compare(Unidad n1, Unidad n2) {
        if (n1.getVictorias()> n2.getVictorias()) {
            return 1;
        } else if (n1.getVictorias()< n2.getVictorias()) {
            return -1;
        } else {
            return 0;
        }

    }
}
