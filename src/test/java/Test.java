import com.cuit.exam.utils.MD5Util;

public class Test {
public static void main(String[] args) throws Exception {
}
public static String[] split(String msg, int num) {
    int len = msg.length();
    if (len <= num)
      return new String[] {msg};

    int count = len / (num - 1);
    count += len > (num - 1) * count ? 1 : 0;   //这里应该值得注意

    String[] result = new String[count];

    int pos = 0;
    int splitLen = num-1;
    for (int i = 0; i < count; i++) {
      if (i == count - 1)
        splitLen = len - pos;

      result[i]  = msg.substring(pos,  pos+ splitLen);
      pos += splitLen;

    }

    return result;
}
}
