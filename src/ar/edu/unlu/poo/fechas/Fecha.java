package ar.edu.unlu.poo.fechas;

import java.time.LocalDate;

public class Fecha {
    private final LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public Boolean entreFechas(LocalDate fecha1, LocalDate fecha2) {
        return this.fecha.isAfter(fecha1) && this.fecha.isBefore(fecha2) || this.fecha.isAfter(fecha2) && this.fecha.isBefore(fecha1);
    }

    public Boolean esMenor(LocalDate fecha2) {
        return this.fecha.isBefore(fecha2);
    }

    public Boolean esMayor(LocalDate fecha2) {
        return this.fecha.isAfter(fecha2);
    }
}
