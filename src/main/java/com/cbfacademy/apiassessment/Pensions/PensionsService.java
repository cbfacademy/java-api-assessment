package com.cbfacademy.apiassessment.Pensions;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;



@Service
public class PensionsService {
public PensionsRepository pensionsRepository;

public PensionsService(PensionsRepository pensionsRepository){
        this.pensionsRepository = pensionsRepository;
}

public List<Pensions> getAllPensionsById(UUID id) {
    return pensionsRepository.getAllPensionsById(id);
}

public List<Pensions> getPensionsById(UUID id) {
    return pensionsRepository.getPensionsById(id);
}


public List<Pensions> getStatePensionById(UUID id) {
    return pensionsRepository.getStatePensionById(id);
}


public List<Pensions> getPrivatePensionById(UUID id) {
    return pensionsRepository.getPensionsById(id);
}

public List<Pensions> getFrequency() {
    return pensionsRepository.getFrequency();
}

public Pensions createPensions(Pensions pensions)
throws IllegalArgumentException, OptimisticLockingFailureException{
    return pensionsRepository.save(pensions);
}

Pensions updatePensions(UUID id, Pensions updatedPensions)
    throws IllegalArgumentException, OptimisticLockingFailureException{
    Pensions pensions = pensionsRepository.findById(id).orElseThrow();
        pensions.setuser(updatedPensions.getUser());
        pensions.setStatePensionById(updatedPensions.getStatePensionById()!= null ? updatedPensions.getStatePensionById() : BigDecimal.ZERO);
        pensions.setPrivatePensionById(updatedPensions.getPrivatePensionById()!= null ? updatedPensions.getStatePensionById() : BigDecimal.ZERO);
        pensions.setFrequency(updatedPensions.getFrequency());



    return pensionsRepository.save(updatedPensions);

    }

public void deletePensionsById(UUID id){
    if(!pensionsRepository.existsById(id)){
        throw new NoSuchElementException("Leisure Not Found");
    }
        pensionsRepository.deleteById(id);
}

}
