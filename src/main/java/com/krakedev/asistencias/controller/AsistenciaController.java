package com.krakedev.asistencias.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.RegistroAsistencia;
import com.krakedev.asistencias.services.ServicioAsistencia;
import com.krakedev.asistencias.services.ServicioEstudiantes;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaController {

	private final ServicioAsistencia servicioAsistencia;

	// Inyección de dependencias por constructor
	public AsistenciaController(ServicioEstudiantes servicioEstudiantes) {
		this.servicioAsistencia = new ServicioAsistencia(servicioEstudiantes);
	}

	@PostMapping("/{cedula}")
	public RegistroAsistencia registrarAsistencia(@PathVariable String cedula) {
		return servicioAsistencia.registrarAsistencia(cedula);
	}

	@GetMapping("/{cedula}")
	public List<Asistencia> consultarAsistencia(@PathVariable String cedula) {
		return servicioAsistencia.consultarAsistencia(cedula);
	}
}