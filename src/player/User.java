package player;

import java.util.Collections;
import java.util.Scanner;

public class User extends Player {

    public void sort() {
        Collections.sort(getHand().getCards());
    }

    @Override
    public int[] getCardsToPlay(int last_card) {
        sort();
        getHand().printCards();

        Scanner sc = new Scanner(System.in);

        if (last_card != -1) {
            System.out.println("The last card played was: " + last_card + " \nYou can play that card, one above or one below.");
        } else {
            System.out.println("You can play any card value you want.");
        }

        System.out.println("How many cards would you like to play?");

        int size = sc.nextInt();

        while (isValidSize(size)) {
            System.out.println("Error! Error! This is not a valid size. Please try again.");
            System.out.println("Please enter how many cards you want to play: ");
            size = sc.nextInt();
        }

        int[] card_indices = new int[size];
        int index;

        for (int i = 0; i < size; i++) {
            System.out.println("Please enter index of card you would like to play: ");
            index = sc.nextInt();

            while (index < 0 || index >= getHand().getSize()) {
                System.out.println("Error! Error! You cannot play a card at that index");
                System.out.println("Please enter another index to play: ");
                index = sc.nextInt();
            }

            card_indices[i] = index;
        }


        return card_indices;
    }

    private boolean isValidSize(int size) {
        return (size > getHand().getSize() || size <= 0 || size > 4);
    }

    @Override
    public boolean callCheat(int card, int multiple) throws IllegalMoveException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to call cheat? Yes/No");

        String answer = sc.next();

        switch (answer) {
            case "Yes":
                return true;
            case "No":
                return false;
            default:
                System.out.println("You didn't type in a correct answer so I am assuming that you mean no. Good day!");
                return false;
        }
    }
}
