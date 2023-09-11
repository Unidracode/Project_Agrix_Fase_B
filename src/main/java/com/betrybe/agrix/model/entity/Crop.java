package com.betrybe.agrix.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * comment.
 */

@Entity
@Table(name = "crop")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @Column(name = "planted_area")
  private Double plantedArea;

  @Column(name = "farm_id")
  private Long farmId;

  public Crop() {}

  /**
   * comment.
   */

  public Crop(String name, Double plantedArea, Long farmId) {
    this.name = name;
    this.plantedArea = plantedArea;
    this.farmId = farmId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public Long getFarmId() {
    return farmId;
  }

  public void setFarmId(Long farmId) {
    this.farmId = farmId;
  }
}