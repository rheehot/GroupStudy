import java.util.Scanner;

public class SwitchStatement {
    public static void main(String[] args) {
        System.out.println("switch 문을 배워봅시다!");

        Scanner scan = new Scanner(System.in);

        System.out.println("점수를 입력하세요: ");
        int num = scan.nextInt();

        if((num >100) || (num < 0)) {
            System.out.println("잘못된 값을 입력하였습니다.");
        }

//      (int)(num / 10.0f)
//      위의 코드는 결과를 강제로 int 형으로 처리하는 방식이다.
//      10.0f 라는 것이 보이는데
//      실수형에 f가 오면 float 타입을 의미한다.
//      결국 f를 쓰지 않으면 double 타입을 의미한다.
//      위의 방식을 강제 캐스팅이라고도 하며 Type Casting 이라 불린다.
        int fnum = (int)(num /10.0f);
        System.out.println("실수형 값 = " + fnum);

//      90 ~ 100: A, 80 ~ 89: B, 70 ~79: C, 60~69: D, 나머지 F
//      90 ~ 100 / 10 = 9.0 ~ 10.0
//      80 ~ 89 / 10 = 8.0 ~ 8.9
//      70 ~ 79 / 10 = 7.0 ~ 7.9
//      60 ~ 69 / 10 = 6.0 ~ 6.9
//      0 ~ 59 / 10 = 0.0 ~ 5.9

//      break가 case 마다 있는 것을 볼 수 있다.
//      break가 없는 경우 아래와 같이 10과 9인 경우엔
//      10 혹은 9에 대해 모두 같은 처리를 하겠음을 의미한다.
//      break를 만나기 전까지는 동작이 유지된다.

        switch (fnum) {
            case 10:
            case 9:
                System.out.println("당신의 등급은 A");
                break;
            case 8:
                System.out.println("당신의 등급은 B");
                break;
            case 7:
                System.out.println("당신의 등급은 C");
                break;
            case 6:
                System.out.println("당신의 등급은 D");
                break;
            default:
                System.out.println("당신의 등급은 F");
                break;
        }
/*
      <<switch문 작성방법>>

        1.switch를 적고 소괄호를 열고 닫고 중괄호를 열고 닫는다.
        2.소괄호 내부에 조건(케이스가 될 숫자 등등)을 작성한다.
        3.중괄호 내부에는 각각의 케이스를 'case 경우:'로 작성한다.
        4.각각의 케이스에서 동작할 코드를 작성하고 break한다.
        5.필요하다면 break 빼고 묶을 수도 있다.

        Q: switch문은 언제 많이 사용하나요?
        A: 케이스가 뚜렷한 경우엔 세세한 조작을 수행할 수 있다.
           그래서 대표적으로 컴파일러나 IDE 개발시 많이 나타난다.

        Q: switch문에서 default의 용도는 무엇인가요?
        A: case 각각의 케이스들을 적는다고 하였는데
           해당하는 케이스가 하나도 없을 경우 default가 동작을 하게 된다.
*/
    }
}
