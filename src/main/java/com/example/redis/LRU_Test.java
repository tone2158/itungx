package com.example.redis;

import java.util.*;

class LRUCache{
    private int capacity;
    private Map<Integer,Integer> cache ;
    LinkedList<Integer> list;
    public LRUCache(int capacity){
        this.capacity = capacity ;
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
    }
    //添加元素
    public void put(Integer key , Integer value ){
        cache.put(key,value);
        if(!list.contains(key)){
            list.add(key);
        }
        afterPut(key,value);
    }
    //获取元素
    public int get(Integer key ){
        if(cache.containsKey(key)){
            afterGet(key);
            return cache.get(key);
        }else {
            return -1 ;
        }
    }

    //使用元素之后
    public void afterGet(Integer key ){
        list.remove(key);//移除现有元素，将其添加到最后
        list.addLast(key);
    }

    //添加元素后
    //超过长度后则移除最久未使用的函数
    public void afterPut(Integer key , Integer value ){
        if(cache.size() > capacity){
            Integer oldKey = list.getFirst();
            list.removeFirst();
           // System.out.println("old "+oldKey);
            cache.remove(oldKey);
        }
    }
}
public class LRU_Test {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine()) ;//容量
        LRUCache lru = new LRUCache(n);
        while (scanner.hasNextLine()){
            String[] str = scanner.nextLine().split(" ");
            String op = str[0] ;
            if(op.equals("p")){//put
                int key = Integer.valueOf(str[1]);
                int value = Integer.valueOf(str[2]);
                lru.put(key,value);
            }else {
                int key = Integer.valueOf(str[1]);
                int value = lru.get(key);
                System.out.println(value);
            }
        }
    }
}
//原文链接：https://blog.csdn.net/u012485480/article/details/82427037