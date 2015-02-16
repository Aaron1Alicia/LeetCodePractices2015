package edu.nyu.yaowang.leetcode.ood;

/**
 * Created by Yao on 2/1/15.
 */
public class ReadNCharsGivenRead4 extends Reader4{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {

        char[] buffer = new char[4];
        int readBytes = 0;
        int bytes = 0;
        boolean flag = false;

        while(!flag && readBytes<n) {
            bytes = read4(buffer);
            if(bytes<4) {
                flag = true;
            }

            bytes = Math.min(n-readBytes, bytes);
            System.arraycopy(buffer /* src */, 0 /* srcPos */,
                    buf /* dest */, readBytes /* destPos */, bytes /* length */);
            readBytes+=bytes;

        }

        return readBytes;


    }

    // This methos will help read 0~3 chars


}

abstract class Reader4{

    int read4(char[] buf){
        return 0;
    }
}
