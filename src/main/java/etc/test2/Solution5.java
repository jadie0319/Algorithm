package etc.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author choijaeyong on 15/04/2019.
 * @project Algorithm
 * @description
 */
public class Solution5 {
  public static void main(String[] args) {
    int n = 8;
    List<Integer> a = new ArrayList<>();
    a.add(2);
    a.add(3);
    a.add(4);
    a.add(3);
    List<Integer> b = new ArrayList<>();
    b.add(8);
    b.add(5);
    b.add(6);
    b.add(4);

    System.out.println(angryAnimals(n,a,b));
  }

  public static long angryAnimals(int n, List<Integer> a, List<Integer> b) {
    List<Integer> answer = new ArrayList<>();
    List<Animal> animals = new ArrayList<>();
    for(int i=1; i <= n ; i++) {
      Animal animal = new Animal(i);
      animals.add(animal);
    }

    for(int i=0; i < a.size() ; i++) {
      int animalNumber = a.get(i);
      int enemyNumber = b.get(i);

      Animal animal = animals.get(animalNumber-1);
      Animal enemy = animals.get(enemyNumber-1);
      animal.setEnemy(enemy);
    }

    // 외부 인덱스
    Integer index =0;
    // 내부 인덱스
    Integer i=0;
    long count=0;

    start:while(true) {
      Animal currentAnimal = animals.get(i);
      //System.out.println("currentAnimal.number : "+currentAnimal.number);
      answer.add(currentAnimal.number);
      //Integer enemyNumber = currentAnimal.getEnemyNumber();
      Set<Animal> enemyList = currentAnimal.getEnemyNumber();
      System.out.println(enemyList.size());

      boolean isAnswerContainEnemy = false;
      for(Animal enemy : enemyList) {
        if(answer.contains(enemy.number)) {
          isAnswerContainEnemy = true;
        }
      }


      if(isAnswerContainEnemy) {
        animals.get(index).isVisited = true;
        index++;
        i = index;
        //print(answer,count);
        answer.clear();
        isAnswerContainEnemy = false;
        continue start;
      } else if(index == n-1) {
        count++;
        break;
      }
      i++;
      if(i == n) {
        index++;
        i=index;
        count++;
        //print(answer,count);
        isAnswerContainEnemy = false;
        answer.clear();
        continue start;
      }

      count++;
    }

    return count;
  }

  public static void print(List<Integer> answer,long count) {
    for(Integer k : answer) {
      System.out.print(k + " ");
    }
    System.out.print("    count : " + count);
    System.out.println();
  }

}



class Animal {
  Integer number;
  //Animal enemy;
  Set<Animal> enemies;
  boolean isVisited;
  public Animal(Integer number) {
    this.number = number;
    this.enemies = new HashSet<>();
  }
  public void setEnemy(Animal animal) {
    this.enemies.add(animal);
    //this.enemy = animal;
    animal.enemies.add(this);
  }
  public Set<Animal> getEnemyNumber() {
    return enemies;
//    if(enemies.isEmpty()) {
//      return enemies;
//    } else {
//      return enemies;
//    }
  }
}