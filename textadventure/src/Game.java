import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, traveller");

        Player player = new Player();
        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

//        int counter = 0;
//        while(counter < 100){
//            counter++;
//        }

//        for(int i = 0; i < 10; i++){
//            for(int j = 0; j < 5; j++){
//                if((i + j) % 3 == 0) {
//                    continue;
//                }
//
//                if(i == 6){
//                    break;
//                }
//
//                System.out.println(i);
//                System.out.println("FOO");
//            }


//        }

    }
}
