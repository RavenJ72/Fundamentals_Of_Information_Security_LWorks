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

        String[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя,№$)('>< ".split("");
        int[] matrixKey = {0, 2, 3, 2, 1, 2, 3, 3, 2, 1, 0, 3, 0};
        String[][][] key = {
                {
                        "ьаебх)лгпш№нй>дюмкщъ,'эы$зоучвтфёия(<црсж|".split(""),
                        "мжаэ'лк>я,двю|нчьецёзбъыт)щ<ги№пшоусй$(фрх".split(""),
                        "lbъiбeatоmuqf)ns№wитcгkdшzhyoj<ыrущgп|зvpx".split(""),
                        "d№tsmпjaq)ыiгтъ<шозr exиczlщkbofvуwhnyбupg".split(""),
                },
                {
                        "э<л|созйкшгь№$ч')рунжвцпы(фдаеиёяхмщъ>юб,т".split(""),
                        "ёбзчалцтх<пюдн№)м(сфв$щшьиъэе|гжоуйр',>кыя".split(""),
                        "и<)jgзbpvhбпг|№fтnexmiщkzwodlоsшctrъыuyaуq".split(""),
                        "qtkpxъоjшщh<smvптbegir№ozl)гзиydaы nufwбуc".split(""),
                },
                {

                        "ь$я|'уыащър>и(гсдцлнчжфхмё,о)юйкбштвэзп№е<".split(""),
                        "hxщaw)stjr|vоiпzldзыgъбcуnитшpufo№<mгeqbky".split(""),
                        "гxоъmseи hбraщvlpw<тofш|зut№jdcqykzыупnig)".split(""),
                        "щbsпptuvdxkуeошзl№тjhig<mыayzcq гrfбnoи)ъw".split(""),
                },
                {
                        "оиск№$бэ'взпаждъч<ырй(ш,ньщфёт)|хе>юуялмгц".split(""),
                        "гх№ц'чзслешкпыь,юрщ$|ёу>адф<вижъбм)(оэтйня".split(""),
                        "|mrщгscywу tzbxhag)oneбpтшыivъ<udjfпlзиоq№".split(""),
                        "№h)oipveпwщгтtylъgоjn<u kaбbmqrзzxcdиуsыfш".split(""),
                }
        };

        String[] message = "УМЫШленные угрозы преследуют цель нанесения ущерба пользователям сети и подразделяются на активные и пассивные.".split("");


        message = (encrypt(alphabet,key,matrixKey,message,"encrypt")).split("");

        System.out.println("Зашифрованное сообщение: \n\n" + Arrays.stream(message).collect(Collectors.joining()));

        System.out.println("\nИсходное сообщение: \n\n " + encrypt(alphabet,key,matrixKey,message,"decrypt"));












    }
}
