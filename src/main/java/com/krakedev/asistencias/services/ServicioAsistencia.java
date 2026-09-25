package com.krakedev.asistencias.services;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class ServicioAsistencia {

    private ArrayList<RegistroAsistencia> registros = new ArrayList<>();

    private final ServicioEstudiantes servicioEstudiantes;

    public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
        this.servicioEstudiantes = servicioEstudiantes;
    }

    public RegistroAsistencia registrarAsistencia(String cedula) {
        Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);
        if (estudiante == null) {
            return null;
        }

        Asistencia asistencia = new Asistencia(
                LocalDate.now(),
                LocalDateTime.now(),
                "P"
        );

        RegistroAsistencia registro = new RegistroAsistencia(estudiante, asistencia);
        registros.add(registro);
        return registro;
    }

    public ArrayList<Asistencia> consultarAsistencia(String cedula) {
        ArrayList<Asistencia> resultado = new ArrayList<>();
        for (RegistroAsistencia r : registros) {
            if (r.getEstudiante().getCedula().equals(cedula)) {
                resultado.add(r.getAsistencia());
            }
        }
        return resultado;
    }
}
