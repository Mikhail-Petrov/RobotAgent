package com.company;

import sofia_kp.SSAP_sparql_response;
import sofia_kp.iKPIC_subscribeHandler2;
import wrapper.SmartSpaceException;
import wrapper.SmartSpaceKPI;
import wrapper.SmartSpaceTriplet;

import java.awt.*;
import java.util.Vector;

/**
 * Created by user on 22.10.15.
 * Класс агента для взаимодействия робота, других агентов и SmartSpace.
 * При окончании работы с классом необходимо вызвать метод {@link #exit}().
 */
public class Agent implements iKPIC_subscribeHandler2 {
    public SmartSpaceKPI smartSpaceKPI;
    IRobot robot;
    /**
     * Значение координаты Y для всех букв.
     */
    private final int defaultX = -10;
    private final int defaultY = 30;

    public boolean SSOnRouter;

    public Agent(IRobot robot, boolean SSOnRouter) {
        this.robot = robot;
        this.SSOnRouter = SSOnRouter;
        try {
            String routerHost = "192.168.1.1", PCHost = "192.168.2.101";
            smartSpaceKPI = new SmartSpaceKPI(SSOnRouter ? routerHost : PCHost, 10010, "x");
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
    }

    public String subscribe(String subject, String predicate, String object) {
        try {
            return smartSpaceKPI.subscribe(new SmartSpaceTriplet(subject, predicate, object), this);
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void unsubscribe(String subject, String predicate, String object, boolean fullMatch) {
        try {
            smartSpaceKPI.unsubscribe(new SmartSpaceTriplet(subject, predicate, object), fullMatch);
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Осуществляет запрос в SmartSpace и возвращает вектор троек, подходящих условию.
     *
     * @param subject   субъект в искомых тройках
     * @param predicate предикат в искомых тройках
     * @param object    объект в искомых тройках
     * @return вектор SmartSpaceTriplet, удовлетворяющих условиям поиска
     */
    public Vector<SmartSpaceTriplet> getQuery(String subject, String predicate, String object) {
        try {
            return smartSpaceKPI.query(new SmartSpaceTriplet(subject, predicate, object));
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Осуществляет вставку заданной тройки в SmartSpace.
     *
     * @param subject   субъект вставляемой тройки
     * @param predicate предикат вставляемой тройки
     * @param object    объект вставляемой тройки
     */
    public void insertIntoSS(String subject, String predicate, String object) {
        try {
            smartSpaceKPI.insert(new SmartSpaceTriplet(subject, predicate, object));
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Осуществляет вставку заданных троек в SmartSpace.
     *
     * @param triplets вектор SmartSpaceTriplet, которые будут вставлены в SmartSpace.
     */
    public void insertIntoSS(Vector<SmartSpaceTriplet> triplets) {
        for (SmartSpaceTriplet triplet : triplets)
            try {
                smartSpaceKPI.insert(triplet);
            } catch (SmartSpaceException e) {
                e.printStackTrace();
            }
    }

    /**
     * Удаляет из SmartSpace тройки, подходящие заданному условию.
     *
     * @param subject   субъект удаляемых троек
     * @param predicate предикат удаляемых троек
     * @param object    объект удаляемых троек
     */
    public void removeFromSS(String subject, String predicate, String object) {
        try {
            smartSpaceKPI.remove(new SmartSpaceTriplet(subject, predicate, object));
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаляет из SmartSpace тройки, подходящие заданному условию.
     *
     * @param triplets условие для поиска удаляемых троек
     */
    public void removeFromSS(Vector<SmartSpaceTriplet> triplets) {
        for (SmartSpaceTriplet triplet : triplets)
            try {
                smartSpaceKPI.remove(triplet);
            } catch (SmartSpaceException e) {
                e.printStackTrace();
            }
    }

    public void printSSInfo(String subject, String predicate, String object) {
        try {
            Vector<SmartSpaceTriplet> triplets = smartSpaceKPI.query(new SmartSpaceTriplet(subject, predicate, object));
            for (SmartSpaceTriplet triplet : triplets) {
                if (!triplet.getPredicate().startsWith("http://"))
                    System.out.println(String.format("%s, %s, %s", triplet.getSubject(), triplet.getPredicate(), triplet.getObject()));
            }
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Завершает работу с SmartSpace.
     * Необходимо вызвать этот метод при окончании работы с SmartSpace.
     */
    public void exit() {
        try {
            smartSpaceKPI.leave();
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Заносит в SmartSpace информацию о том, что робот захватил букву определённого цвета.
     * Подписывается на информацию о том, куда идти роботу.
     *
     * @param color цвет захваченной буквы
     */
    public void reactOnColor(String color) {
        try {
            smartSpaceKPI.subscribe(new SmartSpaceTriplet(robot.getName(), "shouldGoTo", null), this);
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }
        removeFromSS(robot.getName(), "holdsColor", color);
        insertIntoSS(robot.getName(), "holdsColor", color);
    }

    /**
     * Реагирует на добавление в SmartSpace тройки {<имя робота>, "shouldGoTo", <координата точки назначения>}.
     * Отправляет робота в данную точку
     *
     * @param added
     * @param removed
     * @param s
     * @param s1
     */
    @Override
    public void kpic_RDFEventHandler(Vector<Vector<String>> added, Vector<Vector<String>> removed, String s, String s1) {
        /*if (added.size() > 0) {
            String xString = added.get(0).get(2);
            int y = Integer.parseInt(xString);
            robot.goToPoint(new Point(defaultX, defaultY + y));
        }*/
        for (Vector<String> addedVector : added) {
            SmartSpaceTriplet addedTriplet = new SmartSpaceTriplet(addedVector);
            System.out.println(String.format("Added:\n%s\t%s\t%s",
                    addedTriplet.getSubject(), addedTriplet.getPredicate(), addedTriplet.getObject()));
        }
    }

    @Override
    public void kpic_SPARQLEventHandler(SSAP_sparql_response ssap_sparql_response, SSAP_sparql_response ssap_sparql_response1, String s, String s1) {

    }

    @Override
    public void kpic_UnsubscribeEventHandler(String s) {

    }

    @Override
    public void kpic_ExceptionEventHandler(Throwable throwable) {

    }
}
