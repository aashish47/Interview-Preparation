package Competition;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import  java.util.Arrays;
import java.util.Scanner;

public class Robot {

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void findEnd(int caseNo, int n, int r, int c, int sR, int sC, String in){
        int grid[][] = new int[r][c];
        grid[sR][sC] = -1;
        for(int i = 0; i < in.length(); i++){
            char z = in.charAt(i);
            if(z == 'N'){
                while(grid[sR][sC] != 0){
                    sR--;
                }
                grid[sR][sC] = -1;

            }
            if(z == 'S'){
                while(grid[sR][sC] != 0){
                    sR++;
                }
                grid[sR][sC] = -1;
            }
            if(z == 'E'){
                while(grid[sR][sC] != 0){
                    sC++;
                }
                grid[sR][sC] = -1;
            }
            if(z == 'W'){
                while(grid[sR][sC] != 0){
                    sC--;
                }
                grid[sR][sC] = -1;
            }
        }

        System.out.println("Case #" + ++caseNo + ": " + ++sR + " " + ++sC);


    }

    public static void main(String[] args) throws IOException{
        InputStream inputStream=System.in;
        OutputStream outputStream=System.out;
        InputReader in=new InputReader(inputStream);
        OutputWriter out=new OutputWriter(outputStream);
//        Reader s=new Reader();
        int t = in.nextInt();
        ArrayList<Integer> noOfInstructions = new ArrayList<>();
        ArrayList<Integer> noOfRows = new ArrayList<>();
        ArrayList<Integer> noOfColumns = new ArrayList<>();
        ArrayList<Integer> startRow = new ArrayList<>();
        ArrayList<Integer> startColumn = new ArrayList<>();
        ArrayList<String> instructions = new ArrayList<>();
        String temp;
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            int sR = in.nextInt();
            int sC = in.nextInt();
            noOfInstructions.add(n);
            noOfRows.add(r);
            noOfColumns.add(c);
            startRow.add(sR);
            startColumn.add(sC);
            temp = in.readLine();
            instructions.add(temp);
        }

        for(int i = 0; i < t; i++){
            int n = noOfInstructions.get(i);
            int r = noOfRows.get(i);
            int c = noOfColumns.get(i);
            int sR = startRow.get(i);
            int sC = startColumn.get(i);
            String in1 = instructions.get(i);
            findEnd(i,n,r,c,sR - 1,sC - 1,in1);
        }
    }

}

class InputReader {
    private boolean finished = false;

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c)) {
                res.appendCodePoint(c);
            }
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuilder buf = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                buf.appendCodePoint(c);
            }
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0) {
            s = readLine0();
        }
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines) {
            return readLine();
        } else {
            return readLine0();
        }
    }

    public BigInteger readBigInteger() {
        try {
            return new BigInteger(nextString());
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public char nextCharacter() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        return (char) c;
    }

    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1) {
            read();
        }
        return value == -1;
    }

    public String next() {
        return nextString();
    }

    public SpaceCharFilter getFilter() {
        return filter;
    }

    public void setFilter(SpaceCharFilter filter) {
        this.filter = filter;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
    public int[] nextIntArray(int n){
        int[] array=new int[n];
        for(int i=0;i<n;++i)array[i]=nextInt();
        return array;
    }
    public int[] nextSortedIntArray(int n){
        int array[]=nextIntArray(n);
        Arrays.sort(array);
        return array;
    }
    public int[] nextSumIntArray(int n){
        int[] array=new int[n];
        array[0]=nextInt();
        for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
        return array;
    }
    public long[] nextLongArray(int n){
        long[] array=new long[n];
        for(int i=0;i<n;++i)array[i]=nextLong();
        return array;
    }
    public long[] nextSumLongArray(int n){
        long[] array=new long[n];
        array[0]=nextInt();
        for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
        return array;
    }
    public long[] nextSortedLongArray(int n){
        long array[]=nextLongArray(n);
        Arrays.sort(array);
        return array;
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(char[] array) {
        writer.print(array);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
    }

    public void print(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
    }

    public void print(long[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
    }

    public void println(int[] array) {
        print(array);
        writer.println();
    }

    public void println(double[] array) {
        print(array);
        writer.println();
    }

    public void println(long[] array) {
        print(array);
        writer.println();
    }

    public void println() {
        writer.println();
    }

    public void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public void print(char i) {
        writer.print(i);
    }

    public void println(char i) {
        writer.println(i);
    }

    public void println(char[] array) {
        writer.println(array);
    }

    public void printf(String format, Object... objects) {
        writer.printf(format, objects);
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }

    public void print(long i) {
        writer.print(i);
    }

    public void println(long i) {
        writer.println(i);
    }

    public void print(int i) {
        writer.print(i);
    }

    public void println(int i) {
        writer.println(i);
    }

    public void separateLines(int[] array) {
        for (int i : array) {
            println(i);
        }
    }
}

