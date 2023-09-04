package ar.edu.unlu.poo.listaTareas;

import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private Prioridad prioridad;
    private Estado estado;
    private LocalDate fechaLimite;
    private LocalDate fechaRecordatorio;
    private String colaborador;
    private LocalDate fechaRealizacion;

    public Tarea(String descripcion, Prioridad prioridad, Estado estado) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public Tarea(String descripcion, Prioridad prioridad, Estado estado, LocalDate fechaLimite) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
    }

    public Tarea(String descripcion, Prioridad prioridad, Estado estado, LocalDate fechaLimite, LocalDate fechaRecordatorio) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
        this.fechaRecordatorio = fechaRecordatorio;
        this.colaborador = null;
        this.fechaRealizacion = null;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Boolean estaCompleta() {
        return this.estado == Estado.COMPLETA;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public boolean estaVencida() {
        LocalDate actual = LocalDate.now();
        return this.fechaLimite.isBefore(actual) && this.estado == Estado.INCOMPLETA;
    }

    public String devolverDescripcio() {
        if (this.estaVencida()) {
            return "(Vencida)... " + this.descripcion;
        } else if(this.porVencer() && !this.estaCompleta()) {
            return "(por vencer)..." + this.descripcion;
        }else{
            return "COMPLETA..." + this.descripcion;
        }
    }

    public void completarTarea(Colaborador colaborador) {
        this.estado = Estado.COMPLETA;
        this.colaborador = colaborador.getAlias();
        this.fechaRealizacion = LocalDate.now();
    }

    public Prioridad getPrioridad() {
        return this.prioridad;
    }

    public LocalDate getFechaLimite() {
        return this.fechaLimite;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Boolean porVencer() {
        return this.fechaRecordatorio.isAfter(LocalDate.now()) || this.fechaRecordatorio.equals(LocalDate.now());
    }

    public Boolean aumentarPrioridad() {
        return this.fechaRecordatorio.isBefore(LocalDate.now()) || this.fechaRecordatorio.equals(LocalDate.now());
    }

    public LocalDate getFechaRecordatorio() {
        return this.fechaRecordatorio;
    }

    public String getColaborador() {
        return this.colaborador;
    }

    public LocalDate getFechaRealizacion() {
        return this.fechaRealizacion;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
}
