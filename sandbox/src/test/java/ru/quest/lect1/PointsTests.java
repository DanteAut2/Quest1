package ru.quest.lect1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTests {
    @Test
    public void thisPointA() {
        Point s = new Point (3, 6);
        Point z = new Point (2, 4);
        Assert.assertEquals(s.distance(z), 2.0);
    }
    @Test
    public void thisPointB() {
        Point k = new Point (9, 4);
        Point l = new Point (8, 9);
        Assert.assertEquals(k.distance(l), 5.0);
    }
    @Test
    public void thisPointC() {
        Point k = new Point (7, 4);
        Point l = new Point (8, 0);
        Assert.assertEquals(k.distance(l), 4.0);
    }
}
