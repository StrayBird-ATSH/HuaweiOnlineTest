import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] zeros = new String[]{"", "0000000", "000000", "00000", "0000", "000", "00", "0"};
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++)
            arrayList.add(in.next());
        for (int i = 0; i < count; i++) {
            String string = arrayList.get(i);
            if (string.length() > 8) {
                arrayList.set(i, string.substring(0, 8));
                arrayList.add(string.substring(8));
                if (arrayList.get(arrayList.size() - 1).length() > 8) {
                    while (arrayList.get(arrayList.size() - 1).length() > 8) {
                        arrayList.set(arrayList.size() - 1, arrayList.get(arrayList.size() - 1).substring(0, 8));
                        arrayList.add(arrayList.get(arrayList.size() - 1).substring(8));
                    }
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++)
            if (arrayList.get(i).length() < 8)
                arrayList.set(i, arrayList.get(i) + zeros[arrayList.get(i).length()]);
        arrayList.sort(null);
        for (String value : arrayList)
            System.out.print(value + " ");
    }
}