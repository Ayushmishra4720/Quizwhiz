import java.util.Scanner;
// Project on quizprogram _ Ayush Mishra , Ashutosh Tiwari, Ayush Kumar Singh
public class Quizwhiz {
	static Scanner sc = new Scanner(System.in);

	static String[] cQuestions = new String[10];
	static String[][] cOptions = new String[10][4];
	static int[] cAnswers = new int[10];

	static String[] javaQuestions = new String[10];
	static String[][] javaOptions = new String[10][4];
	static int[] javaAnswers = new int[10];

	public static void main(String[] args) {
		initializeQuestions();

		if (authenticateUser()) {
			System.out.println("Select your programming language for the quiz:");
			System.out.println("1. C\n2. Java");
			int languageChoice = sc.nextInt();
			switch (languageChoice) {
			case 1:
				System.out.println("You selected C language.");
				startQuiz(cQuestions, cOptions, cAnswers);
				break;
			case 2:
				System.out.println("You selected Java language.");
				startQuiz(javaQuestions, javaOptions, javaAnswers);
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}

	static void initializeQuestions() {
		cQuestions[0] = "Who is the father of C language?";
		cOptions[0] = new String[] {"James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Ken Thompson"};
		cAnswers[0] = 1;

		cQuestions[1] = "C is a _____ level language.";
		cOptions[1] = new String[] {"Low", "High", "Middle", "None"};
		cAnswers[1] = 2;

		cQuestions[2] = "Which of these is a loop construct in C?";
		cOptions[2] = new String[] {"if", "while", "switch", "case"};
		cAnswers[2] = 1;

		cQuestions[3] = "Which symbol is used to terminate a statement in C?";
		cOptions[3] = new String[] {";", ":", ".", ","};
		cAnswers[3] = 0;

		cQuestions[4] = "Which keyword is used to define a constant in C?";
		cOptions[4] = new String[] {"const", "final", "immutable", "static"};
		cAnswers[4] = 0;

		cQuestions[5] = "What is the output of printf(\"%d\", 10);?";
		cOptions[5] = new String[] {"10", "1", "Error", "None"};
		cAnswers[5] = 0;

		cQuestions[6] = "Which of these is used for comments in C?";
		cOptions[6] = new String[] {"//", "/* /", "#", "// and / */"};
		cAnswers[6] = 3;

		cQuestions[7] = "Which data type is used for floating point numbers in C?";
		cOptions[7] = new String[] {"int", "float", "char", "double"};
		cAnswers[7] = 1;

		cQuestions[8] = "Which operator is used for assignment in C?";
		cOptions[8] = new String[] {"==", "=", "+", "-"};
		cAnswers[8] = 1;

		cQuestions[9] = "What is the size of an int in C?";
		cOptions[9] = new String[] {"2 bytes", "4 bytes", "8 bytes", "Depends on platform"};
		cAnswers[9] = 3;

		javaQuestions[0] = "Who is the father of Java language?";
		javaOptions[0] = new String[] {"James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Ken Thompson"};
		javaAnswers[0] = 0;

		javaQuestions[1] = "Java is a _____ level language.";
		javaOptions[1] = new String[] {"Low", "High", "Middle", "None"};
		javaAnswers[1] = 1;

		javaQuestions[2] = "Which of these is a loop construct in Java?";
		javaOptions[2] = new String[] {"if", "while", "switch", "case"};
		javaAnswers[2] = 1;

		javaQuestions[3] = "Which symbol is used to terminate a statement in Java?";
		javaOptions[3] = new String[] {";", ":", ".", ","};
		javaAnswers[3] = 0;

		javaQuestions[4] = "Which keyword is used to define a constant in Java?";
		javaOptions[4] = new String[] {"const", "final", "immutable", "static"};
		javaAnswers[4] = 1;

		javaQuestions[5] = "What is the output of System.out.println(10);?";
		javaOptions[5] = new String[] {"10", "1", "Error", "None"};
		javaAnswers[5] = 0;

		javaQuestions[6] = "Which of these is used for comments in Java?";
		javaOptions[6] = new String[] {"//", "/* /", "#", "// and / */"};
		javaAnswers[6] = 3;

		javaQuestions[7] = "Which data type is used for floating point numbers in Java?";
		javaOptions[7] = new String[] {"int", "float", "char", "double"};
		javaAnswers[7] = 1;

		javaQuestions[8] = "Which operator is used for assignment in Java?";
		javaOptions[8] = new String[] {"==", "=", "+", "-"};
		javaAnswers[8] = 1;

		javaQuestions[9] = "What is the size of an int in Java?";
		javaOptions[9] = new String[] {"2 bytes", "4 bytes", "8 bytes", "Depends on platform"};
		javaAnswers[9] = 1;
	}
	static boolean authenticateUser() {
		System.out.println("Are you a new user or returning user?");
		System.out.println("1. New User\n2. Returning User (Username: Ayush, Password: 1234)");
		int choice = sc.nextInt();
		sc.nextLine(); // Consume newline

		if (choice == 1) {
			return registerNewUser();
		} else if (choice == 2) {
			return loginReturningUser();
		} else {
			System.out.println("Invalid choice!");
			return false;
		}
	}
	static boolean registerNewUser() {
		System.out.println("Enter your username:");
		String username = sc.nextLine();

		System.out.println("Enter your password:");
		String password = sc.nextLine();

		System.out.println("Enter your mobile number:");
		String mobileNumber = sc.nextLine();

		System.out.println("Registration successful! You can now log in.");
		return true;
	}
	static boolean loginReturningUser() {
		System.out.println("Enter your username:");
		String username = sc.nextLine();

		System.out.println("Enter your password:");
		String password = sc.nextLine();

		if (username.equals("Ayush") && password.equals("1234")) {
			System.out.println("Login successful!");
			return true;
		} else {
			System.out.println("Invalid username or password.");
			return false;
		}
	}

	static void startQuiz(String[] questions, String[][] options, int[] answers) {
		int score = 0;

		for (int i = 0; i < 10; i++) {
			System.out.println("Q" + (i + 1) + ": " + questions[i]);
			for (int j = 0; j < 4; j++) {
				System.out.println((j + 1) + ". " + options[i][j]);
			}
			System.out.print("Enter your answer (1-4): ");
			int userAnswer = sc.nextInt() - 1;

			if (userAnswer == answers[i]) {
				score += 4;
			}
		}
		double percentage = ((double) score / 40) * 100;
		System.out.println("\nYour total score is: " + score + " out of 40");
		System.out.println("Your percentage is: " + percentage + "%");

		System.out.println("\nHere are the correct answers:");
		for (int i = 0; i < 10; i++) {
			System.out.println("Q" + (i) + ": " + questions[i]);
			System.out.println("Correct Answer: " + options[i][answers[i]]);
		}
	}
}
