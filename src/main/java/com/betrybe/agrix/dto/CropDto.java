package com.betrybe.agrix.dto;

import com.betrybe.agrix.models.entities.Crop;

/**
 * comment.
 */

public record CropDto(Long id, Long farmId, String name, Double plantedArea) {

  public static CropDto fromEntity(Crop crop) {
    return new CropDto(crop.getId(), crop.getFarmId(), crop.getName(), crop.getPlantedArea());
  }

  /**
   * comment.
   */

  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setFarmId(this.farmId);
    crop.setId(this.id);
    crop.setName(this.name);
    crop.setPlantedArea(this.plantedArea);
    return crop;
  }
}