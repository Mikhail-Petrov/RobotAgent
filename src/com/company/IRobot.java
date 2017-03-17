package com.company;

import java.awt.*;

/**
 * Created by user on 22.10.15.
 */
public interface IRobot {
    /**
     * Возвращает имя робота
     * @return String, имя робота
     */
    String getName();

    /**
     * Говорит роботу двигаться в определённую точку
     * @param destination    точка, в которую необходимо двигаться
     */
    void goToPoint(Point destination);
}
