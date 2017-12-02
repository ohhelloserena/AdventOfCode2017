package com.company;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        List<String> stringArr = new ArrayList<>();
        stringArr.add("626\t2424\t2593\t139\t2136\t163\t1689\t367\t2235\t125\t2365\t924\t135\t2583\t1425\t2502");
        stringArr.add("183\t149\t3794\t5221\t5520\t162\t5430\t4395\t2466\t1888\t3999\t3595\t195\t181\t6188\t4863");
        stringArr.add("163\t195\t512\t309\t102\t175\t343\t134\t401\t372\t368\t321\t350\t354\t183\t490");
        stringArr.add("2441\t228\t250\t2710\t200\t1166\t231\t2772\t1473\t2898\t2528\t2719\t1736\t249\t1796\t903");
        stringArr.add("3999\t820\t3277\t3322\t2997\t1219\t1014\t170\t179\t2413\t183\t3759\t3585\t2136\t3700\t188");
        stringArr.add("132\t108\t262\t203\t228\t104\t205\t126\t69\t208\t235\t311\t313\t258\t110\t117");
        stringArr.add("963\t1112\t1106\t50\t186\t45\t154\t60\t1288\t1150\t986\t232\t872\t433\t48\t319");
        stringArr.add("111\t1459\t98\t1624\t2234\t2528\t93\t1182\t97\t583\t2813\t3139\t1792\t1512\t1326\t3227");
        stringArr.add("371\t374\t459\t83\t407\t460\t59\t40\t42\t90\t74\t163\t494\t250\t488\t444");
        stringArr.add("1405\t2497\t2079\t2350\t747\t1792\t2412\t2615\t89\t2332\t1363\t102\t81\t2346\t122\t1356");
        stringArr.add("1496\t2782\t2257\t2258\t961\t214\t219\t2998\t400\t230\t2676\t3003\t2955\t254\t2250\t2707");
        stringArr.add("694\t669\t951\t455\t2752\t216\t1576\t3336\t251\t236\t222\t2967\t3131\t3456\t1586\t1509");
        stringArr.add("170\t2453\t1707\t2017\t2230\t157\t2798\t225\t1891\t945\t943\t2746\t186\t206\t2678\t2156");
        stringArr.add("3632\t3786\t125\t2650\t1765\t1129\t3675\t3445\t1812\t3206\t99\t105\t1922\t112\t1136\t3242");
        stringArr.add("6070\t6670\t1885\t1994\t178\t230\t5857\t241\t253\t5972\t7219\t252\t806\t6116\t4425\t3944");
        stringArr.add("2257\t155\t734\t228\t204\t2180\t175\t2277\t180\t2275\t2239\t2331\t2278\t1763\t112\t2054");


        // Part 1

        int sum = 0;
        int max;
        int min;
        int diff;

        for (int i = 0; i < stringArr.size(); i++) {
            String[] stringParts = stringArr.get(i).split("\t");
            List<Integer> parts = new ArrayList<>(stringParts.length);

            for (int j = 0; j < stringParts.length; j++) {
                parts.add(Integer.parseInt(stringParts[j]));
            }

            max = Collections.max(parts);
            min = Collections.min(parts);
            diff = max - min;
            sum += diff;
        }
        System.out.println("Part 1: " + sum);

        // Part 2

        int sum2 = 0;

        for (int i = 0; i < stringArr.size(); i++) {
            String[] stringParts = stringArr.get(i).split("\t");
            List<Integer> parts = new ArrayList<>(stringParts.length);

            for (int j = 0; j < stringParts.length; j++) {
                parts.add(Integer.parseInt(stringParts[j]));
            }

            Collections.sort(parts, Collections.reverseOrder()); // sort list in descending order

            for (int k = 0; k < parts.size(); k++) {
                for (int m = k + 1; m < parts.size(); m++) {
                    if (parts.get(k) % parts.get(m) == 0) {
                        sum2 += parts.get(k) / parts.get(m);
                        break;
                    }
                }
            }
        }
        System.out.println("Part 2: " + sum2);
    }
}

