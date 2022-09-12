import java.util.Arrays;
import java.util.stream.Collectors;

public class LWork3 {


    public static String encrypt(String[] alphabet,String[][][] key, int[] matrixKey,String[] message,String param){

        StringBuilder result = new StringBuilder();
        int keyChanger = 0;
        int keyMatrixChanger = 0;
        boolean flag = false;
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if(param.equalsIgnoreCase("encrypt")){
                    if (message[i].equalsIgnoreCase(alphabet[j])) {
                        if(Character.isUpperCase(message[i].charAt(0))){
                            result.append(key[matrixKey[keyMatrixChanger]][keyChanger][j].toUpperCase());
                        }else{
                            result.append(key[matrixKey[keyMatrixChanger]][keyChanger][j]);
                        }
                        keyChanger++;
                        if(keyChanger>key.length-1) {
                            keyChanger = 0;
                            keyMatrixChanger++;
                            if(keyMatrixChanger > matrixKey.length-1){
                                keyMatrixChanger = 0;
                            }
                        }
                        flag = true;
                        break;
                    }
                } else if (param.equalsIgnoreCase("decrypt")) {
                    if (message[i].equalsIgnoreCase(key[matrixKey[keyMatrixChanger]][keyChanger][j])) {
                        if(Character.isUpperCase(message[i].charAt(0))){
                            result.append(alphabet[j].toUpperCase());
                        }else{
                            result.append(alphabet[j]);
                        }
                        keyChanger++;
                        if(keyChanger>key.length-1) {
                            keyChanger = 0;
                            keyMatrixChanger++;
                            if(keyMatrixChanger > matrixKey.length-1){
                                keyMatrixChanger = 0;
                            }
                        }
                        flag = true;
                        break;
                    }
                }else{
                    return "";
                }


            }
            if (!flag) result.append(message[i]);
            flag = false;
        }
        return result.toString();
    }
    public static void main(String[] args) {

        String[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".split("");
        int[] matrixKey = {0, 2, 3, 2, 1, 2, 3, 3, 2, 1, 0, 3, 0};
        String[][][] key = {
                {
                        "ьаебхлгпшнйдюмкщъэызоучвтфёияцрсж".split(""),
                        "мжаэлкядвюнчьецёзбъытщгипшоусйфрх".split(""),
                        "lbъiбeоmuqfnsитcгkdzhojыrущgпзvpx".split(""),
                        "dtmпjqыiгтъшозexиczlщkbofvуhnyбpg".split(""),
                },
                {
                        "элсозйкшгьчрунжвцпыфдаеиёяхмщъюбт".split(""),
                        "ёбзчалцтх<пюднмсфвщшьиъэегжоуйркы".split(""),
                        "иjgзbphбпгfтnexmikzwodоsctrъыuyуq".split(""),
                        "qtpxъоjшщhsmптbegirozlгзиydaыuбуc".split(""),
                },
                {

                        "ьяуыащъригсдцлнчжфхмёоюйкбштвэзпе".split(""),
                        "hxawstjrоiпzldзыgъбcnитшpufomeqby".split(""),
                        "гxоъmsиhбraщvlpwтofшзutdcqykzыуig".split(""),
                        "щbsпtuvdxуeошlтjhigыayzcqгrfбnoиw".split(""),
                },
                {
                        "оискбэвзпаждъчырйшньщфётхеюуялмгц".split(""),
                        "гхцчзслешкпыюрщёу>адф<вижъбмоэтйн".split(""),
                        "mrщгscywуtzbxhagoneбpтшыъudjlзиоq".split(""),
                        "oipeпwгтtylъgоjnkaбbmqзzxcdиуsыfш".split(""),
                }
        };

        String[] message = "Умышленные угрозы преследуют цель нанесения ущерба пользователям сети и подразделяются на активные и пассивные.".split("");


        message = (encrypt(alphabet,key,matrixKey,message,"encrypt")).split("");

        System.out.println("Зашифрованное сообщение: \n\n" + Arrays.stream(message).collect(Collectors.joining()));

        System.out.println("\nИсходное сообщение: \n\n " + encrypt(alphabet,key,matrixKey,message,"decrypt"));












    }
}
