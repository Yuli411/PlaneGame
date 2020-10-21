package com.ppp.model;

import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 15:54
 * @Description:
 */
public class Enemy03 extends Enemy {

    public Enemy03 (MyPanel myPanel){
        super(myPanel);
        width = 60;
        height = 40;
        x = (int) (Math.random() * BaseFrame.frameWidth - width);
        y = -40;
        image = Toolkit.getDefaultToolkit().getImage("images/enemy03.png");
        hp = 4;
        speed = 4;


    }
}
