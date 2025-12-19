package Lcu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Lcu.StoreData;

public class Check {
    ArrayList<StoreData> list;

    Check(ArrayList<StoreData> list) {
        this.list = list;
    }

    enum FanType {
        DIEHARD(3), REGULAR(2), CURIOUS(1);
        int rank;
        FanType(int rank) { this.rank = rank; }
    }
    
    public void display(){
        for(StoreData t: list){
            System.out.print("Name :" +t.name);
            System.out.print("\tFan type:" +t.Fan_type);
            System.out.print("\tScore :"+t.score);
            System.out.print("\tSnack :"+t.snack);
            System.out.println("\tPower :"+t.power);

        }
    }
    public void decideOrder() {
        Collections.sort(list, new Comparator<StoreData>() {
            public int compare(StoreData data1, StoreData data2) {
                
                boolean priority_data1 = data1.score >= 8 
                                         && data1.snack.equalsIgnoreCase("no") 
                                         && data1.Fan_type.equalsIgnoreCase("diehard");
                boolean priority_data2 = data2.score >= 8 
                                         && data2.snack.equalsIgnoreCase("no") 
                                         && data2.Fan_type.equalsIgnoreCase("diehard");

                if (priority_data1 && !priority_data2) return -1;
                if (!priority_data1 && priority_data2) return 1;

                if (data1.power != data2.power) return data2.power - data1.power;

                if (data1.score != data2.score) return data2.score - data1.score;

                int rank1 = getFanRank(data1.Fan_type);
                int rank2 = getFanRank(data2.Fan_type);
                if (rank1 != rank2) {
                    return Integer.compare(rank2, rank1); 
                }

           
                return data1.name.compareTo(data2.name);
            }
        });
    }

    private int getFanRank(String fanType) {
        if (fanType == null) return 0;
        switch (fanType.toUpperCase()) {
            case "DIEHARD": return 3;
            case "REGULAR": return 2;
            case "CURIOUS": return 1;
            default: return 0;
        }
    }
}
