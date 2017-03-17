package com.company;

import wrapper.SmartSpaceException;
import wrapper.SmartSpaceKPI;
import wrapper.SmartSpaceTriplet;

import java.awt.*;

/**
 * Created by user on 22.10.15.
 */
public class TestRobot implements IRobot {
    private String name;

    public TestRobot(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void goToPoint(Point destination) {
        String message = String.format("Robot \"%s\" is going to point (%d, %d).", getName(), (int) destination.getX(), (int) destination.getY());
        System.out.println(message);
        /*try {
            SmartSpaceKPI smartSpaceKPI = new SmartSpaceKPI("192.168.1.174", 10010, "x");
            smartSpaceKPI.insert(new SmartSpaceTriplet(message, "haha", "haha"));
            smartSpaceKPI.leave();
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }   */
    }
}
