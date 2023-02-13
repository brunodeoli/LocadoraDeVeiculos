package model.tipos;

import java.time.LocalDateTime;

public class Agendamento {
    private LocalDateTime data;
    private String local;

    public Agendamento(LocalDateTime data, String local) {
        this.data = data;
        this.local = local;
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
}
