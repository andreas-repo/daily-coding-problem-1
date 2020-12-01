package main.java.application;

import java.util.LinkedList;

public class Main {
    /*
    Good morning! Here's your coding interview problem for today.

    This problem was asked by Dropbox.

    Given a list of words, determine whether the words can be chained to form a circle. A word X can be placed in front of another word Y in a circle if the last character of X is same as the first character of Y.

    For example, the words ['chair', 'height', 'racket', touch', 'tunic'] can form the following circle: chair --> racket --> touch --> height --> tunic --> chair.
     */
    public static void main(String[] args) {
        //Array of Words which you want to chain together
        String[] stringArray = {"chair", "height", "racket", "touch", "tunic"};
        //LinkedList for the chained words
        LinkedList<String> wordChain = new LinkedList<>();
        char lastChar;

        //amount of loops of this for loop is the amount of words which you want to chain together
        for(int i = 0; i < stringArray.length-1; i++) {
            //if it is the first word...
            if(i == 0) {
                //..add the first starting word to the LinkedList...
                wordChain.add(stringArray[i]);
                //...and remove the word from the word list.
                stringArray[0] ="";
            }
            //extract the word from the LinkedList and create a string variable...
            String word = wordChain.get(i);
            //...and get the last letter of the word.
            char lastLetter = word.charAt(word.length()-1);
            //...now loop through all words to find the matching word which hast the same beginning letter.
            for (int y = 1; y < (stringArray.length); y++) {
                //create a string variable of the word you want to test
                String checkWord = stringArray[y];
                //try is needed because if the word is empty because it got removed because its already in the list, a IndexOutOfBounds exception will be thrown
                try {
                    //extract the first letter....
                    char firstLetter = checkWord.charAt(0);
                    //...if the letter equals the letter you look for...
                    if(firstLetter == lastLetter) {
                        //...the word is added to the LinkedList and...
                        wordChain.add(stringArray[y]);
                        //...is removed from the source array
                        stringArray[y] = "";
                        //close the inner loop and jump back in the outer loop.
                        break;
                    }
                } catch (IndexOutOfBoundsException e) {

                }
            }
        }
        //if all words are chained together, the first word is added at the end of the LinkedList to close the circle of chained words.
        wordChain.add(wordChain.get(0));
        //print out the chain
        System.out.println(wordChain);
    }
}
