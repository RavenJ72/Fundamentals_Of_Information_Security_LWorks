import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
public class LWork6 {
    public static String encrypt(String[] message,int[] key,String key2){

        int gapsChanger = 0;
        int indexOfSpace = 0;
        int[] gaps = Arrays.stream(key2.split(" ")[1].split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <Integer.parseInt(key2.split(" ")[0]); i++,gapsChanger++) {
            if(gapsChanger>gaps.length-1) gapsChanger = 0;
            if(indexOfSpace + gaps[gapsChanger] > message.length-1){
                break;
            }else{
                indexOfSpace += gaps[gapsChanger];
                message[indexOfSpace] += " ";
            }
        }

        message = Arrays.stream(message).collect(Collectors.joining()).split("");
        String[][] resultArrays = new String[key.length][(int)Math.ceil((float)message.length/ key.length)];
        int counter = 0;
        int index = 0;
        for (int i = 0; i < message.length; i++,counter++) {
            if(counter> key.length-1){counter = 0;index++;}
            resultArrays[key[counter]-1][index] = message[i];
        }
        StringBuilder encryptedWord = new StringBuilder();
        Arrays.stream(resultArrays).forEach(e -> encryptedWord.append(Arrays.stream(e).collect(Collectors.joining())));
        return encryptedWord.toString().replaceAll("null"," ");
    }
    public static String decrypt(String message,int[] key,String key2){

        String[][] encryptedWord = Arrays.stream(message.split("(?<=\\G.{"+(int)Math.ceil((float)message.length()/key.length)+"})")).map(e-> e.split("")).toArray(String[][]::new);
        String decryptedWord = "";
        int keyChanger = 0;
        int index = 0;
        for (int i = 0; i < message.length(); i++,keyChanger++) {
            if(keyChanger> key.length-1){keyChanger = 0;
                index++;
            }
            decryptedWord += encryptedWord[key[keyChanger]-1][index];

        }

        String[] decryptedWordWithoutSpaces = decryptedWord.split("");

        int gapsChanger = 0;
        int indexOfSpace = 0;
        int[] gaps = Arrays.stream(key2.split(" ")[1].split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <Integer.parseInt(key2.split(" ")[0]); i++,gapsChanger++) {
            if(gapsChanger>gaps.length-1) gapsChanger = 0;
            if(indexOfSpace + gaps[gapsChanger] > decryptedWordWithoutSpaces.length-1){
                break;
            }else{
                indexOfSpace += gaps[gapsChanger] + 1;
                decryptedWordWithoutSpaces[indexOfSpace] = "";
            }

        }
        return Arrays.stream(decryptedWordWithoutSpaces).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Добрый день, введите ,пожалуста, первый ключ, который представляет собой неповторяющийся набор целых чисел от [1 до N] в произвольном порядке.");
        System.out.println("Пример ключа: " + "2314");
        int[] key = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Теперь введите число неиспользуемых элементов.");
        String n = in.nextLine();

        System.out.println("Введите промежутки через которые будет произведена замена.");
        System.out.println("Пример: " + "12312341231");
        String gaps = in.nextLine();


        String key2 = n+" "+gaps;
        String encryptedWord;

        System.out.println("Введите сообщение, которое нужно зашифровать.После зашифровки программа сразу же произведет дешифровку и выведет два результата на экран.");
        String[] message = in.nextLine().split("");
        encryptedWord = encrypt(message,key,key2);
        System.out.println("Зашифрованное сообщение: " + encryptedWord);
        System.out.println("Дешифрованное сообщение: " + decrypt(encryptedWord,key,key2));
    }
}
