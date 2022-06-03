package usecases;

import collections.Dato;
import dto.DatoDTO;
import mapper.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;
import repositorie.Repositorio;
import usecases.inter.GuardarDato;
@Service
@Validated
public class UseCaseCrear implements GuardarDato {
    private final Repositorio repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public UseCaseCrear(MapperUtils mapperUtils, Repositorio repositorio){
        this.repositorio=repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(DatoDTO datoDTO){
        return repositorio.save(mapperUtils.mapperToDato(null).apply(datoDTO)).map(Dato::getId);
    }
}
