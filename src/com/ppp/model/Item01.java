package com.ppp.model;

import com.ppp.view.MyPanel;

import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 16:45
 * @Description:
 */
public class Item01 extends Item {
    public Item01(MyPanel myPanel){
        super(myPanel);
        width = 15;
        height = 15;
        images = new Image[]{
                Toolkit.getDefaultToolkit().getImage("images/star01.png"),
                Toolkit.getDefaultToolkit().getImage("images/star02.png"),
                Toolkit.getDefaultToolkit().getImage("images/star03.png"),
                Toolkit.getDefaultToolkit().getImage("images/star04.png"),
                Toolkit.getDefaultToolkit().getImage("images/star05.png"),
                Toolkit.getDefaultToolkit().getImage("images/star06.png"),
                Toolkit.getDefaultToolkit().getImage("images/star07.png"),
                Toolkit.getDefaultToolkit().getImage("images/star08.png"),
                Toolkit.getDefaultToolkit().getImage("images/star09.png"),

        };
        imageSpeed = (int) (Math.random() * 20 + 5);
        speed = 3 ;
        count = 10;

    }
}
