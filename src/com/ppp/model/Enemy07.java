package com.ppp.model;

import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 15:57
 * @Description:
 */
public class Enemy07 extends Enemy {

    public Enemy07(MyPanel myPanel){
        super(myPanel);
        width = 80;
        height = 60;
        x = (int) (Math.random() * BaseFrame.frameWidth - width);
        y = -40;
        image = Toolkit.getDefaultToolkit().getImage("images/enemy07.png");
        hp = 5;
        speed = 5;
        items = new Item[]{
                new Item01(myPanel),
                new Item01(myPanel),
                new Item01(myPanel),
                new Item01(myPanel),
                new Item01(myPanel)

        };


    }
}
