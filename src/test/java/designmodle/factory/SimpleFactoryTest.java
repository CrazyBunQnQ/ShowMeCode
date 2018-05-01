package designmodle.factory;

import com.crazybunqnq.designpattern.factory.simple.Shape;
import com.crazybunqnq.designpattern.factory.simple.ShapeFactory;
import org.junit.Test;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class SimpleFactoryTest {
    @Test
    public void test() {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape(ShapeFactory.CIRCLE);
        Shape rectangle = shapeFactory.getShape(ShapeFactory.RECTANGLE);
        Shape square = shapeFactory.getShape(ShapeFactory.SQUARE);

        circle.draw();
        rectangle.draw();
        square.draw();
    }
}
