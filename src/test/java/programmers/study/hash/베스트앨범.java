package programmers.study.hash;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class 베스트앨범 {
    //속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    //장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

    @Test
    void case1() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);
        assertThat(result).containsExactly(4,1,3,0);
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Musics> musicsByGenre = new HashMap<>();
        for (int i=0; i < genres.length ; i++) {
            createMusics(genres[i], plays[i], musicsByGenre, i);
        }

        List<Musics> orderedMusics = musicsByGenre.values()
                .stream()
                .sorted(new Comparator<Musics>() {
                    @Override
                    public int compare(Musics o1, Musics o2) {
                        return o1.sum() > o2.sum() ? -1 : 1;
                    }
                })
                .collect(Collectors.toList());

        List<Integer> answerList = new ArrayList<>();
        for(Musics musics : orderedMusics) {
            List<Integer> answerIndex = musics.getAnswerMusics();
            answerList.addAll(answerIndex);
        }
        return answerList.stream().mapToInt(a -> a).toArray();
    }

    private void createMusics(String genre, int play, Map<String, Musics> musicsByGenre, int i) {
        Music music = new Music(i, play);
        if (musicsByGenre.containsKey(genre)) {
            Musics musics= musicsByGenre.get(genre);
            musics.add(music);
        } else {
            ArrayList<Music> musics = new ArrayList<>();
            musics.add(music);
            musicsByGenre.put(genre, new Musics(musics));
        }
    }

    public static class Music implements Comparable<Music> {
        private Integer index;
        private Integer playCount;

        public Music(Integer index, Integer play) {
            this.index = index;
            this.playCount = play;
        }

        public Integer getIndex() {
            return index;
        }

        public Integer getPlayCount() {
            return playCount;
        }

        @Override
        public int compareTo(Music o) {
            if (playCount > o.playCount) {
                return -1;
            } else if (playCount == o.playCount) {
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
            return musics.stream().mapToInt(music -> music.getPlayCount()).sum();
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

    @Test
    void stst() {
        Music m1 = new Music(1, 100);
        Music m2 = new Music(2, 200);
        Music m3 = new Music(3, 300);

        List<Music> music = Arrays.asList(m1, m2, m3);
        List<Integer> musics = music.stream()
                .sorted(new Comparator<Music>() {
                    @Override
                    public int compare(Music o1, Music o2) {
                        return o1.playCount > o2.playCount ? -1 : 1;
                    }
                })
                .map(m -> m.getIndex())
                .collect(Collectors.toList());
        assertThat(musics).containsExactly(3,2,1);
    }

}
