import commands.History;
import commands.Shot;
import org.junit.Assert;

import java.util.ResourceBundle;
import java.util.Scanner;


public class ShotTest {


    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("Beginning testing of Shot.java");
    }

    @org.junit.AfterClass
    public  static void afterClass() {
        System.out.println("Testing of Shot.java finished");
    }

    @org.junit.Test
    public void execute() throws Exception{
        Shot shot = new Shot(new History());
        System.out.println("First quarter");
        shot.readParameters(new Scanner("5 5 5"));
        Assert.assertEquals(ResourceBundle.getBundle("res.Messages").getString("shot") +
                " ( X = 5.0, Y = 5.0, R = 5.0) " + ResourceBundle.getBundle("res.Messages").getString("flew_by")+"\n",
                shot.execute());

        System.out.println("Second quarter");

        System.out.println("Third quarter");

        System.out.println("Fourth quarter");
    }

    @org.junit.Test
    public void readParameters() {
    }
}