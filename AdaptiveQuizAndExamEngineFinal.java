import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdaptiveQuizAndExamEngineFinal {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<QuizResult> allResults = new ArrayList<>();

    static class QuizResult {
        private String name;
        private int rollNumber;
        private String subject;
        private int score;
        private double percentage;
        private int level;

        QuizResult(String name, int rollNumber, String subject, int score, double percentage, int level) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.subject = subject;
            this.score = score;
            this.percentage = percentage;
            this.level = level;
        }

        public double getPercentage() {
            return percentage;
        }

        @Override
        public String toString() {
            return "Name: " +name
                    + "Roll No: " + rollNumber
                    + ", Subject: " + subject
                    + ", Score: " + score + "/10"
                    + ", Percentage: " + percentage + "%"
                    + ", Difficulty: " + difficultyName(level);
        }
    }

    static String getSubjectName(int subject) {
        switch (subject) {
            case 1: return "PSP";
            case 2: return "MFC";
            case 3: return "DDCA";
            default: return "Unknown";
        }
    }

    static String difficultyName(int level) {
        if (level == 1) return "EASY";
        if (level == 2) return "MEDIUM";
        return "DIFFICULT";
    }

    static void saveResult(QuizResult result) {
        try (FileWriter writer = new FileWriter("quiz_results.txt", true)) {
            writer.write(result.toString());
            writer.write(System.lineSeparator());
            System.out.println("Result saved to quiz_results.txt.");
        } catch (IOException e) {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }

    static void showPreviousResults() {
        System.out.println("\n--------- PREVIOUS RESULTS ---------");
        try (BufferedReader reader = new BufferedReader(new FileReader("quiz_results.txt"))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                found = true;
            }
            if (!found) System.out.println("No saved results yet.");
        } catch (IOException e) {
            System.out.println("No previous results found yet.");
        }
    }

    static void showLeaderboard() {
        System.out.println("\n--------- QUIZ LEADERBOARD (THIS RUN) ---------");
        if (allResults.isEmpty()) {
            System.out.println("No results in this session yet.");
            return;
        }
        allResults.stream()
                .sorted(Comparator.comparingDouble(QuizResult::getPercentage).reversed())
                .forEach(System.out::println);
    }

    static void showPassingResults() {
        System.out.println("\n--------- PASSING RESULTS (THIS RUN) ---------");
        long count = allResults.stream()
                .filter(result -> result.getPercentage() >= 50)
                .peek(System.out::println)
                .count();
        if (count == 0) System.out.println("No passing results in this session yet.");
    }

    static void displayQuestion(int subject, int level, int q) {
        switch (subject) {
            case 1:
                switch (level) {
                    case 1:
                        switch (q) {
                            case 1:
                                System.out.println("Which data type stores whole numbers?");
                                System.out.println("1. int");
                                System.out.println("2. boolean");
                                System.out.println("3. char");
                                System.out.println("4. double");
                                break;
                            case 2:
                                System.out.println("Which class is commonly used for keyboard input?");
                                System.out.println("1. Math");
                                System.out.println("2. Scanner");
                                System.out.println("3. System");
                                System.out.println("4. Random");
                                break;
                            case 3:
                                System.out.println("Which operator gives the remainder?");
                                System.out.println("1. +");
                                System.out.println("2. /");
                                System.out.println("3. %");
                                System.out.println("4. *");
                                break;
                            case 4:
                                System.out.println("Which statement displays output?");
                                System.out.println("1. System.out.println()");
                                System.out.println("2. Scanner.nextInt()");
                                System.out.println("3. if()");
                                System.out.println("4. for()");
                                break;
                            case 5:
                                System.out.println("Which symbol ends most Java statements?");
                                System.out.println("1. :");
                                System.out.println("2. ;");
                                System.out.println("3. ,");
                                System.out.println("4. .");
                                break;
                            case 6:
                                System.out.println("Which is a Boolean literal?");
                                System.out.println("1. yes");
                                System.out.println("2. 1");
                                System.out.println("3. true");
                                System.out.println("4. on");
                                break;
                            case 7:
                                System.out.println("Which operator checks equality?");
                                System.out.println("1. =");
                                System.out.println("2. ==");
                                System.out.println("3. !=");
                                System.out.println("4. >");
                                break;
                            case 8:
                                System.out.println("Which declaration is valid?");
                                System.out.println("1. int count;");
                                System.out.println("2. count int;");
                                System.out.println("3. integer count;");
                                System.out.println("4. int = count;");
                                break;
                            case 9:
                                System.out.println("What is 17 % 5?");
                                System.out.println("1. 2");
                                System.out.println("2. 3");
                                System.out.println("3. 5");
                                System.out.println("4. 12");
                                break;
                            case 10:
                                System.out.println("Which operator means logical AND?");
                                System.out.println("1. ||");
                                System.out.println("2. !");
                                System.out.println("3. &&");
                                System.out.println("4. ==");
                                break;
                        }
                        break;
                    case 2:
                        switch (q) {
                            case 1:
                                System.out.println("What is the value of 8 + 3 * 2?");
                                System.out.println("1. 22");
                                System.out.println("2. 14");
                                System.out.println("3. 16");
                                System.out.println("4. 11");
                                break;
                            case 2:
                                System.out.println("Which loop checks its condition before each iteration?");
                                System.out.println("1. while");
                                System.out.println("2. do-while only");
                                System.out.println("3. switch");
                                System.out.println("4. if");
                                break;
                            case 3:
                                System.out.println("What is printed by if (5 > 2)?");
                                System.out.println("1. False branch");
                                System.out.println("2. True branch");
                                System.out.println("3. Nothing always");
                                System.out.println("4. Compilation error");
                                break;
                            case 4:
                                System.out.println("Which statement selects among fixed cases?");
                                System.out.println("1. for");
                                System.out.println("2. while");
                                System.out.println("3. switch");
                                System.out.println("4. break");
                                break;
                            case 5:
                                System.out.println("What is the value of 10 / 3 using int operands?");
                                System.out.println("1. 3");
                                System.out.println("2. 3.33");
                                System.out.println("3. 1");
                                System.out.println("4. 0");
                                break;
                            case 6:
                                System.out.println("Which keyword skips to the next loop iteration?");
                                System.out.println("1. stop");
                                System.out.println("2. exit");
                                System.out.println("3. continue");
                                System.out.println("4. return");
                                break;
                            case 7:
                                System.out.println("How many times does for (int i=0; i<4; i++) run?");
                                System.out.println("1. 3");
                                System.out.println("2. 4");
                                System.out.println("3. 5");
                                System.out.println("4. Infinite");
                                break;
                            case 8:
                                System.out.println("What is the value of 6 != 6?");
                                System.out.println("1. true");
                                System.out.println("2. 6");
                                System.out.println("3. false");
                                System.out.println("4. Error");
                                break;
                            case 9:
                                System.out.println("Which branch runs when an if condition is false and else exists?");
                                System.out.println("1. if");
                                System.out.println("2. else");
                                System.out.println("3. switch");
                                System.out.println("4. case");
                                break;
                            case 10:
                                System.out.println("What does break do in a loop?");
                                System.out.println("1. Repeats loop");
                                System.out.println("2. Skips one statement");
                                System.out.println("3. Exits the loop");
                                System.out.println("4. Declares a variable");
                                break;
                        }
                        break;
                    case 3:
                        switch (q) {
                            case 1:
                                System.out.println("What is the final value of x: int x=2; x=x*3+1?");
                                System.out.println("1. 7");
                                System.out.println("2. 9");
                                System.out.println("3. 6");
                                System.out.println("4. 5");
                                break;
                            case 2:
                                System.out.println("How many times does for(int i=1;i<=5;i+=2) run?");
                                System.out.println("1. 2");
                                System.out.println("2. 3");
                                System.out.println("3. 4");
                                System.out.println("4. 5");
                                break;
                            case 3:
                                System.out.println("What is printed by int x=9; if(x%2==0) print even else print odd?");
                                System.out.println("1. even");
                                System.out.println("2. odd");
                                System.out.println("3. 9");
                                System.out.println("4. Error");
                                break;
                            case 4:
                                System.out.println("Which condition checks that n is between 1 and 10 inclusive?");
                                System.out.println("1. n>1 && n<10");
                                System.out.println("2. n>=1 && n<=10");
                                System.out.println("3. n<1 || n>10");
                                System.out.println("4. n==1 && n==10");
                                break;
                            case 5:
                                System.out.println("What is the final value of s in int s=0; for(int i=1;i<=4;i++) s+=i?");
                                System.out.println("1. 6");
                                System.out.println("2. 8");
                                System.out.println("3. 10");
                                System.out.println("4. 4");
                                break;
                            case 6:
                                System.out.println("Which loop is guaranteed to execute at least once?");
                                System.out.println("1. for");
                                System.out.println("2. while");
                                System.out.println("3. do-while");
                                System.out.println("4. nested if");
                                break;
                            case 7:
                                System.out.println("If x=3, what is x++ + 2?");
                                System.out.println("1. 5");
                                System.out.println("2. 6");
                                System.out.println("3. 4");
                                System.out.println("4. 3");
                                break;
                            case 8:
                                System.out.println("Which expression is true when x is even?");
                                System.out.println("1. x%2==1");
                                System.out.println("2. x/2==0");
                                System.out.println("3. x%2==0");
                                System.out.println("4. x==2");
                                break;
                            case 9:
                                System.out.println("What does continue do inside a loop?");
                                System.out.println("1. Ends program");
                                System.out.println("2. Skips remaining loop body for this iteration");
                                System.out.println("3. Exits method");
                                System.out.println("4. Restarts JVM");
                                break;
                            case 10:
                                System.out.println("How many times does for(int i=10;i>0;i-=3) run?");
                                System.out.println("1. 3");
                                System.out.println("2. 4");
                                System.out.println("3. 5");
                                System.out.println("4. 10");
                                break;
                        }
                        break;
                }
                break;
            case 2:
                switch (level) {
                    case 1:
                        switch (q) {
                            case 1:
                                System.out.println("What is 5 squared?");
                                System.out.println("1. 10");
                                System.out.println("2. 20");
                                System.out.println("3. 25");
                                System.out.println("4. 15");
                                break;
                            case 2:
                                System.out.println("What is 2 + 3 * 4?");
                                System.out.println("1. 20");
                                System.out.println("2. 14");
                                System.out.println("3. 24");
                                System.out.println("4. 10");
                                break;
                            case 3:
                                System.out.println("What is the average of 4 and 8?");
                                System.out.println("1. 4");
                                System.out.println("2. 6");
                                System.out.println("3. 8");
                                System.out.println("4. 12");
                                break;
                            case 4:
                                System.out.println("What is 10 modulo 3?");
                                System.out.println("1. 0");
                                System.out.println("2. 2");
                                System.out.println("3. 1");
                                System.out.println("4. 3");
                                break;
                            case 5:
                                System.out.println("What is 7 * 6?");
                                System.out.println("1. 36");
                                System.out.println("2. 40");
                                System.out.println("3. 42");
                                System.out.println("4. 48");
                                break;
                            case 6:
                                System.out.println("What is 100 / 4?");
                                System.out.println("1. 20");
                                System.out.println("2. 25");
                                System.out.println("3. 30");
                                System.out.println("4. 40");
                                break;
                            case 7:
                                System.out.println("What is the square root of 16?");
                                System.out.println("1. 2");
                                System.out.println("2. 4");
                                System.out.println("3. 6");
                                System.out.println("4. 8");
                                break;
                            case 8:
                                System.out.println("If x + 5 = 12, what is x?");
                                System.out.println("1. 5");
                                System.out.println("2. 6");
                                System.out.println("3. 7");
                                System.out.println("4. 8");
                                break;
                            case 9:
                                System.out.println("What is 9 - 4?");
                                System.out.println("1. 3");
                                System.out.println("2. 4");
                                System.out.println("3. 5");
                                System.out.println("4. 6");
                                break;
                            case 10:
                                System.out.println("What is 3 cubed?");
                                System.out.println("1. 6");
                                System.out.println("2. 9");
                                System.out.println("3. 18");
                                System.out.println("4. 27");
                                break;
                        }
                        break;
                    case 2:
                        switch (q) {
                            case 1:
                                System.out.println("What is the mean of 2, 4, and 9?");
                                System.out.println("1. 4");
                                System.out.println("2. 5");
                                System.out.println("3. 6");
                                System.out.println("4. 15");
                                break;
                            case 2:
                                System.out.println("What is 15% of 200?");
                                System.out.println("1. 15");
                                System.out.println("2. 20");
                                System.out.println("3. 30");
                                System.out.println("4. 45");
                                break;
                            case 3:
                                System.out.println("Solve 3x = 21.");
                                System.out.println("1. 6");
                                System.out.println("2. 7");
                                System.out.println("3. 8");
                                System.out.println("4. 9");
                                break;
                            case 4:
                                System.out.println("What is 2^3 + 4?");
                                System.out.println("1. 10");
                                System.out.println("2. 12");
                                System.out.println("3. 16");
                                System.out.println("4. 20");
                                break;
                            case 5:
                                System.out.println("What is the perimeter of a square of side 6?");
                                System.out.println("1. 12");
                                System.out.println("2. 18");
                                System.out.println("3. 24");
                                System.out.println("4. 36");
                                break;
                            case 6:
                                System.out.println("What is 1/2 + 1/4?");
                                System.out.println("1. 1/6");
                                System.out.println("2. 2/6");
                                System.out.println("3. 3/4");
                                System.out.println("4. 1");
                                break;
                            case 7:
                                System.out.println("What is the median of 3, 8, 5?");
                                System.out.println("1. 3");
                                System.out.println("2. 5");
                                System.out.println("3. 8");
                                System.out.println("4. 16");
                                break;
                            case 8:
                                System.out.println("If y=4, what is 2y+3?");
                                System.out.println("1. 8");
                                System.out.println("2. 9");
                                System.out.println("3. 11");
                                System.out.println("4. 12");
                                break;
                            case 9:
                                System.out.println("What is 0.2 expressed as a percentage?");
                                System.out.println("1. 2%");
                                System.out.println("2. 20%");
                                System.out.println("3. 25%");
                                System.out.println("4. 200%");
                                break;
                            case 10:
                                System.out.println("What is the area of a rectangle 5 by 3?");
                                System.out.println("1. 8");
                                System.out.println("2. 15");
                                System.out.println("3. 16");
                                System.out.println("4. 30");
                                break;
                        }
                        break;
                    case 3:
                        switch (q) {
                            case 1:
                                System.out.println("Solve 2x + 5 = 17.");
                                System.out.println("1. 5");
                                System.out.println("2. 6");
                                System.out.println("3. 7");
                                System.out.println("4. 11");
                                break;
                            case 2:
                                System.out.println("A value rises from 80 to 100. What is the percentage increase?");
                                System.out.println("1. 20%");
                                System.out.println("2. 25%");
                                System.out.println("3. 30%");
                                System.out.println("4. ต้อง");
                                break;
                            case 3:
                                System.out.println("What is the mean of 4, 7, 9, and 12?");
                                System.out.println("1. 7");
                                System.out.println("2. 8");
                                System.out.println("3. 9");
                                System.out.println("4. 10");
                                break;
                            case 4:
                                System.out.println("If f(x)=x^2-1, what is f(5)?");
                                System.out.println("1. 24");
                                System.out.println("2. 25");
                                System.out.println("3. 26");
                                System.out.println("4. 10");
                                break;
                            case 5:
                                System.out.println("A triangle has base 10 and height 6. Its area is:");
                                System.out.println("1. 16");
                                System.out.println("2. 30");
                                System.out.println("3. 60");
                                System.out.println("4. 32");
                                break;
                            case 6:
                                System.out.println("Solve x/3 + 2 = 6.");
                                System.out.println("1. 8");
                                System.out.println("2. 10");
                                System.out.println("3. 12");
                                System.out.println("4. 18");
                                break;
                            case 7:
                                System.out.println("What is the probability of an even number on a fair six-sided die?");
                                System.out.println("1. 1/6");
                                System.out.println("2. 1/3");
                                System.out.println("3. 1/2");
                                System.out.println("4. 2/3");
                                break;
                            case 8:
                                System.out.println("If 4 workers finish a task in 6 days, worker-days are:");
                                System.out.println("1. 10");
                                System.out.println("2. 12");
                                System.out.println("3. 24");
                                System.out.println("4. 2");
                                break;
                            case 9:
                                System.out.println("What is (3 + 5)^2 / 4?");
                                System.out.println("1. 8");
                                System.out.println("2. 12");
                                System.out.println("3. 16");
                                System.out.println("4. 64");
                                break;
                            case 10:
                                System.out.println("The roots of x^2 - 9 = 0 are:");
                                System.out.println("1. 9 only");
                                System.out.println("2. -3 only");
                                System.out.println("3. 3 only");
                                System.out.println("4. -3 and 3");
                                break;
                        }
                        break;
                }
                break;
            case 3:
                switch (level) {
                    case 1:
                        switch (q) {
                            case 1:
                                System.out.println("How many bits are in one byte?");
                                System.out.println("1. 4");
                                System.out.println("2. 8");
                                System.out.println("3. 16");
                                System.out.println("4. 2");
                                break;
                            case 2:
                                System.out.println("Which gate inverts its input?");
                                System.out.println("1. AND");
                                System.out.println("2. OR");
                                System.out.println("3. NOT");
                                System.out.println("4. XOR");
                                break;
                            case 3:
                                System.out.println("What is 1 AND 1?");
                                System.out.println("1. 0");
                                System.out.println("2. 1");
                                System.out.println("3. 10");
                                System.out.println("4. Undefined");
                                break;
                            case 4:
                                System.out.println("Which number system uses 0 and 1?");
                                System.out.println("1. Decimal");
                                System.out.println("2. Octal");
                                System.out.println("3. Binary");
                                System.out.println("4. Hexadecimal");
                                break;
                            case 5:
                                System.out.println("How many inputs does a NOT gate have?");
                                System.out.println("1. 1");
                                System.out.println("2. 2");
                                System.out.println("3. 3");
                                System.out.println("4. 4");
                                break;
                            case 6:
                                System.out.println("Which gate outputs 1 when inputs differ?");
                                System.out.println("1. AND");
                                System.out.println("2. OR");
                                System.out.println("3. XOR");
                                System.out.println("4. NOT");
                                break;
                            case 7:
                                System.out.println("Which circuit adds two bits?");
                                System.out.println("1. Decoder");
                                System.out.println("2. Half adder");
                                System.out.println("3. Multiplexer");
                                System.out.println("4. Encoder");
                                break;
                            case 8:
                                System.out.println("How many select lines does a 4-to-1 MUX need?");
                                System.out.println("1. 1");
                                System.out.println("2. 2");
                                System.out.println("3. 3");
                                System.out.println("4. 4");
                                break;
                            case 9:
                                System.out.println("Which gate is 0 only when both inputs are 1?");
                                System.out.println("1. NAND");
                                System.out.println("2. AND");
                                System.out.println("3. OR");
                                System.out.println("4. NOT");
                                break;
                            case 10:
                                System.out.println("Which component can store one bit?");
                                System.out.println("1. Decoder");
                                System.out.println("2. Adder");
                                System.out.println("3. Flip-flop");
                                System.out.println("4. MUX");
                                break;
                        }
                        break;
                    case 2:
                        switch (q) {
                            case 1:
                                System.out.println("What is binary 1010 in decimal?");
                                System.out.println("1. 8");
                                System.out.println("2. 9");
                                System.out.println("3. 10");
                                System.out.println("4. 12");
                                break;
                            case 2:
                                System.out.println("What is the output of OR for inputs 0 and 1?");
                                System.out.println("1. 0");
                                System.out.println("2. 1");
                                System.out.println("3. 2");
                                System.out.println("4. Undefined");
                                break;
                            case 3:
                                System.out.println("How many outputs does a 2-to-4 decoder have?");
                                System.out.println("1. 2");
                                System.out.println("2. 3");
                                System.out.println("3. 4");
                                System.out.println("4. 8");
                                break;
                            case 4:
                                System.out.println("What is the sum output of a half adder for 1 and 1?");
                                System.out.println("1. 0");
                                System.out.println("2. 1");
                                System.out.println("3. 2");
                                System.out.println("4. Carry only");
                                break;
                            case 5:
                                System.out.println("Which gate gives 1 only when both inputs are 1?");
                                System.out.println("1. OR");
                                System.out.println("2. XOR");
                                System.out.println("3. AND");
                                System.out.println("4. NOR");
                                break;
                            case 6:
                                System.out.println("How many bits can a 3-bit register store?");
                                System.out.println("1. 2");
                                System.out.println("2. 3");
                                System.out.println("3. 6");
                                System.out.println("4. 8");
                                break;
                            case 7:
                                System.out.println("What is binary 111 equal to in decimal?");
                                System.out.println("1. 5");
                                System.out.println("2. 6");
                                System.out.println("3. 7");
                                System.out.println("4. 8");
                                break;
                            case 8:
                                System.out.println("Which circuit selects one input from many?");
                                System.out.println("1. Decoder");
                                System.out.println("2. Multiplexer");
                                System.out.println("3. Full adder");
                                System.out.println("4. Counter");
                                break;
                            case 9:
                                System.out.println("How many inputs does a 2-input XOR gate have?");
                                System.out.println("1. 1");
                                System.out.println("2. 2");
                                System.out.println("3. 3");
                                System.out.println("4. 4");
                                break;
                            case 10:
                                System.out.println("Which flip-flop is commonly used for data storage?");
                                System.out.println("1. D flip-flop");
                                System.out.println("2. OR gate");
                                System.out.println("3. Decoder");
                                System.out.println("4. Half adder");
                                break;
                        }
                        break;
                    case 3:
                        switch (q) {
                            case 1:
                                System.out.println("What is binary 1101 in decimal?");
                                System.out.println("1. 11");
                                System.out.println("2. 12");
                                System.out.println("3. 13");
                                System.out.println("4. 14");
                                break;
                            case 2:
                                System.out.println("What are sum and carry for a full adder with A=1, B=1, Cin=1?");
                                System.out.println("1. Sum 0, Carry 1");
                                System.out.println("2. Sum 1, Carry 1");
                                System.out.println("3. Sum 1, Carry 0");
                                System.out.println("4. Sum 0, Carry 0");
                                break;
                            case 3:
                                System.out.println("How many select lines are needed for an 8-to-1 MUX?");
                                System.out.println("1. 2");
                                System.out.println("2. 3");
                                System.out.println("3. 4");
                                System.out.println("4. 8");
                                break;
                            case 4:
                                System.out.println("What is the two's complement of 0101 in 4 bits?");
                                System.out.println("1. 1010");
                                System.out.println("2. 1011");
                                System.out.println("3. 1101");
                                System.out.println("4. 1110");
                                break;
                            case 5:
                                System.out.println("For inputs A=1, B=0, what is NAND output?");
                                System.out.println("1. 0");
                                System.out.println("2. 1");
                                System.out.println("3. A");
                                System.out.println("4. Undefined");
                                break;
                            case 6:
                                System.out.println("A 4-bit unsigned number can represent values from:");
                                System.out.println("1. 0 to 4");
                                System.out.println("2. 0 to 7");
                                System.out.println("3. 0 to 15");
                                System.out.println("4. 1 to 16");
                                break;
                            case 7:
                                System.out.println("Which expression represents XOR?");
                                System.out.println("1. AB");
                                System.out.println("2. A+B");
                                System.out.println("3. A'B+AB'");
                                System.out.println("4. A'B'");
                                break;
                            case 8:
                                System.out.println("A 3-bit binary counter has how many states?");
                                System.out.println("1. 3");
                                System.out.println("2. 6");
                                System.out.println("3. 8");
                                System.out.println("4. 16");
                                break;
                            case 9:
                                System.out.println("What is the decimal value of hexadecimal A?");
                                System.out.println("1. 8");
                                System.out.println("2. 9");
                                System.out.println("3. 10");
                                System.out.println("4. 11");
                                break;
                            case 10:
                                System.out.println("In a full adder, carry output is 1 when:");
                                System.out.println("1. No inputs are 1");
                                System.out.println("2. At least two inputs are 1");
                                System.out.println("3. All inputs are 0");
                                System.out.println("4. Exactly one input is 1");
                                break;
                        }
                        break;
                }
                break;
        }
    }

    // Return the answer key for the selected subject and difficulty.
    static int[] getAnswerKey(int subject, int level) {
        switch (subject) {
            case 1:
                switch (level) {
                    case 1: return new int[]{1, 2, 3, 1, 2, 3, 2, 1, 1, 3};
                    case 2: return new int[]{2, 1, 2, 3, 1, 3, 2, 3, 2, 3};
                    case 3: return new int[]{1, 2, 2, 2, 3, 3, 1, 3, 2, 2};
                }
                break;
            case 2:
                switch (level) {
                    case 1: return new int[]{3, 2, 2, 3, 3, 2, 2, 3, 3, 4};
                    case 2: return new int[]{2, 3, 2, 2, 3, 3, 2, 3, 2, 2};
                    case 3: return new int[]{2, 2, 2, 1, 2, 3, 3, 3, 3, 4};
                }
                break;
            case 3:
                switch (level) {
                    case 1: return new int[]{2, 3, 2, 3, 1, 3, 2, 2, 1, 3};
                    case 2: return new int[]{3, 2, 3, 1, 3, 2, 3, 2, 2, 1};
                    case 3: return new int[]{3, 2, 2, 2, 2, 3, 3, 3, 3, 2};
                }
                break;
        }
        return new int[10];
    }

    static int calculateScore(int[] answers, int[] key) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == key[i]) {
                score++;
            }
        }
        return score;
    }

    static void showDifficulty(int level) {
        if (level == 1) {
            System.out.println("Difficulty: EASY");
        } else if (level == 2) {
            System.out.println("Difficulty: MEDIUM");
        } else {
            System.out.println("Difficulty: DIFFICULT");
        }
    }

    public static void main(String[] args) {
        String name;
        int rollNumber;
        int subject;
        int answer;
        int again = 1;
        int level = 2; // Start at medium difficulty.

        System.out.println("-------------------------------");
        System.out.println(" ADAPTIVE QUIZ AND EXAM ENGINE");
        System.out.println("--------------------------------");
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your roll number: ");
        rollNumber = sc.nextInt();

        do {
            System.out.println("\nChoose a subject:");
            System.out.println("1. PSP");
            System.out.println("2. MFC");
            System.out.println("3. DDCA");
            System.out.print("Enter your choice: ");
            subject = sc.nextInt();

            if (subject < 1 || subject > 3) {
                System.out.println("Invalid subject choice.");
                continue;
            }
            System.out.println("\nName:" +name);
            System.out.println("Roll number: " + rollNumber);
            showDifficulty(level);
            System.out.println("Answer each question by entering 1, 2, 3, or 4.");

            int[] answers = new int[10];
            int[] key = getAnswerKey(subject, level);

            for (int i = 0; i < 10; i++) {
                System.out.println("\nQuestion " + (i + 1) + ":");
                displayQuestion(subject, level, i + 1);
                do {
                    System.out.print("Your answer: ");
                    answer = sc.nextInt();
                    if (answer < 1 || answer > 4) {
                        System.out.println("Please enter a number from 1 to 4.");
                    }
                } while (answer < 1 || answer > 4);
                answers[i] = answer;
            }

            int score = calculateScore(answers, key);
            double percentage = score * 10.0;
            int quizLevel = level;
            QuizResult result = new QuizResult(name,rollNumber, getSubjectName(subject), score, percentage, quizLevel);
            allResults.add(result);
            saveResult(result);

            System.out.println("\n--------- RESULT ---------");
            System.out.println(result);
            System.out.println("Correct answers: " + score + " out of 10");
            System.out.println("Percentage: " + percentage + "%");

            if (score >= 8) {
                System.out.println("Performance: Excellent");
                if (level < 3) {
                    level++;
                    System.out.println("Your next quiz will be more difficult.");
                } else {
                    System.out.println("You will remain at the difficult level.");
                }
            } else if (score <= 4) {
                System.out.println("Performance: Needs more practice");
                if (level > 1) {
                    level--;
                    System.out.println("Your next quiz will be easier.");
                } else {
                    System.out.println("You will remain at the easy level.");
                }
            } else {
                System.out.println("Performance: Satisfactory");
                System.out.println("Your next quiz will remain at the same level.");
            }

            int option;
            do {
                System.out.println("\n--------- RESULT OPTIONS ---------");
                System.out.println("1. View previous results (file)");
                System.out.println("2. View leaderboard (this run)");
                System.out.println("3. View passing results (this run)");
                System.out.println("4. Continue to next quiz / exit");
                System.out.print("Enter your choice: ");
                option = sc.nextInt();
                switch (option) {
                    case 1: showPreviousResults(); break;
                    case 2: showLeaderboard(); break;
                    case 3: showPassingResults(); break;
                    case 4: break;
                    default: System.out.println("Invalid option. Choose 1 to 4.");
                }
            } while (option < 1 || option > 4);

            System.out.println("\nDo you want to take another quiz?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            again = sc.nextInt();

        } while (again == 1);

        System.out.println("Thank you for using the Adaptive Quiz and Exam Engine.");
        sc.close();
    }
}