package etc.test3;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author choijaeyong on 19/04/2019.
 * @project Algorithm
 * @description
 */

@Getter
@Setter
public class Subject {

  private String name;
  private List<Time> time;
  private Integer score;

  public Subject(String name, Integer score) {
    this.name = name;
    this.score = score;
  }


  // 과목이 1~2 학점이면 주 2시간의 수업
  // 과목이 3학점이면 주2회 2시간의 수업

}
