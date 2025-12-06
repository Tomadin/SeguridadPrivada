package com.tomadin.dev.seguridadPrivada.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "fotos_tarea")
@Data
public class FotoTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarea", nullable = false)
    private Tarea tarea;

    @Column(nullable = false, length = 500)
    private String url;

    @Column(columnDefinition = "TEXT")
    private String metadata;

    @Column(name = "fecha_captura", nullable = false)
    private LocalDateTime fechaCaptura;

    @PrePersist
    protected void onCreate() {
        fechaCaptura = LocalDateTime.now();
    }

    public FotoTarea() {
    }

    public FotoTarea(Tarea tarea, String url, String metadata, LocalDateTime fechaCaptura) {
        this.tarea = tarea;
        this.url = url;
        this.metadata = metadata;
        this.fechaCaptura = fechaCaptura;
    }
}
