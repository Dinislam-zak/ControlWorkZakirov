package ru.itis.inf304;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Atlas\\IdeaProjects\\ControlWorkZakirov\\src\\main\\java\\ru\\itis\\inf304\\schedule.txt";
        Scanner s = new Scanner(new File(path));
        List<String> list = new ArrayList<>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        //4
        Map<BroadcastsTime, List<Program>> BroadcastsTimeMap = new LinkedHashMap<>();
        List<Program> listOfSchedule = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(0) == '#') {
                String channel = list.get(i);
                i++;
                while (list.get(i).charAt(0) != '#'){
                    BroadcastsTime broadcastsTime = new BroadcastsTime(list.get(i));
                    Program program = new Program(channel, broadcastsTime, list.get(i));
                    listOfSchedule.add(program);
                    if (BroadcastsTimeMap.containsKey(broadcastsTime)){
                        BroadcastsTimeMap.get(broadcastsTime).add(program);
                    } else BroadcastsTimeMap.put(broadcastsTime, new ArrayList<>(List.of(program)));
                    i = i + 2;
                    if (i >= list.size()){
                        break;
                    }
                }
                i--;
            }
        }
        //5
        List<Program> allPrograms = new ArrayList<>();

        for (List<Program> channelPrograms : BroadcastsTimeMap.values()) {
            allPrograms.addAll(channelPrograms);
        }


        List<Program> allProgramms = new ArrayList<>();
        for (List<Program> programs : BroadcastsTimeMap.values()) {
            allProgramms.addAll(programs);
        }

        //6
        Collections.sort(allProgramms, new Comparator<Program>() {
            @Override
            public int compare(Program p1, Program p2) {
                int channelComparison = p1.getChannel().compareTo(p2.getChannel());
                if (channelComparison != 0) {
                    return channelComparison;
                }
                return p1.getTime().compareTo(p2.getTime());
            }
        });


        for (Program program : allProgramms) {
            System.out.println(program.toString());
        }
        BroadcastsTime nowTime = new BroadcastsTime((byte) 3, (byte) 30);

        //7
        System.out.println("Программы, которые начнутся сейчас");
        for (int i = 0; i < allPrograms.size(); i++) {
            if (allPrograms.get(i).getTime().equals(nowTime)) {
                System.out.println(allPrograms.get(i).toString());
            }
        }
        System.out.println();

        //8
        String needName = "Наше всё";

        System.out.println("Программы по названию: " + needName);
        for (int i = 0; i < allPrograms.size(); i++) {
            if (allPrograms.get(i).getName().equals(needName)) {
                System.out.println(allPrograms.get(i).toString());
            }
        }
        System.out.println();

        //9
        String neededChannel = "#Матч!";
        System.out.println("Программы с канала: " + neededChannel + " идущие сейчас");
        for (int i = 0; i < allPrograms.size(); i++) {
            if (allPrograms.get(i).getChannel().equals(neededChannel) && allPrograms.get(i).getTime().equals(nowTime)) {
                System.out.println(allPrograms.get(i).toString());
            }
        }
        System.out.println();

        //10
        BroadcastsTime t1 = new BroadcastsTime((byte)2, (byte) 25);
        BroadcastsTime t2 = new BroadcastsTime((byte)20, (byte) 40);

        System.out.println("Программы с канала: " + neededChannel + " идущие в период: с " + t1 + " до " + t2);
        for (int i = 0; i < allPrograms.size(); i++) {
            if (allPrograms.get(i).getChannel().equals(neededChannel) && allPrograms.get(i).getTime().between(t1, t2)) {
                System.out.println(allPrograms.get(i).toString());
            }
        }
    }
}
