package Lcu;
import java.util.ArrayList;
import java.util.Scanner;

public class Lcu{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no of friends : ");
        int Numberoffriends = s.nextInt();

        ArrayList<StoreData> dataset = new ArrayList<>();
        
        while(Numberoffriends-- != 0){
            System.out.println("Name");
            String name = s.next();
            System.out.println("Fan type");
            String Fan_type = s.next();
            System.out.println("Fan score");
            int score = s.nextInt();
            System.out.println("Have snacks");
            String snack = s.next();
            System.out.println("Ticket holding power");
            int power = s.nextInt();
            StoreData storing = new StoreData(name, Fan_type, score, snack, power) ;
            dataset.add(storing);
        }
       Check check = new Check(dataset);
       check.decideOrder();
       check.display(); 
    }
}
