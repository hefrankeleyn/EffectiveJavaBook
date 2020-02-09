package com.hef.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
/**
 * @Date 2020/2/8
 * @Author lifei
 */
public class WorldCount {

    public static void main(String[] args) {
//        keyToList();
//        toMapTest01();
//        toMapTest02();
//        groupingByTest01();
        joiningTest();
    }

    /**
     * 一段伪装成Stream代码的迭代式代码
     * 因为这段代码利用一个改变外部状态（频率表）的Lamdba，完成了在终止操作的forEach中的所有工作
     * @param file
     */
    private static void readFileCountWorld(File file){
        Map<String, Long> freq = new HashMap<>();
        try(Stream<String> words = new Scanner(file).tokens()){
            words.forEach(world->{freq.merge(world.toLowerCase(), 1L, Long::sum);});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void readFileCountWorldWithStream(File file){
        Map<String, Long> freq;
        try(Stream<String> words = new Scanner(file).tokens()){
            freq = words.collect(groupingBy(String::toLowerCase, counting()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void keyToList(){
        Map<String, Long> freq = new HashMap<>();
        freq.put("world", 3L);
        freq.put("aa", 2L);
        freq.put("bb", 12L);
        freq.put("hello", 1l);
        List<String> topThree = freq.keySet().stream().sorted(Comparator.comparing(freq::get).reversed())
                .limit(3)
                .collect(toList());
        System.out.println(topThree);
    }


    private static void toMapTest01(){
        List<WorldObj> worldObjs = new ArrayList<>();
        worldObjs.add(new WorldObj("aa", 2));
        worldObjs.add(new WorldObj("aa", 3));
        worldObjs.add(new WorldObj("bb", 1));
        Map<String, WorldObj> topWorldObj = worldObjs.stream()
                .collect(toMap(WorldObj::getWorld, worldObj -> worldObj,
                BinaryOperator.maxBy(Comparator.comparingInt(WorldObj::getLen))));
        for (Map.Entry<String, WorldObj> entry : topWorldObj.entrySet()) {
            System.out.printf("%s %s %d%n", entry.getKey(), ":", entry.getValue().getLen());
        }
    }

    private static void toMapTest02(){
        List<WorldObj> worldObjs = new ArrayList<>();

        worldObjs.add(new WorldObj("aa", 2));
        worldObjs.add(new WorldObj("aa", 3));
        worldObjs.add(new WorldObj("bb", 1));
        worldObjs.add(new WorldObj("aa", 23));
        ConcurrentMap<String, WorldObj> map =
                worldObjs.stream().collect(toConcurrentMap(WorldObj::getWorld, worldObj -> worldObj, (oldVal, newVal) -> newVal));

        for (Map.Entry<String, WorldObj> entry : map.entrySet()) {
            System.out.printf("%s %s %d%n", entry.getKey(), ":", entry.getValue().getLen());
        }

    }

    private static void groupingByTest01(){
        List<WorldObj> worldObjs = new ArrayList<>();

        worldObjs.add(new WorldObj("aa", 2));
        worldObjs.add(new WorldObj("aa", 3));
        worldObjs.add(new WorldObj("bb", 1));
        worldObjs.add(new WorldObj("aa", 23));

        Map<String, List<WorldObj>> map = worldObjs.stream().collect(groupingBy(WorldObj::getWorld));
        for (Map.Entry<String, List<WorldObj>> entry : map.entrySet()) {
            System.out.printf("%s : %d%n", entry.getKey(), entry.getValue().size());
        }
        // 添加一个下游收集器
        Map<String, Integer> map02 = worldObjs.stream().collect(groupingBy(WorldObj::getWorld, summingInt(WorldObj::getLen)));
        for (Map.Entry<String, Integer> entry : map02.entrySet()) {
            System.out.printf("%s %s %d%n", entry.getKey(), ":", entry.getValue());
        }

        worldObjs.stream().collect(groupingBy(WorldObj::getWorld,toCollection(LinkedHashSet::new)));

        Map<String, Long> map03 = worldObjs.stream().collect(groupingBy(WorldObj::getWorld,counting()));


        TreeMap<String, Long> treeMap = worldObjs.stream().collect(groupingBy(WorldObj::getWorld, TreeMap::new, counting()));

        Map<Boolean, List<WorldObj>> map04 = worldObjs.stream().collect(partitioningBy(worldObj -> worldObj.getLen() > 10));
        for (Map.Entry<Boolean, List<WorldObj>> entry : map04.entrySet()) {
            System.out.printf("%s %d%n", entry.getKey(), entry.getValue().size());
        }

        Map<Boolean, Long> map05 = worldObjs.stream().collect(partitioningBy(worldObj -> worldObj.getLen() > 10, counting()));
        for (Map.Entry<Boolean, Long> entry : map05.entrySet()) {
            System.out.printf("%s %s %d%n", entry.getKey(), ":", entry.getValue());
        }

        long count = worldObjs.stream().count();


    }


    private static void joiningTest(){
        String[] strArr = {"world", "hello"};
        String str01 = Stream.of(strArr).collect(joining());
        String str02 = Stream.of(strArr).collect(joining("$"));
        String str03 = Stream.of(strArr).collect(joining("#", "{", "}"));
        System.out.println(str01);
        System.out.println(str03);
    }

    private static class WorldObj{
        private String world;
        private int  len;

        public WorldObj(String world, int len){
            this.world = world;
            this.len = len;
        }

        public int getLen() {
            return len;
        }

        public String getWorld() {
            return world;
        }

        public void setLen(int len) {
            this.len = len;
        }

        public void setWorld(String world) {
            this.world = world;
        }
    }

}
