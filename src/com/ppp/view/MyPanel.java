package com.ppp.view;

import com.ppp.model.Bullet;
import com.ppp.model.Enemy;
import com.ppp.model.Item;
import com.ppp.model.Player;
import com.ppp.thread.MusicThread;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Yhurri
 * @Date: 2020/4/12 23:33
 * @Description:
 */
public class MyPanel extends JPanel {

    public Image bgImage;
    public Image myPlane;
    private int timer;
    private int top = 0;
    private Player player;
    private List<Bullet> bullets;
    private List<Enemy> enemies;
    private List<Class> typesOfEnemies;
    private List<Item> items;
    private List<Bullet> enemyBullets;

    public List<Item> getItems() {
        return items;
    }

    public MyPanel() {
        bgImage = Toolkit.getDefaultToolkit().getImage("F:\\workplace-idea\\planegame\\images\\bg01.jpg");
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        typesOfEnemies = new ArrayList<>();
        items = new ArrayList<>();
        enemyBullets = new ArrayList<>();

    }

    public List<Enemy> getEnemies() {
        return enemies;
    }


    public int getTimer() {
        return timer;
    }


    public int getTop() {
        return top;
    }



    public List<Bullet> getBullets() {
        return bullets;
    }

    public List<Bullet> getEnemyBullets() {
        return enemyBullets;
    }

    public Player getPlayer(){
        return player;
    }

    public Player createPlayer(){
        if (player == null) {
            return player = new Player(this);
        }else
            return player;
    }



    public List<Class> getTypesOfEnemies() {
        return typesOfEnemies;
    }


    //绘制组件
    //painter
    @Override
    protected void paintComponent(Graphics g) {
        if (player.getHp() > 0) {
            super.paintComponent(g);
            //坐标是图片左上角的位置,相对于panel
            //后面参数是绘制图形矩形的长和宽
            //第一张图 在panel上面
            g.drawImage(bgImage, 0, top - bgImage.getHeight(this), bgImage.getWidth(this), bgImage.getHeight(this), null);
            //第二张图 在panel里面
            g.drawImage(bgImage, 0, top, bgImage.getWidth(this), bgImage.getHeight(this), null);
            timer++;
            if (timer == 10000) {
                timer = 0;
            }
            //没间隔1ms调用一次该方法 所以 每隔10ms重画图片
            if (timer % 10 == 0) {
                top++;
                if (top == bgImage.getHeight(this)) {
                    top = 0;
                }
            }
            if (player != null) {

                player.drawItself(g);

                if (timer % 100 == 0) {
                    if (player.getAttackMode() == 1) {
                        Bullet bullet = new Bullet(this);
                        bullet.setX(player.getX() + player.getWidth() / 2 - bullet.getWidth() / 2);
                        bullet.setY(player.getY());
                        bullets.add(bullet);
                        new MusicThread("video/bullet.wav").start();


                    } else if (player.getAttackMode() == 2) {
                        Bullet bullet1 = new Bullet(this);
                        bullet1.setY(player.getY() - 15);
                        bullet1.setX(player.getX() + player.getWidth() / 2 - bullet1.getWidth() / 2);
                        Bullet bullet2 = new Bullet(this);
                        bullet2.setX(player.getX() + player.getWidth() / 2 - bullet1.getWidth() - 10);
                        bullet2.setY(player.getY());
                        Bullet bullet3 = new Bullet(this);
                        bullet3.setX(player.getX() + player.getWidth() / 2 + bullet1.getWidth() + 10);
                        bullet3.setY(player.getY());
                        bullets.add(bullet1);
                        bullets.add(bullet2);
                        bullets.add(bullet3);
                        new MusicThread("video/bullet.wav").start();

                    } else if (player.getAttackMode() == 3) {
                        Bullet bullet1 = new Bullet(this);
                        bullet1.setY(player.getY() - 30);
                        bullet1.setX(player.getX() + player.getWidth() / 2 - bullet1.getWidth() / 2);
                        Bullet bullet2 = new Bullet(this);
                        bullet2.setX(player.getX() + player.getWidth() / 2 - bullet1.getWidth() - 10);
                        bullet2.setY(player.getY() - 15);
                        Bullet bullet3 = new Bullet(this);
                        bullet3.setX(player.getX() + player.getWidth() / 2 + bullet1.getWidth() + 10);
                        bullet3.setY(player.getY() - 15);
                        Bullet bullet4 = new Bullet(this);
                        bullet4.setX(player.getX() + player.getWidth() / 2 - 2 * bullet1.getWidth() - 10);
                        bullet4.setY(player.getY());
                        Bullet bullet5 = new Bullet(this);
                        bullet5.setX(player.getX() + player.getWidth() / 2 + 2 * bullet1.getWidth() + 10);
                        bullet5.setY(player.getY());
                        bullets.add(bullet1);
                        bullets.add(bullet2);
                        bullets.add(bullet3);
                        bullets.add(bullet4);
                        bullets.add(bullet5);
                        new MusicThread("video/bullet.wav").start();
                    }
                }

                for (Bullet bullet : bullets) {
                    bullet.drawBullet(g);
                }


            }

            if (timer % 200 == 0) {
                if (typesOfEnemies.size() > 0) {
                    int index = (int) (Math.random() * typesOfEnemies.size());
                    try {
                        Enemy enemy = (Enemy) typesOfEnemies.get(index).getConstructor(MyPanel.class).newInstance(this);
                        enemies.add(enemy);
                        if (enemy.bullets != null) {
                            for (int i = 0; i < enemy.bullets.length; i++) {
                                enemy.bullets[i] = new Bullet(this);
                                enemy.bullets[i].setX(enemy.x + enemy.width / 2 - enemy.bullets[i].getWidth() / 2);
                                enemy.bullets[i].setY(enemy.y);
                                enemyBullets.add(enemy.bullets[i]);
                                new MusicThread("video/bullet.wav").start();

                            }
                        }

                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }


            }

            if (enemies.size() != 0) {

                for (Enemy enemy : enemies) {
                    enemy.drawEnemy(g);
                }

            }

            if (items.size() != 0) {

                for (Item item : items) {
                    item.drawItem(g);
                }
            }

            if (enemyBullets.size() != 0) {
                for (Bullet enemyBullet : enemyBullets) {
                    enemyBullet.drawEnemyBullet(g);
                }
            }


            g.setColor(Color.white);
            g.drawString("score" + player.getCount(), BaseFrame.frameWidth - 100, 20);
            g.drawString("hp:" + player.getHp(), BaseFrame.frameWidth - 100, 40);

        }else if (player.getHp() == 0) {

            g.setColor(Color.red);
            g.drawString("hp:" + player.getHp(), BaseFrame.frameWidth - 100, 20);
            g.drawString("score:" + player.getCount(), BaseFrame.frameWidth - 100, 40);
            Font currentFont = g.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 2.5F);
            g.setFont(newFont);
            g.drawString("Game Over",BaseFrame.frameWidth/2-100,BaseFrame.frameHeight/2);
        }



    }




}


