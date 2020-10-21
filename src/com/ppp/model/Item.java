package com.ppp.model;

import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/14 16:03
 * @Description:
 */
public abstract class Item {
    public MyPanel myPanel;
    public int x;
    public int y;
    public int width;
    public int height;
    public Image[] images;
    public int imageSpeed;
    public int speed;
    private int imageIndex;
    public int count;

    public Item(MyPanel myPanel){
        this.myPanel = myPanel;
    }

    public void drawItem(Graphics graphics){

        //x,y according to the position where enemy is killed

        graphics.drawImage(images[imageIndex],x,y,width,height,null);
        if (myPanel.getTimer() % imageSpeed == 0){
            imageIndex++;
            if (imageIndex == images.length){
                imageIndex = 0;
            }
        }
        if (myPanel.getTimer() % speed == 0){
            y++;
            if (y > BaseFrame.frameHeight){
                myPanel.getItems().remove(this);
            }
        }
    }

    public void eaten(){
        myPanel.getItems().remove(this);
        myPanel.getPlayer().setCount(myPanel.getPlayer().getCount() + count);
    }

}
