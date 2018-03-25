package com.crud.library.mapper;

import com.crud.library.domain.Reader;
import com.crud.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto){
        return new Reader(
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getCreatedDate());
    }

    public ReaderDto mapToReaderDto (final Reader reader){
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getCreatedDate());
    }

    public List<ReaderDto> mapToReaderDtoList (final List<Reader> readerList){
        return readerList.stream()
                .map(t -> new ReaderDto(t.getId(), t.getFirstName(), t.getLastName(), t.getCreatedDate()))
                .collect(Collectors.toList());
    }
}
