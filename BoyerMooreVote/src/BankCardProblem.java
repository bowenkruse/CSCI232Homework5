/**
 * Bowen Kruse
 * 6/2/2019
 * While the merge short method runs in O(n Log n)
 * This Boyer-moore implementation runs in O(n)
 * Array fraudbankcards represents a card set where account number 12
 * represents more than half of all cards and is therefor not
 * Array bankcards does not have a card type that represents half
 * of the total card quantity and will not return a card type. 
 */
public class BankCardProblem {

    public static void find(int[] cards) {
        int size = cards.length;
        if (size == 0)
            return;

        int MajorityCard = cards[0];
        int count = 1;

        //First iteration
        for (int i = 1; i < cards.length; i++) {
            if (MajorityCard == cards[i]) {
                count++;
            }
            else if (count == 0) {
                MajorityCard = cards[i];
                count = 1;
            }
            else {
                count--;
            }
        }

        //Second iteration
        count = 0;
        for (int i = 0; i < size; i ++) {
            if (cards[i] == MajorityCard) {
                count ++;
            }
        }

        if (count>size/2) {
            System.out.println("Fraud card:  " + MajorityCard);
        }

        else
            System.out.println("There is no bank card that represents half of all cards");
    }

    public static void main(String args[]) {
        int[] fraudbankcards = {12,12,12,12,12,12,12,12,3,4,5,6,7,8};
        int[] bankcards = {1,2,23,4,56,7,8,3,97,6,5,4,3,7,3,4,6,7,8};

        find(fraudbankcards);
        find(bankcards);
    }
}
