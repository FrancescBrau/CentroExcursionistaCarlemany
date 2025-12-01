package com.grupo4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class catalogo {
    private final List<Montana> montanas;
    private final List<Excursion> excursiones;

    public catalogo() {
        this.montanas = new ArrayList<>();
        this.excursiones = new ArrayList<>();
    }

    public List<Montana> getMontanas() {
        return new ArrayList<>(montanas);
    }

    public List<Excursion> getExcursiones() {
        return new ArrayList<>(excursiones);
    }

    /** Crea montaña y su excursión asociada (mismo nombre) pidiendo datos por consola. */
    public void crearMontanaYExcursion(Scanner sc) {
        System.out.println("\n--- Alta de Montaña (crea excursión automática) ---");
        System.out.print("Nombre de la montaña: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Altitud (m): ");
        int altitud = leerEntero(sc);

        System.out.print("Ubicación: ");
        String ubicacion = sc.nextLine().trim();

        System.out.print("Dificultad (F/PD/AD/D/ED…): ");
        String dificultad = sc.nextLine().trim();

        Montana m = new Montana(nombre, altitud, ubicacion, dificultad);
        montanas.add(m);

        System.out.println("Ahora define los datos de la excursión asociada a '" + nombre + "':");
        System.out.print("Fecha de inicio (YYYY-MM-DD): ");
        LocalDate fi = leerFecha(sc);

        System.out.print("Fecha de fin (YYYY-MM-DD): ");
        LocalDate ff = leerFecha(sc);

        System.out.print("Plazas: ");
        int plazas = leerEntero(sc);

        Excursion ex = new Excursion(m, fi, ff, plazas);
        excursiones.add(ex);

        System.out.println("✅ Montaña y excursión creadas correctamente.");
    }

    public void listarMontanas() {
        if (montanas.isEmpty()) {
            System.out.println("No hay montañas registradas.");
            return;
        }
        System.out.println("\n--- Montañas ---");
        montanas.forEach(System.out::println);
    }

    public void listarExcursiones() {
        if (excursiones.isEmpty()) {
            System.out.println("No hay excursiones registradas.");
            return;
        }
        System.out.println("\n--- Excursiones ---");
        excursiones.forEach(System.out::println);
    }

    public Excursion buscarExcursionPorNombre(String nombreMontana) {
        return excursiones.stream()
                .filter(e -> e.getMontana().getNombre().equalsIgnoreCase(nombreMontana))
                .findFirst()
                .orElse(null);
    }

    // ---- Helpers de lectura segura ----
    private int leerEntero(Scanner sc) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                return n;
            } catch (NumberFormatException ex) {
                System.out.print("Valor inválido. Introduce un número entero: ");
            }
        }
    }

    private LocalDate leerFecha(Scanner sc) {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return LocalDate.parse(s);
            } catch (Exception e) {
                System.out.print("Fecha inválida. Usa formato YYYY-MM-DD: ");
                       }
        }
    }}
