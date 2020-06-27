package designmodle.factory;

import com.crazybunqnq.designpattern.factory_simple.Shape;
import com.crazybunqnq.designpattern.factory_simple.ShapeFactory;
import org.junit.Test;

/**
 * @version 2018/5/1.
 * @auther CrazyBunQnQ
 */
public class SimpleFactoryTest {
    @Test
    public void test() {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape(Shape.CIRCLE);
        Shape rectangle = shapeFactory.getShape(Shape.RECTANGLE);
        Shape square = shapeFactory.getShape(Shape.SQUARE);

        circle.draw();
        rectangle.draw();
        square.draw();
    }
}
