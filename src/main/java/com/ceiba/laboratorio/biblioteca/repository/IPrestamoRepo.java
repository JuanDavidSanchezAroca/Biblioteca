package com.ceiba.laboratorio.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.laboratorio.biblioteca.entity.Usuario_x_Libro;

public interface IPrestamoRepo extends JpaRepository<Usuario_x_Libro, Integer> {

}
