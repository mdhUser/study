package org.maxwell.wrongcase;

import java.util.Scanner;

public class SM4 {
    int[] RK = new int[32];//32轮轮密钥, 每个RKi为32bit
    int[] K = new int[36];//在密钥扩展中使用, 一共36组, 每个Ki为32bit
    char[] S_Box = {//S盒，输入8bit, 输出8bit

            0xd6, 0x90, 0xe9, 0xfe, 0xcc, 0xe1, 0x3d, 0xb7, 0x16, 0xb6, 0x14, 0xc2, 0x28, 0xfb, 0x2c, 0x05,
            0x2b, 0x67, 0x9a, 0x76, 0x2a, 0xbe, 0x04, 0xc3, 0xaa, 0x44, 0x13, 0x26, 0x49, 0x86, 0x06, 0x99,
            0x9c, 0x42, 0x50, 0xf4, 0x91, 0xef, 0x98, 0x7a, 0x33, 0x54, 0x0b, 0x43, 0xed, 0xcf, 0xac, 0x62,
            0xe4, 0xb3, 0x1c, 0xa9, 0xc9, 0x08, 0xe8, 0x95, 0x80, 0xdf, 0x94, 0xfa, 0x75, 0x8f, 0x3f, 0xa6,
            0x47, 0x07, 0xa7, 0xfc, 0xf3, 0x73, 0x17, 0xba, 0x83, 0x59, 0x3c, 0x19, 0xe6, 0x85, 0x4f, 0xa8,
            0x68, 0x6b, 0x81, 0xb2, 0x71, 0x64, 0xda, 0x8b, 0xf8, 0xeb, 0x0f, 0x4b, 0x70, 0x56, 0x9d, 0x35,
            0x1e, 0x24, 0x0e, 0x5e, 0x63, 0x58, 0xd1, 0xa2, 0x25, 0x22, 0x7c, 0x3b, 0x01, 0x21, 0x78, 0x87,
            0xd4, 0x00, 0x46, 0x57, 0x9f, 0xd3, 0x27, 0x52, 0x4c, 0x36, 0x02, 0xe7, 0xa0, 0xc4, 0xc8, 0x9e,
            0xea, 0xbf, 0x8a, 0xd2, 0x40, 0xc7, 0x38, 0xb5, 0xa3, 0xf7, 0xf2, 0xce, 0xf9, 0x61, 0x15, 0xa1,
            0xe0, 0xae, 0x5d, 0xa4, 0x9b, 0x34, 0x1a, 0x55, 0xad, 0x93, 0x32, 0x30, 0xf5, 0x8c, 0xb1, 0xe3,
            0x1d, 0xf6, 0xe2, 0x2e, 0x82, 0x66, 0xca, 0x60, 0xc0, 0x29, 0x23, 0xab, 0x0d, 0x53, 0x4e, 0x6f,
            0xd5, 0xdb, 0x37, 0x45, 0xde, 0xfd, 0x8e, 0x2f, 0x03, 0xff, 0x6a, 0x72, 0x6d, 0x6c, 0x5b, 0x51,
            0x8d, 0x1b, 0xaf, 0x92, 0xbb, 0xdd, 0xbc, 0x7f, 0x11, 0xd9, 0x5c, 0x41, 0x1f, 0x10, 0x5a, 0xd8,
            0x0a, 0xc1, 0x31, 0x88, 0xa5, 0xcd, 0x7b, 0xbd, 0x2d, 0x74, 0xd0, 0x12, 0xb8, 0xe5, 0xb4, 0xb0,
            0x89, 0x69, 0x97, 0x4a, 0x0c, 0x96, 0x77, 0x7e, 0x65, 0xb9, 0xf1, 0x09, 0xc5, 0x6e, 0xc6, 0x84,
            0x18, 0xf0, 0x7d, 0xec, 0x3a, 0xdc, 0x4d, 0x20, 0x79, 0xee, 0x5f, 0x3e, 0xd7, 0xcb, 0x39, 0x48};
    static int[] CK = new int[32];//定义固定参数CK, 32组, 每个CKi为32bit
    static int[] FK = {0xa3b1bac6, 0x56aa3350, 0x677d9197, 0xb27022dc};//给定的系统参数FK, 4组, 每个FKi为32bit
    static int[] In = new int[4];

    public SM4(String key, String content) {
        byte[] keys = key.getBytes();
        int[][] SK = new int[4][8];
        SetPara();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                SK[i][j] = keys[i * 8 + j] & 0xff;
            }
        }
        SetRoundKey(SK);
        byte[] contents = content.getBytes();
        byte[][] In1 = new byte[4][8];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(contents, i * 8, In1[i], 0, 8);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                if (In1[i][j] >= 48 && In1[i][j] <= 57)
                    In[i] += ((In1[i][j] - 48) << (28 - j * 4));
                else if (In1[i][j] >= 97 && In1[i][j] <= 102) {
                    In[i] += ((In1[i][j] - 87) << (28 - j * 4));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入明文：");
        String comtent = sc.nextLine();
        if (comtent.startsWith("0x")) {
            comtent = comtent.substring(2);
        }
        System.out.println("请输入密钥：");
        String key = sc.nextLine();
        if (key.startsWith("0x")) {
            key = key.substring(2);
        }
        SM4 sm4 = new SM4(key, comtent);
        System.out.println("加密请输入1,解密请输入2");
        int chance;
        chance = sc.nextByte();
        sm4.Crypt(chance == 1);
    }

    public int S_Func(int In) {//S函数
        int Out = 0;
        int temp;
        for (int i = 0; i < 4; i++) {                   //4组8bit的部分分别经过S盒, 再拼成32bit
            temp = ((In >>> (24 - 8 * i)) & 0xFF);
            Out = Out + (S_Box[temp] << (24 - 8 * i));
        }
        return Out;
    }

    public void SetRoundKey(int[][] SK) {//密钥扩展函数
        int[] SK1 = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                if (SK[i][j] >= 48 && SK[i][j] <= 57)
                    SK1[i] += ((SK[i][j] - 48) << (28 - j * 4));
                else if (SK[i][j] >= 97 && SK[i][j] <= 122) {
                    SK1[i] += ((SK[i][j] - 87) << (28 - j * 4));
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            K[i] = SK1[i] ^ FK[i];
        }
        for (int i = 0; i < 32; i++) {
            K[i + 4] = K[i] ^ T1(K[i + 1] ^ K[i + 2] ^ K[i + 3] ^ CK[i]);
            RK[i] = K[i + 4];
        }
    }

    public int RotL(int In, int loop) {//循环左移函数
        return ((In << loop) | (In >>> (32 - loop)));
    }

    public int T(int In) {//T置换
        return L_Func(S_Func(In));
    }

    public int T1(int In) {//T'置换
        return L1_Func(S_Func(In));
    }

    public int L_Func(int In) {//L变换
        return In ^ RotL(In, 2) ^ RotL(In, 10) ^ RotL(In, 18) ^ RotL(In, 24);
    }

    public int L1_Func(int In) {
        return In ^ RotL(In, 13) ^ RotL(In, 23);
    }

    public void Crypt(boolean flag) {//加解密
        int[] Out = new int[4];
        int[] state = new int[36];
        System.arraycopy(In, 0, state, 0, 4);
        for (int j = 0; j < 32; j++) {
            if (flag)
                state[j + 4] = state[j] ^ T(state[j + 1] ^ state[j + 2] ^ state[j + 3] ^ RK[j]);
            else
                state[j + 4] = state[j] ^ T(state[j + 1] ^ state[j + 2] ^ state[j + 3] ^ RK[31 - j]);
        }
        for (int k = 0; k < 4; k++) {
            Out[k] = state[35 - k];
            System.out.println(Integer.toHexString(Out[k]));
        }
    }

    public void SetPara() {//设置固定参数CK
        int temp;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 4; j++) {
                temp = (7 * (4 * i + j)) & 0xFF;
                temp = temp << (24 - 8 * j);
                CK[i] = CK[i] + temp;
            }
        }
    }
}
