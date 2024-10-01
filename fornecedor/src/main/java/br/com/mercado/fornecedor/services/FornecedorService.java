package br.com.mercado.fornecedor.services;


import br.com.mercado.fornecedor.exceptions.FornecedorNaoEncontradoException;
import br.com.mercado.fornecedor.models.Fornecedor;
import br.com.mercado.fornecedor.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor getFornecedor(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(FornecedorNaoEncontradoException::new);
    }

    public void save(Fornecedor fornecedor){
        fornecedorRepository.save(fornecedor);
    }
}

