package pl.sapiens.javarestsoap.mapper;

public interface Mapper<E, Dto> {
    Dto fromEntityToDto(E entity);
    E fromDtoToEntity(Dto dto);
}
