
package com.grupo4.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CEC {
    private final catalogo catalogo;
    private final List<Expedicionario> listaExpedicionarios;
    private final Scanner sc;

    public CEC() {
        this.catalogo = new catalogo();
        this.listaExpedicionarios = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== Centro de Excursiones de Cordillera (CEC) ===");
            System.out.println("1. Gestionar expedicionarios");
            System.out.println("2. Añadir montaña (crea excursión)");
            System.out.println("3. Listar montañas");
            System.out.println("4. Listar excursiones");
            System.out.println("5. Asignar expedicionario a excursión");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> gestionarExpedicionario();      // ya lo tenías
                case 2 -> catalogo.crearMontanaYExcursion(sc);
                case 3 -> catalogo.listarMontanas();
                case 4 -> catalogo.listarExcursiones();
                case 5 -> asignarExpedicionarioAExcursion();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ---------- GESTIÓN EXPEDICIONARIOS (igual que antes, añado búsqueda por ID) ----------
    public void gestionarExpedicionario() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Expedicionarios ---");
            System.out.println("1. Añadir Alpinista");
            System.out.println("2. Añadir Médico");
            System.out.println("3. Listar Expedicionarios");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> crearAlpinista();
                case 2 -> crearMedico();
                case 3 -> listarExpedicionarios();
                case 0 -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void crearAlpinista() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Experiencia: ");
        String experiencia = sc.nextLine();
        System.out.print("Alergias: ");
        String alergias = sc.nextLine();
        System.out.print("¿Disponible? (true/false): ");
        boolean disponible = leerBooleano();
        System.out.print("Rango: ");
        String rango = sc.nextLine();
        System.out.print("¿Ha hecho cima? (true/false): ");
        boolean cima = leerBooleano();

        Alpinista alpinista = new Alpinista(nombre, id, experiencia, alergias, disponible, rango, cima);
        listaExpedicionarios.add(alpinista);
        System.out.println("✅ Alpinista añadido.");
    }

    private void crearMedico() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Experiencia: ");
        String experiencia = sc.nextLine();
        System.out.print("Alergias: ");
        String alergias = sc.nextLine();
        System.out.print("¿Disponible? (true/false): ");
        boolean disponible = leerBooleano();
        System.out.print("ID Colegiado: ");
        String idColegiado = sc.nextLine();
        System.out.print("Especialista: ");
        String especialista = sc.nextLine();

        Medico medico = new Medico(nombre, id, experiencia, alergias, disponible, idColegiado, especialista);
        listaExpedicionarios.add(medico);
        System.out.println("✅ Médico añadido.");
    }

    private void listarExpedicionarios() {
        if (listaExpedicionarios.isEmpty()) {
            System.out.println("No hay expedicionarios registrados.");
        } else {
            System.out.println("\n--- Lista de Expedicionarios ---");
            for (Expedicionario e : listaExpedicionarios) {
                System.out.println(e);
            }
        }
    }

    // ---------- ASIGNACIÓN ----------
    public void asignarExpedicionarioAExcursion() {
        if (listaExpedicionarios.isEmpty()) {
            System.out.println("⚠ No hay expedicionarios. Añade alguno primero.");
            return;
        }
        if (catalogo.getExcursiones().isEmpty()) {
            System.out.println("⚠ No hay excursiones. Crea una montaña (que genera excursión) primero.");
            return;
        }

        System.out.print("ID del expedicionario: ");
        int idExp = leerEntero();
        Expedicionario exp = buscarExpedicionarioPorId(idExp);
        if (exp == null) {
            System.out.println("No existe un expedicionario con ese ID.");
            return;
        }

        System.out.print("Nombre de la montaña (excursión asociada): ");
        String nombreMontana = sc.nextLine().trim();
        Excursion ex = catalogo.buscarExcursionPorNombre(nombreMontana);
        if (ex == null) {
            System.out.println("No existe excursión asociada a la montaña '" + nombreMontana + "'.");
            return;
        }

        boolean ok = ex.addExpedicionario(exp);
        if (ok) {
            System.out.println("✅ Expedicionario asignado a la excursión de " + nombreMontana + ".");
        } else {
            System.out.println("❌ No se pudo asignar (sin plazas, no disponible o ya está inscrito).");
        }
    }

    private Expedicionario buscarExpedicionarioPorId(int id) {
        return listaExpedicionarios.stream()
                .filter(e -> e.getIdExp() == id)
                .findFirst()
                .orElse(null);
    }

    // ---- Lecturas seguras ----
    private int leerEntero() {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                System.out.print("Número inválido. Intenta de nuevo: ");
            }
        }
    }

    private boolean leerBooleano() {
        while (true) {
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("true") || s.equals("t") || s.equals("si") || s.equals("sí")) return true;
            if (s.equals("false") || s.equals("f") || s.equals("no")) return false;
            System.out.print("Valor inválido (true/false). Intenta de nuevo: ");
        }
    }
}

