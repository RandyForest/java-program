package com.randy.program.changeprobability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 一个概率游戏
 * 有三扇门，其中一扇后面有奖品。
 * 观众选择一扇，主持人打开一扇没有奖品的门，
 * 这时问观众要不要换门。是否换门对中奖概率的影响。
 * <p>
 * Author: randy
 * Date: 2019/11/28 18:39
 */
public class App {
    public static void main(String[] args) {
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
        audience.setDoor(removeDoor[random.nextInt(removeDoor.length)]);

        // 获取结果
        if (audience.getDoor().isPrize()) {
            System.out.println("中奖");
        } else {
            System.out.println("没中奖");
        }
    }
}
