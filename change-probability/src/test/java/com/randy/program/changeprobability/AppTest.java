package com.randy.program.changeprobability;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: randy
 * Date: 2019/11/28 18:40
 */
public class AppTest {
    @Test
    void test() {
        App.main(null);
    }

    /**
     * 测试不换门
     */
    @Test
    void testNoChange() {
        int win = 0;
        int total = 1000;

        for (int i = 0; i < total; i++) {
            if (noChange()) {
                win++;
            }
        }

        double probability = (double) win / (double) total;
        System.out.println(probability);
    }

    /**
     * 测试换门
     */
    @Test
    void testChange() {
        int win = 0;
        int total = 1000;

        for (int i = 0; i < total; i++) {
            if (change()) {
                win++;
            }
        }

        double probability = (double) win / (double) total;
        System.out.println(probability);
    }

    /**
     * 不换门
     *
     * @return 是否中奖
     */
    boolean noChange() {
        Random random = new Random();

        // 创建三扇门
        Door door1 = new Door("门1");
        Door door2 = new Door("门2");
        Door door3 = new Door("门3");

        Door[] doors = new Door[]{door1, door2, door3};

        // 给门随机设置奖品
        doors[random.nextInt(3)].setPrize(true);

        // 观众选一扇
        Audience audience = new Audience();
        Door chooseDoor = doors[random.nextInt(3)];
        audience.setDoor(chooseDoor);

        // 主持人打开其它两扇中没有奖品的门
        Compere compere = new Compere();
        Door[] removeDoor = compere.removeDoor(doors, chooseDoor);

        // 不换门

        // 获取结果
        return audience.getDoor().isPrize();
    }

    /**
     * 换门
     *
     * @return 是否中奖
     */
    boolean change(){
        Random random = new Random();

        // 创建三扇门
        Door door1 = new Door("门1");
        Door door2 = new Door("门2");
        Door door3 = new Door("门3");


        Door[] doors = new Door[]{door1, door2, door3};

        // 给门随机设置奖品
        doors[random.nextInt(3)].setPrize(true);

        // 观众选一扇
        Audience audience = new Audience();
        Door chooseDoor = doors[random.nextInt(3)];
        audience.setDoor(chooseDoor);

        // 主持人打开其它两扇中没有奖品的门
        Compere compere = new Compere();
        Door[] removeDoor = compere.removeDoor(doors, chooseDoor);

        // 观众换门
        ArrayList<Door> removeDoorList = new ArrayList<>(List.of(removeDoor));
        removeDoorList.remove(chooseDoor);
        audience.setDoor(removeDoorList.get(0));

        // 获取结果
        return audience.getDoor().isPrize();
    }
}
