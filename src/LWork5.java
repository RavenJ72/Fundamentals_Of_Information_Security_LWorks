import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
public class LWork5 {
    public static String encrypt(String[] message,int[] key){
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
    public static String decrypt(String message,int[] key){

        String[][] encryptedWord = Arrays.stream(message.split("(?<=\\G.{"+(int)Math.ceil((float)message.length()/key.length)+"})")).map(e-> e.split("")).toArray(String[][]::new);


        for (int i = 0; i < encryptedWord.length; i++) {
            for (int j = 0; j < encryptedWord[j].length; j++) {

                System.out.print(encryptedWord[i][j] + " ") ;

            }
            System.out.println();
        }

        String decryptedWord = "";
        int keyChanger = 0;
        int index = 0;
        for (int i = 0; i < message.length(); i++,keyChanger++) {
            if(keyChanger> key.length-1){keyChanger = 0;index++;}

            decryptedWord += encryptedWord[key[keyChanger]-1][index];
        }
        return decryptedWord;
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Добрый день, введите ,пожалуста, первый ключ, который представляет собой неповторяющийся набор целых чисел от [1 до N] в произвольном порядке.");
        System.out.println("Пример ключа: " + "2314");
        int[] key = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();


        String encryptedWord;
        System.out.println("Введите сообщение, которое нужно зашифровать.После зашифровки программа сразу же произведет дешифровку и выведет два результата на экран.");
        String[] message = in.nextLine().split("");
        encryptedWord = encrypt(message,key);
        System.out.println("Зашифрованное сообщение: " + encryptedWord);
        System.out.println("Дешифрованное сообщение: " + decrypt(encryptedWord,key));
    }
}
