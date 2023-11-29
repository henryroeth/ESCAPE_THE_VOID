import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

public class SpaceshipTest {
public static final double EPSILON=1E-14;
@Test
public void testConstructor() {
	Spaceship s=new Spaceship(20,40,2,3,Color.gray,Color.green);
	assertEquals("Your constructor failed: ",20,s.getX(),EPSILON);
	assertEquals("Your constructor failed: ",40,s.getY(),EPSILON);
	assertEquals("Your constructor failed: ",2,s.getDX(),EPSILON);
	assertEquals("Your constructor failed: ",3,s.getDY(),EPSILON);
	assertEquals("Your constructor failed: ",Color.gray,s.getColor());
	assertEquals("Your constructor failed: ",Color.green,s.getColor1());
	}
@Test
public void testMoveSpaceship() {
	Asteroid asteroid=new Asteroid(150,100);
	Spaceship spaceship=new Spaceship(75,100,50,0,Color.gray,Color.gray);
	spaceship.moveSpaceship();
	assertEquals("Your method moveSpaceship() failed: ",true,spaceship.getBoundingBox().intersects(asteroid.getBoundingBox()));
}
@Test
public void testSetDx() {
	Spaceship spaceship=new Spaceship(75,100,0,0,Color.gray,Color.gray);
	spaceship.setDx(2);
	spaceship.moveSpaceship();
	assertEquals("Your method setDx failed: ",79,spaceship.getX(),EPSILON);
}
@Test
public void testSetDy() {
	Spaceship spaceship=new Spaceship(75,100,0,0,Color.gray,Color.gray);
	spaceship.setDy(2);
	spaceship.moveSpaceship();
	assertEquals("Your method setDx failed: ",104,spaceship.getY(),EPSILON);
}
@Test
public void testChangeColor() {
	Spaceship spaceship=new Spaceship(75,100,0,0,Color.gray,Color.gray);
	spaceship.changeColor();
	Color randomColor=spaceship.getColor();
	Color randomColor1=spaceship.getColor1();
	assertEquals("Your method changeColor() failed: ",randomColor,spaceship.getColor());
	assertEquals("Your method changeColor() failed: ",randomColor1,spaceship.getColor1());
}
}
