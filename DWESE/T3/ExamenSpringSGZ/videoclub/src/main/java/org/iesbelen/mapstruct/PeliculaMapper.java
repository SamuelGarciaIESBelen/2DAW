package org.iesbelen.mapstruct;

import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.model.Pelicula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {

    @Mapping(target = "nombreIdioma", source = "nombreIdioma")
    public PeliculaDTO peliculaAPeliculaDTO(Pelicula pelicula, String nombreIdioma);
}
