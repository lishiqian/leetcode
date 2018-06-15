package Interview;
import org.junit.Test;

import java.io.UnsupportedEncodingException;


public class NameUtils {
    public String encode(String context) throws UnsupportedEncodingException {
        byte[] bytes = context.getBytes("utf-8");
        reverse(bytes);
        StringBuilder resultSB = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            resultSB.append(bytes[i]);
            if(i != bytes.length-1)
                resultSB.append('|');
        }
        return '[' + resultSB.toString() + ']';
    }



    public String decode(String context) throws UnsupportedEncodingException {
        context = context.substring(1,context.length()-1);
        String[] byteStr = context.split("\\|");
        byte[] bytes = new byte[byteStr.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = Byte.parseByte(byteStr[i]);
        }
        reverse(bytes);
        return new String(bytes,"utf-8");
    }


    public String encode(String context,int count){
        for (int i = 0; i < count; i++) {
            try {
                context = encode(context);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return context;
    }



    public String decode(String context,int count){
        for (int i = 0; i < count; i++) {
            try {
                context = decode(context);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return context;
    }

    public void reverse(byte[] bytes) {
        int begin = 0, end = bytes.length - 1;
        while (begin < end) {
            byte temp = bytes[begin];
            bytes[begin++] = bytes[end];
            bytes[end--] = temp;
        }
    }




    @Test
    public void main() throws UnsupportedEncodingException {
        String codeStr = encode("李仕铅",1);
        System.out.println(codeStr);
        String context = decode(codeStr,1);
        System.out.println(context);

    }
}
