package usecases;

import dto.DatoDTO;
import mapper.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import repositorie.Repositorio;

import java.util.function.Supplier;

@Service
@Validated
public class UseCaseListar implements Supplier {
    private final Repositorio repositorio;
    private final MapperUtils mapperUtils;

    public UseCaseListar(Repositorio repositorio, MapperUtils mapperUtils) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<DatoDTO> get(){
        return repositorio.findAll().map(mapperUtils.mapDatoToDTO());
    }
}
