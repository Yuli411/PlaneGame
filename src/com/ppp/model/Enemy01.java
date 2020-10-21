package com.ppp.model;

import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;


/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 14:01
 * @Description:
 */
public class Enemy01 extends Enemy {
    public Enemy01(MyPanel myPanel) {
        super(myPanel);
        width = 60;
        height = 40;
        x = (int) (Math.random() * (BaseFrame.frameWidth - width));
        y = -40;
        hp = 3;
        speed = 3;
        image = Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\enemy01.png");
        items = new Item[]{
                new Item01(myPanel),
                new Item01(myPanel),
                new Item01(myPanel)
        };




    }



    public Enemy01(){

    }
}
