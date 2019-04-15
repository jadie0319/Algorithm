package etc.test2;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 15/04/2019.
 * @project Algorithm
 * @description
 */
public class Solution4 {

  public static void main(String[] args) throws IOException {
    String substr="spiderman";
    String json = readJsonFromUrl("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr);
    System.out.println(json);
    Gson gson = new Gson();
    Movies movies = gson.fromJson(json,Movies.class);

    System.out.println(movies.total);
    //String[] answer = new String[movies.total];
    List<String> answer = new ArrayList<>(movies.total);
    List<Movie> movieList = movies.data;
    addAnswer(answer,movieList);


    if(movies.total_pages > 1) {
      for(int i=2 ; i <= movies.total_pages ; i++) {
        json = readJsonFromUrl("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page=" + i);
        gson = new Gson();
        movies = gson.fromJson(json,Movies.class);
        movieList = movies.data;
        addAnswer(answer,movieList);
      }
    }

    for(String title : answer) {
      System.out.println(title);
    }

    String[] strs = answer.toArray(new String[answer.size()]);
    Arrays.sort(strs);
    System.out.println("=====================================");
    for(String title : strs) {
      System.out.println(title);
    }


  }

  public static String[] getMovieTitles(String subset) {

    return null;
  }



  public static void addAnswer(List<String> answer , List<Movie> movieList) {
    for(int i=0; i < movieList.size() ; i++) {
      answer.add(movieList.get(i).Title);
    }
  }



  public static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static String readJsonFromUrl(String url) throws IOException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
//      Gson gson = new Gson();
//      String json = gson.toJson(jsonText);
      return jsonText;
    } finally {
      is.close();
    }

  }


}


class Movies {
  String page;
  Integer per_page;
  Integer total;
  Integer total_pages;
  List<Movie> data;
}


class Movie {
  String Poster;
  String Title;
  String Type;
  String Year;
  String imdbID;
}
