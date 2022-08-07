import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A066 {
    // https://paiza.jp/career/challenges/558/retry
    public static void main(String[] args) {

        // 標準入力全行取得
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.length() == 0) {
                break;
            }
            lines.add(str);
        }
        scanner.close();

        // 全ての行数
        int rowCount = Integer.parseInt(lines.get(0));
        List<NumPair> numPairs = lines.subList(1, lines.size()).stream()
                .map(line -> {
                    String[] spl = line.split(" ");
                    return new NumPair(Integer.parseInt(spl[0]), Integer.parseInt(spl[1]));
                })
                .collect(Collectors.toList());

        // 包含チェック
        List<NumPair> uniqueNumPairs = numPairs.stream()
                .filter(np1 -> {
                    for (NumPair np2 : numPairs) {
                        if (np1.equals(np2)) continue;// 自分はスキップ
                        if(np2.isInclusive(np1)){
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());


//        Iterator<NumPair> it = numPairs.iterator();
//        while (it.hasNext()) {
//            NumPair np = it.next();
//        }

        // 開始日でソート
        Collections.sort(uniqueNumPairs);

        // 包含チェック


        // 途中経過確認
        uniqueNumPairs.forEach(System.out::println);
    }

    private static class NumPair implements Comparable<NumPair> {
        private int start;// 開始日
        private int end;// 終了日
        private int continueCount;// 開始日からの錬金日数
        private boolean inclusiveFlg;

        public NumPair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }

        public int getContinueCount() {
            return this.continueCount;
        }

        public boolean isInclusiveFlg() {
            return this.inclusiveFlg;
        }

        public void setContinueCount(int dateCount) {
            this.continueCount = dateCount;
        }

        public void setInclusiveFlg(boolean inclusiveFlg) {
            this.inclusiveFlg = inclusiveFlg;
        }

        // 連勤チェック
        public boolean isContinue(int end) {
            return this.start <= end + 1;
        }

        // 包含チェック
        public boolean isInclusive(NumPair np) {
            return this.start <= np.start && np.end <= this.end;
        }

        // 開始日でソート
        @Override
        public int compareTo(NumPair np) {
            int start = np.getStart();
            return (this.start > start) ? 1 : ((this.start == start) ? 0 : -1);
        }

        // 確認用
        @Override
        public String toString() {
            return String.valueOf(this.start).concat(",").concat(String.valueOf(this.end));
        }
    }
}
