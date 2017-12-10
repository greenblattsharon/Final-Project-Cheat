package player;

import java.util.Collections;
import java.util.Scanner;

public class User extends Player {

    public void sort(){
        Collections.sort(getHand().getCards());
    }

    @Override
    public int[] getCardsToPlay(int last_card) {
        getHand().printCards();

        Scanner sc = new Scanner(System.in);
        System.out.println("How many cards would you like to play?");

        int size = sc.nextInt();

        while(size > getHand().getSize()){
            System.out.println("Error! Error! You do not have that many cards in your hand" );
            System.out.println("Please enter how many cards you want to play: ");
            size = sc.nextInt();
        }

        int[] card_indices = new int[size];
        int index;

        for(int i = 0; i < size; i++){
            System.out.println("Please enter index of card you would like to play: ");
            index = sc.nextInt();

            while(index < 0 || index >= getHand().getSize()){
                System.out.println("Error! Error! You cannot play a card at that index" );
                System.out.println("Please enter another index to play: ");
                index = sc.nextInt();
            }

            card_indices[i] = index;
        }


        return card_indices;
    }
}
