package estudo;

import lombok.Data;

@Data
public class ToDo {
  private int userId;
  private int id;
  private String title;
  private boolean completed;
}
