package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
입출력 예
number	k	return
"1924"	2	"94"
"1231234"	3	"3234"
"4177252841"	4	"775841"
 */

public class 탐욕법_큰수만들기 {

    @Test
    void case1() {
        String number = "1924";
        int k = 2;
        String solution = solution(number, k);
        assertThat(solution).isEqualTo("94");
    }

    @Test
    void case3() {
        String number = "4177252841";
        int k = 4;
        String solution = solution(number, k);
        assertThat(solution).isEqualTo("775841");
    }

    public String solution(String number, int k) {
        int resultLength = number.length() - k;
        // 4 - 2 = 2
        // 1924    2자리 숫자를 만들때  적어도 1,9,2 중에서 10의 자리 숫자가 나와야함.


        StringBuilder builder = new StringBuilder();
        //int position = 0;
        int startIndex = -1;
        for (int i = 0; i < resultLength ; i++ ) {
            int max = 0;
            for (int j = startIndex + 1 ; j <= i + k ; j++) {
                int num = Integer.parseInt(String.valueOf(number.charAt(j)));
                //int num = (int)number.charAt(j);
                //int num = (int)builder.charAt(j);
                // num >= max 로 하면 3번째 케이스 실패함
                // 77 중에서 앞에 7 은 무시되어서 그런듯.

                // 숫자가 9일때는 다른거 비교할 것도 없이 제일 큰수니까 break
                // 이 if 문 추가하니 10번 케이스 통과.
                if (num == 9) {
                    startIndex = j;
                    max = num;
                    break;
                }

                if (num > max) {
                    startIndex = j;
                    max = num;
                }
            }
            //builder.append(max);
            builder.append(max);
        }
        return builder.toString();


//        return integerList.stream()
//                .map(num -> String.valueOf(num))
//                .reduce( (n1,n2) -> n1 + n2)
//                .get()
//                ;
    }
}
