package com.randy.program.changeprobability;

/**
 * 门
 *
 * Author: randy
 * Date: 2019/11/28 18:46
 */
public class Door {
    private String name;
    private boolean prize;

    public Door(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrize() {
        return prize;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }


    @Override
    public String toString() {
        return "Door{" + "name='" + name + '\'' + ", prize=" + prize + '}';
    }
}
