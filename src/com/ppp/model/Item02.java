package com.ppp.model;

import com.ppp.view.MyPanel;

import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 17:03
 * @Description:
 */
public class Item02 extends Item {

    public Item02(MyPanel myPanel) {
        super(myPanel);
        width = 15;
        height = 15;
        images = new Image[]{
                Toolkit.getDefaultToolkit().getImage("images/diamond01.png"),
                Toolkit.getDefaultToolkit().getImage("images/diamond02.png")


        };

        imageSpeed = (int) (Math.random() * 20 +1);
        speed = 4;

        count = 20;

    }
}
