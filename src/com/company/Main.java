package com.company;

import wrapper.SmartSpaceException;
import wrapper.SmartSpaceKPI;
import wrapper.SmartSpaceTriplet;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TestRobot robot1 = new TestRobot("robot1");
        Agent myAgent = new Agent(robot1, true);

        String color = "Red";/*
        myAgent.subscribe(null, "sss", null);
//        myAgent.subscribe("bbb", "ssss", null);
        myAgent.unsubscribe(null, null, null, false);*/
//        myAgent.insertIntoSS("repeatRecord", "commandIs", "test.txt");
        /*for (int i = 0; i < 30; i++) {
            myAgent.insertIntoSS("block0" + i * 2, "commandIs", "stop" + i);
        }
        for (int i = 0; i < 30; i++)
            try {
                myAgent.smartSpaceKPI.update(new SmartSpaceTriplet("1", "commandIs", "3" + i),
                        new SmartSpaceTriplet("block0" + i * 2, "commandIs", "stop" + i));
            } catch (SmartSpaceException e) {
                e.printStackTrace();
            }
        myAgent.removeFromSS(null, "commandIs", null);*/
//        myAgent.removeFromSS(null, null, null);
        /*SmartSpaceKPI smartSpaceKPI = myAgent.smartSpaceKPI;
        ArrayList<String> list = new ArrayList<String>();
        list.add(myAgent.subscribe(null, "commandIs", null));*/
        /*try {
            smartSpaceKPI.unsubscribe(list);
        } catch (SmartSpaceException e) {
            e.printStackTrace();
        }*/
//        myAgent.removeFromSS("a", "sss", "a");
//        myAgent.insertIntoSS("a", "sss", "a");
        /*try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
//        myAgent.reactOnColor(color);
//        myAgent.removeFromSS(null, "coordinates", null);
//        myAgent.insertIntoSS("robot", "blockAmount", "3");
//        myAgent.removeFromSS(null, null, null);
//        myAgent.insertIntoSS("block0", "commandIs", "stop");
//        myAgent.insertIntoSS("block1", "commandIs", "stop");
//        myAgent.removeFromSS(null, null, "1-16");
//        myAgent.removeFromSS(null, "obstacleInfo", null);
        myAgent.insertIntoSS("exploreObstacle", "coordinates", "3259; 0");
        myAgent.insertIntoSS("robot2", "task", "exploreObstacle");
//        myAgent.insertIntoSS("robot2", "task", "learn");
//        myAgent.insertIntoSS("goToLocation", "coordinates", "1000; 0");
//        myAgent.insertIntoSS("robot1", "task", "goToLocation");
//        myAgent.insertIntoSS("robot1", "task", "moveForward");
//        myAgent.insertIntoSS("robot1", "task", "goToLocation");
//        myAgent.insertIntoSS("acrossObstacle", "acrossType", "commands for 188-6");
//        myAgent.insertIntoSS("robot1", "task", "riseFirstBlock");
//        myAgent.insertIntoSS("robot1", "task", "acrossObstacle");
//        myAgent.insertIntoSS("forward", "back", "stop", "across");
//        myAgent.insertIntoSS(fool(10240), fool(255), fool(255));
//        myAgent.insertIntoSS("robot2", "task", "stop");
//        myAgent.insertIntoSS("robot", "commandIs", "exit", "rise", "lower", "shrink");
//        myAgent.removeFromSS(null, null, null);
//        myAgent.insertIntoSS("Word", "is", "ITMO");
//        myAgent.insertIntoSS("I", "hasColor", "Yellow");
//        myAgent.insertIntoSS("T", "hasColor", "Green");
//        myAgent.insertIntoSS("M", "hasColor", "Red");
//        myAgent.insertIntoSS("O", "hasColor", "Black");
//        myAgent.insertIntoSS("F", "hasColor", "Blue");
//        myAgent.insertIntoSS("E", "hasColor", "Red");
//        myAgent.insertIntoSS("S", "hasColor", "Yellow");
//        myAgent.insertIntoSS("T", "hasColor", "Green");
//        myAgent.insertIntoSS("O", "hasColor", "Black");
//        myAgent.insertIntoSS("Y", "hasColor", "Grey");
//        myAgent.insertIntoSS("M", "hasColor", "Red");
//        myAgent.insertIntoSS("Robot2", "holdsColor", "Green");
//        myAgent.removeFromSS("Word", "is", "sto");
//        myAgent.insertIntoSS("test\t243; 229; 190; 193; 220; 220; 213; 184; 184; 197; 217; 210; 256; 267; 267; 267; 267; 267; 204; 204; 210; 180; 180; 189; 234; 234; 221; 264; 269; 269; 269; 269; 269; 153; 154; 151; 111; 113; 139; 139; 130; 107; 107; 117; 138; 137; 124; 84; 94; 117; 115; 87; 87; 98; 152; 143; 94; 95; 94", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t244; 210; 187; 199; 141; 135; 135; 135; 135; 224; 210; 198; 155; 166; 230; 222; 187; 168; 166; 175; 215; 210; 171; 175; 248; 215; 221; 176; 175; 175; 175; 181; 189; 177; 121; 129; 134; 115; 115; 131; 128; 90; 90; 106; 135; 135; 135; 132; 91; 91; 43; 27; 27; 27; 27; 27; 142; 141; 125", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t244; 224; 156; 170; 208; 198; 204; 213; 206; 175; 185; 132; 119; 119; 119; 210; 210; 194; 197; 205; 193; 185; 193; 230; 230; 230; 229; 229; 229; 228; 227; 226; 214; 41; 35; 38; 142; 126; 23; 37; 113; 103; 168; 264; 260; 65; 66; 156; 156; 138; 94; 104; 248; 100; 100; 104; 83", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t257; 243; 185; 186; 185; 199; 211; 190; 196; 224; 223; 224; 252; 251; 219; 219; 227; 251; 249; 208; 208; 215; 247; 247; 233; 231; 236; 265; 265; 255; 125; 125; 136; 154; 153; 115; 115; 122; 142; 139; 108; 108; 116; 135; 133; 98; 98; 109; 265; 263; 104; 104; 120; 136; 127", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t237; 222; 161; 167; 211; 211; 200; 180; 186; 210; 210; 199; 195; 196; 224; 224; 213; 265; 271; 271; 271; 271; 271; 213; 213; 223; 246; 218; 218; 232; 232; 223; 103; 108; 136; 125; 69; 69; 124; 124; 115; 87; 94; 123; 123; 108; 92; 98; 124; 124; 112; 77; 81; 179; 179; 172", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t243; 222; 197; 201; 194; 157; 163; 212; 212; 195; 200; 212; 211; 199; 206; 217; 212; 171; 178; 219; 218; 179; 182; 230; 230; 214; 152; 159; 192; 192; 149; 19; 107; 105; 66; 72; 107; 107; 83; 62; 79; 109; 100; 60; 69; 18; 10; 10; 10; 10; 28; 99; 88; 88; 102; 106; 93", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t218; 204; 193; 219; 219; 204; 158; 161; 211; 211; 180; 180; 188; 218; 216; 246; 255; 255; 255; 253; 192; 192; 225; 225; 223; 147; 147; 156; 216; 211; 63; 63; 72; 104; 100; 150; 154; 154; 155; 155; 155; 153; 3; 3; 13; 39; 36; 34; 48; 39; 35; 39; 70; 70; 60", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t236; 224; 192; 198; 202; 258; 264; 264; 264; 264; 264; 263; 258; 203; 203; 214; 235; 235; 216; 191; 194; 204; 177; 173; 181; 231; 231; 202; 163; 173; 196; 196; 182; 67; 79; 83; 76; 38; 38; 50; 38; 18; 25; 51; 51; 62; 65; 56; 32; 32; 45; 64; 61", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t239; 219; 141; 156; 205; 189; 196; 231; 228; 194; 198; 209; 207; 194; 198; 213; 210; 174; 175; 175; 175; 174; 174; 174; 174; 176; 176; 176; 183; 188; 145; 58; 129; 128; 112; 86; 96; 39; 34; 34; 34; 35; 48; 130; 120; 172; 272; 256", "obstacle_21", "");
//        myAgent.insertIntoSS("test\t202; 187; 196; 206; 197; 162; 168; 224; 223; 184; 182; 196; 135; 126; 126; 126; 131; 220; 219; 201; 179; 193; 130; 108; 108; 108; 109; 124; 237; 226; 96; 103; 136; 133; 87; 87; 105; 37; 27; 27; 27; 28; 44; 121; 101; 80; 116; 116", "obstacle_21", "");
        myAgent.printSSInfo(null, null, null);
//        myAgent.removeFromSS("robot1", null, null);
//        myAgent.removeFromSS("robot1", "holdsColor", "Red");
//        myAgent.insertIntoSS("robot1", "holdsColor", "Grey");
//        myAgent.printSSInfo("Phone", null, null);
        /*try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }      */
        myAgent.exit();
    }

    static String fool(int l) {
        String res = "";
        for (int i = 1; i <= l; i++) {
            res += String.format("%d", i%10);
        }
        return res;
    }
}
