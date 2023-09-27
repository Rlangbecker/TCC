package com.api.carlosautopecas.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageOutput<T> {

    private Long totalElementos;
    private Integer quantidadePaginas;
    private Integer pagina;
    private Integer tamanho;
    private List<T> elementos;

    public int getTotalElements() {
        return elementos.size();
    }

    public int getTotalPages() {
        return quantidadePaginas;
    }

    public Integer getPage() {
        return pagina;
    }

    public Integer getPageSize() {
        return tamanho;
    }
}
