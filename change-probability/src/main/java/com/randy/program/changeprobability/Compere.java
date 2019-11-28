package com.randy.program.changeprobability;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * 主持人
 * <p>
 * Author: randy
 * Date: 2019/11/28 19:12
 */
public class Compere {
    /**
     * 移除没有奖品的门，只留下观众选中的与另一扇未知奖品的门
     *
     * @param doors      所有门
     * @param chooseDoor 观众选中的门
     * @return 观众选中的门与一扇未知的门
     */
    Door[] removeDoor(Door[] doors, Door chooseDoor) {
        Random random = new Random();
        ArrayList<Door> doorList = new ArrayList<>(List.of(doors));

        // 移除观众已选的
        doorList.remove(chooseDoor);

        // 如果观众选的是有奖品的
        if (chooseDoor.isPrize()) {
            // 返回选中的有奖品的与随机的一扇门没奖品的
            return new Door[]{chooseDoor, doorList.get(random.nextInt(doorList.size()))};
        }else {
            // 返回选中的与有奖品的门
            int prizeDoorIndex = 0;
            for (int i = 0; i < doors.length; i++) {
                if (doors[i].isPrize()) {
                    prizeDoorIndex=i;
                }
            }
            return new Door[]{chooseDoor, doors[prizeDoorIndex]};
        }

    }
}
