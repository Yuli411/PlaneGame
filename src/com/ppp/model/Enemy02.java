package com.ppp.model;

import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 15:44
 * @Description:
 */
public class Enemy02 extends Enemy {

    public Enemy02(MyPanel myPanel){
        super(myPanel);
        width = 60;
        height = 40;
        x = (int) (Math.random() * BaseFrame.frameWidth - width);
        y = -40;
        image = Toolkit.getDefaultToolkit().getImage("images/enemy02.png");
        hp = 3;
        speed = 5;
        items = new Item[]{
                new Item02(myPanel),
                new Item02(myPanel),
        };



    }

}
