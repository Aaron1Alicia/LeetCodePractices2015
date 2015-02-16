package edu.nyu.yaowang.leetcode.ood;

/**
 * Created by Yao on 2/2/15.
 */
public class ReadNCharsGivenRead4Multiple extends Reader4 {
    char[] buffer = new char[4];
    private int offset=0;
    //bufsize表征buffer里还剩下的字节数
    private int bufsize=0;
    public int read(char[] buf, int n) {

        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            // bufsize不为0，就不读新的
            if (bufsize == 0) { bufsize = read4(buffer); eof = bufsize < 4;
            }
            int bytes = Math.min(n - readBytes, bufsize); System.arraycopy(buffer /* src */, offset /* srcPos */,
                    buf /* dest */, readBytes /* destPos */, bytes /* length */);
//            if(offset+bytes==4){
//                offset =0;
//            } else {
//                offset+=bytes;
//            }
            //这一句用上面的if else语句写思路更清晰一点
            offset = (offset + bytes) % 4;
            bufsize -= bytes;
            readBytes += bytes;
        }
        return readBytes;


    }
}
