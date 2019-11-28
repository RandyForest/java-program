package com.randy.program.changeprobability;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Author: randy
 * Date: 2019/11/28 19:46
 */
public class CompereTest {
    @Test
    void testRemoveDoor(){
        Door door1 = new Door("门1");
        Door door2 = new Door("门2");
        Door door3 = new Door("门3");
        Door[] doors = {door1, door2, door3};

        door3.setPrize(true);
        System.out.println("所有门："+Arrays.toString(doors));

        Compere compere = new Compere();
        System.out.println("观众选中："+door2);
        Door[] removeDoor = compere.removeDoor(doors, door3);
        System.out.println("主持人移除后的门还剩："+Arrays.toString(removeDoor));

    }
}
