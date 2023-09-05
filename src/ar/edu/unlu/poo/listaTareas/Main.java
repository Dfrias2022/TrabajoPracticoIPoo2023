package ar.edu.unlu.poo.listaTareas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        List<Colaborador> listaColaboradores = new ArrayList<>();
        List<Tarea> listaTareas = new ArrayList<>();
        int opcion = -1;
        do {
            System.out.println("Menu");
            System.out.println("0- Agregar colaboradores");
            System.out.println("1- Crear tarea");
            System.out.println("2- Listar tareas no vencidas ordenadas por prioridad");
            System.out.println("3- Listar tareas no vencidas ordenadas por fecha");
            System.out.println("4- Completar tarea");
            System.out.println("5- Buscar por nombre de tarea");
            System.out.println("6- Listado completo de tareas");
            System.out.println("7- Listado por colaborador");
            System.out.println("8- Salir");
            System.out.println("Seleccione una opcion: ");
            if (ingreso.hasNextInt()) {
                opcion = ingreso.nextInt();
            } else {
                System.out.println("Valores numericos entre 0 y 8");
                ingreso.nextLine();
            }
            String ingresoUsuario;
            switch (opcion) {
                case 0:
                    ingreso.nextLine();
                    System.out.println("Menu --> Creando Colaboradores(usuarios).");
                    System.out.println("Ingrese el nombre del colaborador: ");
                    ingresoUsuario = ingreso.nextLine();
                    Colaborador colaborador = new Colaborador(ingresoUsuario);
                    listaColaboradores.add(colaborador);
                    System.out.println("Añadido.!");
                    break;
                case 1:
                    ingreso.nextLine();
                    boolean estado = false;
                    LocalDate fechaVenc = null;
                    LocalDate fechaRec = null;
                    System.out.println("Menu --> crear tarea.");
                    System.out.print("Ingrese la tarea: ");
                    System.out.println();
                    String sTarea = ingreso.nextLine();
                    do {
                        System.out.println("Ingrese la fecha de vencimiento: (formato: dd-MM-yyyy)");
                        ingresoUsuario = ingreso.nextLine();
                        try {
                            fechaVenc = LocalDate.parse(ingresoUsuario, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                            estado = true;
                        } catch (Exception var20) {
                            System.out.println("Error de formato ingresando fecha.");
                        }
                    } while(!estado);
                    do {
                        System.out.println("Ingrese la fecha de recordatorio: (formato: dd-MM-yyyy)");
                        ingresoUsuario = ingreso.nextLine();
                        try {
                            fechaRec = LocalDate.parse(ingresoUsuario, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                            if (fechaRec.isBefore(fechaVenc)) {
                                estado = false;
                            } else {
                                System.out.println("La fecha recordatorio no puede ser posterior a la fecha de vencimiento.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error de formato ingresando fecha.");
                        }
                    } while(estado);
                    Tarea tarea = new Tarea(sTarea, Prioridad.NORMAL, Estado.INCOMPLETA, fechaVenc, fechaRec);
                    if (tarea.aumentarPrioridad()) {
                        tarea.setPrioridad(Prioridad.ALTA);
                    }
                    listaTareas.add(tarea);
                    break;
                case 2:
                    ingreso.nextLine();
                    System.out.println("Menu --> Listar tareas no vencidas ordenadas por prioridad.");
                    if(!listaTareas.isEmpty()){
                        List <Tarea> listaPrioridad = new ArrayList<>();
                        for(Tarea t:listaTareas){
                            if(!t.estaVencida()){
                                listaPrioridad.add(t);
                            }
                        }
                        Comparator<Tarea> compararPorPrioridad = Comparator.comparing(Tarea::getPrioridad);
                        listaPrioridad.sort(compararPorPrioridad);
                        for(Tarea t:listaPrioridad){
                            System.out.printf("%s %s %s %s.\n",t.getPrioridad(),t.getDescripcion(),t.getEstado(),t.getFechaLimite());
                        }
                    }else{
                        System.out.println("Lista de tareas vacia.");
                    }
                    break;
                case 3:
                    ingreso.nextLine();
                    System.out.println("Menu --> Listar tareas no vencidas ordenadas por fecha.");
                    if(!listaTareas.isEmpty()){
                        List <Tarea> listaFecha = new ArrayList<>();
                        for(Tarea t:listaTareas){
                            if(!t.estaVencida()){
                                listaFecha.add(t);
                            }
                        }
                        Comparator<Tarea> compararPorFecha = Comparator.comparing(Tarea::getFechaLimite);
                        listaFecha.sort(compararPorFecha);
                        for(Tarea t:listaFecha){
                            System.out.printf("%s %s %s %s.\n",t.getFechaLimite(),t.getDescripcion(),t.getEstado(),t.getPrioridad());
                        }
                    }else{
                        System.out.println("Lista de tareas vacia.");
                    }
                    break;
                case 4:
                    ingreso.nextLine();
                    System.out.println("Menu --> Completar tarea.");
                    if (listaColaboradores.isEmpty()) {
                        System.out.println("No hay colaboradores definidos para realizar las tareas, primero defina al menos uno");
                    } else if (listaTareas.isEmpty()) {
                        System.out.println("No existen tareas en la lista");
                    } else {
                        List<Integer> posiciones = new ArrayList<>();
                        int pos = 0;
                        int ntarea = 0;
                        for(Tarea t:listaTareas) {
                            if (!t.estaCompleta() && !t.estaVencida()) {
                                posiciones.add(pos);
                                pos++;
                                ntarea++;
                                System.out.printf("(%d) %s\n", ntarea, t.devolverDescripcio());
                            }
                        }
                        if (posiciones.isEmpty()) {
                            System.out.println("No hay tareas pendiente por completar.");
                            continue;
                        }
                        do {
                            System.out.println("Ingrese el numero de tarea a completar");
                            if (ingreso.hasNextInt()) {
                                opcion = ingreso.nextInt();
                            } else {
                                System.out.println("Opcion no valida.");
                                ingreso.nextLine();
                            }
                        } while(opcion < 1 || opcion > posiciones.size());
                        ingreso.nextLine();
                        int opcion2 = -1;
                        do {
                            int indiceColaborador = 1;
                            System.out.println("-Colaboradores-");
                            for(Colaborador c:listaColaboradores) {
                                System.out.printf("(%d) %s.\n", indiceColaborador, c.getAlias());
                                indiceColaborador++;
                            }
                            System.out.println("Ingrese el numero del colaborador que completara la tarea");
                            if (ingreso.hasNextInt()) {
                                opcion2 = ingreso.nextInt();
                            } else {
                                System.out.println("Opcion no valida.");
                                ingreso.nextLine();
                            }
                        } while(opcion2 < 1 || (opcion2 - 1) > listaColaboradores.size());
                        (listaTareas.get((Integer)posiciones.get(opcion - 1))).completarTarea((Colaborador)listaColaboradores.get(opcion2 - 1));
                        System.out.println("Realizado.");
                    }
                    break;
                case 5:
                    ingreso.nextLine();
                    System.out.println("Menu --> Buscar por nombre de tarea.");
                    if (listaTareas.isEmpty()) {
                        System.out.println("Lista de tareas vacia.");
                    } else {
                        Tarea tareaEncontrada = null;
                        System.out.println("ingrese la tarea a buscar");
                        ingresoUsuario = ingreso.nextLine();
                        for(Tarea t:listaTareas) {
                            if (t.getDescripcion().equals(ingresoUsuario)) {
                                tareaEncontrada = t;
                                break;
                            }
                        }
                        if (tareaEncontrada != null) {
                            System.out.printf("%s %s %s.\n", tareaEncontrada.getDescripcion(), tareaEncontrada.getEstado(), tareaEncontrada.getPrioridad());
                        }
                    }
                    break;
                case 6:
                    ingreso.nextLine();
                    System.out.println("Menu --> Listar todas las tareas en la lista.");
                    if(!listaTareas.isEmpty()) {
                        for (Tarea t : listaTareas) {
                            if (t.getColaborador() != null) {
                                System.out.printf("TAREA: %s Fecha limite: %s Estado: %s Prioridad: %s Fecha recordatorio: %s Colaborador: %s Finalizacion: %s.\n", t.devolverDescripcio(), t.getFechaLimite(), t.getEstado(), t.getPrioridad(), t.getFechaRecordatorio(), t.getColaborador(), t.getFechaRealizacion());
                            } else {
                                System.out.printf("TAREA: %s Fecha limite: %s Estado: %s Prioridad: %s Fecha recordatorio: %s.\n", t.devolverDescripcio(), t.getFechaLimite(), t.getEstado(), t.getPrioridad(), t.getFechaRecordatorio());
                            }
                        }
                    }else{
                        System.out.println("Lista de tareas vacia.");
                    }
                    break;
                case 7:
                    ingreso.nextLine();
                    int opcion2 = -1;
                    System.out.println("Menu --> Listado por colaborador.");
                    if(!listaTareas.isEmpty()){
                        do {
                            int indiceColaborador = 1;
                            System.out.println("-Colaboradores-");
                            for(Colaborador c:listaColaboradores) {
                                System.out.printf("(%d) %s.\n", indiceColaborador, c.getAlias());
                                indiceColaborador++;
                            }
                            System.out.println("Ingrese el numero del colaborador que desea consultar las tareas que completo:");
                            if (ingreso.hasNextInt()) {
                                opcion2 = ingreso.nextInt();
                            } else {
                                System.out.println("Opcion no valida.");
                                ingreso.nextLine();
                            }
                        } while(opcion2 < 1 || (opcion2 - 1)> listaColaboradores.size());
                        List <Tarea> listaAux = new ArrayList<>();
                        for(Tarea t:listaTareas){
                            if(t.getColaborador().equals(listaColaboradores.get(opcion2 - 1).getAlias())){
                                listaAux.add(t);
                            }
                        }
                        Comparator <Tarea> compararPorFinalizacion = Comparator.comparing(Tarea::getFechaRealizacion);
                        listaAux.sort(compararPorFinalizacion);
                        for(Tarea t:listaAux){
                            System.out.printf("%s %s %s.\n",t.getFechaRealizacion(),t.getDescripcion(),t.getColaborador());
                        }
                    }else{
                        System.out.println("Lista de tareas vacia.");
                    }
                    break;
                case 8:
                    ingreso.nextLine();
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.\n");
            }
        } while(opcion != 8);

    }
}
