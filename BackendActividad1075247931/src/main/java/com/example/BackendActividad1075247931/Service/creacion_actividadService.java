package com.example.BackendActividad1075247931.Service;

import com.example.BackendActividad1075247931.Entity.Creacion_actividad;
import com.example.BackendActividad1075247931.IRepository.Icreacion_actividadRepository;
import com.example.BackendActividad1075247931.IService.Icreacion_actividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreacionActividadService implements Icreacion_actividadService {

    @Autowired
    private Icreacion_actividadRepository creacionActividadRepository;

    @Override
    public List<Creacion_actividad> All() {
        return creacionActividadRepository.findAll();
    }

    @Override
    public Optional<Creacion_actividad> FindById(Long id) {
        return creacionActividadRepository.findById(id);
    }

    @Override
    public void Update(Creacion_actividad creacionActividad, Long id) {
        Optional<Creacion_actividad> actividadExistente = FindById(id);

        if (actividadExistente.isEmpty()) {
            throw new RuntimeException("Actividad no encontrada con el ID: " + id);
        } else {
            Creacion_actividad actividadActual = actividadExistente.get();
            actividadActual.setNombre(creacionActividad.getNombre());
            actividadActual.setDescripcion(creacionActividad.getDescripcion());
            actividadActual.setFecha(creacionActividad.getFecha());
            // Actualiza otros campos según sea necesario

            creacionActividadRepository.save(actividadActual);
        }
    }

    @Override
    public Creacion_actividad Save(Creacion_actividad creacionActividad) {
        return creacionActividadRepository.save(creacionActividad);
    }

    @Override
    public void Delete(Long id) {
        creacionActividadRepository.deleteById(id);
    }
}
