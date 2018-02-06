import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String cont = "y";
		int counter = 0;
		String name = Validator.getString(scan, "Please enter your name: ");
		HumanPlayer hp = new HumanPlayer();
		hp.setName(name);
		while (cont.equalsIgnoreCase("y")) {
			// Your code should start here

			System.out.println("Opponents");
			System.out.println("________________________");
			System.out.println("1. The Rock");
			System.out.println("2. Random Player");
			System.out.println();

			int playerChoice = Validator.getInt(scan,
					"Hi, " + name + "!\nPlease select an opponent from the list above: ", 1, 2);
			System.out.println();
			++counter;
			System.out.println("Round: #" + counter);
			switch (playerChoice) {
			case 1:
				String hPSelection = Validator.getString(scan, "Please select ROCK, PAPER, or SCISSORS: ");
				RockPlayer rock = new RockPlayer();

				hp.setUserChoice(hPSelection);
				Roshambo p1 = hp.generateRoshambo();
				Roshambo p2 = rock.generateRoshambo();
				System.out.println();
				System.out.println(hp.getName() + ": " + p1);
				System.out.println(rock.getName() + ": " + p2);
				decideWinner(p1, p2);
				break;
			case 2:
				String hPSelection2 = Validator.getString(scan, "Please select ROCK, PAPER, or SCISSORS: ");
				RandomPlayer rp2 = new RandomPlayer();

				hp.setUserChoice(hPSelection2);
				Roshambo p3 = hp.generateRoshambo();
				Roshambo p4 = rp2.generateRoshambo();
				System.out.println();
				System.out.println(hp.getName() + ": " + p3);
				System.out.println(rp2.getName() + ": " + p4);
				decideWinner(p3, p4);
				break;
			default:
				System.out.println("Something went terribly wrong!");
				break;
			}

			// this is where your code should end if your using this as a template
			System.out.println();
			cont = Validator.getString(scan, "Do you want to continue? y/n ");
			System.out.println();

		}

		// Let the user know the program has ended
		System.out.println("Thanks for playing! Goodbye :)");

		scan.close();

	}

	public static void decideWinner(Roshambo p1, Roshambo p2) {
		if ((p1 == Roshambo.ROCK && p2 == Roshambo.ROCK) || (p1 == Roshambo.PAPER && p2 == Roshambo.PAPER)
				|| (p1 == Roshambo.SCISSORS && p2 == Roshambo.SCISSORS)) {
			System.out.println("TIE!");
		} else if ((p1 == Roshambo.PAPER && p2 == Roshambo.ROCK) || (p2 == Roshambo.PAPER && p1 == Roshambo.ROCK)) {
			System.out.println(Roshambo.PAPER + " WINS!");
		} else if ((p1 == Roshambo.PAPER && p2 == Roshambo.SCISSORS)
				|| (p2 == Roshambo.PAPER && p1 == Roshambo.SCISSORS)) {
			System.out.println(Roshambo.SCISSORS + " WINS!");
		} else if ((p1 == Roshambo.SCISSORS && p2 == Roshambo.ROCK)
				|| (p1 == Roshambo.ROCK && p2 == Roshambo.SCISSORS)) {
			System.out.println(Roshambo.ROCK + " WINS!");
		}
	}

}
