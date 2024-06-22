package com.cbfacademy.apiassessment.Leisure;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;




@Service
public class LeisureService {
public LeisureRepository leisureRepository;

public LeisureService(LeisureRepository leisureRepository){
        this.leisureRepository = leisureRepository;
}

public List<Leisure> getAllLeisureById(UUID id) {
    return leisureRepository.getAllLeisureById(id);
}

public List<Leisure> getLeisureById(UUID id) {
    return leisureRepository.getLeisureById(id);
}

public List<Leisure> getEntertainmentById(UUID id) {
    return leisureRepository.getEntertainmentById(id);
}

public List<Leisure> getDiningOutById(UUID id) {
    return leisureRepository.getDiningOutById(id);
}

public List<Leisure> getTravelById(UUID id) {
    return leisureRepository.getTravelById(id);
}

public List<Leisure> getSportsMembershipById(UUID id) {
    return leisureRepository.getSportsMembershipById(id);
}

public List<Leisure> getFrequency() {
    return leisureRepository.getFrequency();
}

public Leisure createLeisure(Leisure leisure)
    throws IllegalArgumentException, OptimisticLockingFailureException{
    return leisureRepository.save(leisure);
}

Leisure updateLeisure(UUID id, Leisure updatedLeisure)
    throws IllegalArgumentException, OptimisticLockingFailureException{
    Leisure leisure = leisureRepository.findById(id).orElseThrow();

    leisure.setuser(updatedLeisure.getUser());  
    leisure.setDiningOutById(updatedLeisure.getDiningOutById()!= null ? updatedLeisure.getDiningOutById() : BigDecimal.ZERO);
    leisure.setTravelById(updatedLeisure.getTravelById()!= null ? updatedLeisure.getTravelById() : BigDecimal.ZERO);
    leisure.setSportsMembershipById(updatedLeisure.getSportsMembershipById()!= null ? updatedLeisure.getSportsMembershipById() : BigDecimal.ZERO);
    leisure.setFrequency(updatedLeisure.getFrequency());

return leisureRepository.save(updatedLeisure);

// }).orElseThrow(() -> new NoSuchElementException("Leisure Not Found"));
}

public void deleteLeisureById(UUID id){
    if(!leisureRepository.existsById(id)){
        throw new NoSuchElementException("Leisure Not Found");
    }
        leisureRepository.deleteById(id);
}
}
