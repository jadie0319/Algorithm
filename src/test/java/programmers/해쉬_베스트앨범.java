package programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class 해쉬_베스트앨범 {

  @Test
  void case1() {
    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};
    int[] solution = solution(genres, plays);
    assertThat(solution).containsExactly(4,1,3,0);
  }

  public int[] solution(String[] genres, int[] plays) {
    Map<String, Musics> musicsByGenre = new HashMap<>();
    for (int i=0; i < genres.length ; i++) {
      Music music = new Music(i, plays[i]);
      if (musicsByGenre.containsKey(genres[i])) {
        Musics musics= musicsByGenre.get(genres[i]);
        musics.add(music);
      } else {
        ArrayList<Music> musics = new ArrayList<>();
        musics.add(music);
        musicsByGenre.put(genres[i], new Musics(musics));
      }
    }

    List<Musics> orderedMusics = musicsByGenre.values().stream().sorted(new Comparator<Musics>() {
      @Override
      public int compare(Musics o1, Musics o2) {
        return o1.sum() > o2.sum() ? -1 : 1;
      }
    }).collect(Collectors.toList());

    List<Integer> answerList = new ArrayList<>();
    for(Musics musics : orderedMusics) {
      musics.sort();
      List<Integer> answerIndex = musics.getAnswerMusics();
      answerList.addAll(answerIndex);
    }
    return answerList.stream().mapToInt(a -> a).toArray();
  }


  public static class Music implements Comparable<Music> {
    private Integer index;
    private Integer play;

    public Music(Integer index, Integer play) {
      this.index = index;
      this.play = play;
    }

    public Integer getIndex() {
      return index;
    }

    public Integer getPlay() {
      return play;
    }

    @Override
    public int compareTo(Music o) {
      if (play > o.play) {
        return -1;
      } else if (play == o.play) {
        return index > o.index ? -1 : 1;
      }
      return 1;
    }
  }

  public static class Musics {
    private List<Music> musics;

    public Musics(List<Music> musics) {
      this.musics = musics;
    }

    public void add(Music music) {
      musics.add(music);
    }

    public int sum() {
      return musics.stream().mapToInt(music -> music.getPlay()).sum();
    }

    public List<Integer> getAnswerMusics() {
      if (musics.size() == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(musics.get(0).index);
        return list;
      }
      Collections.sort(musics);
      List<Integer> list = new ArrayList<>();
      list.add(musics.get(0).index);
      list.add(musics.get(1).index);
      return list;
    }

    public void sort() {
      Collections.sort(musics);
    }
  }

}
