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

public List<Leisure> findLeisureById(UUID id) {
    return leisureRepository.findLeisureById(id);
}

public List<Leisure> findEntertainmentById(UUID id) {
    return leisureRepository.findEntertainmentById(id);
}

public List<Leisure> findDiningOutById(UUID id) {
    return leisureRepository.findDiningOutById(id);
}

public List<Leisure> findTravelById(UUID id) {
    return leisureRepository.findTravelById(id);
}

public List<Leisure> findSportsMembershipById(UUID id) {
    return leisureRepository.findSportsMembershipById(id);
}

public List<Leisure> findByFrequency(String frequency) {
    return leisureRepository.findByFrequency(frequency);
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
