import java.io.*;
import java.util.Scanner;

public class AdventureTime {


    public AdventureTime() throws FileNotFoundException {
    }

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        System.out.println(challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        System.out.println(challengeTwoAnswer);
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        System.out.println(challengeThreeAnswer);
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");
        System.out.println(challengeFourAnswer);

        writeFileAllAnswers("AdventureTime.txt", challengeOneAnswer,challengeTwoAnswer,challengeThreeAnswer,challengeFourAnswer);
    }





    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int intNumber = countLinesInFile(fileName);
        int[] intArray= readFile(fileName);
        int answer1 = 0;
        for(int i = 1; i < intNumber; i++){
            if (intArray[i] > intArray[i-1]){
                    answer1 ++;
            } else{
                answer1 += 0;
            }
        }

        return answer1;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int intNumber = countLinesInFile(fileName);
        int[] intArray = readFile(fileName);

        int answer2 = 0;
        for(int i = 0; i < intNumber - 3; i++){
            if(intArray[i+1] + intArray[i+2] + intArray[i+3] > intArray[i] + intArray[i+1] + intArray[i+2]){
                answer2 ++;
            } else{
                answer2 += 0;
            }
        }
        return answer2;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int intNumber = countLinesInFile(fileName);
        String[] stringArray = readFileTwo(fileName);
        int horaxis = 0;
        int veraxis = 0;
        for(int i = 0; i < intNumber ; i++){
            if(stringArray[i].substring(0,2).equals("up")){
                int ver = Integer.parseInt(stringArray[i].substring(3));
                veraxis -= ver;
            }
            else if(stringArray[i].substring(0,4).equals("down")){
                int ver = Integer.parseInt(stringArray[i].substring(5));
                veraxis += ver;
            }
            else{
                int hor = Integer.parseInt(stringArray[i].substring(8));
                horaxis += hor;
            }
        }
        return horaxis*veraxis;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int intNumber = countLinesInFile(filename);
        String[] stringArray = readFileTwo(filename);
        int aim = 0;
        int horizontal = 0;
        int depth = 0;
        for(int i = 0; i < intNumber ; i++){
            if(stringArray[i].contains("forward")){
                int hor = Integer.parseInt(stringArray[i].substring(8));
                horizontal += hor;
                depth += aim*hor;
            }
            else if(stringArray[i].contains("down")){
                int ver = Integer.parseInt(stringArray[i].substring(5));
                aim += ver;
            }
            else if(stringArray[i].contains("up")){
                int ver = Integer.parseInt(stringArray[i].substring(3));
                aim -= ver;
            }
            else{
                aim += 0;
            }
        }
        return depth*horizontal;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

    private static String[] readFileTwo(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int intNumber = countLinesInFile(inputFilename);
        String[] stringArray = new String[intNumber];
        int index = 0;
        while(scanner.hasNextLine()){
            stringArray[index++] = scanner.nextLine();
        }
        return stringArray;
    }

}