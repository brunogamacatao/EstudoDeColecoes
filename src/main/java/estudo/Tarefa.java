package estudo;

import lombok.Data;
import lombok.NonNull;

@Data
public class Tarefa {
  @NonNull
  private int usuarioId;
  @NonNull
  private int id;
  @NonNull
  private String titulo;
  @NonNull
  private boolean completada;
}
