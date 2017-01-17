import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid Tomasiewicz on 17.01.17.
 */
public class Application {
    public static void main(String[] args) {
        SimpleMatrix computedIntegralsTemplate = fillTemplateMatrix();
        SimpleMatrix leftSideOfOurMatrixEquation = new SimpleMatrix(8,8);
        SimpleMatrix rightSideOfOurMatrixEquation = new SimpleMatrix(8,1);

        List<Point> pointList = new ArrayList<>();
        List<Element> elementList = new ArrayList<>();
        pointList.add(new Point(-1.0,1.0));
        pointList.add(new Point(0.0,1.0));
        pointList.add(new Point(1.0,1.0));
        pointList.add(new Point(-1.0,0.0));
        pointList.add(new Point(0.0,0.0));
        pointList.add(new Point(1.0,0.0));
        pointList.add(new Point(0.0,-1.0));
        pointList.add(new Point(1.0,-1.0));
        elementList.add(new Element(3,4,1,0));
        elementList.add(new Element(4,5,2,1));
        elementList.add(new Element(6,7,5,4));

        for (Element element :
                elementList) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    leftSideOfOurMatrixEquation.set(element.getPoints().get(i),element.getPoints().get(j),
                            leftSideOfOurMatrixEquation.get(element.getPoints().get(i),element.getPoints().get(j))
                                    + computedIntegralsTemplate.get(j,i));
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            leftSideOfOurMatrixEquation.set(3,i,0);
            leftSideOfOurMatrixEquation.set(4,i,0);
            leftSideOfOurMatrixEquation.set(6,i,0);
        }
        leftSideOfOurMatrixEquation.set(3,3,1);
        leftSideOfOurMatrixEquation.set(4,4,1);
        leftSideOfOurMatrixEquation.set(6,6,1);






        System.out.println(leftSideOfOurMatrixEquation.toString());
        System.out.println(computedIntegralsTemplate.toString());
    }





    static SimpleMatrix fillTemplateMatrix(){
        SimpleMatrix computedIntegralsTemplate = new SimpleMatrix(4,4);
        for (int i = 0; i < 4; i++) {
            computedIntegralsTemplate.set(i,i,2.0/3.0);
            if (i < 3){
                computedIntegralsTemplate.set(i+1,i,-1.0/6.0);
                computedIntegralsTemplate.set(i,i+1,-1.0/6.0);
            }
            if (i < 2){
                computedIntegralsTemplate.set(i+2,i,-1.0/3.0);
                computedIntegralsTemplate.set(i,i+2,-1.0/3.0);
            }
        }
        computedIntegralsTemplate.set(3,0,-1.0/6.0);
        computedIntegralsTemplate.set(0,3,-1.0/6.0);
        return computedIntegralsTemplate;
    }
}
