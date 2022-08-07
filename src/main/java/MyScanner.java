import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * スキャナー確認用
 * https://qiita.com/wing-x/items/187e988125a3bd7b2b32
 * 読み取る行数あるならそれでループも良いかも
 */
public class MyScanner {

    public static void main(String[] args) {
        myScannerByLine();
    }

    /**
     * 1行ずつ読み取る
     */
    private static void myScannerByLine() {
        // 標準入力全行取得
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {// 空文字でもtrueを返す
            String str = scanner.nextLine();
            if (str.length() == 0) {
                break;
            }
            lines.add(str);
        }
        scanner.close();
        lines.forEach(System.out::println);
    }

    /**
     * 1単語ずつ読み取る
     * これじゃScanner終わらない
     */
    private static void myScannerByWord() {
        // 標準入力全行取得
        List<String> words = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(str.length());

            if (str.length() == 0) {
                break;
            }
            words.add(str);
        }
        scanner.close();
        words.forEach(System.out::println);
    }
}
