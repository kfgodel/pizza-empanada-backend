package com.tenpines.encolapp.modelo;


/**
 * Date: 27/01/18 - 11:22
 */
public class Speaker {

  private String nombre;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public static Speaker create(String nombre) {
    Speaker speaker = new Speaker();
    speaker.setNombre(nombre);
    return speaker;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Speaker)) return false;

    Speaker speaker = (Speaker) o;

    return nombre.equals(speaker.nombre);
  }

  @Override
  public int hashCode() {
    return nombre.hashCode();
  }
}
