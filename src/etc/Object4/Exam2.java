package etc.Object4;

/**
 * @author choijaeyong on 17/02/2019.
 * @project Algorithm
 * @description
 */

class Animal {
  public String name;
  public void showName() {
    System.out.printf("안녕 나는 %s야. 반가워\n",name);
  }
}
class Penguin extends Animal {
  public String habitat;

  public void showHabitat() {
    System.out.printf("%s는 %s에 살아\n", name, habitat);
  }

  // 오버라이딩 - 상위 클래스의 메서드와 같은 이름, 같은 인자 리스트
  public void showName() {
    System.out.println("어머 내 이름은 알아서 뭐하게요?");
  }
  // 오버로딩 - 중복정의 : 같은 메서드 이름, 다른 인자리스트.
  public void showName(String yourName) {
    System.out.printf("%s 야. 안녕. 나는 %s라고 해!\n", yourName, name);
  }
}
public class Exam2 {
  public static void main(String[] args) {
    Penguin pororo = new Penguin();

    pororo.name = "뽀로로";
    pororo.habitat = "남극";

    pororo.showName();
    pororo.showName("초보람보");
    pororo.showHabitat();

    Animal pingu = new Penguin();

    pingu.name = "핑구";
    ((Penguin) pingu).habitat = "핑구집";
    pingu.showName();
    ((Penguin) pingu).showName("고수람보");
    ((Penguin) pingu).showHabitat();

  }


}
