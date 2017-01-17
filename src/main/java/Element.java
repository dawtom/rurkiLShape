import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid Tomasiewicz on 17.01.17.
 */
public class Element {

    List <Integer> points = new ArrayList<>();

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public Element(Integer first, Integer second, Integer third, Integer fourth) {
        this.points.add(first);
        this.points.add(second);
        this.points.add(third);
        this.points.add(fourth);

    }
}
