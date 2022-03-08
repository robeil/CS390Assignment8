package CS390Assignment8.prob3;

import java.util.Comparator;

public class ComparatorClass implements Comparator<Marketing> {
    @Override
    public int compare(Marketing o1, Marketing o2) {
        if(Double.compare(o1.getSalesamount(),o2.getSalesamount()) != 0);
        return Double.compare(o1.getSalesamount(),o2.getSalesamount());
    }
}
