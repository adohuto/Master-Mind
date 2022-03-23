import java.util.ArrayList;
import java.util.Scanner;

public class MasterMind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> fulllist = new ArrayList<String>();
		ArrayList<String> selectedlist = new ArrayList<String>();
		int random;
		int i;
		int playCount;

		boolean validEntry = false;
		boolean continue_play = true;
		fulllist.add("R");
		fulllist.add("G");
		fulllist.add("B");
		fulllist.add("Y");
		fulllist.add("O");
		fulllist.add("P");

		while (continue_play == true) {
			selectedlist.clear();
			playCount = 0;
			i = 0;
		while (i < 4) {
			random = (int) Math.floor((Math.random() * 5));
			if (!selectedlist.contains(fulllist.get(random))) {
				selectedlist.add(fulllist.get(random));
				i++;
			}
		}
		System.out.println("Welcome to MasterMind. Try and guess the secret colour code.");
		System.out.println();
		System.out.println("For every correct colour in the right position, you will be shown a +");
		System.out.println("For every correct colour in the wrong position you will be shown a -");
		System.out.println();
		System.out.println("You have 12 chances. Good luck!");
		System.out.println("Colours are:" + fulllist);
		System.out.println();

		
		//System.out.println(selectedlist); // delete before playing game. test purposesh

		boolean guessed = false;
		Scanner input = new Scanner(System.in);

		int guesses = 0;
		do {
			int hintPlus = 0;
			int hintMinus = 0;
			System.out.print("Guess a 4 colour code with no duplicate digits: ");
			String guess = "";
			validEntry = false;
			while (validEntry == false) {
				validEntry = true;
				guess = input.nextLine();
				guess = guess.toUpperCase();

				if (guess.length() != 4) {
					System.out.print("Please enter a guess with only 4 colours: ");
					validEntry = false;

				} else {
					for (i = 0; i < 4; i++) {
						String aString = Character.toString(guess.charAt(i));
						if (fulllist.contains(aString) == false) {
							validEntry = false;
							System.out.print("Please select your colours from the following only: R G B Y O P! : ");
							break;
						}
					}
				}

			}

			guesses++;
			String guessStr = guess + "";

			for (i = 0; i < 4; i++) {
				if (selectedlist.get(i).charAt(0) == guessStr.charAt(i)) {
					hintPlus++;
				} else if (selectedlist.contains(guessStr.charAt(i) + "")) {
					hintMinus++;
				}
			}
			if (hintPlus == 4) {
				guessed = true;
			} else {
				
				for (i = 0; i < hintPlus; i++) {
					System.out.print(" +");
				}
				for (i = 0; i < hintMinus; i++) {
					System.out.print(" -");
				}
				System.out.println();
			}
			playCount++;
		} while (!guessed && playCount < 12);
		
		if( playCount == 12 && guessed == false) {
			System.out.println("You ran out of chances :(");
			System.out.println("The code was:" + selectedlist);
			}

		else if (guessed = true ) {
		System.out.println("You won after " + guesses + " guesses! woah take it easy Master Mind");
		}

		System.out.println("Press Y to play again, Any other key to exit:");
		Scanner input1 = new Scanner(System.in);
		String answer = input1.nextLine();
		if (answer.equals("Y") || answer.equals("y")) {
			continue_play = true;
		} else {
			continue_play = false;
		}

	} // End of While-Loop

	}
}


