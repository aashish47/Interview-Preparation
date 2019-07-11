package Math;

public class ExcelNumberToTitle {
    public static String convertToTitle(int columnNumber) {
        String columnName = "";

        while (columnNumber > 0)
        {
            int rem = columnNumber % 26;

            if (rem == 0)
            {
                columnName = "Z" + columnName;
                columnNumber = (columnNumber / 26) - 1;
            }
            else
            {
                columnName = (char)((rem - 1) + 'A') + columnName;
                columnNumber = columnNumber / 26;
            }
        }
        return columnName;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
}
