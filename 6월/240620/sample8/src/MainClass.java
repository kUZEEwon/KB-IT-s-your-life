public class MainClass {
    public static void main(String[] args) {
        /*
        * bit 연산자
        * low level
        *
        * bit: 0, 1
        *
        * &     And     두개 모두 참이어야 참
        * |     Or      하나만 참이면 참
        * ^     Xor     비트가 다르면 참 비트가 같으면 거짓
        *
        * <<    left shift      0001    ->  0010
        * >>    right shift     1000    ->  0100
        *
        * ~     반전             0 -> 1, 1 -> 0
        *
        * 16진수
        *
        * 1010 1100(2)
        * 8421 8421
        * Hex: AC
        *
        * 0XF4
        * Bin: 1111 0100
        *
        *
        * */
        //AND

        // 1010 1100 & 1111 0100 = 1010 0100 = 0xA4

        int result = 0xAC & 0xF4; // 0xA4
        System.out.println(result); // 10진수
        System.out.printf("%x\n", result);

        // OR
        /*
        * 1010 1100
        * 1111 0100
        * 1111 1100     -> 0xFC
        * */
        int result2 = 0xAC | 0xF4; // 0xFC
        System.out.println(result2); // 10진수
        System.out.printf("%x\n", result2);


        // XOR(^) 제일 중요해
        /*
         * 1010 1100
         * 1111 0100
         * 0101 1000     -> 0x58
         * */
        System.out.println("xor");
        int result3 = 0xAC ^ 0xF4; // 0xFC
        System.out.println(result3); // 10진수
        System.out.printf("%x\n", result3);

        // left shift(곱하기 2)
        /*
        * x2
        *       0001    0010    0100
        *       8421    2       4
        * */
        System.out.println("left shift");
        byte by = 0x9 << 2; //2
        System.out.println(by);

        // right shift(나누기 2)
        System.out.println("right shift");
        by = 0x10 >> 2;
        System.out.println(by);



        // ~ 반전( 1 <-> 0 )
        System.out.println("반전");
        by = 0x55;
        /*
        * 0x55
        * 0101 0101     ->      1010 1010
        * 85            ->      A    A
        * */
        System.out.printf("%x\n", by);
    }
}
