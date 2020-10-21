package com.ppp.model;

import com.ppp.view.BaseFrame;
import com.ppp.view.MyPanel;

import java.awt.*;

/**
 * @Auther: Yhurri
 * @Date: 2020/6/13 22:49
 * @Description:
 */
public class Bullet {
    private MyPanel myPanel;
    private Image[] image;
    private int width = 8;
    private int height = 8;
    private int x ;
    private int y ;
    private int imageIndex = 0 ;
    private int timer;


    public Bullet(MyPanel myPanel){
        this.myPanel = myPanel;

        image = new Image[]{

                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\bullet01.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\bullet02.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\bullet03.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\bullet04.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\bullet05.png"),
                Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\bullet06.png")

        };
        this.timer = myPanel.getTimer();
    }

    public void drawBullet(Graphics graphics){
        graphics.drawImage(image[imageIndex],x,y,width,height,null);

        if(timer % 1 ==0)
        {
            imageIndex++;
            y--;

            if(imageIndex==this.image.length)
                imageIndex=0;

            if(y<0)
                this.myPanel.getBullets().remove(this);
        }
        //judge if bullet hits enemy
        //everytime we draw a bullet, we need to know if it hits enemies not not
        for (Enemy enemy : myPanel.getEnemies()){
            if (x >= enemy.x - width && x <= enemy.x + enemy.width && y >= enemy.y - height && y <= enemy.y + enemy.height ){
               //destroy this bullet
                myPanel.getBullets().remove(this);
                enemy.attacked();
            }
        }


    }

    public void drawEnemyBullet(Graphics graphics){
        graphics.drawImage(image[imageIndex],x,y,width,height,null);
        if (timer % 1 == 0){
            imageIndex++;
            y++;

            if (imageIndex == image.length){
                imageIndex = 0;
            }
            if (y > BaseFrame.frameHeight){
                myPanel.getEnemyBullets().remove(this);
            }
        }

        //attack player

        attackPlayer();

    }

    public MyPanel getMyPanel() {
        return myPanel;
    }



    public Image[] getImage() {
        return image;
    }



    public int getWidth() {
        return width;
    }



    public int getHeight() {
        return height;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public void attackPlayer(){
        int xx = myPanel.getPlayer().getX();
        int yy = myPanel.getPlayer().getY();
        int playerWidth = myPanel.getPlayer().getWidth();
        int playerHeight = myPanel.getPlayer().getHeight();
        if (x <= xx + playerWidth && x >= xx - width && y <= yy + playerHeight && y >= yy - height) {
            myPanel.getEnemyBullets().remove(this);
            if (myPanel.getPlayer().getHp() > 0) {
                myPanel.getPlayer().setHp(myPanel.getPlayer().getHp() - 1);
            }
        }
    }



}
