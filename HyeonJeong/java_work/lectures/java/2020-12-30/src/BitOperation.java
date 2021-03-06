public class BitOperation {
    public static void main(String[] args) {
        System.out.println("비트 연산자 예제입니다.");

        int num1 = 5, num2 = 10;

//      &은 비트 연산자 AND를 의미함
//      비트 연산의 특징:
//      같은 자리수에 1이 배치된 경우에만 1이며
//      그 외의 케이스는 모두 0이다.
//      집합으로 생각한다면 교집합
        int res = num1 & num2;
        System.out.println("num1 AND num2 = " + res);

//      |는 비트 연산자 OR를 의미함
//      OR 비트 연산의 특징:
//      같은 자리수에 하나라도 1이 배치되어 있다면 1이고
//      그렇지 않다면 0이 된다.
//      집합으로 생각한다면 합집합
        res = num1 | num2;
        System.out.println("num1 OR num2 = " + res);

//      ^는 비트 연산자 XOR를 의미함
//      XOR 비트 연산의 특징:
//      서로 일치하는 것이 없는 경우에만 1이 된다.
        res = num1 ^ num2;
        System.out.println("num XOR num2 = " + res);

//      ~은 비트 연산자 NOT을 의미함
//      NOT 비트 연산의 특징:
//      모든것을 부정한다.
//      참의 부정 = 거짓
//      거짓의 부정 = 참
        res = ~num1;
        System.out.println("NOT num1 = " + res);

/*
        * 2진수 체계

        Q: 왜 2진수를 알아야 하나요 ?
        A: 비트 연산자는 2진수를 기반으로 동작하기 때문이다.

        ex) 10진수 3421을 생각해보자!

           3    2    1    0  --- ??? 10^n
           3    4    2    1

        3 x 10^3 + 4 x 10^2 + 2 x 10^1 + 1 x 10^0 =
        3000 + 400 + 20 + 1 =
        3421

        핵심 개념: 2진수는 각 자리에 두 가지 숫자만 올 수 있다.
                       2진수는 0 ~ 1 즉 두 개의 숫자만 올 수 있다.

        ex) 2진수로 10진수 10을 표현해보자!

           3    2    1    0 --- ??? 2^n  --- 2의 n승 자리

           8    4    2    1 --- 계산된 2의 n승 자리

           1    0    1    0

        10진수 10은 2진수로 1010(2) 이다.

        * 10진수를 2진수로 만드는 가장 빠른 방법

        1. 변환하고자 하는 숫자를 선정한다.
            예로 23을 들어보자!
        2. 변환하고자 하는 숫자보다 작지만 그 중 가장 큰 2의 n승을 선택한다.
            2^n = 1, 2, 4, 8, 16, 32, 64, ......
            현재 예에서는 16이 선택되며
            16은 2^4 이다.
        3. 변환하고자 하는 숫자에서 2번에서 선택한 숫자를 뺀다.
            현재 케이스에서는 23 - 16 = 7 이 된다.
        4. 나머지가 0이 될 때까지 2 ~ 3번을 반복한다.
            7을 선정하고 근접한 최대 2의 n승은 4다.
            그러므로 7 - 4 = 3이 된다.
            4는 2^2 이다.
        5. 3을 선정하고 근접한 최대 2의 n승은 2다.
            그러므로 3 - 2 = 1이 된다.
            2는 2^1 이다.
        6. 1을 선정하고 근접한 최대 2의 n승은 1이다.
            1은 2^0 이다.

        10111(2) = 23

        검토하고 싶다면

        43210

        2^4 x 1 +
        2^3 x 0 +
        2^2 x 1 +
        2^1 x 1 +
        2^0 x 1 = 16 + 4 + 2 + 1 = 23



        숫자 10의 2진수 변환 1010(2)
        숫자 5의  2진수 변환 0101(2)

                10     1010
        AND      5     0101
        -------------------
                 0     0000

                10     1010
        OR      5      0101
        -------------------
                15     1111

        8 + 4 + 2 + 1 = 15
        16 - 1        = 15

        15 = 01111(2)
        16 = 10000(2)

        7 = 00111(2)
        8 = 01000(2)

        3 = 00011(2)
        4 = 00100(2)

                10     1010
        XOR      5     0101
        -------------------
                15     1111

        NOT      5     0000 0101
        -------------------------
                -6     1111 1010

        ?????? 이게 뭐지 ???

        * 일단 컴퓨터에서 음수를 표현하는 방법

        int는 정수형임을 모두 알고 있지만 음수 표현법은 좀 별개다.
        int는 4 바이트 정수형 데이터 타입
        byte는 1 바이트 데이터 타입
        float은 4 바이트 실수형 데이터 타입
        double은 8 바이트 실수형 데이터 타입

        바이트란?
        컴퓨터가 표현할 수 있는 최소 단위: 비트(bit)
        비트(bit)가 8개 모이면 바이트(byte)가 된다.
        그러므로 우리가 배웠던 int는 32비트가 된다.
        그래서 사실 비트 연산시 32개의 비트를 모두 적어놓는것이 정석이지만
        적을 것이 너무 많이 때문에 줄여서 8개 정도로 적어놓고 계산한다.

         7     6     5     4     3    2    1    0   --- 2의 n승 자리
        128   64    32    16     8    4    2    1   --- 해당 위치에서의 숫자
         0     0     0     0     0    1    0    1   --- 숫자 5를 2진수로 표현
        -----------------------------------------
         1     1     1     1     1    0    1    0   --- 이게 왜 -6 인가요 ?

        우선 int형은 맨 앞에 비트(bit)가 부호를 의미한다.
        맨 앞 bit가 0이면 양수, 1이면 음수입니다.

        10진수 6 은 2진수로 110(2)이므로
        1 000......... 110(2) 이게 왜 -6 이 아닐까 ?

        위의 케이스가 안되는 이유는 0 때문입니다.
        +1 + (-1) = 0

        0000 0001    = 1
        1000 0001    = -1 +
        ---------------------------
        1000 0010    = 0???

      1 1111 111
        0000 0001    = 1
        1111 1111    = -1 +
     -------------------------
        0000 0000    = 0

      1 1111 11
        0000 0110    = 6
        1111 1010    = -6 +
     -------------------------
        0000 0000    = 0

      1 1111 1
        0000 1100    = 12
        1111 0100    = -12 +
     -------------------------
        0000 0000    = 0

      1 1111 111
        0000 1101    = 13
        1111 0011    = -13 +
     -------------------------
        0000 0000    = 0


        어떤 숫자의 음수를 빠르게 만드는 방법
        1. 먼저 만들고 싶은 음수의 양수값을 이진수로 작성한다.
        2. 가장 낮은 자리에 있는 1을 찾는다.
        3. 해당하는 1을 찾은 자리까지의 값은 유지한다.
        4. 나머징 값은 전부 반전한다(참->거짓, 거짓->참)
        [0은 1이 되고 , 1은 0이 된다)

        연습 문제 1.

        -20을 2진수로 표현해보자!
        int는 너무 기니까 8 비트만 표현하도록 한다.

        20 = 16 + 4

        0001 0100(2) = 20
        1110 1100(2) = -20

        연습 문제 2.

        -29를 2진수로 표현해보자!
        29 = 16 + 8 + 4 + 1

        0001 1101(2) = 29
        1110 0011(2) = -29

        XOR 과 OR 는 어떤 차이점이 있는걸까 ?

        1001(2) = 9
        1101(2) = 13 OR
      ------------------
        1101(2) = 13

        1001(2) = 9
        1101(2) = 13 XOR
      ------------------
        0100(2) = 4

        아스키코드
        A = 65, a = 97    둘 사이엔 32 차이
        B = 66, b = 98

        65 = 64 + 1

        0100 0001(2) = 65

        97 = 64 + 32 + 1

        0110 0001(2) = 97
        0010 0000(2) = 32  XOR
     ---------------------------
        0100 0001(2) = 65

        0100 0001(2) = 65
        0010 0000(2) = 32  XOR
     ---------------------------
        0110 0001(2) = 97
 */

//      2진법(Integer.toBinaryString() )
        int num3 = 20;
        int num4 = 29;
        String a2 = Integer.toBinaryString(num3);
        String a3 = Integer.toBinaryString(num4);

        System.out.println(num3 + "의 2진수: " + a2);
        System.out.println(num4 + "의 2진수: " + a3);

    }
}
