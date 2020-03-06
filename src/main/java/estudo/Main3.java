package estudo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {
  public static void main(String[] args) throws Exception{
    String json = httpGet("https://jsonplaceholder.typicode.com/todos/");

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    Type listaDeToDosType = new TypeToken<ArrayList<ToDo>>() {}.getType();

    List<ToDo> todos = gson.fromJson(json, listaDeToDosType);

    // Convertendo os ToDos, do usuário 7, para Tarefas
    List<Tarefa> tarefas = todos.stream()
        .filter(t -> t.getUserId() == 7)
        .map(t -> new Tarefa(t.getUserId(), t.getId(), t.getTitle(), t.isCompleted()))
        .collect(Collectors.toList());

    tarefas.forEach(t -> System.out.println(t));
  }

  private static String httpGet(String urlAddress) throws Exception {
    URL url = new URL(urlAddress);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    conn.setRequestMethod("GET");
    conn.setRequestProperty("Accept", "application/json");

    if (conn.getResponseCode() != 200) {
      throw new RuntimeException("Erro ao acessar o serviço: " + conn.getResponseCode());
    }

    InputStreamReader in = new InputStreamReader(conn.getInputStream());
    BufferedReader reader = new BufferedReader(in);
    String linha = null;
    StringBuilder strBuilder = new StringBuilder();

    while ((linha = reader.readLine()) != null) strBuilder.append(linha);

    conn.disconnect();

    return strBuilder.toString();
  }
}
