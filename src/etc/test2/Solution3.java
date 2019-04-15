package etc.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 15/04/2019.
 * @project Algorithm
 * @description
 */
public class Solution3 {

  public static void main(String[] args) {
    List<Integer> lists = new ArrayList<>();
    lists.add(2);


    System.out.println(minPower(lists));
  }

  public static int minPower(List<Integer> p) {
    boolean check = false;
    Gandalf gandalf = new Gandalf();
    int initPower = 1;

    init:while(check != true) {
      gandalf.setInitPower(initPower);
      gandalf.setPower(initPower);
      initPower++;

      for(Integer enemy : p) {
        if(!gandalf.isPowerOverOne(enemy)) {
          continue init;
        }
      }

      check = true;
    }

    return gandalf.getInitPower();
  }

}




class Gandalf {
  int power;
  int initPower;
  public Gandalf() {
  }
  public void setInitPower(int power) {
    this.initPower = power;
  }
  public void setPower(int power) {
    this.power = power;
  }
  public int getInitPower() {
    return this.initPower;
  }
  public boolean isPowerOverOne(int enemyOrBoost) {
    power = power + enemyOrBoost;

    if(power < 1 ) {
      return false;
    }
    return true;
  }
}
