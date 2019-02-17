package etc.Object4;

/**
 * @author choijaeyong on 17/02/2019.
 * @project Algorithm
 * @description
 */

class 동물{
  String myClass;
  동물() {
    myClass="동물";
  }
  void showMe() {
    System.out.println(myClass);
  }
}
class 포유류 extends 동물 {
  포유류() {
    myClass = "포유류";
  }
}
class 조류 extends 동물 {
  조류() {
    myClass="조류";
  }
}
class 고래 extends 포유류 {
  고래() {
    myClass="고래";
  }
}
class 박쥐 extends 포유류 {
  박쥐() {
    myClass="박쥐";
  }
}
class 참새 extends 조류 {
  참새() {
    myClass="참새";
  }
}
class 펭귄 extends 포유류 {
  펭귄() {
    myClass="펭귄";
  }
}

public class Exam1 {
  public static void main(String[] args) {
    동물 animal = new 동물();
    동물 mammalia = new 포유류();
    동물 bird = new 조류();
    동물 whale = new 고래();
    동물 sparrow = new 참새();

    animal.showMe();
    mammalia.showMe();
    whale.showMe();
    sparrow.showMe();
  }

}
