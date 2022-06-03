package mapper;

import collections.Dato;
import dto.DatoDTO;

import java.util.function.Function;

public class MapperUtils {
    public Function<DatoDTO, Dato> mapperToDato(String id){
        return updateDato->{
            var dato = new Dato();
            dato.setId(id);
            dato.setInformacion(updateDato.getInformacion()); //updateDato.getInformation viene del DTO
            return dato;
        };
    }

    public Function<Dato,DatoDTO> mapDatoToDTO(){
        return entity->new DatoDTO(entity.getId(), entity.getInformacion());
    }
}
