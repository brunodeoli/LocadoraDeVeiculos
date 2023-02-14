package model.tipos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private LocalDateTime data;
    private String local;

    public Agendamento(LocalDateTime data, String local) {
        this.data = data;
        this.local = local;
    }

    public static DateTimeFormatter getFmt() {
        return fmt;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return data.format(fmt) + " - " + local;
    }
}
