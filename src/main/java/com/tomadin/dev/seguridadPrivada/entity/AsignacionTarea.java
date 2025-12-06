package com.tomadin.dev.seguridadPrivada.entity;

import com.tomadin.dev.seguridadPrivada.enums.EstadoAsignacion;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones_tarea")
public class AsignacionTarea extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarea", nullable = false)
    private Tarea tarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_operario", nullable = false)
    private Operario operario;

    @Column(name = "hora_inicio_real")
    private LocalDateTime horaInicioReal;

    @Column(name = "hora_fin_real")
    private LocalDateTime horaFinReal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAsignacion estado = EstadoAsignacion.ASIGNADA;

    @Column(columnDefinition = "TEXT")
    private String novedades;

    @Column(columnDefinition = "TEXT")
    private String resultado;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    public AsignacionTarea(Tarea tarea, Operario operario, LocalDateTime horaInicioReal, LocalDateTime horaFinReal) {
        this.tarea = tarea;
        this.operario = operario;
        this.horaInicioReal = horaInicioReal;
        this.horaFinReal = horaFinReal;
        this.estado = EstadoAsignacion.ASIGNADA;
    }
}

